package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
	
	public static void main(String [] args) throws IOException{
		
		File archivo = new File("E:/James/archivos/archivo.txt");
		BufferedWriter bw;
		
		if (archivo.exists()) {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("El archivo ya existe");
		}else{
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("Se acaba de crear el archivo");
		}
		
		bw.close();
		
		//Leer el archivo
		FileReader leerArchivo = new FileReader("E:/James/archivos/archivo.txt");
		// Se crea un String que va tener todo el contenido del archivo
		String texto;
		
		//El contenido del lector se guarda en un BufferedReader
		BufferedReader contenido = new BufferedReader(leerArchivo);
		
		//Con este ciclo extraemos todo el contenido del objeto "contenido" y lo
		//mostramos
		while ((texto = contenido.readLine()) != null) {
			System.out.println(texto);
		}
		
		contenido.close();
		
	}

}
