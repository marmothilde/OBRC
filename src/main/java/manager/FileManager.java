package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

	private static final Path PATH = Paths.get("src/main/resources/measurements.txt");

	public static BufferedReader getFile() throws IOException {

		return Files.newBufferedReader(PATH);

	}

}
