package efaia.util;

import java.io.File;

public class FilesPath {
	
	

	
	public static File[] generarFiles(String path, String[] names){
		File[] archivos = new File[names.length];
		
		for (int i = 0; i < archivos.length; i++) {
			archivos[i]= new File(path+"/"+names[i]);
		}
		
		return archivos;
	}

}
