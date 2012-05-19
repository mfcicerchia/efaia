package efaia.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.algorithms.SpaceTreeLayoutAlgorithm;
import org.xml.sax.SAXException;

import efaia.model.Node;
import efaia.model.NodeModelContentProvider;
import efaia.model.Tree;
import efaia.provider.TreeViewLabelProvider;
import efaia.provider.TreeViewNodeContentProvider;
import efaia.util.FileNotSupportedException;

public class TreeView extends ViewPart implements IZoomableWorkbenchPart {

	public TreeView() {
		super();
	}

	public static final String ID = "eFaia.view.TreeView";
	private Tree t;
	private Node nodoSeleccionado;
	private List<Node> nodos;
	private GraphViewer viewer;
	private String sencodaryId;

	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new TreeViewNodeContentProvider());
		viewer.setLabelProvider(new TreeViewLabelProvider());
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		viewer.getGraphControl().getLightweightSystem()
				.setEventDispatcher(new SWTEventDispatcher() {
					public void dispatchMouseMoved(
							org.eclipse.swt.events.MouseEvent me) {
					}
				});
		fillToolBar();
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

	public void setSecID(String id_sec) {
		sencodaryId = id_sec;

	}

	public String getSecID() {
		return sencodaryId;

	}

	public void cargarArbol(String path) throws FileNotFoundException{
			try {
				String p1 = path.replace("[", "").replace("]", "");
				File f = new File(p1);
				NodeModelContentProvider model = new NodeModelContentProvider(
						f.getPath());
				nodos = model.getNodes();
				viewer.setInput(nodos);
				getSite().setSelectionProvider(viewer);
				nodoSeleccionado = nodos.get(0);
				SpaceTreeLayoutAlgorithm l = new SpaceTreeLayoutAlgorithm();
				viewer.setLayoutAlgorithm(l, true);
				viewer.getGraphControl().setPreferredSize(1024, 800);
				viewer.applyLayout();
				viewer.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						StructuredSelection s = (StructuredSelection) event
								.getSelection();
						if (s.size() > 0) {
							List nodes = s.toList();
							if (nodes.get(nodes.size() - 1).getClass()
									.equals(Node.class)) {
								Node n = (Node) nodes.get(nodes.size() - 1);
								ASView asView = (ASView) getSite().getPage().findView(
										ASView.ID);

								asView.setearDatos(n.getAgentState());
							}
						}

					}
				});
			} catch (FileNotSupportedException e) {
				MessageDialog
				.openError(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						"Error",
						e.getMessage());
			} catch (SAXException e) {
				MessageDialog
				.openError(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						"Error",
						e.getMessage());
			} catch (IOException e) {
				MessageDialog
				.openError(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						"Error",
						e.getMessage());
			}
		

	}

	public void setTitle(String title) {
		String p1 = title.replace("[", "").replace("]", "");
		int i = p1.lastIndexOf("\\");
		if (i != -1) {
			p1 = p1.substring(i + 1);
			this.setPartName(p1);
		}

	}

	public void saveImage(String filename, int format) {
		Graph g = (Graph) viewer.getControl();
		Rectangle bounds = g.getContents().getBounds();
		Point size = new Point(g.getContents().getSize().width, g.getContents()
				.getSize().height);
		org.eclipse.draw2d.geometry.Point viewLocation = g.getViewport()
				.getViewLocation();
		final Image image = new Image(null, size.x, size.y);
		GC gc = new GC(image);
		SWTGraphics swtGraphics = new SWTGraphics(gc);

		swtGraphics.translate(-1 * bounds.x + viewLocation.x, -1 * bounds.y
				+ viewLocation.y);
		g.getViewport().paint(swtGraphics);
		gc.copyArea(image, 0, 0);
		gc.dispose();
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] { image.getImageData() };
		loader.save(filename, 4);
	}

}
