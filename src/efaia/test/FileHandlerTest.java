package efaia.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

import efaia.files.handler.FileHandler;
import efaia.model.Node;

public class FileHandlerTest {
	public static String FILE = "/home/kbza/workspace/FAIAUI/searchTrees/13Bis.xml";

	public static void main(String[] args) {
		try {
			FileHandler fh = new FileHandler();
			fh.leer("/home/kbza/Facultad/Proyecto/efaia/archivos/13.xml");
			ArrayList<Node> nodos = new ArrayList<Node>();
			nodos = (ArrayList<Node>) fh.getNodos();
			
			System.out.println(nodos.get(0).getASAN());
			System.out.println(nodos.get(0).getASV());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

}
