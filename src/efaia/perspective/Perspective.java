package efaia.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import efaia.view.ASView;
import efaia.view.AgentStateProperty;
import efaia.view.FilesView;
import efaia.view.TreeView;


public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addView(TreeView.ID, IPageLayout.RIGHT,
				0.01f, IPageLayout.ID_EDITOR_AREA);
		layout.addView(ASView.ID, IPageLayout.BOTTOM, 0.81f, TreeView.ID);
		layout.addView(FilesView.ID, IPageLayout.LEFT,
				0.27f, TreeView.ID);
	}
}
