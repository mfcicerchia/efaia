package efaia.files.handler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import efaia.model.Connection;
import efaia.model.Node;
import efaia.util.Constantes;

public class FileHandler extends DefaultHandler implements Constantes {

	private final XMLReader file;
	private List<Node> nodos;
	private List<Connection> conecciones;

	public FileHandler() throws SAXException {
		file = XMLReaderFactory.createXMLReader();
		file.setContentHandler(this);
		file.setErrorHandler(this);
		nodos = new ArrayList<Node>();
		conecciones = new ArrayList<Connection>();
	}

	public List<Node> getNodos() {
		return nodos;
	}

	public List<Connection> getConecciones() {
		return conecciones;
	}

	public void leer(final String archivoXML) throws FileNotFoundException,
			IOException, SAXException {
		FileReader fr = new FileReader(archivoXML);
		file.parse(new InputSource(fr));
	}

	@Override
	public void startDocument() {
	}

	@Override
	public void endDocument() {
	}

	@Override
	public void startElement(String uri, String name, String qName,
			Attributes atts) {

		if (qName.equals(NODE)) {
			parseNode(atts);
		} else if (qName.equals(EDGE)) {
			parseEdge(atts);
		}
	}

	@Override
	public void endElement(String uri, String name, String qName) {
	}

	protected void parseNode(Attributes atts) {
		String alName, id = null, action = null, cost = null, agentState = null;
		for (int i = 0; i < atts.getLength(); i++) {
			alName = atts.getQName(i);
			if (alName.equals(ID)) {
				id = atts.getValue(i);
			} else if (alName.equals(ACTION)) {
				action = atts.getValue(i);
			} else if (alName.equals(COST)) {
				cost = atts.getValue(i);
			} else if (alName.equals(AGENT_STATE)) {
				agentState = atts.getValue(i);
			}
		}
		if (id == null || action == null || cost == null || agentState == null) {
			System.err.println("Error Nodo");
			return;
		}

		Node n = new Node(id, action, cost, agentState);
		nodos.add(n);
	}

	private void parseEdge(Attributes atts) {

		String alName, idS = null, idT = null;
		for (int i = 0; i < atts.getLength(); i++) {
			alName = atts.getQName(i);
			if (alName.equals(SOURCE)) {
				idS = atts.getValue(i);
			} else if (alName.equals(TARGET)) {
				idT = atts.getValue(i);
			}
		}

		if (idS == null || idT == null) {
			System.err.println("Error Coneccion");
			return;
		}

		Integer s = new Integer(idS);
		Integer t = new Integer(idT);
		Node source = null;
		Node target = null;

		for (int i = 0; i < nodos.size(); i++) {
			if (nodos.get(i).getId().equals(s.toString()))
				source = nodos.get(i);
			if (nodos.get(i).getId().equals(t.toString()))
				target = nodos.get(i);
		}

		if ((source != null) && (target != null)) {
			Connection c = new Connection(idS, idT, source, target);
			conecciones.add(c);
		}

	}

	protected Class parseType(String type) {
		type = Character.toUpperCase(type.charAt(0))
				+ type.substring(1).toLowerCase();
		if (type.equals(INT) || type.equals(INTEGER)) {
			return int.class;
		} else if (type.equals(LONG)) {
			return long.class;
		} else if (type.equals(FLOAT)) {
			return float.class;
		} else if (type.equals(DOUBLE) || type.equals(REAL)) {
			return double.class;
		} else if (type.equals(BOOLEAN)) {
			return boolean.class;
		} else if (type.equals(STRING)) {
			return String.class;
		} else if (type.equals(DATE)) {
			return Date.class;
		} else {
			throw new RuntimeException("Unrecognized data type: " + type);
		}
	}

}
