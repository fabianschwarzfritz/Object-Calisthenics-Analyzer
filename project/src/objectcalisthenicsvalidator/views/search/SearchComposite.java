/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class SearchComposite extends Composite {

	private ViolationFilter filter;

	public SearchComposite(Composite parent, StructuredViewer resultViewer) {
		super(parent, SWT.NONE);
		filter = new ViolationFilter();
		resultViewer.addFilter(filter);

		Label label = new Label(parent, SWT.NONE);
		label.setText("Search: ");

		Text text = new Text(parent, SWT.BORDER | SWT.SEARCH);
		text.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_FILL));
		text.addKeyListener(new SearchAdapter(resultViewer, filter, text));

	}

}
