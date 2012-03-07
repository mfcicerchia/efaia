package efaia.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import efaia.view.TreeView;

public class ExportToJPGHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		TreeView tv = (TreeView) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActivePart();

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		String fileSelected = dialog.open();
		
		if(fileSelected != null)
			tv.saveImage(fileSelected, 4);

		return null;
	}

}
