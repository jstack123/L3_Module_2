package TestFiles;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileEncrypter {

	public static void main(String[] args) {
		 String message = JOptionPane.showInputDialog("Write a message in the space below.");
		 String encryptedMessage = "";
			for (int i = 0; i < message.length(); i++) {
				char c = message.charAt(i);
				c += 2;
				encryptedMessage += (char) c;
			}
			System.out.println(encryptedMessage);
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/fw.txt");
			fw.write(encryptedMessage);

			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
