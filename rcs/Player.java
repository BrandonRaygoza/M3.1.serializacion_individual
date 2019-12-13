package rcs;

import java.io.Serializable;

public class Player implements Serializable{
	private String name;
	private int score;
	private int rank;
	
	public Player() {}
	
	public Player(String nombre, int puntos, int posicion) {
		setName(nombre);
		setScore(puntos);
		setRank(posicion);
	}

	public void setName(String nombre) {
		// TODO Auto-generated method stub
		this.name = nombre;
	}

	public void setScore(int puntos) {
		// TODO Auto-generated method stub
		this.score = puntos;
	}

	public void setRank(int posicion) {
		// TODO Auto-generated method stub
		this.rank = posicion;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getRank() {
		return this.rank;
	}
}
