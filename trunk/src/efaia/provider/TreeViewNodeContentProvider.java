package efaia.provider;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.INestedContentProvider;

import efaia.model.Node;

public class TreeViewNodeContentProvider  extends ArrayContentProvider  implements IGraphEntityContentProvider{

	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof Node) {
			Node node = (Node) entity;
			return node.getConnectedTo().toArray();
		}
		throw new RuntimeException("Type not supported");
	}

}
