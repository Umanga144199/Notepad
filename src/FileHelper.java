import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

	public static void saveFile(String path, String content) throws IOException {
		FileWriter writer = new FileWriter("C:/Users/Umanga/Desktop/" + path
				+ ".txt");
		writer.write(content);
		writer.close();
	}

	public static String openFile(String path) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = "";
		StringBuilder box = new StringBuilder();
		
		while((line = reader.readLine()) != null){	
		box.append(line + "\r\n");
	}
		return box.toString();
			
		
	}
}
