package efaia.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import efaia.view.ASView;
import efaia.view.AgentStateProperty;
import efaia.view.FilesView;
import efaia.view.TreeView;
import org.eclipse.ui.IFolderLayout;


public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		
			IFolderLayout folderLayout = layout.createFolder("trees", IPageLayout.RIGHT, 0.01f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("eFaia.view.TreeView");
		
		
		layout.addView(ASView.ID, IPageLayout.BOTTOM, 0.81f, TreeView.ID);
		
		layout.addView(FilesView.ID, IPageLayout.LEFT,
				0.27f, TreeView.ID);
	}
	
	public void agregarNuevoArbol(){
		
	}
}
