package efaia.provider;

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;

import efaia.model.Connection;
import efaia.model.Node;

public class ZestLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof Node) {
			Node myNode = (Node) element;
			StringBuilder sb = new StringBuilder();
			sb.append(myNode.getId());
			sb.append("\n");
			sb.append(myNode.getName());
			sb.append("\n");
			sb.append(myNode.getCost());
			return sb.toString();
		}
		// Not called with the IGraphEntityContentProvider
		if (element instanceof Connection) {
			Connection myConnection = (Connection) element;
			return myConnection.getLabel();
		}

		if (element instanceof EntityConnectionData) {
			EntityConnectionData test = (EntityConnectionData) element;
			return "";
		}
		throw new RuntimeException("Wrong type: "
				+ element.getClass().toString());
	}

}
