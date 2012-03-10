package efaia.model;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;

public class GraphStaticViewer extends GraphViewer {
	
	protected GraphStatic graph = null;

	public GraphStaticViewer(Composite composite, int style) {
		super(composite, style);
		this.graph = new GraphStatic(composite, style);
		hookControl(this.graph);
	}

}
