package fr.imie.gameoflife.model;

import java.util.Random;

public class World {
	
	private Cell[][] myWorld;
	
	public World() {
	}

	public World (int nbColumn, int nbRows) {
		myWorld = new Cell[nbColumn][nbRows];
		
		for (int i = 0; i < myWorld.length; i++) {
			for (int j = 0; j < myWorld[0].length; j++) {
				Random rand = new Random();
				if (rand.nextBoolean()) {
					myWorld[i][j] = new AliveCell();
				} else {
					myWorld[i][j] = new DeadCell();
				}
			}
		}
	}

	@Override
	public String toString() {
		String strWorld = "";
		
		for (int i = 0; i < myWorld.length; i++) {
			for (int j = 0; j < myWorld.length; j++) {
				strWorld += myWorld[i][j].getAsString();
			}
			strWorld += "\n";
		}
		
		return strWorld;
	}
	
	public void  nextGeneration() {
		
		Cell[][] myTempWorld = new Cell[myWorld.length][myWorld[0].length];
		
		for (int i = 0; i < myTempWorld.length; i++) {
			for (int j = 0; j < myTempWorld.length; j++) {
				
				int nbNeighbours = 0;
				
				for (int u = -1; u <= 1; u++) {
					for (int v = -1; v <= 1; v++) {
						
						int xIndexCurrentNeighbours = i + u;
						
						int yIndexCurrentNeighbours = j + v;
						
						if (xIndexCurrentNeighbours >= 0 
								&& yIndexCurrentNeighbours >= 0 
								&& xIndexCurrentNeighbours < myTempWorld.length 
								&& yIndexCurrentNeighbours < myTempWorld[0].length) {
							
							if (!(u == 0 && v == 0)) {
								
								if (myWorld[xIndexCurrentNeighbours][yIndexCurrentNeighbours].isAlive()) {
									
									nbNeighbours++;
								}
								
							}
							
						}
						
					}
				}
				
				myTempWorld[i][j] = myWorld[i][j].newGeneration(nbNeighbours);
				
				
			}
		}
		
		myWorld = myTempWorld;
		
	}
	
	
}
