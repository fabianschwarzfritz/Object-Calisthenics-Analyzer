package ocanalyzer.rules.task;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class AllRulesTask implements Executable {

	protected List<CompilationUnit> unitsToAnalyze;
	protected RuleViolationReporter reporter;

	public AllRulesTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		this.unitsToAnalyze = unitsToAnalyze;
		this.reporter = reporter;
	}

	public void execute() {
		this.executePretask();
		this.executePrimitives();
		this.executeCollections();
	}

	private void executePretask() {
		ElseRuleTask elseT = new ElseRuleTask(unitsToAnalyze, reporter);
		elseT.execute();

		IndentationRuleTask indent = new IndentationRuleTask(unitsToAnalyze,
				reporter);
		indent.execute();

		InstanceVariableRuleTask instance = new InstanceVariableRuleTask(
				unitsToAnalyze, reporter);
		instance.execute();
	}

	private void executePrimitives() {
		PrimitiveTypeTask primitiveTask = new PrimitiveTypeTask(unitsToAnalyze,
				reporter);
		primitiveTask.execute();
		Set<TypeDeclaration> wrappers = primitiveTask.getWrappers();

		PrimitiveUsageTask primitiveUsageTask = new PrimitiveUsageTask(
				unitsToAnalyze, reporter, wrappers);
		primitiveUsageTask.execute();

		PrimitiveReturnWrapperTask wrapperTask = new PrimitiveReturnWrapperTask(
				unitsToAnalyze, reporter, wrappers);
		wrapperTask.execute();
	}

	private void executeCollections() {
		CollectionTypeTask primitiveTask = new CollectionTypeTask(
				unitsToAnalyze, reporter);
		primitiveTask.execute();
		Set<TypeDeclaration> wrappers = primitiveTask.getWrappers();

		CollectionUsageTask primitiveUsageTask = new CollectionUsageTask(
				unitsToAnalyze, reporter, wrappers);
		primitiveUsageTask.execute();

		CollectionReturnWrapperTask wrapperTask = new CollectionReturnWrapperTask(
				unitsToAnalyze, reporter, wrappers);
		wrapperTask.execute();
	}

}
