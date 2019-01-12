import java.util.*;
import java.io.*;

class Test {
	public static void main(String[] args) {
		String data = "aaaaaabccccccddeeeee";
		HuffmanCode hf = new HuffmanCode(data);

		//get encode data
		String encodedData = hf.encodeData();
		System.out.println(encodedData);

		// //get decoded data
		hf.decode(hf.getRoot(), encodedData);


	}
}