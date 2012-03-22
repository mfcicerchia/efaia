package efaia.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

import efaia.view.TreeView;

public class ExportJPGAction extends Action implements IWorkbenchWindowActionDelegate{
	
	private IWorkbenchWindow fWindow;
	
	public ExportJPGAction(){
		setEnabled(true);
	}
	
	@Override
	public void run() {
		
		/*IWorkbenchPart part = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActivePart();*/
		IWorkbenchPart part = fWindow.getActivePage().getActivePart();

		if (part instanceof TreeView) {
			TreeView tv = (TreeView) part;

			/*Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell();

			FileDialog dialog = new FileDialog(shell, SWT.SAVE);*/
			FileDialog dialog = new FileDialog(fWindow.getShell(), SWT.SAVE);
			dialog.setFilterExtensions(new String[] { "*.jpg", "*.*" });
			dialog.setFilterNames(new String[] { "JPEG Image File", "All Files" });
			String fileSelected = dialog.open();
			
			if(!fileSelected.contains(".jpg"))
				fileSelected = fileSelected.concat(".jpg");
			
			System.out.println(fileSelected);

			if (fileSelected != null)
				tv.saveImage(fileSelected, 4);
		}
	}

	@Override
	public void run(IAction action) {
		run();
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		fWindow = null;
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		fWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
	}

}
