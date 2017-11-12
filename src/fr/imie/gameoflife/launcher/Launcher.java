package fr.imie.gameoflife.launcher;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.imie.gameoflife.model.World;

public class Launcher {

	public static void main(String[] args) {
		boolean flag = true;

		System.out.println("Welcome to the GAME OF LIFE");

		Scanner sc = new Scanner(System.in);

		while (flag) {
			try {
				System.out.println("Please enter the number of columns in your world !");
				
				int columns = sc.nextInt();
				
				System.out.println("Please enter the number of rows in your world !");

				int rows = sc.nextInt();
				
				World world = new World(columns, rows);
				flag = false;

				System.out.println(world.toString());

				while (true) {

					world.nextGeneration();

					System.out.println(world.toString());

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			} catch (Exception e) {
				
				System.out.println("This is not an integer");

				//Clear the buffer
				sc.nextLine();
				flag = true;
			} 
		}
	}		
}
