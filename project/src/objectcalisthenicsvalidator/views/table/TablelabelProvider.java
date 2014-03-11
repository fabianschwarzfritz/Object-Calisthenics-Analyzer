package objectcalisthenicsvalidator.views.table;

import ocanalyzer.dto.ViolationDTO;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class TablelabelProvider extends LabelProvider implements
		ITableLabelProvider {

	public String getColumnText(Object element, int index) {
		if (element instanceof ViolationDTO) {
			ViolationDTO violation = (ViolationDTO) element;
			return informationForIndex(index, violation);
		}
		return new String();
	}

	private String informationForIndex(int index, ViolationDTO violation) {
		if (index == 0) {
			return violation.getName();
		} else if (index == 1) {
			return violation.getMessage();
		} else if (index == 2) {
			return violation.getDegree();
		} else if (index == 3) {
			return violation.getPosition();
		} else if (index == 4) {
			return violation.getResourceName();
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
