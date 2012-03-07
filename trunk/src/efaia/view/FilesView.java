package efaia.view;

import java.io.File;

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.ViewPart;

import efaia.actions.OpenViewAction;
import efaia.provider.FileViewContentProvider;
import efaia.provider.FileViewLabelProvider;

public class FilesView extends ViewPart {

	public static final String ID = "eFaia.view.FilesView";
	private ListViewer listViewer;
	private List list;

	public FilesView() {
		super();
		this.setPartName("Archivos");
	}

	@Override
	public void createPartControl(Composite parent) {

		listViewer = new ListViewer(parent, SWT.BORDER | SWT.V_SCROLL);
		list = listViewer.getList();
		listViewer.setLabelProvider(new FileViewLabelProvider());
		listViewer.setContentProvider(new FileViewContentProvider());
		listViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				TreeView tv = null;
				OpenViewAction ov = new OpenViewAction(getSite()
						.getWorkbenchWindow(), TreeView.ID);
				ov.run();
				IViewReference[] viewReferences = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getViewReferences();
				for (int i = 0; i < viewReferences.length; i++) {
					if(viewReferences[i].getId().equals(TreeView.ID)){
						tv = (TreeView) viewReferences[i].getPart(true);
					}
						
				}
				
				if(tv != null){
					tv.cargarArbol(event.getSelection().toString());
					tv.setTitle(event.getSelection().toString());
				}
			}
		});

	}

	public void agregarArchivos(File[] files) {

		for (int i = 0; i < files.length; i++) {
			agregarArchivos(files[i]);
		}

	}

	public void agregarArchivos(File file) {
		listViewer.setInput(file);
	}

	@Override
	public void setFocus() {
		listViewer.getControl().setFocus();

	}
	
	public void setearRuta(String path){
		this.setContentDescription(path);
	}
}
