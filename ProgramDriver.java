package com.gamingroom;
/**
 * Application start-up program
 *
 * @author jevon.watts@snhu.edu
 */
public class ProgramDriver {
/**
 * The one-and-only main() method
 *
 * @param args command line arguments
 */
	public static void main(String[] args) {
		/*
		 * The singleton design pattern enables us to create just an object at a time
		 * we create an instance of the class by calling a class method without the need
		 * to instantiate the object of the class
		 */
		GameService service = GameService.getInstance();
		System.out.println("\nAbout to test initializing game data...");
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Games #2");
		System.out.println(game2);
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
