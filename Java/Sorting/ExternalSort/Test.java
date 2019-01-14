import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.File;

public class Test {
	public static void main(String[] args) throws IOException {
		//A file with random numbers
		FileWriter fw = new FileWriter("input.txt");
		Random rand = new Random();
		for (int i = 0; i < 1022; i++) {
			fw.write(String.valueOf(rand.nextInt(1000) + 1) + "\n");
		}
		fw.close();

		//sorting
		ExternalSort es = new ExternalSort("input.txt");
		es.sort();
	}
}