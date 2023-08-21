package com.gamingroom;
/**
 * A class to test a singleton's behavior
 *
 * @author jevon.watts@snhu.edu
 */
public class SingletonTester {
	public void testSingleton() {
		System.out.println("\nAbout to test the singleton...");
		/*
		 * The singleton design pattern enables us to create just an object at a time
		 * we create an instance of the class by calling a class method without the need
		 * to instantiate the object of the class
		 */
		GameService service = GameService.getInstance();
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}
	}
}