package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

public class CopyrightNotices {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/TestFiles/FileDecrypter.java", true);
			fw.write("//Copyright © 2017 by Joey Stack");

			fw.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
