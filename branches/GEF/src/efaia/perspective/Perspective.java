package efaia.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import efaia.view.ASView;
import efaia.view.FilesView;
import efaia.view.TreeView;
import efaia.view.TreeViewGEF;

public class Perspective implements IPerspectiveFactory {
	private IFolderLayout fl;

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);

		//layout.addShowViewShortcut(TreeView.ID);
		/*fl = layout.createFolder("trees", IPageLayout.RIGHT, 0.16f,
				IPageLayout.ID_EDITOR_AREA);
		fl.addPlaceholder(TreeViewGEF.ID+":*");*/

		layout.addView(TreeViewGEF.ID,IPageLayout.RIGHT,0.16f,IPageLayout.ID_EDITOR_AREA);
		layout.addView(ASView.ID, IPageLayout.BOTTOM, 0.78f, TreeViewGEF.ID);
		layout.addView(FilesView.ID, IPageLayout.LEFT, 0.29f, TreeViewGEF.ID);
		
	}
}
