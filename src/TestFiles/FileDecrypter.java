package TestFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileDecrypter {
	public static void main(String[] args) {

		/*JFileChooser jfc = new JFileChooser();
		
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}*/
		String contents = "";
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("src/intro_to_file_io/fw.txt"));
				String line = br.readLine();
				while (line != null) {
					contents += line;
					line=br.readLine();
				}
				System.out.println(contents);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String decrpytedMessage = "";
			for (int i = 0; i < contents.length(); i++) {
				char c = contents.charAt(i);
				c -= 2;
				decrpytedMessage += (char) c;
			}
			System.out.println(decrpytedMessage);
		}
	}
//Copyright © 2017 by Joey Stack//Copyright © 2017 by Joey Stack