package ocanalyzer.handlers;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.AnalyzerFactoryImpl;
import ocanalyzer.analyzer.WorkspaceAnalyzer;
import ocanalyzer.reporter.ConsoleReporter;
import ocanalyzer.reporter.DelegateReporter;
import ocanalyzer.reporter.MarkerReporter;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.task.AllRulesTask;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * TODO: Improve documentation: Clarify: What is this class exactly, what's it's
 * one and only purpose???
 * 
 * This is the "top level" entry class for an Object Calisthenics Validation
 * plugin. It starts prepares all necessary steps to start the analyzation of
 * the rules.
 * 
 * Therefore it set up a {@link WorkspaceAnalyzer} in order to start the
 * analysis of the rules on the plugin's workspace.
 * 
 * Furthermore it sets up a {@link ConsoleReporter} and a {@link MarkerReporter}
 * , bundled in a {@link DelegationReporter}, which is then delegating to the
 * given reporters.
 * 
 * It is an {@link AbstractHandler}
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ObjectCalisthenicsHandler extends AbstractHandler {
	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

	protected AnalyzerFactory factory;
	protected RuleViolationReporter reporter;
	protected WorkspaceAnalyzer workspaceAnalyzer;

	public ObjectCalisthenicsHandler() {
		factory = new AnalyzerFactoryImpl();
		DelegateReporter delegateReporter = new DelegateReporter();
		delegateReporter.add(new ConsoleReporter(System.out));
		delegateReporter.add(new MarkerReporter());
		reporter = delegateReporter;
	}

	public ObjectCalisthenicsHandler(RuleViolationReporter reporter) {
		this.reporter = reporter;
		factory = new AnalyzerFactoryImpl();
	}

	public ObjectCalisthenicsHandler(AnalyzerFactory factory,
			RuleViolationReporter reporter) {
		this.factory = factory;
		this.reporter = reporter;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspaceAnalyzer = factory.createWorkspaceAnalyzer(workspace);

		List<CompilationUnit> unitsToAnalyze = workspaceAnalyzer
				.extractCompilationUnits();

		applyTask(unitsToAnalyze);

		return null;
	}

	protected void applyTask(List<CompilationUnit> unitsToAnalyze) {
		AllRulesTask task = new AllRulesTask(unitsToAnalyze, reporter);
		task.execute();
	}
}
