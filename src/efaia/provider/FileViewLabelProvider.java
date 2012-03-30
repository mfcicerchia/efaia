package efaia.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class FileViewLabelProvider implements ILabelProvider {
	private List<ILabelProviderListener> listeners;

	public FileViewLabelProvider() {
		listeners = new ArrayList<ILabelProviderListener>();
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);

	}

	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Object element) {
		String text = ((File) element).getName();

		if (((File) element).getName().length() == 0) {
			text = ((File) element).getPath();
		}
		return text;
	}

}
