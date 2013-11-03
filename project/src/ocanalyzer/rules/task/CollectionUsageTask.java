package ocanalyzer.rules.task;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.CollectionWrapperRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class CollectionUsageTask extends WrapperUsageTask {

	public CollectionUsageTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter, Set<TypeDeclaration> wrappers) {
		super(unitsToAnalyze, reporter);
		this.wrappers = wrappers;
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new CollectionWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}
}