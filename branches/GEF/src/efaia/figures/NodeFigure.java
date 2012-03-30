package efaia.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

import efaia.figures.listener.FigureMover;
import efaia.model.Node;

public class NodeFigure extends RoundedRectangle implements IFigure {

	private Label idLabel;
	private Label actionLabel;
	private Label costLabel;

	public NodeFigure(Node node) {
		super();
		setBackgroundColor(ColorConstants.lightGray);
		setLayoutManager(new ToolbarLayout());
		setPreferredSize(50, 50);
		setBorder(new LineBorder(1));
		idLabel = new Label(node.getId());
		add(idLabel);
		actionLabel = new Label(node.getName());
		add(actionLabel);
		costLabel = new Label(node.getCost()) {
			protected void paintBorder(Graphics graphics) {
				Rectangle r = getBounds();
				graphics.drawLine(r.x, r.y, r.x + r.width, r.y);
			}

			public Insets getInsets() {
				// top, left, bottom, right
				return new Insets(2, 0, 0, 0);
			}
		};
		add(costLabel);
		new FigureMover(this);
	}

	public void paintFigure(Graphics graphics) {
		Rectangle r = getBounds();
		graphics.setBackgroundPattern(new Pattern(Display.getCurrent(), r.x,
				r.y, r.x + r.width, r.y + r.height, ColorConstants.white,
				ColorConstants.lightBlue));
		graphics.fillRoundRectangle(r, 8, 8);
		graphics.setForegroundPattern(new Pattern(Display.getCurrent(), r.x,
				r.y, r.x + r.width, r.y + r.height, ColorConstants.yellow,
				ColorConstants.yellow));
	}

	public Label getIdLabel() {
		return idLabel;
	}

	public void setIdLabel(String newId) {
		this.idLabel.setText(newId);
	}

	public Label getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String newAction) {
		this.actionLabel.setText(newAction);
	}

	public Label getCostLabel() {
		return costLabel;
	}

	public void setCostLabel(String newCost) {
		this.costLabel.setText(newCost);
	}
	
	
}
