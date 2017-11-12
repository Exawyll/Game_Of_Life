package fr.imie.gameoflife.model;

//Liste de m�thodes abstraites
//M�thode abstraite n'a pas de comportement
//Uniquement une signature
//Une interface est aussi un type
public interface Cell {
	
	Cell newGeneration(int nbNeighbours);
	String getAsString();
	boolean isAlive();
	
}
