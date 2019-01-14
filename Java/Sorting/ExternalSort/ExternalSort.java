import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ExternalSort {

	private File input;
	private static final int RAM_CAP = 100;

	public ExternalSort(String input) {
		this.input = new File(input);
	}

	public boolean sort() throws IOException {

		int rounds = 0;
		ArrayList<Integer> arr = new ArrayList<>();

		//Sorting 
		BufferedReader br = new BufferedReader(new FileReader(input));
		String read;
		while ((read = br.readLine()) != null) {
			arr.add(Integer.valueOf(read));
			if (arr.size() == RAM_CAP) {
				rounds++;
				Collections.sort(arr);
				FileWriter fw = new FileWriter(String.valueOf(rounds) + ".txt");
				for (int i = 0; i < arr.size(); i++) {
					fw.write(String.valueOf(arr.get(i)) + "\n");
				}
				fw.close();
				arr.clear();
			}
		}
		if (arr.size() != 0) {
			rounds++;
			Collections.sort(arr);
			FileWriter fw = new FileWriter(String.valueOf(rounds) + ".txt");
			for (int i = 0; i < arr.size(); i++) {
				fw.write(String.valueOf(arr.get(i)) + "\n");
			}
			fw.close();
			arr.clear();
		}



		// merging files
		FileWriter result = new FileWriter("output.txt");
		BufferedReader[] files = new BufferedReader[rounds];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		String[] reads = new String[rounds];
		for (int i = 0; i < rounds; i++) {
			files[i] = new BufferedReader(new FileReader(String.valueOf(i + 1) + ".txt"));
			reads[i] = files[i].readLine();
			pq.add(Integer.valueOf(reads[i]));

		}
		while (pq.size() != 0) {
			String small = String.valueOf(pq.poll());
			result.write(small + "\n");
			for (int i = 0; i < rounds; i++) {
				if (reads[i] != null && reads[i].equals(small)) {
					reads[i] = files[i].readLine();
					if(reads[i] != null){
						pq.add(Integer.valueOf(reads[i]));
					}
					break;
				}
			}	
		}
		result.close();

		//delete extra files
		File f;
		for (int i = 0; i < rounds; i++) {
			f = new File(String.valueOf(i + 1) + ".txt");
			f.delete();
		}


		return true;
	}
}