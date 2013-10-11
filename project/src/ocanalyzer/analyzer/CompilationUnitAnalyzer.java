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

	protected ICompilationUnit unit;

	public CompilationUnitAnalyzer(ICompilationUnit unit,
			AnalyzerFactory factory) {
		this.unit = unit;
	}

	public void handle() {
		CompilationUnit compilationUnit = (CompilationUnit) new ASTNodeFactory()
				.parse(unit);
		RuleFactory factory = createFactory(compilationUnit);

		acceptRules(compilationUnit, factory);
	}

	protected RuleFactory createFactory(CompilationUnit compilationUnit) {
		RuleFactory factory = new RuleFactory(unit, compilationUnit);
		return factory;
	}

	protected void acceptRules(CompilationUnit compilationUnit,
			RuleFactory factory) {
		acceptElseRule(compilationUnit, factory);
		acceptIndentiationRule(compilationUnit, factory);
	}

	public void acceptElseRule(CompilationUnit compilationUnit,
			RuleFactory factory) {
		ASTVisitor elseRule = factory.createElseRule();
		compilationUnit.accept(elseRule);
	}

	protected void acceptIndentiationRule(CompilationUnit compilationUnit,
			RuleFactory factory) {
		ASTVisitor indentiationRule = factory.createIndentiationRule();
		compilationUnit.accept(indentiationRule);
	}
}
