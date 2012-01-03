package efaia.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class DirectoryOpenHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);

		String fileSelected = dialog.open();

		if (fileSelected != null) {
			// Perform Action, like open the file.
			System.out.println("Selected file: " + fileSelected);
		}
		return null;
	}

}
