package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.table.ViolationProvider;
import ocanalyzer.domain.DTOFactory;
import ocanalyzer.domain.Run;
import ocanalyzer.domain.Training;
import ocanalyzer.dto.RunDTO;

import org.eclipse.jface.action.Action;
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
	private ViolationProvider modelProvider;

	public StartRuleValidation(Training training,
			ViolationProvider modelProvider) {
		this.training = training;
		this.modelProvider = modelProvider;

		setText("Validate");
		setToolTipText("Validate");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	public void run() {
		Run run = training.create();
		run.validate();
		RunDTO runDTO = DTOFactory.runDTO(run);
		modelProvider.setRun(runDTO);
	}
}
