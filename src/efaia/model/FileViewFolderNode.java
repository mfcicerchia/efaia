package efaia.model;

import java.io.File;
import java.util.List;

import efaia.util.ITreeNode;

public class FileViewFolderNode extends FileViewTreeNode {
	
	private File fFolder;
	
	public FileViewFolderNode(File folder) {
		this(null,folder);
	}

	public FileViewFolderNode(ITreeNode parent, File folder) {
		super(parent);
		fFolder = folder;
	}

	public String getName() {		
		return "FOLDER: " + fFolder.getName();
	}
	
	protected void createChildren(List<FileViewTreeNode> children)
	{			
		File[] childFiles = fFolder.listFiles();
		for(int i=0; i<childFiles.length; i++)
		{
			File childFile = childFiles[i];
			if( childFile.isDirectory() )
				children.add(new FileViewFolderNode(this, childFile));
			else
				children.add(new FileViewFileNode(this, childFile));
		}
	}	

}
