package challenges.easy._107_shortest_repetition;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import challenges.ExecuteInterface;

public class Main implements ExecuteInterface {

	public static void main(String... args) throws Exception {
		List<String> lineList = Files.readAllLines(new File(args[0]).toPath(), Charset.defaultCharset());
		System.out.println(new Main().execute(lineList));
	}

	public String execute(List<String> inputList) throws Exception {
		return inputList.stream().map(this::process).collect(Collectors.joining(System.getProperty("line.separator")));
	}

	private String process(String line) {
		int nextIndexOfFirstChar = line.indexOf(line.charAt(0), 1);
		return Integer.toString(nextIndexOfFirstChar == -1 ? line.length() : nextIndexOfFirstChar);
	}
}
