package ocanalyzer.handlers;

import java.util.List;

import ocanalyzer.analyzer.AnalyzerFactory;
import ocanalyzer.analyzer.AnalyzerFactoryImpl;
import ocanalyzer.analyzer.WorkspaceAnalyzer;
import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.reporter.StandardReporter;
import ocanalyzer.rules.AllRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ObjectCalisthenicsHandler extends AbstractHandler {
	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";

	protected AnalyzerFactory factory;

	private RuleViolationReporter reporter;
	private WorkspaceAnalyzer workspaceAnalyzer;

	public ObjectCalisthenicsHandler() {
		factory = new AnalyzerFactoryImpl();
		reporter = new StandardReporter();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspaceAnalyzer = new WorkspaceAnalyzer(workspace, factory);

		List<CompilationUnit> unitsToAnalyze = workspaceAnalyzer
				.extractCompilationUnits();

		applyOnUnits(unitsToAnalyze);

		return null;
	}

	private void applyOnUnits(List<CompilationUnit> unitsToAnalyze) {
		for (CompilationUnit compilationUnit : unitsToAnalyze) {
			ITypeRoot typeRoot = compilationUnit.getTypeRoot();
			// FIXME: This must be a ICompilationunit because nothing else was
			// extracted...
			ICompilationUnit iCompilationUnit = (ICompilationUnit) typeRoot;
			RuleFactory ruleFactory = new AllRulesFactory(iCompilationUnit,
					compilationUnit, reporter);
			ruleFactory.createRules().validate();
		}
	}
}
