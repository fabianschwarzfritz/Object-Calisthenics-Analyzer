package ocanalyzer;

import objectcalisthenicsvalidator.views.ObjectCalisthenicsView;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * This class is an {@link AbstractHandler}, a plugin entry point. Because all
 * events are started by the ui in the class {@link ObjectCalisthenicsView},
 * this class does not have any functionality.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ObjectCalisthenicsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return null;
	}
}
