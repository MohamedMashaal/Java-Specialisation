import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		URLResource res = new URLResource("http://www.dukelearntoprogram.com");
		for (String line : res.lines()) {
			System.out.println(line);
		}
	}
}
