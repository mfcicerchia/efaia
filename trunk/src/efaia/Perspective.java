package efaia;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import efaia.view.FilesView;
import efaia.view.TreeView;


public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addView(FilesView.ID, IPageLayout.LEFT,
				IPageLayout.RATIO_MIN, IPageLayout.ID_EDITOR_AREA);
		layout.addView(TreeView.ID, IPageLayout.RIGHT,
				IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
	}
}
