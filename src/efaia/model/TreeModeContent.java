package efaia.model;

import org.eclipse.swt.SWT;
import org.eclipse.zest.core.widgets.GraphConnection;

public class TreeModeContent {
	
	
	public TreeModeContent(Tree t) {
		TreeNode t1 = new TreeNode(t, SWT.NONE, "0\nNull");
		TreeNode t2 = new TreeNode(t, SWT.NONE, "1\nEat");
		TreeNode t3 = new TreeNode(t, SWT.NONE, "2\nGoRight");
		TreeNode t4 = new TreeNode(t, SWT.NONE, "3\nGoLeft");
		TreeNode t5 = new TreeNode(t, SWT.NONE, "4\nGoUp");
		TreeNode t6 = new TreeNode(t, SWT.NONE, "5\nGoDown");
		
		new TreeConnection(t, SWT.NONE, t1, t2);
		new TreeConnection(t, SWT.NONE, t1, t3);
		new TreeConnection(t, SWT.NONE, t3, t4);
		new TreeConnection(t, SWT.NONE, t3, t5);
		new TreeConnection(t, SWT.NONE, t3, t6);
	}

}
