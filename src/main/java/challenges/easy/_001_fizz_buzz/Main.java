package challenges.easy._001_fizz_buzz;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String... args) throws IOException {
		List<String> lineList = Files.readAllLines(new File(args[0]).toPath(), Charset.defaultCharset());
		System.out.println(new Main().execute(lineList));
	}

	public String execute(List<String> inputList) throws IOException {
		List<List<Result>> listOfResultList = inputList.stream().map(this::toResultList).collect(Collectors.toList());
		List<String> resultStringList = listOfResultList.stream().map(this::toString).collect(Collectors.toList());
		return resultStringList.stream().collect(Collectors.joining(System.getProperty("line.separator")));
	}

	private String toString(List<Result> resultList) {
		return resultList.stream().map(result -> result.toString()).collect(Collectors.joining(" "));
	}

	private List<Result> toResultList(String line) {
		Input input = toInput(line);
		List<Result> results = new ArrayList<>();
		for (int i = 1; i <= input.max; i++) {
			results.add(fizzBuzz(i, input.fizz, input.buzz));
		}
		return results;
	}

	private Result fizzBuzz(int number, int fizz, int buzz) {
		Result result = new Result();
		result.fizz = number % fizz == 0;
		result.buzz = number % buzz == 0;
		result.number = number;
		return result;
	}

	private Input toInput(String str) {
		List<Integer> list = Arrays.stream(str.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
		Input returnValue = new Input();
		returnValue.fizz = list.get(0);
		returnValue.buzz = list.get(1);
		returnValue.max = list.get(2);
		return returnValue;
	}

	private static class Input {
		int fizz;
		int buzz;
		int max;
	}

	private static class Result {
		boolean fizz = false;
		boolean buzz = false;
		int number;

		@Override
		public String toString() {
			return (fizz ? "F" : "") + (buzz ? "B" : "") + (!fizz && !buzz ? number : "");
		}
	}
}
