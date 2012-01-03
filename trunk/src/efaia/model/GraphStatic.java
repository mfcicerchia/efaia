package efaia.model;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.widgets.Graph;

public class GraphStatic extends Graph {

	public GraphStatic(Composite parent, int style) {
		super(parent, style);
		this.getLightweightSystem().setEventDispatcher(
				new SWTEventDispatcher() {
					public void dispatchMouseMoved(
							org.eclipse.swt.events.MouseEvent me) {
						// Doing nothing
						System.out.println("Entra");
					}
				});
		// TODO Auto-generated constructor stub
	}

}
