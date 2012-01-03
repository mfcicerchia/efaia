package efaia.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private final String id;
	private final String name;
	private final String agentState;
	private List<Node> connections;

	public Node(String id, String name) {
		this.id = id;
		this.name = name;
		this.agentState = null;
		
		this.connections = new ArrayList<Node>();
	}
	
	public Node(String id, String name, String agentState) {
		this.id = id;
		this.name = name;
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
