package efaia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import efaia.files.handler.FileHandler;

public class NodeModelContentProvider {
	private List<Connection> connections;
	private List<Node> nodes;
	private FileHandler fh;

	public NodeModelContentProvider() {
		// Image here a fancy DB access
		// Now create a few nodes
		nodes = new ArrayList<Node>();

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
	
	public NodeModelContentProvider(String filePath){
		try {
			fh = new FileHandler();
			fh.leer(filePath);
			nodes = fh.getNodos();
			connections = fh.getConecciones();
			for (Connection connection : connections) {
				connection.getSource().getConnectedTo()
						.add(connection.getDestination());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	

	public List<Node> getNodes() {
		return nodes;
	}

}
