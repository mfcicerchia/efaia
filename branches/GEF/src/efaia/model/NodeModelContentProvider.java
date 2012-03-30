package efaia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import efaia.files.handler.FileHandler;
import efaia.util.FileNotSupportedException;

public class NodeModelContentProvider {
	private List<Connection> connections;
	private List<Node> nodes;
	private FileHandler fh;

	public NodeModelContentProvider(String filePath) throws FileNotSupportedException, SAXException, FileNotFoundException, IOException {
			fh = new FileHandler();
			fh.leer(filePath);
			nodes = fh.getNodos();
			connections = fh.getConecciones();


			if(nodes.size() == 0){
				throw new FileNotSupportedException("El árchivo seleccionado no es válido.");
			}
			
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
	}

	public List<Node> getNodes() {
		return nodes;
	}

}
