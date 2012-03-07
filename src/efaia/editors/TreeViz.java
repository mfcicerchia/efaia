package efaia.editors;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.algorithms.SpaceTreeLayoutAlgorithm;
import org.eclipse.swt.SWT;

import efaia.model.Node;
import efaia.model.NodeModelContentProvider;
import efaia.model.Tree;
import efaia.provider.ZestLabelProvider;
import efaia.provider.ZestNodeContentProvider;
import efaia.view.ASView;

public class TreeViz extends EditorPart {
	public static final String ID = "eFaia.editors.TreeViz";
	private Tree t;
	private Node nodoSeleccionado;
	private List<Node> nodos;
	private GraphViewer viewer;
	private String sencodaryId;


	public TreeViz() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new ZestNodeContentProvider());
		viewer.setLabelProvider(new ZestLabelProvider());
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);

	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public void cargarArbol(String path) {
		String p1 = path.replace("[", "").replace("]", "");
		File f = new File(p1);
		NodeModelContentProvider model = new NodeModelContentProvider(
				f.getPath());
		nodos = model.getNodes();
		viewer.setInput(nodos);
		getSite().setSelectionProvider(viewer);
		nodoSeleccionado = nodos.get(0);
		SpaceTreeLayoutAlgorithm l = new SpaceTreeLayoutAlgorithm();
		// l.setResizing(false);
		viewer.setLayoutAlgorithm(l, true);
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
						List<String> keys = n.getASAN();
						List<String> values = n.getASV();

						asView.setearDatos(keys, values);
					}
				}

			}
		});
	}

}
