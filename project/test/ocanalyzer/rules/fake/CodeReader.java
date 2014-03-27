package ocanalyzer.rules.fake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CodeReader {

	private static final String TEST_PROJECT_LOCATION = "C:/Users/d056995/git/Object-Calisthenics-Analyzer/testproject/";

	public String readFromFile(String file) {
		File codefile = new File(TEST_PROJECT_LOCATION + "/TestProject/src/"
				+ file);

		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(codefile));
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return stringBuilder.toString();
	}
}
