package ocanalyzer.rules.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public abstract class WrapperTypeTask extends ValidationTask implements
		RuleFactoryProvider {

	protected Set<TypeDeclaration> wrappers;

	public WrapperTypeTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public abstract RuleFactory createRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

	@Override
	public void execute() {
		wrappers = new HashSet<TypeDeclaration>();

		new UnitsValidator().validate(unitsToAnalyze, this);
	}

	public Set<TypeDeclaration> getWrappers() {
		return new HashSet<TypeDeclaration>(wrappers);
	}

}
