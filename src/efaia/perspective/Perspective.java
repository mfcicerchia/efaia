package efaia.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import efaia.view.ASView;
import efaia.view.FilesView;
import efaia.view.TreeView;

public class Perspective implements IPerspectiveFactory {
	private IFolderLayout fl;

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);

		//layout.addShowViewShortcut(TreeView.ID);
		fl = layout.createFolder("trees", IPageLayout.RIGHT, 0.16f,
				IPageLayout.ID_EDITOR_AREA);
		fl.addPlaceholder(TreeView.ID+":*");

		layout.addView(ASView.ID, IPageLayout.BOTTOM, 0.71f, "trees");
		layout.addView(FilesView.ID, IPageLayout.LEFT, 0.29f, "trees");
		
	}
}
