package ocanalyzer.analyzer;

import ocanalyzer.analyzer.factory.ASTNodeFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * 
 * This class creates the AST tree of a Java class to examine.
 * 
 * Therefore the {@link #handle()} method creates an AST tree and adds all
 * visitors to the Java class's {@link CompilationUnit}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CompilationUnitAnalyzer {

	private ICompilationUnit unit;

	public CompilationUnitAnalyzer(ICompilationUnit unit) {
		this.unit = unit;
	}

	public void handle() {
		CompilationUnit compilationUnit = (CompilationUnit) new ASTNodeFactory()
				.parse(unit);
		RuleFactory factory = new RuleFactory(unit, compilationUnit);

		acceptElseRule(compilationUnit, factory);
		acceptIndentiationRule(compilationUnit, factory);
	}

	private void acceptElseRule(CompilationUnit compilationUnit,
			RuleFactory factory) {
		ASTVisitor elseRule = factory.createElseRule();
		compilationUnit.accept(elseRule);
	}

	private void acceptIndentiationRule(CompilationUnit compilationUnit,
			RuleFactory factory) {
		ASTVisitor indentiationRule = factory.createIndentiationRule();
		compilationUnit.accept(indentiationRule);
	}
}
