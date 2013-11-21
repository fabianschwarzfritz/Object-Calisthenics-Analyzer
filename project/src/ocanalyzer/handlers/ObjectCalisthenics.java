package ocanalyzer.handlers;

import java.util.List;

import ocanalyzer.analyzer.factory.AnalyzerFactoryImpl;
import ocanalyzer.analyzer.factory.ExtractorFactory;
import ocanalyzer.analyzer.factory.extractor.WorkspaceExtractor;
import ocanalyzer.reporter.PackageReporter;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.DelegateReporter;
import ocanalyzer.reporter.impl.MarkerReporter;
import ocanalyzer.tasks.AllRulesTask;

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
 * Therefore it set up a {@link WorkspaceExtractor} in order to start the
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
public class ObjectCalisthenics extends AbstractHandler {
	protected ExtractorFactory factory;
	protected Reporter reporter;
	protected WorkspaceExtractor workspaceAnalyzer;

	public ObjectCalisthenics() {
		initDefaultReporter();
		initFactory();
	}

	private void initDefaultReporter() {
		DelegateReporter delegateReporter = new DelegateReporter();
		ConsoleReporter consoleReporter = new ConsoleReporter(System.out);
		delegateReporter.addClassReporter(consoleReporter);
		delegateReporter.addClassReporter(new MarkerReporter());
		delegateReporter.addPackageReporter(delegateReporter);
		reporter = delegateReporter;
	}

	public ObjectCalisthenics(Reporter reporter) {
		this.reporter = reporter;
		initFactory();
	}

	private void initFactory() {
		factory = new AnalyzerFactoryImpl(reporter);
	}

	public ObjectCalisthenics(ExtractorFactory factory, Reporter reporter) {
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
