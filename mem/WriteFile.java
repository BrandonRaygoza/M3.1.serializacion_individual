package mem;

import java.io.FileWriter;
import java.io.*;

public class WriteFile {

		public void WriteOnFile(String cadena, String score)
		{
			File file;
			FileWriter w;
			BufferedWriter bw;
			PrintWriter wr;
			
			ReadFile leer = new ReadFile();
			String aux = "";
			aux=leer.ReadAFile();
			System.out.print(aux);
			
			try {
				
				file= new File("archivo.txt");
				w= new FileWriter(file);
				bw= new BufferedWriter(w);
				wr= new PrintWriter(bw);
				
				wr.println(aux);
				//wr.println(cadena);
				
				wr.println(cadena+"................................"+score);
				
				
				wr.close();
				bw.close();
				
			}catch (Exception e)
			{
				System.out.print("error");
			}
			
		}
}
