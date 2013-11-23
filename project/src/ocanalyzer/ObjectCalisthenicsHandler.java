package ocanalyzer;

import ocanalyzer.extractor.impl.WorkspaceExtractor;
import ocanalyzer.reporter.Reporter;
import ocanalyzer.reporter.ReporterFactory;
import ocanalyzer.reporter.impl.ConsoleReporter;
import ocanalyzer.reporter.impl.MarkerReporter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

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
public class ObjectCalisthenicsHandler extends AbstractHandler {

	private ObjectCalisthenics objectCalisthenics;

	public ObjectCalisthenicsHandler() {
		Reporter reporter = ReporterFactory.createStandardReporter();
		ObjectCalisthenics.create(reporter);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		objectCalisthenics.validate();
		return null;
	}
}
