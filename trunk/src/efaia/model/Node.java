package efaia.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String id;
	private String name;
	private String cost;
	private String agentState;
	private List<Node> connections;

	public Node(String id, String name, String cost) {
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append("\n");
		sb.append(name);
		return sb.toString();
	}




}