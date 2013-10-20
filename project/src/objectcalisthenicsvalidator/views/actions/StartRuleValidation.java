package objectcalisthenicsvalidator.views.actions;

import objectcalisthenicsvalidator.views.ViewContentProvider;
import ocanalyzer.handlers.ObjectCalisthenicsHandler;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class StartRuleValidation extends Action {

	private ObjectCalisthenicsHandler ocHandler;
	private ViewContentProvider tableProvider;
	private TableViewer rulesViewer;

	public StartRuleValidation(ObjectCalisthenicsHandler ocHandler,
			ViewContentProvider tableProvider, TableViewer rulesViewer) {
		this.ocHandler = ocHandler;
		this.tableProvider = tableProvider;
		this.rulesViewer = rulesViewer;

		setText("Validate");
		setToolTipText("??");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	public void run() {
		try {
			tableProvider.clear();
			ocHandler.execute(null);
			rulesViewer.refresh();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
