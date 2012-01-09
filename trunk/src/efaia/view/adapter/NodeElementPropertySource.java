package efaia.view.adapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import efaia.model.Node;

public class NodeElementPropertySource implements IPropertySource {
	final protected NodeElement element;
	protected List<String> attr;
	protected List<String> values;
	protected List<String> idAttr;
	protected IPropertyDescriptor[] propertyDescriptors;

	public NodeElementPropertySource(NodeElement e) {
		super();
		element = e;
		values = new ArrayList<String>();
		attr = new ArrayList<String>();
		idAttr = new ArrayList<String>();
		initProp();
	}

	private void initProp() {
		Node n = element.getControl();
		attr = n.getASAN();
		values = n.getASV();
		for(int i=0; i < attr.size();i++){
			idAttr.add(new Integer(i).toString());
		}
		
	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
            propertyDescriptors = new IPropertyDescriptor[attr.size()];
    
            for (int i=0;i<attr.size();i++) {				
    			// Add each property supported.
    			
    			PropertyDescriptor descriptor = new PropertyDescriptor(idAttr.get(i), attr.get(i));
    			propertyDescriptors[i] = (IPropertyDescriptor)descriptor;
    			descriptor.setCategory("Basic");
    		}
    				
    		// Return it.
    		return propertyDescriptors;
	}

	@Override
	public Object getPropertyValue(Object id) {
		
		for(int i=0; i<idAttr.size();i++)
			if (id.equals(idAttr.get(i)))
				return values.get(i);

		return null;
	}
	

	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}

}
