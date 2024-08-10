package sample;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadingTextData {

	public static void main(String[] args) {
		
		try(var channel = FileChannel.open(Path.of("output.txt"),
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE)) {
			
			var charBuffer = CharBuffer.wrap("Hello Java");
			var encoder = Charset.defaultCharset().newEncoder();
			
			var byteBuffer = encoder.encode(charBuffer);
			
			channel.write(byteBuffer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
