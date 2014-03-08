package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.domain.Run;
import ocanalyzer.domain.Training;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * This class represents an action that is triggering an object calisthenics
 * validation.
 * 
 * Therefore it uses an {@link #oc} to trigger it. This class does not configure
 * or set up the handler, but assumes that the configuration (like for example
 * setting up the correct rule violation reporters) is already done.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class StartRuleValidation extends Action {

	private Training training;
	private ViolationProvider tableProvider;
	private Viewer rulesViewer;

	public StartRuleValidation(Training training,
			ViolationProvider tableProvider, Viewer rulesViewer) {
		this.training = training;
		this.tableProvider = tableProvider;
		this.rulesViewer = rulesViewer;

		setText("Validate");
		setToolTipText("Validate");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	public void run() {
		tableProvider.clear();
		Run run = training.create();
		run.validate(tableProvider);
		rulesViewer.refresh();
	}
}
