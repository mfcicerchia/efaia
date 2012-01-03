package efaia.model;

import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.IContainer;

public class TreeNode extends GraphNode {

	public TreeNode(IContainer graphModel, int style) {
		super(graphModel, style);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public TreeNode(IContainer graphModel, int style, Object data) {
		super(graphModel, style, data);
		// TODO Auto-generated constructor stub
	}

/*	public TreeNode(IContainer graphModel, int style, String text, Image image,
			Object data) {
		super(graphModel, style, text, image, data);
		// TODO Auto-generated constructor stub
	}

	public TreeNode(IContainer graphModel, int style, String text, Image image) {
		super(graphModel, style, text, image,null);
		// TODO Auto-generated constructor stub
	}

	public TreeNode(IContainer graphModel, int style, String text, Object data) {
		super(graphModel, style, text,null, data);
		// TODO Auto-generated constructor stub
	}*/

	public TreeNode(IContainer graphModel, int style, String text) {
		super(graphModel, style, text);
		// TODO Auto-generated constructor stub
	}

}
