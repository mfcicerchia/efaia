package efaia.view;

import java.io.File;

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;

import efaia.provider.FileViewContentProvider;
import efaia.provider.FileViewLabelProvider;

public class FilesView extends ViewPart {

	public static final String ID = "eFaia.view.FilesView";
	private TreeViewer treeViewer;

	public FilesView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		 
		 Composite archivos = new Composite(parent, SWT.NONE);
		 archivos.setLayout(new TreeColumnLayout());
		 
		 treeViewer = new TreeViewer(archivos, SWT.BORDER);
		 treeViewer.setContentProvider(new FileViewContentProvider());
		 treeViewer.setLabelProvider(new FileViewLabelProvider());
		 Tree tree = treeViewer.getTree();
		 tree.setHeaderVisible(true);
		 tree.setLinesVisible(true);
		 //treeViewer.setInput("Hola");

	}

	public void agregarArchivos(File[] files) {

		for (int i = 0; i < files.length; i++) {
			agregarArchivos(files[i]);
		}

	}

	public void agregarArchivos(File file) {
		treeViewer.setInput(file);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();

	}

}
