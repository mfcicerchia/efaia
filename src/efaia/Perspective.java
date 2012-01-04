package efaia;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import efaia.view.AgentStateProperty;
import efaia.view.FilesView;
import efaia.view.TreeView;


public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addView(FilesView.ID, IPageLayout.LEFT,
				IPageLayout.RATIO_MIN, IPageLayout.ID_EDITOR_AREA);
		layout.addView(TreeView.ID, IPageLayout.RIGHT,
				0.01f, IPageLayout.ID_EDITOR_AREA);
		layout.addView(AgentStateProperty.ID, IPageLayout.BOTTOM, 0.9f, TreeView.ID);
	}
}
