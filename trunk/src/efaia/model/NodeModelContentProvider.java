package efaia.model;

import java.util.ArrayList;
import java.util.List;

public class NodeModelContentProvider {
	private List<Connection> connections;
	private List<Node> nodes;

	public NodeModelContentProvider() {
		// Image here a fancy DB access
		// Now create a few nodes
		nodes = new ArrayList<Node>();
		Node node = new Node("1", "Null");
		nodes.add(node);
		node = new Node("2", "Eat");
		nodes.add(node);
		node = new Node("3", "GoRight");
		nodes.add(node);
		node = new Node("4", "GoLeft");
		nodes.add(node);
		node = new Node("5", "GoUp");
		nodes.add(node);
		node = new Node("6", "GoDown");
		nodes.add(node);

		connections = new ArrayList<Connection>();
		Connection connect = new Connection("1", "1", nodes.get(0),
				nodes.get(1));
		connections.add(connect);
		connect = new Connection("2", "2", nodes.get(0), nodes.get(4));
		connections.add(connect);
		connect = new Connection("3", "3", nodes.get(2), nodes.get(1));
		connections.add(connect);
		connect = new Connection("4", "3", nodes.get(1), nodes.get(3));
		connections.add(connect);

		// Because we are lasy we save the info about the connections in the
		// nodes

		for (Connection connection : connections) {
			connection.getSource().getConnectedTo()
					.add(connection.getDestination());
		}
	}

	public List<Node> getNodes() {
		return nodes;
	}

}
