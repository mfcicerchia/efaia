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

	public NodeModelContentProvider(String filePath) {
		try {
			fh = new FileHandler();
			fh.leer(filePath);
			nodes = fh.getNodos();
//			System.out.println(nodes.size());
			connections = fh.getConecciones();
//			System.out.println(connections.size());


			for (int i = 0; i < nodes.size(); i++) {
				for (int j = 0; j < connections.size(); j++) {;
					if(nodes.get(i).equals(connections.get(j).getSource()))
						nodes.get(i).addNodeConnected(connections.get(j).getDestination());
				}
			}
			
			
/*			for (Connection connection : connections) {
				connection.getSource().getConnectedTo()
						.add(connection.getDestination());
			}*/

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
