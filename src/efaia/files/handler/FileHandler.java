package efaia.files.handler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import efaia.util.Constantes;

public class FileHandler extends DefaultHandler implements Constantes {

	private final XMLReader file;

	public FileHandler() throws SAXException {
		file = XMLReaderFactory.createXMLReader();
		file.setContentHandler(this);
		file.setErrorHandler(this);
	}

	public void leer(final String archivoXML) throws FileNotFoundException,
			IOException, SAXException {
		FileReader fr = new FileReader(archivoXML);
		file.parse(new InputSource(fr));
	}

	@Override
	public void startDocument() {
		System.out.println("Comienzo del Documento XML");
	}

	@Override
	public void endDocument() {
		System.out.println("Final del Documento XML");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println(qName);
		System.out.println(attributes.getIndex(qName));
		System.out.println(uri);
		
	}

//	@Override
	/*public void startElement(String uri, String name, String qName,
			Attributes atts) {
		
		if ( qName.equals(BRANCH) || qName.equals(LEAF) ) {
//            schemaCheck();
            
            // parse a node element
            Node n;
            if ( m_activeNode == null ) {
                n = m_tree.addRoot();
            } else {
                n = m_tree.addChild(m_activeNode);
            }
            m_activeNode = n;
        }
        else if ( qName.equals(NODE) ) {
            // parse an attribute
            parseAttribute(atts);
        } else if(qName.equals(AGENT_STATE)){
        	// parsea el estado del agente.
        	parseAgentState(atts);
        }
		
		
		System.out.println("tElemento: " + name);

		for (int i = 0; i < atts.getLength(); i++) {
			System.out.println("ttAtributo: " + atts.getLocalName(i) + " = "
					+ atts.getValue(i));
		}
	}

	@Override
	public void endElement(String uri, String name, String qName) {
		System.out.println("tFin Elemento: " + name);
	}
	
    protected void parseAgentState(Attributes atts) {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<atts.getLength();i++){
        	sb.append(atts.getQName(i));
        	sb.append("=");
        	sb.append(atts.getValue(i));
        	sb.append("  ");
        	if(i != atts.getLength()-1)
        		sb.append("\n");
        }
		System.out.println("------------------------------");
		System.out.println(sb.toString());
		System.out.println("------------------------------");
		
//		m_activeNode.set(AGENT_STATE, sb.toString());
	}
    
    protected void parseAttribute(Attributes atts) {
        String alName, id = null, action = null;
        for ( int i = 0; i < atts.getLength(); i++ ) {
            alName = atts.getQName(i);
            if ( alName.equals(ID) ) {
                id = atts.getValue(i);
            } else if ( alName.equals(ACTION) ) {
                action = atts.getValue(i);
            }
        }
        if ( id == null || action == null ) {
            System.err.println("Attribute under-specified");
            return;
        }

        try {
            //Object val = parse(value, m_nodes.getColumnType(name));
        	StringBuilder sb = new StringBuilder();
        	sb.append(id);
        	sb.append("\n");
        	sb.append(action);
//            m_activeNode.set(NODE, sb.toString());
        } catch ( Exception e ) {
            throw new RuntimeException(e);
        }
    }*/

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
