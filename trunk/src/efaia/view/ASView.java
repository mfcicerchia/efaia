package efaia.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ASView extends ViewPart {
	
	public static final String ID = "eFaia.view.ASView";
	private Text asText;

	
	
	public ASView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		asText = new Text(parent, SWT.BORDER | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.CENTER | SWT.MULTI);
		asText.setEnabled(false);
/*		asText.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		asText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));*/
		asText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		
		

	}
	
	
	public void setearDatos(String agentState){
		asText.setText(agentState);
	}

	@Override
	public void setFocus() {
		asText.setFocus();

	}
	
	

}
