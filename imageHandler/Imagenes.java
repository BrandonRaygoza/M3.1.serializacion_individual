package imageHandler;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rcs.MenuItem;

public class Imagenes {
	public static final int Altura =110;
	public static final int Ancho =110;
	private  int cont;
	
	public static void Creador_Image(Image[] Im,String[][] Ruta) {
		Direcciones(Ruta);
		try {
			 	for (int i=0;i<5;i++) {
			 Im[i]=new Image(Ruta[i][0]); 
		}
	 
			}
			catch(Exception e) {
			  //  Block of code to handle errors
			}
	
	}
	public static int Existencia(Button[] basura,String busqueda) {
			int cont=0;
		for (int i=0;i<5;i++) {
			if(basura[i].getId().toString().equals(busqueda)){
			cont++;	
			}
		}
		return cont;
	}
	
	public static int Existencia(MenuItem[] basura,String busqueda) {
		int cont=0;
		for (int i=0;i<5;i++) {
			if(basura[i].getId().toString().equals(busqueda)){
				cont++;	
			}
		}
		return cont;
	}
	
	public Imagenes(int cont) {
		this.cont=cont;
	}
	
	public static void Creador_ImaView(ImageView[] ImVi) {
		Image[] Im=new Image[5];
		String[][] Ruta =new String[5][2];
		Creador_Image(Im,Ruta);
		
		for (int i=0;i<5;i++) {
			 ImVi[i]=new ImageView(Im[i]);
			 ImVi[i].setId(Ruta[i][1]);
			 System.out.print("\n"+"imagen "+Ruta[i][0]+" id de imagen"+Ruta[i][1]);
			 ImVi[i].setFitHeight(Altura);ImVi[i].setFitWidth(Ancho);
			 
			 ImVi[i].setX(500);
			 ImVi[i].setY(500);
		}

	}
	public static void Boton_basura(Button[] basura,ImageView[] ImVi) {
		for (int i=0;i<5;i++) {

			 basura[i] = new Button("",ImVi[i]);
			 basura[i].setId(ImVi[i].getId());
			 basura[i].setContentDisplay(ContentDisplay.TOP);
			 basura[i].setPrefSize(Altura,Ancho);
		}
	}
	
	public static void Boton_basura(MenuItem[] basura,ImageView[] ImVi) {
		for (int i=0;i<5;i++) {

			 basura[i] = new MenuItem(ImVi[i]);
			 basura[i].setId(ImVi[i].getId());
			 //basura[i].setContentDisplay(ContentDisplay.TOP);
			 basura[i].setPrefSize(Altura,Ancho);
		}
	}
	
	public static void Cambiar_basura(Button[] basura,ImageView[] ImVi) {
		
		for (int i=0;i<5;i++) {
	
			 basura[i] = new Button("",ImVi[i]);
			 basura[i].setId(String.valueOf(i));
			 basura[i].setContentDisplay(ContentDisplay.TOP);
			 basura[i].setPrefSize(Altura,Ancho);
		}
	}
	
public static void Cambiar_basura(MenuItem[] basura,ImageView[] ImVi) {
		
		for (int i=0;i<5;i++) {
	
			 basura[i] = new MenuItem(ImVi[i]);
			 basura[i].setId(String.valueOf(i));
			 //basura[i].setContentDisplay(ContentDisplay.TOP);
			 basura[i].setPrefSize(Altura,Ancho);
		}
	}
	
	
	
	
	public static void Direcciones(String[][] Ruta) {
		int x;
		String[] Rutas=new String[20];
		
		Rutas[0]= "recursos/residuos/glass/0.png";
		Rutas[1]= "recursos/residuos/glass/1.png";
		Rutas[2]= "recursos/residuos/glass/2.png";
		Rutas[3]= "recursos/residuos/glass/3.png";
		Rutas[4]= "recursos/residuos/metal/0.png";
		Rutas[5]= "recursos/residuos/metal/1.png";
		Rutas[6]= "recursos/residuos/metal/2.png";
		Rutas[7]= "recursos/residuos/metal/3.png";
		Rutas[8]= "recursos/residuos/organic/0.png";
		Rutas[9]="recursos/residuos/organic/1.png";
		Rutas[10]="recursos/residuos/organic/2.png";
		Rutas[11]="recursos/residuos/organic/3.png";
		Rutas[12]="recursos/residuos/paper/0.png";
		Rutas[13]="recursos/residuos/paper/1.png";
		Rutas[14]="recursos/residuos/paper/2.png";
		Rutas[15]="recursos/residuos/paper/3.png";
		Rutas[16]="recursos/residuos/plastic/0.png";
		Rutas[17]="recursos/residuos/plastic/1.png";
		Rutas[18]="recursos/residuos/plastic/2.png";
		Rutas[19]="recursos/residuos/plastic/3.png";
	
			for (int i=0;i<5;i++) {
				x=rng(20);
				Ruta[i][0]=Rutas[x];
				
				System.out.print("\n "+"numero rng"+x+"  ruta "+Rutas[x]);

				if(x>-1 && x<4) {
				Ruta[i][1]="0";	
				}
				
				if(x>3 && x<8) {
				Ruta[i][1]="1";	
				}
				
				if(x>7 && x<12) {
				Ruta[i][1]="2";	
				}
				
				if(x>11 && x<16) {
				Ruta[i][1]="3";	
				}
				
				if(x>15 && x<21) {
				Ruta[i][1]="4";	
				}
				
			}

	}
	public static int rng(int dis)
	{
		Random rand = new Random();
		int valor = rand.nextInt(dis);
		System.out.print(valor);
		return valor;
	}


	public static void SetVisibles(Button[] basura) {
		for (int i=0;i<5;i++) {
			basura[i].setVisible(true);
			
		}
		
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	
}

