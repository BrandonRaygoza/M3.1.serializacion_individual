package Interfaz;

import static java.lang.System.exit;

import java.util.ArrayList;

import externLibrary.Wcore;
import imageHandler.Imagenes;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
//import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import mem.FileManager;
import mem.Memoria;
import mem.ReadFile;
import rcs.MenuBox;
import rcs.MenuItem;
import rcs.Player;
import rcs.Titulo;

public class Interfaz {

	public static Scene JuegoScreen;
	public static Scene MenuScreen;
	public static Scene ScoreScreen;

	public static AudioClip music;
	
	static int score=0;
	static int vidas=3;
	static int aux=0;
	
	
	public static Parent Scores(Stage primaryStage) 
	{
		/*
		ReadFile leer = new ReadFile();
		Text usuarios = new Text();
		usuarios.setText(leer.ReadAFile());
		usuarios.setFill(Color.BLACK);
		usuarios.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 25));
		*/
		FileManager.numPlayer();
		
		Player[] jugadores = FileManager.getRanking();
		ArrayList<Text> usuarios = new ArrayList<Text>();
		ArrayList<Text> puntos = new ArrayList<Text>();
		ArrayList<Text> pos = new ArrayList<Text>();
		
		
		
		for(int i=0; i<FileManager.numPlayers; i++) {
			
			usuarios.add(i, new Text(jugadores[i].getName()));
			puntos.add(i, new Text(String.valueOf(jugadores[i].getScore())));
			pos.add(new Text(String.valueOf(jugadores[i].getRank())));			
		}
		
		VBox rankBox = new VBox();
		VBox nameBox = new VBox();
		VBox scoreBox = new VBox();
		
		
		
		Pane root = new Pane();
		root.setPrefSize(1024,768);
		
		Image arena= new Image("recursos/fondo1.jpg");
        ImageView img = new ImageView(arena);
        
        img.setFitWidth(1024);
        img.setFitHeight(768);
        
        Titulo tittle = new Titulo ("Puntajes",200);
    	tittle.setTranslateX(400);
    	tittle.setTranslateY(100);

    	
    	//try {
	    	rankBox.setLayoutX(20);		rankBox.setLayoutY(200);	rankBox.getChildren().addAll(pos);		rankBox.setVisible(true);
			nameBox.setLayoutX(50);		nameBox.setLayoutY(200);	nameBox.getChildren().addAll(usuarios);	nameBox.setVisible(true);
			scoreBox.setLayoutX(200);	scoreBox.setLayoutY(200);	scoreBox.getChildren().addAll(puntos);	scoreBox.setVisible(true);
    	/*}
    	catch(Exception e) {
    		System.out.println("Hola");
    	}*/
    	MenuItem back = new MenuItem("ATRAS",175, 40);
    	back.setTranslateY(730);
    	back.setOnMouseReleased(e ->{
    	primaryStage.setScene(MenuScreen);});
       
    	root.getChildren().addAll(img,back,rankBox, nameBox, scoreBox,tittle);
        return root;
		
	}
	public static Parent Juego(Stage primaryStage) 
	{
		int cont=0;
		
		String preguntas[]= {"Orgánico","Metálico","Vidrio","Papel","Plastico"};
		
		ImageView[]ImVi=new ImageView[5];
		Imagenes.Creador_ImaView(ImVi);
		MenuItem[] basura = new MenuItem[5];
		
		Button Reset =new Button();
		Reset=new Button("reset");
			
		Imagenes.Boton_basura(basura,ImVi);
		HBox Contenedor = new HBox();
		
		int x=Wcore.rng(5);
		
		
		MenuItem aceptar = new MenuItem("Aceptar", 100, 50);
		MenuItem cancelar = new MenuItem("Cancelar", 100, 50);
		TextField name = new TextField();
		VBox addPane = new VBox();
		HBox addPaneButtons = new HBox();
		
		addPaneButtons.getChildren().addAll(aceptar, cancelar);
		name.setPrefColumnCount(10);
		name.setMaxWidth(200);
		name.setMaxHeight(50);
		addPane.setLayoutX((1024-200)/2);
		addPane.setLayoutY(primaryStage.getY() + 150);
		addPane.getChildren().addAll(name, addPaneButtons);
		addPane.setVisible(false);
		
		
		aceptar.setOnMouseClicked(e ->{
			
		});
		
		
		
		Text bote=new Text();
		bote.setX(280);
		bote.setY(100);
		bote.setFill(Color.WHITE);
		bote.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));
		
		Text ganaste=new Text("Ganaste");
		ganaste.setX(400);
		ganaste.setY(400);
		ganaste.setVisible(false);
		ganaste.setFill(Color.WHITE);
		ganaste.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 71));
		
		Text perdiste=new Text("Perdiste");
		perdiste.setX(370);
		perdiste.setY(400);
		perdiste.setFill(Color.WHITE);
		perdiste.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 100));
		perdiste.setVisible(false);		
		
		Text lives = new Text("Vidas: "+vidas);
		lives.setX(870);
		lives.setY(50);
		lives.setFill(Color.BLACK);
		lives.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));	
		
		Text shots=new Text("Score: "+score);
		shots.setX(770);
		shots.setY(750);
		shots.setFill(Color.BLACK);
		shots.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 70));
		
		MenuItem submit = new MenuItem("REGISTRAR PUNTAJE",175, 40);
        submit.setTranslateX(415);
        submit.setTranslateY(450);
        submit.setVisible(false);
		
		cont=Imagenes.Existencia(basura,ImVi[x].getId());
		
		System.out.println("\n IMPRIME: "+ImVi[x].getId().toString());
		
		if(ImVi[x].getId().toString().equals("2"))
			bote.setText("Busca materiales tipo: "+preguntas[0]);
		else if(ImVi[x].getId().toString().equals("1"))
			bote.setText("Busca materiales tipo: "+preguntas[1]);
		else if(ImVi[x].getId().toString().equals("0"))
			bote.setText("Busca materiales tipo: "+preguntas[2]);
		else if(ImVi[x].getId().toString().equals("3"))
			bote.setText("Busca materiales tipo: "+preguntas[3]);
		else if(ImVi[x].getId().toString().equals("4"))
			bote.setText("Busca materiales tipo: "+preguntas[4]);
		
		Imagenes contador=new Imagenes(cont);
		
		  basura[0].setOnMouseClicked(e ->
		  {	
			  	lives.setText("Vidas: "+vidas);
				basura[0].setVisible(false);
				if (basura[0].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
				}
				else
					vidas=vidas-1;
					
				System.out.print(contador.getCont());
				if(contador.getCont()==0) {
					bote.setVisible(false);
					shots.setVisible(false);
					Contenedor.setVisible(false);
					score=score+100;
					JuegoScreen = new Scene(Juego(primaryStage));
					primaryStage.setScene(JuegoScreen);
				}
				
				if(vidas==0)
				{
					perdiste.setVisible(true);
					submit.setVisible(true);
					Contenedor.setVisible(false);
					bote.setVisible(false);
					shots.setVisible(false);
					lives.setVisible(false);
					aux=score;
					score=0;
					vidas=3;
				}
			 	lives.setText("Vidas: "+vidas);
			});
		  
		  basura[1].setOnMouseClicked(e ->
		  {	
			  lives.setText("Vidas: "+vidas);
				basura[1].setVisible(false);
				if (basura[1].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
				}
				else
					vidas=vidas-1;
				
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
					bote.setVisible(false);
					shots.setVisible(false);
					Contenedor.setVisible(false);
					score=score+100;
					JuegoScreen = new Scene(Juego(primaryStage));
					primaryStage.setScene(JuegoScreen);
				}
				
				if(vidas==0)
				{
					perdiste.setVisible(true);
					submit.setVisible(true);
					Contenedor.setVisible(false);
					bote.setVisible(false);
					shots.setVisible(false);
					lives.setVisible(false);
					aux=score;
					score=0;
					vidas=3;
				}
				  lives.setText("Vidas: "+vidas);
			});
		  
		  basura[2].setOnMouseClicked(e ->
		  {	
				basura[2].setVisible(false);
				if (basura[2].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
				}
				else
					vidas=vidas-1;
				
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
					bote.setVisible(false);
					shots.setVisible(false);
					Contenedor.setVisible(false);
					score=score+100;
					JuegoScreen = new Scene(Juego(primaryStage));
					primaryStage.setScene(JuegoScreen);
				}
				
				if(vidas==0)
				{
					perdiste.setVisible(true);
					submit.setVisible(true);
					Contenedor.setVisible(false);
					bote.setVisible(false);
					shots.setVisible(false);
					lives.setVisible(false);
					aux=score;
					score=0;
					vidas=3;
				}
				  lives.setText("Vidas: "+vidas);
			});
		  
		  basura[3].setOnMouseClicked(e ->
		  {					
				basura[3].setVisible(false);
				if (basura[3].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
				}
				else
					vidas=vidas-1;
				
				if(contador.getCont()==0) {
					ganaste.setVisible(true);
					shots.setVisible(false);
					bote.setVisible(false);
					Contenedor.setVisible(false);
					score=score+100;
					JuegoScreen = new Scene(Juego(primaryStage));
					primaryStage.setScene(JuegoScreen);
				}
				
				if(vidas==0)
				{
					perdiste.setVisible(true);
					submit.setVisible(true);
					Contenedor.setVisible(false);
					bote.setVisible(false);
					shots.setVisible(false);
					lives.setVisible(false);
					aux=score;
					score=0;
					vidas=3;
				}
				  lives.setText("Vidas: "+vidas);
			});
		  
		  basura[4].setOnMouseClicked(e ->
		  {	
				basura[4].setVisible(false);
				if (basura[4].getId().toString().equals(ImVi[x].getId())){
					contador.setCont(Wcore.dec(contador.getCont()));
				}
				else 
					vidas=vidas-1;
				
				if(contador.getCont()==0) 
				{
						ganaste.setVisible(true);
						shots.setVisible(false);
						bote.setVisible(false);
						Contenedor.setVisible(false);
						score=score+100;
						JuegoScreen = new Scene(Juego(primaryStage));
						primaryStage.setScene(JuegoScreen);
				}
				
				if(vidas==0)
				{
					perdiste.setVisible(true);
					submit.setVisible(true);
					Contenedor.setVisible(false);
					bote.setVisible(false);
					shots.setVisible(false);
					lives.setVisible(false);
					aux=score;
					score=0;
					vidas=3;
				}
				lives.setText("Vidas: "+vidas);
		  });
		  
		  Text registro = new Text("Registrate");
		  registro.setX(400);
		  registro.setY(100);
		  registro.setFill(Color.WHITE);
		  registro.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 70));
		  registro.setVisible(false);
		  
		  submit.setOnMouseReleased (e ->{
			  registro.setVisible(true);
			  addPane.setVisible(true);
			  primaryStage.setScene(JuegoScreen);}
		  );
		  
		  aceptar.setOnMouseReleased(e ->{
			  //Memoria.Guarda(String.valueOf(name.getText()), aux);
			  FileManager.Save(new Player(name.getText(), aux, 0));
			  addPane.setVisible(false);
			  primaryStage.setScene(MenuScreen);
		  });
		  
		  cancelar.setOnMouseReleased(e ->{
			  addPane.setVisible(false);
		  });
		  
		  Reset.setOnMouseClicked(e ->
		  {					
				for (int i=0;i<5;i++) {
					basura[i].setVisible(true);	
					JuegoScreen = new Scene(Juego(primaryStage));
				}
			});
		
		
		Contenedor.setLayoutX(190);Contenedor.setLayoutY(320);
		Contenedor.getChildren().addAll(basura);
       
		
		
		Pane root = new Pane();
		root.setPrefSize(1024,768);
		
		Image arena= new Image("recursos/pasto.jpg");
        ImageView img = new ImageView(arena);
        img.setFitWidth(1024);
        img.setFitHeight(768);
        
        
    	 MenuItem back = new MenuItem("ATRAS",175, 40);
    	 back.setTranslateY(730);
    	 back.setOnMouseClicked(e ->{ 
    		 Imagenes.Cambiar_basura(basura, ImVi);
    		 primaryStage.setScene(MenuScreen);
    		
    	});
    	 root.getChildren().addAll(img,back,submit,Contenedor,Reset,bote,shots,ganaste,lives,perdiste,registro, addPane);
    	 
        return root;
	}
	
	public static Parent Menu(Stage primaryStage)
	{
		//FileManager.resetScore();
		Pane root = new Pane();
		root.setPrefSize(1024,768);
		Image menu= new Image("recursos/fondo1.jpg");
		ImageView img = new ImageView(menu);	
		
		Titulo tittle = new Titulo ("GARBAGE RECYCLER",500);
		tittle.setTranslateX(500);
		tittle.setTranslateY(200);
	
		MenuItem solo = new MenuItem("JUGAR",175, 40);
		solo.setOnMouseReleased (e ->{
			JuegoScreen = new Scene(Juego(primaryStage));
			primaryStage.setScene(JuegoScreen);});
		
		MenuItem puntajes = new MenuItem("PUNTAJES",175, 40);
		puntajes.setOnMouseReleased (e ->{
		ScoreScreen = new Scene(Scores(primaryStage));
		primaryStage.setScene(ScoreScreen);});
		
		MenuItem salir = new MenuItem("SALIR",175, 40);
		salir.setOnMouseReleased(e -> exit(0));
		
		MenuBox vboxTittle = new MenuBox(solo,puntajes,salir);
		vboxTittle.setTranslateX(70);
		vboxTittle.setTranslateY(300);
		root.getChildren().addAll(img,tittle,vboxTittle);
		
	    return root;

}
	
	public void iniciaInterfaz(Stage primaryStage)  {
		//JuegoScreen = new Scene(Juego(primaryStage));
		MenuScreen = new Scene(Menu(primaryStage));
		//ScoreScreen = new Scene(Scores(primaryStage));
		primaryStage.setTitle("Scrap Boy");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(MenuScreen);
		primaryStage.show();
		
	//	SelectMusic selectMusic = new SelectMusic();
		//selectMusic.seleccionM();
		//music.setCycleCount(AudioClip.INDEFINITE);
		//music.play();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				exit(0);
			}
		});
	}
}
