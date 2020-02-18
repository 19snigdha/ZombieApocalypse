package com.ailo.zombieapocalypse;

//creature class
public class Creature {
	
	int x_coordinate;
	int y_coordinate;
	String move;
	Boolean converted = false;
	
	//constructor
	public Creature(int x, int y) {
		x_coordinate = x;
		y_coordinate = y;
	}
}
