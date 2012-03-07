package efaia.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import efaia.view.TreeView;

public class OpenViewAction extends Action {

	private final IWorkbenchWindow window;
	public static int instanceNum;
	private final String viewId;
	private TreeView ventAct;

	public OpenViewAction(IWorkbenchWindow window, String viewId) {
		this.window = window;
		this.viewId = viewId;
	}

	public void run() {
		try {
			ventAct = (TreeView) window.getActivePage()
					.showView(viewId, Integer.toString(instanceNum),
							IWorkbenchPage.VIEW_ACTIVATE);
			instanceNum++;
		} catch (PartInitException e) {
			System.out.println("Excepcion");
		}
	}
}
