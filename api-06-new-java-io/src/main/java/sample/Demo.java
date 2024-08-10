package sample;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Demo {

	public static void main(String[] args) {
		
		try(var input = FileChannel.open(Path.of("mysql.jar"), StandardOpenOption.READ);
				var output = FileChannel.open(Path.of("copy.jar"), 
						StandardOpenOption.CREATE,
						StandardOpenOption.TRUNCATE_EXISTING, 
						StandardOpenOption.WRITE)) {
			
			input.transferTo(0, input.size(), output);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
