package objectcalisthenicsvalidator.views.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ClearMarker extends Action {

	public ClearMarker() {
		setText("Clear");
		setToolTipText("Clear");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_CLEAR));
	}

	public void run() {
		// TODO clear all markers in application
		System.out.println("Not yet implemented yet: clear all markers");
		throw new UnsupportedOperationException(
				"Clearing markers is not implemented yet");
	}
}
