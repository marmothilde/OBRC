import java.io.IOException;
import java.util.Date;

import manager.CalculManager;

public class Main {

	public static void main(String[] args) throws IOException {
		Date start = new Date();

		CalculManager.compute();

		System.out.println((System.currentTimeMillis() - start.getTime()));

	}

}
