package fr.imie.gameoflife.model;

//Liste de méthodes abstraites
//Méthode abstraite n'a pas de comportement
//Uniquement une signature
//Une interface est aussi un type
public interface Cell {
	
	Cell newGeneration(int nbNeighbours);
	String getAsString();
	boolean isAlive();
	
}
