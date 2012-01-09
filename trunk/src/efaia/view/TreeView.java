package efaia.view;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import efaia.model.Node;
import efaia.model.NodeModelContentProvider;
import efaia.model.Tree;
import efaia.provider.ZestLabelProvider;
import efaia.provider.ZestNodeContentProvider;

public class TreeView extends ViewPart implements IZoomableWorkbenchPart {

	public TreeView() {
	}

	public static final String ID = "eFaia.view.TreeView";
	private Tree t;
	private Node nodoSeleccionado;
	private GraphViewer viewer;

	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new ZestNodeContentProvider());
		viewer.setLabelProvider(new ZestLabelProvider());
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);

		NodeModelContentProvider model = new NodeModelContentProvider(
				"/home/kbza/Facultad/Proyecto/efaia/archivos/13.xml");
		viewer.setInput(model.getNodes());
		getSite().setSelectionProvider(viewer);
		nodoSeleccionado = model.getNodes().get(0);
		// LayoutAlgorithm layout = new
		// TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		TreeLayoutAlgorithm l = new TreeLayoutAlgorithm();
		l.setResizing(false);
		viewer.setLayoutAlgorithm(l, true);
		viewer.applyLayout();
		fillToolBar();

		ASView asView = (ASView) getSite()
				.getPage().findView(ASView.ID);
		List<String> keys = nodoSeleccionado.getASAN();
		List<String> values = nodoSeleccionado.getASV();
		
		asView.setearDatos(keys, values);

		System.out.println("Pausa");

	}

	private void fillToolBar() {
		ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(
				this);
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().add(toolbarZoomContributionViewItem);

	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(Class)
	 */
	public Object getAdapter(Class adapter) {
		return super.getAdapter(adapter);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPart#dispose()
	 */
	public void dispose() {
		super.dispose();
	}

}
