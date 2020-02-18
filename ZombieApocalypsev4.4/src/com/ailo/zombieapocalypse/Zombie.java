package com.ailo.zombieapocalypse;

//zombie class

public class Zombie {

	int x_coordinate;
	int y_coordinate;
	String move;
	
	
	//constructor
	public Zombie(int x, int y, String move) {
		x_coordinate = x;
		y_coordinate = y;
		this.move = move;
	}
}
