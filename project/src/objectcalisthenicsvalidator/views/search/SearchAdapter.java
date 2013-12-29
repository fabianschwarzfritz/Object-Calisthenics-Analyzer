/**
 * 
 */
package objectcalisthenicsvalidator.views.search;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;

/**
 * @author Fabian Schwarz-Fritz
 * 
 */
public class SearchAdapter extends KeyAdapter {

	private Text textElement;
	private TableViewer viewer;
	private ViolationFilter filter;

	public SearchAdapter(TableViewer viewer, ViolationFilter filter, Text text) {
		super();
		this.textElement = text;
		this.viewer = viewer;
		this.filter = filter;
	}

	public void keyReleased(KeyEvent ke) {
		String text = textElement.getText();
		filter.setSearchText(text);
		viewer.refresh();
	}
}
