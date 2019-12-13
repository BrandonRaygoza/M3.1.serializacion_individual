package mem;


import java.io.*;

public class ReadFile {
	
	public String ReadAFile()
	{
		File file;
		FileReader fr;
		BufferedReader br;
		
		String cadena= "";

		try {
			
			file = new File ("archivo.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String leyendo;
			
			while((leyendo=br.readLine())!=null)
			{
				cadena=(cadena+leyendo);
				cadena=(cadena+"\n");
			}
			
			
			br.close();
			fr.close();
			
			
		}catch (Exception e)
		{
			System.out.print("error");
		}
		
		return cadena;
		
	}

}
