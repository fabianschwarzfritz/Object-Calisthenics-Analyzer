package ocanalyzer.tasks;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

abstract class WrapperUsageTask extends ValidationTask implements
		RuleFactoryProvider {

	Set<TypeDeclaration> wrappers;

	public WrapperUsageTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public abstract RuleFactory createRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

}
