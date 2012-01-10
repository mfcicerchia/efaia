package efaia.view;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class ASView extends ViewPart {
	
	public static final String ID = "eFaia.view.ASView";
	private Table agentState;

	public ASView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		agentState = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		agentState.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		agentState.setHeaderVisible(true);
		agentState.setLinesVisible(true);
		
		TableColumn tblclmnPropiedad = new TableColumn(agentState, SWT.NONE);
		tblclmnPropiedad.setWidth(251);
		tblclmnPropiedad.setText("Propiedad");
		
		TableColumn tblclmnValor = new TableColumn(agentState, SWT.NONE);
		tblclmnValor.setWidth(117);
		tblclmnValor.setText("Valor");
		
		
		

	}
	
	private void agregarFila(String key, String value){
		TableItem item= new TableItem(agentState, SWT.NONE);
		item.setText(0,key);
		item.setText(1,value);	
	}
	
	public void setearDatos(List<String> keys, List<String> values){
		agentState.removeAll();
		for(int i=0;i<keys.size();i++)
			agregarFila(keys.get(i), values.get(i));
		
		agentState.redraw();
	}

	@Override
	public void setFocus() {
		agentState.setFocus();

	}
	
	

}
