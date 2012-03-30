package efaia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import efaia.model.listeners.NodeListener;

public class Node {
	private String id;
	private String name;
	private String cost;
	private String agentState;
	private List<Node> connections;
	private int x;
	private int y;
	private int width;
	private int height;

	public Node(String id, String name, String cost){
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.agentState = null;
		
		this.connections = new ArrayList<Node>();
	}
	
	public Node(String id, String name, String cost ,String agentState) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.agentState = agentState;
		
		this.connections = new ArrayList<Node>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getAgentState() {
		return agentState;
	}
		
	
	public String getCost() {
		return cost;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public void addNodeConnected(Node son){
		connections.add(son);
	}
	
	public void setConnectedTo(List<Node> sons) {
		connections = sons;
	}

	public List<Node> getConnectedTo() {
		return connections;
	}
	
	public List<String> getASAN() {
		ArrayList<String> agentStateAtrNames = new ArrayList<String>();
		String state = agentState.replace("=","");
		StringTokenizer st = new StringTokenizer(state);
		String[] as = state.split("\"");
		
		for(int i=0; i<as.length;i++){
			if((i % 2)==0)
				agentStateAtrNames.add(as[i].trim());
		}
		
		return agentStateAtrNames;
	}
	
	public List<String> getASV() {
		ArrayList<String> agentStateValues = new ArrayList<String>();
		String state = agentState.replace("=","");
		String[] as = state.split("\"");
		
		for(int i=0; i<as.length;i++){
			if((i % 2)!=0)
				agentStateValues.add(as[i]);
		}
		
		return agentStateValues;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append("\n");
		sb.append(name);
		return sb.toString();
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
