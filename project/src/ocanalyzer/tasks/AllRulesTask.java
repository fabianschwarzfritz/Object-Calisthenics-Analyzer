package ocanalyzer.tasks;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.ClassReporter;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class AllRulesTask implements Executable {

	private List<CompilationUnit> unitsToAnalyze;
	private ClassReporter reporter;

	public AllRulesTask(List<CompilationUnit> unitsToAnalyze, ClassReporter reporter) {
		this.unitsToAnalyze = unitsToAnalyze;
		this.reporter = reporter;
	}

	public void execute() {
		this.executePretask();
		this.executePrimitives();
		this.executeCollections();
	}

	private void executePretask() {
		new ElseRuleTask(unitsToAnalyze, reporter).execute();
		new IndentationRuleTask(unitsToAnalyze, reporter).execute();
		new DotRuleTask(unitsToAnalyze, reporter).execute();
		new InstanceVariableRuleTask(unitsToAnalyze, reporter).execute();
		new SmallRuleTask(unitsToAnalyze, reporter).execute();
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
