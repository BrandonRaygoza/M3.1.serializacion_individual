package mem;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rcs.Player;

public class FileManager {
	private static Player[] List = new Player[11];
	private static Player nullPlayer = new Player(null, -1, -1);
	public static int numPlayers;
	
	public static void resetScore() {
		for(int i=0; i<10; i++)
			List[i] = nullPlayer;
		writeScore();
		numPlayers=0;
	}
	
	public static void numPlayer() {
		int num=0;
		readScore();
		//try {
			for(int i=0; i<10; i++)
				if(List[i].getName()!=null)
					num++;
		//}
		//catch(Exception e) {
		//	System.out.println("Viejo"+num);
		//}
		System.out.println("Viejo"+num);
		
		numPlayers = num;
	}
	
	private static void readScore() {
            try {
                FileInputStream fileInputStream = new FileInputStream("Rank.dat");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                List = (Player[])objectInputStream.readObject();

                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
	}
	
	private static void writeScore() {
		try {  
                FileOutputStream fileOutputStream = new FileOutputStream("Rank.dat");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

                objectOutputStream.writeObject(List);
                bufferedOutputStream.flush();

                objectOutputStream.close();
                bufferedOutputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
	}
	
	public static void Save(Player newPlayer) {
		readScore();
		//try {
			if(numPlayers < 10)
				List[numPlayers++] = newPlayer;
			else
				if(newPlayer.getScore() > List[9].getScore())
					List[9] = newPlayer;
		//}
		//catch(Exception e) {
		//	System.out.println("Nuevo "+numPlayers);
		//}
		sort();
		writeScore();
		numPlayer();
		numPlayers=10;
		for(int j=0; j<numPlayers; j++)
			System.out.println(List[j].getName()+List[j].getScore());
		System.out.println("Nuevo "+numPlayers);
	}
	
	public static void sort() {
		for(int i=0; i<numPlayers-1; i++)
			for(int j=i+1; j<numPlayers; j++)
				if(List[i].getScore()<List[j].getScore()) {
					Player aux = List[i];
					List[i] = List[j];
					List[j] = aux;
				}
		setRank();
	}
	
	private static void setRank() {
		for(int i=0; i<numPlayers; i++)
			List[i].setRank(i+1);
	}
	
	public static Player[] getRanking() {
		numPlayer();
		return List;
	}
}
