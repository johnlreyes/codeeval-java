package challenges.easy._001_fizz_buzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class MainTest {

	@Test
	void provided() throws Exception {
		assertEquals(getExpected(), getActual());
	}

	private String getActual() throws IOException {
		InputStream actualResource = this.getClass().getResourceAsStream("input");
		List<String> inputList = getFileContentAsList(actualResource);
		return new Main().execute(inputList);
	}

	private String getExpected() {
		InputStream expectedResource = this.getClass().getResourceAsStream("output");
		return getFileContentAsList(expectedResource).stream()
				.collect(Collectors.joining(System.getProperty("line.separator")));
	}

	private List<String> getFileContentAsList(InputStream expectedResource) {
		return new BufferedReader(new InputStreamReader(expectedResource, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.toList());
	}
}
