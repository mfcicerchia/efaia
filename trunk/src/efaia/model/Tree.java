package efaia.model;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

public class Tree extends Graph {

	public Tree(Composite parent, int style) {
		super(parent, style);
		this.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		this.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),true);
		this.getLightweightSystem().setEventDispatcher(
				new SWTEventDispatcher() {
					public void dispatchMouseMoved(
							org.eclipse.swt.events.MouseEvent me) {
						System.out.println("Entra");
					}
				});
	}

}
