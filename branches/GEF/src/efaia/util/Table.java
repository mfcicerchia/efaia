package efaia.util;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	protected List<String> columnsNames;
	
	protected List rows;
	
	public Table(List<String> columnsNames) {
		this.columnsNames = columnsNames;
		rows = new ArrayList();
	}
	
	public Table(){
		this.columnsNames = new ArrayList();
		this.rows = new ArrayList();
	}
	
	public void addColumn(String columnName){
		this.columnsNames.add(columnName);
	}
	
	public void addColumns(List<String> columnNames){
		this.columnsNames.addAll(columnNames);
	}
	
	public void set(String field, Object value){
		if(columnsNames.contains(field)){
			
		}
		else{
			System.err.println("ERROR NO CONTIENE LA COLUMNA");
		}
		
	}
		
	

}
