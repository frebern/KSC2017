import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {

	public Read() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("test.txt"));
			long d=0;
			while(in.read() != -1) d++;
			in.close();
			System.out.println("Size: "+d+"Byte");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) {
		new Read();
	}

}
