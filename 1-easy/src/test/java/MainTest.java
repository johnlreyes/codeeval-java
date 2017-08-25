import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MainTest {
  @Test
  void provided() throws IOException {
    StringBuilder expected = new StringBuilder();
    Files.readAllLines(new File("output").toPath(), Charset.defaultCharset()).forEach(line -> {
      expected.append(line);
      expected.append(System.getProperty("line.separator"));
    }); 
    assertEquals(expected.toString().trim(), new Main().execute("input").toString().trim()); 
  }
}
