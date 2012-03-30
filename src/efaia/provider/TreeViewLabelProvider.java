package efaia.provider;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IFigureProvider;

import efaia.figures.NodeFigure;
import efaia.model.Connection;
import efaia.model.Node;

public class TreeViewLabelProvider extends LabelProvider implements IColorProvider, IFigureProvider, ISelectionProvider {
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

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return ColorConstants.black;
	}

	@Override
	public Color getBackground(Object element) {
		return ColorConstants.lightGray;
	}

	@Override
	public IFigure getFigure(Object element) {
		if (element instanceof Node) {
			Node myNode = (Node) element;
			NodeFigure nf = new NodeFigure(myNode);
			nf.setSize(nf.getPreferredSize());
			return nf;
		}
		return null;
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelection(ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	

}
