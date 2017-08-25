import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
public class Main {
  public static void main(String ... args) throws IOException {
    System.out.println(new Main().execute(args[0]).toString()); 
  }
  public StringBuilder execute(String filename) throws IOException {
    StringBuilder returnValue = new StringBuilder(); 
    Files.readAllLines(new File(filename).toPath(), Charset.defaultCharset()).forEach(line -> {
      int[] arr = Arrays.stream(line.split("\\s+")).map(String::trim).mapToInt(Integer::parseInt).toArray();
      int limit = arr[2];
      int fizz = arr[0];
      int buzz = arr[1];
      List<String> list = new ArrayList<>();
      for (int i=1; i<=limit; i++) {
        StringBuilder entry = new StringBuilder();
        if (i%fizz==0) {
          entry.append("F");
        }
        if (i%buzz==0) {
          entry.append("B");
        }
        if (entry.length()==0) {
          entry.append(i);
        }
        list.add(entry.toString());
      }
      returnValue.append(list.stream().collect(Collectors.joining(" ")));
      returnValue.append(System.getProperty("line.separator"));
    });
    return returnValue;
  }
}
