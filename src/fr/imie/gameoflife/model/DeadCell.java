package fr.imie.gameoflife.model;

public class DeadCell implements Cell {

	@Override
	public Cell newGeneration(int nbNeighbours) {
		
		if (nbNeighbours == 3) {
			return new AliveCell();
		} else {
			return new DeadCell();
		}
		
	}

	@Override
	public String getAsString() {
		
		return " - ";
	}

	@Override
	public boolean isAlive() {
		
		return false;
	}

}
