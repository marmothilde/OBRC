package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import types.Measurement;

public class CalculManager {

	private static HashMap<String, Measurement> map = new HashMap<>();

	public static void compute() throws IOException {

		BufferedReader reader = FileManager.getFile();

		String current = "";
		while ((current = reader.readLine()) != null) {
			addValue(parseLine(current));
		}
		printSorted();
	}

	private static void addValue(Object[] value) {
		Measurement measurement = map.get(value[0]);
		if (measurement != null) {
			measurement.addValue((int) value[1]);
		} else {
			map.put((String) value[0], new Measurement((int) value[1]));
		}

	}

	public static void printSorted() {
		List<String> sortedKeys = new ArrayList<String>(map.keySet());

		Collections.sort(sortedKeys);

		for (int i = 0; i < sortedKeys.size(); i++) {
			Measurement mesure = map.get(sortedKeys.get(i));
			if (i == 0) {
				System.out.print("{" + sortedKeys.get(i) + "=" + mesure.toString() + ", ");
			} else if (i == sortedKeys.size() - 1) {
				System.out.print(sortedKeys.get(i) + "=" + mesure.toString() + "}\n");
			} else {
				System.out.print(sortedKeys.get(i) + "=" + mesure.toString() + ", ");
			}

		}
	}

	public static Object[] parseLine(String line) {
		int index = line.indexOf(';');
		String stationName = line.substring(0, index);
		int y = parseTemp(line.substring(index + 1));
		return new Object[] { stationName, y };
	}

	private static int parseTemp(String temp) {
		int index = temp.indexOf('.');

		return (temp.charAt(0) == '-')
				? (Integer.parseInt(temp.substring(0, index)) * 10) - Integer.parseInt(temp.substring(index + 1))
				: (Integer.parseInt(temp.substring(0, index)) * 10) + Integer.parseInt(temp.substring(index + 1));

	}
}
