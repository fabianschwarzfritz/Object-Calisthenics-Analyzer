package ocanalyzer.rules;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.analyzer.factory.ASTNodeFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

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
