package efaia.view.adapter;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.views.properties.IPropertySource;

import efaia.model.Node;

public class NodeElement implements IWorkbenchAdapter,IAdaptable {
	
	protected Node nodo;
	protected String name;
	
	public NodeElement(Node initNode, String heading) {
		this.name = heading;
		this.nodo = initNode;
	}
    
    public Node getControl() {
		return nodo;
	}
    public Object getAdapter(Class adapter) {
		if (adapter == IWorkbenchAdapter.class)
			return this;
		if (adapter == IPropertySource.class)
			return new NodeElementPropertySource(this);
		return null;
	}
	/* (non-Javadoc)
	 * Method declared on IWorkbenchAdapter
	 */
	public ImageDescriptor getImageDescriptor(Object object) {
		return null;
	}
	/* (non-Javadoc)
	 * Method declared on IWorkbenchAdapter
	 */
	public String getLabel(Object o) {
		return name;
	}
	/* (non-Javadoc)
	 * Method declared on IWorkbenchAdapter
	 */
	public Object getParent(Object o) {
		return null;
	}

	@Override
	public Object[] getChildren(Object o) {
		return null;
	}
	


}
