package objectcalisthenicsvalidator.views.table;

import ocanalyzer.domain.ViolationImpl;
import ocanalyzer.reporter.PackageViolation;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class TablelabelProvider extends LabelProvider implements
		ITableLabelProvider {

	public String getColumnText(Object element, int index) {
		if (element instanceof ViolationImpl) {
			ViolationImpl violation = (ViolationImpl) element;
			return informationForIndex(index, violation);
		} else if (element instanceof PackageViolation) {
			PackageViolation packageViolation = (PackageViolation) element;
			return informationForIndex(index, packageViolation);
		}
		return new String();
	}

	private String informationForIndex(int index,
			PackageViolation packageViolation) {
		if (index == 0) {
			return new String();
		} else if (index == 1) {
			return packageViolation.getResource().getName();
		} else if (index == 2) {
			return packageViolation.getMessage();
		}
		return new String();
	}

	private String informationForIndex(int index, ViolationImpl violation) {
		if (index == 0) {
			return violation.getLine().toString();
		} else if (index == 1) {
			return violation.getResource().getName();
		} else if (index == 2) {
			return violation.getMessage();
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
