package ocanalyzer.rules;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ASTNodeFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * This class is used to validate given Rules for a given
 * {@link CompilationUnit}, e.g. different implementations of {@link ASTVisitor}
 * 's.
 * 
 * A validation rule can be added by calling {@link Rules#addRule(ASTVisitor)}.
 * After the rules to be validated are added, the validation of the rules can be
 * started via {@link #validate()};
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class Rules {

	private ICompilationUnit unit;
	private List<ASTVisitor> vistors;

	public Rules(ICompilationUnit unit) {
		this.unit = unit;
		vistors = new ArrayList<ASTVisitor>();
	}

	public Rules(ICompilationUnit unit, List<ASTVisitor> ruleValidators) {
		this.unit = unit;
		vistors = ruleValidators;
	}

	public void addRule(ASTVisitor rule) {
		vistors.add(rule);
	}

	public void validate() {
		CompilationUnit compilationUnit = (CompilationUnit) new ASTNodeFactory()
				.parse(unit);
		for (ASTVisitor visitor : vistors) {
			compilationUnit.accept(visitor);
		}
	}
}
