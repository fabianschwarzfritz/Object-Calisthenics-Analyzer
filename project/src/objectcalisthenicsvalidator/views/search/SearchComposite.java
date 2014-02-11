/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class SearchComposite extends Composite {

	private Text text;
	private Label label;

	public SearchComposite(Composite parent) {
		super(parent, SWT.NONE);

		label = new Label(this, SWT.NONE);
		label.setText("Search: ");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		//label.setBackground(new Color(getDisplay(), 40, 160, 0));

		text = new Text(this, SWT.BORDER | SWT.SEARCH);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//text.setBackground(new Color(getDisplay(), 0, 160, 0));

		setLayout(new GridLayout(2, false));
		setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false,
				false));

		//setBackground(new Color(getDisplay(), 50, 60, 145));
	}

	public void setResultComposite(StructuredViewer resultViewer,
			ViolationFilter filter) {
		text.addKeyListener(new SearchAdapter(resultViewer, filter, text));
	}

}
