package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class fileChooser {

	public int N;

	/* -------------- Get Data -----------------------*/
	
	public void getData(File fileName, int arr[]) {

		Vector<String> v = new Vector<String>();
		String line = null;
		try {

			BufferedReader buffer = new BufferedReader(new FileReader(fileName));
			while ((line = buffer.readLine()) != null)
				v.add(line);
			N++;

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(v.elementAt(i));
		}
	}
	
	/* ----------------- Set Size -----------------------*/
	
	public int setSize(File fileName) {				
		try {

			BufferedReader buffer = new BufferedReader(new FileReader(fileName));
			while (buffer.readLine() != null)
				N++;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return N;
	}
}
