import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileHandling {

	public static void main(String[] args) throws IOException {
		String fileName = "file.txt";

		/*
		 * Call helper methods to write, append, then read to files.
		 * Reads, writes, and appends files located in the current directory.
		 */
		writeFile(fileName);
		appendFile(fileName, "Append this text to the file");
		readFile(fileName);

	}

	static boolean readFile(String _fileName) {
		
		//set file address to current directory
		final String fileAddress = System.getProperty("user.dir") + "\\" + _fileName;
		File file = new File(fileAddress);
		System.out.println("Attempting to read file...");
		
		//try to read from 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String output;
			System.out.println("File output: ");
			while ((output = reader.readLine()) != null) {
				System.out.println(output);
			}
			System.out.println();
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file\n");
			return false;
		}
		return true;

	}

	static boolean appendFile(String _fileName, String _append) {
		
		final String fileAddress = System.getProperty("user.dir") + "\\" + _fileName;
		System.out.println("Attempting to append to file...");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileAddress, true));
			writer.write(_append);
			writer.close();
			System.out.println("String: \"" + _append + "\" appended successfully.\n");
		} catch (IOException e) {
			System.out.println("Error appending file\n");
			return false;
		}
		return true;
	}

	static boolean writeFile(String _fileName) {
		
		File newFile = new File("_fileName");
		System.out.println("Attempting to create file with name: \"" + _fileName + "\"...");
		try {
			newFile.createNewFile();
			System.out.println("File creation successful\n");
			return true;

		} catch (IOException e) {
			System.out.println("Error creating file\n");
			return false;
		}

	}

}
