package ocanalyzer.rules.task;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class AllRulesTask extends ValidationTask {

	private PreValidationTask preTask;

	private PrimitiveTypeTask primitiveTask;
	private PrimitiveUsageTask primitiveUsageTask;

	public AllRulesTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public void execute() {
		preTask = new PreValidationTask(unitsToAnalyze, reporter);
		preTask.execute();

		primitiveTask = new PrimitiveTypeTask(unitsToAnalyze, reporter);
		primitiveTask.execute();
		Set<TypeDeclaration> wrappers = primitiveTask.getWrappers();

		primitiveUsageTask = new PrimitiveUsageTask(unitsToAnalyze, reporter, wrappers);
		primitiveUsageTask.execute();
	}

}
