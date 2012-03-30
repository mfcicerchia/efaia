package efaia.model;

import java.util.List;

public class Tree {

	private List<Node> nodes;
	private List<Connection> connections;
	
	public Tree(List<Node> nodes,List<Connection> connections){
		this.nodes = nodes;
		this.connections = connections;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}
	
	

}
