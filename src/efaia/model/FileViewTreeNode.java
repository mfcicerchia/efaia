package efaia.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import efaia.util.ITreeNode;

//import efaia.util.ITreeNode;

public abstract class FileViewTreeNode implements ITreeNode {
	
	protected ITreeNode fParent;
	protected List<FileViewTreeNode> fChildren;
	
	public FileViewTreeNode(ITreeNode parent) {
		fParent = parent;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren() {
		return true;
	}

	@Override
	public ITreeNode getParent() {
		return fParent;
	}

	@Override
	public List<FileViewTreeNode> getChildren() {
		if( fChildren != null )
			return fChildren;
		
		fChildren = new ArrayList<FileViewTreeNode>();
		createChildren(fChildren);
			
		return fChildren;
	}
	
	protected abstract void createChildren(List<FileViewTreeNode> children);

}
