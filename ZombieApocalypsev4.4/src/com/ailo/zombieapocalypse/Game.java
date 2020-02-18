package com.ailo.zombieapocalypse;

import java.io.*;
import java.util.*;

public class Game {


	public static int zombie_score = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		// Creating queue to hold creature converted to zombie
		Queue<Creature> queue = new LinkedList<Creature>();  
		//Reading the file
		Scanner scan = new Scanner(new FileReader("/Users/snigdha/eclipse-workspace/ZombieApocalypsev4.4/src/com/ailo/zombieapocalypse/input.txt"));
		
		String boardSize = scan.nextLine();
		int N = Integer.parseInt(boardSize);
		
		String coordinate = scan.nextLine();
		
		String input = scan.nextLine();
		
		String moves = scan.nextLine();
		
		Board[][] board = new Board[N][N];
		
	    String[] parts = coordinate.split(",");
	   
	    String x = parts[0].trim().substring(1).trim();
	    String y = parts[1].trim().substring(0, parts[1].trim().length() - 1).trim();
	    
	    
	  
	    String[] no_of_creatures = input.split(" ");
	  
	    Creature[]  creature = new Creature[no_of_creatures.length];
	    
	    for(int i=0;i<creature.length;i++) {
	    		String[] sep = no_of_creatures[i].split(",");
	    	
	    		
	    		String creature_x = sep[0].trim().substring(1).trim();
	    	    String creature_y = sep[1].trim().substring(0, parts[1].trim().length() - 1).trim();
	    	    
		    	
		    	creature[i] = new Creature(Integer.parseInt(creature_x),Integer.parseInt(creature_y));
	    		
	    		
	    }
		
	    int zombie_x_coordinate = Integer.parseInt(x);
	    int zombie_y_coordinate = Integer.parseInt(y);
	    
	    
	    Zombie zombie = new Zombie(zombie_x_coordinate,zombie_y_coordinate, moves);
	    
	    
	    zombieGame(board,zombie,creature,queue);
	   
	    while(!queue.isEmpty()) {
	    		Creature front = queue.poll();
	    		zombieGame(board,front,creature,queue);
	    		
	    }
	    
	    System.out.println("Zombie score "+ zombie_score );
	    System.out.print("Zombies positions:"+ "("+zombie.x_coordinate+ " ,"+zombie.y_coordinate+") ");
	    for(Creature var : creature) {
	    		if(var.converted) {
	    			System.out.print( "("+var.x_coordinate+  " ,"+var.y_coordinate+") ");
	    		}
	    } 
		scan.close();
	}
	
	/* This method would match the coordinates of zombie and creature
	 */
	public static boolean coordinatesMatch(Board board[][], Zombie zombie,Creature[] creature,Queue<Creature> queue) {
		
		    if (zombie == null) {
		        return false;
		    }
		    for (Creature var : creature) 
		    { 
		        if((zombie.x_coordinate == var.x_coordinate && zombie.y_coordinate == var.y_coordinate) && (!var.converted)){
		        		var.converted = true;
		        		var.move = zombie.move;
		        		queue.add(var);
		        		return true;
		        		
		        }
		    }
		    return false;	
	}
	/* This method would match the coordinates of converted zombie and creature
	 */
	public static boolean coordinatesMatch(Board board[][], Creature front,Creature[] creature,Queue<Creature> queue) {
	    if (front == null) {
	        return false;
	    }
	    for (Creature var : creature) 
	    { 
	        if((front.x_coordinate == var.x_coordinate && front.y_coordinate == var.y_coordinate) && (!var.converted)){
	        		var.converted = true;
	        		var.move = front.move;
	        		queue.add(var);
	        		return true;
	        		
	        }
	    }
	    return false;	
}
	
	/* This method would play the game on zombie's move
	 */
	static void zombieGame(Board[][] board, Zombie zombie,Creature[] creature, Queue<Creature> queue) {
		
		
		char[] ch = zombie.move.toCharArray(); 
		
		
        for (char c : ch) {
        		
            if(c == 'R') {
            		
            		
            		if(zombie.x_coordinate == board.length-1) {
            			zombie.x_coordinate = 0;
            		}
            		else {
            			zombie.x_coordinate += 1;
            		}

            		
            }
            if(c == 'L') {
            		
            		if(zombie.x_coordinate == 0) {
            			zombie.x_coordinate = board.length-1;
            		}
            		else {
            			zombie.x_coordinate -= 1;
            		}
            		
            	
            }
            if(c == 'U') {
            		
            		if(zombie.y_coordinate == 0) {
            			zombie.y_coordinate = board.length-1;
            		}
            		else {
            			zombie.y_coordinate -= 1;
            		}
         
            	
            }
            if(c == 'D') {
            		
            		if(zombie.y_coordinate == board.length-1) {
            			zombie.y_coordinate = 0;
            		}
            		else {
            			zombie.y_coordinate += 1;
            		}
            	
            }
            //matching the coordinates of zombie and creature
            boolean match = coordinatesMatch(board,zombie,creature,queue);
            if(match) {
            		zombie_score +=1;
    				
    				
    			}
        
        } 
	}
	
	/* This method would play the game on converted zombie's move
	 */
	
static void zombieGame(Board[][] board,Creature front, Creature[] creature, Queue<Creature> queue) {
		
		
	char[] ch = front.move.toCharArray(); 
	
	
    for (char c : ch) {
    		
        if(c == 'R') {
        		
        		
        		if(front.x_coordinate == board.length-1) {
        			front.x_coordinate = 0;
        		}
        		else {
        			front.x_coordinate += 1;
        		}
        		
        		
        }
        if(c == 'L') {
        		
        		if(front.x_coordinate == 0) {
        			front.x_coordinate = board.length-1;
        		}
        		else {
        			front.x_coordinate -= 1;
        		}
        		
        	
        }
        if(c == 'U') {
        		
        		if(front.y_coordinate == 0) {
        			front.y_coordinate = board.length-1;
        		}
        		else {
        			front.y_coordinate -= 1;
        		}
     
        	
        }
        if(c == 'D') {
        		
        		if(front.y_coordinate == board.length-1) {
        			front.y_coordinate = 0;
        		}
        		else {
        			front.y_coordinate += 1;
        		}
        	
        }
        //Matching the coordinates of zombie and creature
        boolean match = coordinatesMatch(board,front,creature,queue);
        if(match) {
        		zombie_score +=1;
				
				
			}
    
    } 
	}

}
