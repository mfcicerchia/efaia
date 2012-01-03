package efaia.model;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;

public class TreeViewer extends GraphViewer {
	
	protected Tree graph;

	public TreeViewer(Composite composite, int style) {
		super(composite, style);
		this.graph = new Tree(composite, style);
		setLayoutAlgorithm(graph.getLayoutAlgorithm(), true);
		hookControl(this.graph);
	}
	
	public void setControl(Tree graphModel) {
		this.graph = graphModel;
		hookControl(this.graph);
	}
	
	public Tree getTree(){
		return graph;
	}
	
	

}
