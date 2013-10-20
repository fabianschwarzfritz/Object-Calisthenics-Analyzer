package objectcalisthenicsvalidator.views;

import ocanalyzer.reporter.Violation;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ViewLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	public String getColumnText(Object element, int index) {
		if (!(element instanceof Violation)) {
			return new String();
		}
// FIXME Clean code!
		Violation violation = (Violation) element;
		if (index == 0) {
			return violation.getLine().toString();
		} else if (index == 1) {
			return violation.getResource().toString();
		} else if (index == 2) {
			return violation.getMessage().toString();
		}
		return new String();
	}

	public Image getColumnImage(Object obj, int index) {
		return getImage(obj);
	}

	public Image getImage(Object obj) {
		return PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}
}
