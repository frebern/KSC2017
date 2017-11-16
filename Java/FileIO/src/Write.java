import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

	public Write() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("test.txt"));
			long GB = 1*1024*1024*1024;
			while(GB--!=0) out.write('A');
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Write();
	}

}
