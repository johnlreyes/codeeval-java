package challenges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public abstract class Common {

	protected boolean log = false;

	abstract protected ExecuteInterface getExecuteInterface();

	@Test
	void provided() throws Exception {
		String expected = getExpected();
		if (log)
			System.out.println("expected=" + expected);
		String actual = getActual();
		if (log)
			System.out.println("actual=" + actual);
		assertEquals(expected, actual);
	}

	private String getFolderPath() {
		return "src/test/java/" + this.getClass().getPackage().getName().replace(".", "/") + "/";
	}

	private String getActual() throws Exception {
		String file = getFolderPath() + "input";
		if (log)
			System.out.println(file);
		if (!new File(file).exists()) {
			throw new FileNotFoundException(file);
		}
		InputStream actualResource = new FileInputStream(file);
		List<String> inputList = getFileContentAsList(actualResource);
		return getExecuteInterface().execute(inputList);
	}

	private String getExpected() throws Exception {
		String file = getFolderPath() + "output";
		if (log)
			System.out.println(file);
		if (!new File(file).exists()) {
			throw new FileNotFoundException(file);
		}
		InputStream expectedResource = new FileInputStream(file);
		return getFileContentAsList(expectedResource).stream()
				.collect(Collectors.joining(System.getProperty("line.separator")));
	}

	private List<String> getFileContentAsList(InputStream expectedResource) {
		return new BufferedReader(new InputStreamReader(expectedResource, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.toList());
	}
}
