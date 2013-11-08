package ocanalyzer.rules.task;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public abstract class WrapperUsageTask extends ValidationTask implements
		RuleFactoryProvider {

	protected Set<TypeDeclaration> wrappers;

	public WrapperUsageTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public abstract RuleFactory createRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

}
