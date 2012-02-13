package efaia.handler;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import efaia.view.FilesView;

public class DirectoryOpenHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);

		String fileSelected = dialog.open();

		if (fileSelected != null) {	
			FilesView fv = (FilesView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0].findView(FilesView.ID);
			fv.agregarArchivos(new File(fileSelected));
		}
		
		return null;
	}

}
