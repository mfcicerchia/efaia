package efaia.util;

import java.util.List;

import org.eclipse.swt.graphics.Image;

public interface ITreeNode {

	public Image getImage();
	
	public boolean hasChildren();
 
	public ITreeNode getParent();
	
	public List getChildren();
}
