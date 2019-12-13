package mem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import externLibrary.Wcore;

public class Memoria implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2128200458112401415L;
	public String nombre;
	public int  puntaje;
	public boolean ocupado;
	
	public Memoria(String nombre, int puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.ocupado=true;
	}
	public Memoria(int puntaje) {
		this.nombre = Wcore.leer();
		this.puntaje = puntaje;
		this.ocupado=true;
	}
	
	public Memoria(){
		this.nombre="Nombre "+Wcore.convierteInt(Wcore.rng(100));
		this.puntaje=Wcore.rng(100);
		this.ocupado=false;
		
	}
	
	public static String ListaUsuarios(Memoria[] listas)  
	{
		String l ="";
		
		 for(int x=0;x<25;x++)
			{
					l=(l+listas[x].toString());
					l=(l+"\n");
			}
		//System.out.print(l);
		 
		return l;
	}
	
	
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", puntaje=" + puntaje + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntaje() {	
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public static boolean cmp(Memoria listas) {
		if (listas.isOcupado())
			return listas.isOcupado();
		else 
		  return false;
	}
	
	 public static void Grabar(Memoria[] listas){
		 
		   try {
				ObjectOutputStream salida=new 
				ObjectOutputStream(new FileOutputStream("Lista.obj"));
				 salida.writeObject(listas);
			      salida.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			} 
	 }
	
	 
	 public static void OrdenarLista(Memoria[] listas) {
		Memoria aux;
		
		for(int i = 0;i<25;i++) {
			for(int j = i+1;j<25;j++){
				if  (listas[i].getPuntaje()<listas[j].getPuntaje()) {
				aux=listas[i];
				listas[i]=listas[j];
				listas[j]=aux;
				}	
				
			}
		}		  
	 }
	 
	 public static Memoria[] Leer() throws ClassNotFoundException{
		 Memoria[] listas = new Memoria[25];
		 try {
				ObjectInputStream entrada=new 
				 ObjectInputStream(new FileInputStream("Lista.obj"));
				Memoria[] listas1=(Memoria[])entrada.readObject();		
				listas=listas1;
			    entrada.close();	
			} catch (IOException e) {
								e.printStackTrace();
			}
		return listas;
	 }
    
	 public static void Mostrar(Memoria[] listas) {
		  for(int x=0;x<25;x++)
			{
					System.out.println(listas[x].toString());
			}
	 }
	 public static Memoria[] GLR() {// generar lista random
		 Memoria[] listas = new Memoria[25]; 
		 for(int x=0;x<25;x++)
			{
				listas[x]=new Memoria();	
			}
		return listas;
		 
	 }
	
	 
	 //public static void Guarda(Stage primaryStage, int score) 
	 public static void Guarda(String nombre, int score) 
	 {
		 WriteFile escribe = new WriteFile();
		 /*
		 StackPane secondaryLayout = new StackPane();    
	     Scene secondScene = new Scene(secondaryLayout, 230, 100);
	     
        Stage Ventana = new Stage();
        Ventana.setTitle("Registro");
        Ventana.setScene(secondScene);
     
        
        Ventana.initModality(Modality.WINDOW_MODAL);
        Ventana.initOwner(primaryStage);
        Ventana.setX(primaryStage.getX() + 400);
        Ventana.setY(primaryStage.getY() + 150);
      
        Ventana.initStyle(StageStyle.UNDECORATED);
        Ventana.show();
		GridPane cuadricula = new GridPane();
		cuadricula.setPadding(new Insets(10, 10, 10, 10));
		cuadricula.setVgap(5);
		cuadricula.setHgap(5);
	
		TextField name = new TextField();
		name.setPromptText("Escribe tu nombre:");
		name.setPrefColumnCount(10);
	
		GridPane.setConstraints(name, 0, 0);
		cuadricula.getChildren().add(name);
		Button enviar = new Button("Guardar");
		GridPane.setConstraints(enviar, 1, 0);
		
		enviar.setOnAction(new EventHandler<ActionEvent>() 
		{
			   public void handle(ActionEvent event) 
			   {
				   String nombre =String.valueOf(name.getText());
				   */
				   escribe.WriteOnFile(nombre,String.valueOf(score));
				   //escribe.WriteOnFile(String.valueOf(score));
				   /*
				   Sonidos.sonidoBoton();
				   Ventana.close();
			   	}
		    });
		Button salir = new Button("Cerrar");
		
		GridPane.setConstraints(salir, 1, 1);
		cuadricula.getChildren().addAll(enviar,salir);
		salir.setOnAction(new EventHandler<ActionEvent>() {
			   
			   public void handle(ActionEvent event) {
				 Sonidos.sonidoBoton();
				 Ventana.close(); 
			   	}
		    });
		
		secondaryLayout.getChildren().addAll(cuadricula);
		 */
	 }
	 
	 
	 public static void main(String[] args) throws ClassNotFoundException 
	 {
	    Memoria[] listas = new Memoria[25];
	    //listas=GLR();
	    Grabar(listas);
	    listas=Leer();
	    //Mostrar(listas);
	    //Mostrar(listas);
    }

}
