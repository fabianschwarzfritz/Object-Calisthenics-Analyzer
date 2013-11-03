package ocanalyzer.rules.task;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.NoReporter;
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

		// This Task uses a no reporter.
		// Getting an information that the type is a wrapper class does _not_
		// indicate that this is a rule violation. Therefore informing the user
		// with a reporter is not necessary.
		primitiveTask = new PrimitiveTypeTask(unitsToAnalyze, new NoReporter());
		primitiveTask.execute();
		Set<TypeDeclaration> wrappers = primitiveTask.getWrappers();

		primitiveUsageTask = new PrimitiveUsageTask(unitsToAnalyze, reporter,
				wrappers);
		primitiveUsageTask.execute();
	}

}
