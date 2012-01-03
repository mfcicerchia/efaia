package efaia.provider;

import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FileViewContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		System.out.println(inputElement.toString());
		File f = ((File)inputElement);
		return f.listFiles();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
//		return ((File) parentElement).listFiles();
		return ((File) parentElement).listFiles();
	}

	@Override
	public Object getParent(Object element) {
		return ((File) element).getParentFile();
	}

	@Override
	public boolean hasChildren(Object element) {
		Object[] obj = getChildren(element);
	    return obj == null ? false : obj.length > 0;
	}

}
