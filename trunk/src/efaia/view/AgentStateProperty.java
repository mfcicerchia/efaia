package efaia.view;

import java.util.List;

import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class AgentStateProperty extends PropertySheet implements
		ISelectionListener {

	public static final String ID = "eFaia.view.AgentStateProperty";

	public AgentStateProperty() {
		super();
		this.setTitle("Estado del Agente");
	}

	public void agregarPropiedades(List<String> keys, List<String> values) {
		for (int i = 0; i < keys.size(); i++)
			this.setPartProperty(keys.get(i), values.get(i));
		PropertySheetPage page = (PropertySheetPage) getCurrentPage();
		page.refresh();
		System.out.println("Pause");
	}

	protected boolean isImportant(IWorkbenchPart part) {
		if (part.getSite().getId().equals(TreeView.ID))
			return true;
		return false;
	}
	
	

}
