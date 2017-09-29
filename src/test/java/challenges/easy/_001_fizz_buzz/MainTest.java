package challenges.easy._001_fizz_buzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class MainTest {

	@Test
	void provided() throws Exception {
		InputStream expectedResource = this.getClass().getResourceAsStream("output");
		String expectedString = new BufferedReader(new InputStreamReader(expectedResource, StandardCharsets.UTF_8))
				.lines().collect(Collectors.joining(System.getProperty("line.separator")));
		InputStream actualResource = this.getClass().getResourceAsStream("input");
		List<String> inputList = new BufferedReader(new InputStreamReader(actualResource, StandardCharsets.UTF_8))
				.lines().collect(Collectors.toList());
		String actualString = new Main().execute(inputList);
		assertEquals(expectedString, actualString);
	}
}
