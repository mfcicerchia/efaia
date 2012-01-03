package efaia.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import efaia.view.FilesView;



public class FileOpenHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		FileDialog dialog = new FileDialog(shell, SWT.OPEN | SWT.MULTI);
		dialog.setFilterExtensions(new String[] { "*.xml", "*.*" });
		dialog.setFilterNames(new String[] { "TreeSearch File", "All Files" });
		dialog.setFilterPath("/home/kbza/workspace/eFaia/searchTrees");
		String fileSelected = dialog.open();
		

		FilesView arc = (FilesView) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.findView(FilesView.ID);

		if (fileSelected != null) {
			// Perform Action, like open the file.
			//arc.agregarArchivos(FilesPath.generarFiles(dialog.getFilterPath(), dialog.getFileNames()));
		}
		return null;
	}

}
