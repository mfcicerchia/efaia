package efaia;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// configurer.setInitialSize(new Point(400, 300));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(false);
		configurer.setTitle("eFaia"); //$NON-NLS-1$
		if (configurer.getWindow().getShell() != null)
			configurer.getWindow().getShell().setMaximized(true);
		else {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			configurer.setInitialSize(new Point(screenSize.height,
					screenSize.width));
		}
	}
}
