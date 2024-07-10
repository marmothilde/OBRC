package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import types.Measurement;

public class CalculManager {

	private static HashMap<String, Measurement> map = new HashMap<>();

	public static void compute() throws IOException {

		BufferedReader reader = FileManager.getFile();

		String current = "";
		while ((current = reader.readLine()) != null) {
			addValue(current.split(";"));
		}

		computeAverage();

		printSorted();

	}

	private static void addValue(String[] value) {
		Measurement measurement = map.get(value[0]);
		if (measurement != null) {
			measurement.addValue(Double.parseDouble(value[1]));
		} else {
			map.put(value[0], new Measurement(Double.parseDouble(value[1])));
		}

	}

	private static void computeAverage() {
		for (Map.Entry<String, Measurement> entry : map.entrySet()) {

			entry.getValue().setAverage(entry.getValue().getSum() / entry.getValue().getNbElement());
		}
	}

	public static void printSorted() {
		List<String> sortedKeys = new ArrayList<String>(map.keySet());

		Collections.sort(sortedKeys);

		// Display the TreeMap which is naturally sorted
		for (int i = 0; i < sortedKeys.size(); i++) {
			Measurement mesure = map.get(sortedKeys.get(i));
			if (i == 0) {
				System.out.print("{" + sortedKeys.get(i) + "=" + mesure.toString() + ",");
			} else if (i == sortedKeys.size() - 1) {
				System.out.print(sortedKeys.get(i) + "=" + mesure.toString() + "}\n");
			} else {
				System.out.print(sortedKeys.get(i) + "=" + mesure.toString() + ",");
			}

		}
	}

}
