package efaia.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import efaia.view.TreeView;

public class ExportToJPGHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActivePart();

		if (part instanceof TreeView) {
			TreeView tv = (TreeView) part;

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell();

			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setFilterExtensions(new String[] { "*.jpg", "*.*" });
			dialog.setFilterNames(new String[] { "JPEG Image File", "All Files" });
			String fileSelected = dialog.open();

			if (fileSelected != null)
				tv.saveImage(fileSelected, 4);
		} else {
			MessageDialog.openWarning(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Atención",
					"No ha seleccionado un árbol de búsqueda.");
		}

		return null;
	}

}
