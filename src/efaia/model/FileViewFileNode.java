package efaia.model;

import java.io.File;
import java.util.List;

import efaia.util.ITreeNode;

public class FileViewFileNode extends FileViewTreeNode {
private File fFile; /* actual data object */
	
	public FileViewFileNode(ITreeNode parent, File file)
	{
		super(parent);
		fFile = file;
	}
	
	public String getName() {		
		return "FILE: " + fFile.getName();
	}
	
	protected void createChildren(List<FileViewTreeNode> children) {		
	}
	
	public boolean hasChildren() {		
		return false;
	}

}
