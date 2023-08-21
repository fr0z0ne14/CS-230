package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
/**
 * A singleton service for the game engine
 *
 * @author jevon.watts@snhu.edu
 */
public class GameService {
	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();
	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;
	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	//@field singleton initialized to null
	private static GameService service = new GameService();
	/*
	 * A private constructor. It is normal for a singleton to have a private
	 * constructor so that we don't instantiate any additional instances
	 * outside of this class.
	 */
	private GameService() {
	}

	/*
	 * A public accessor for our instance. This allows outside classes to
	 * access objects in this singleton class.
	 */
	public static GameService getInstance() {
		return service;
	}
	/**
	 * Construct a new game instance
	 *
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {
		// a local game instance
		Game game = null;	
		//search through the games if the game name exist return it.
		for(int i = 0; i < getGameCount(); ++i) {
			if (name.equalsIgnoreCase(games.get(i).getName())) {
				game = games.get(i);
			}
		}
		//if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		//return the new/existing game instance to the caller
		return game;
	}
	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	/**
	 * Returns the game instance with the specified id.
	 *
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {
		//a local game instance
		Game game = null;
		//search through the games if the game id exist return it.
		for(int i = 0; i < getGameCount(); ++i) {
			if (games.get(i).getId() == id) {
				game = games.get(i);
			}
		}
		return game;
	}
	/**
	 * Returns the game instance with the specified name.
	 *
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {
		//a local game instance
		Game game = null;
		//this iterator method searches through the array of games and checks if their is a game with the name of the game we want to add
		for(int i = 0; i < getGameCount(); ++i) {
			if (name.equalsIgnoreCase(games.get(i).getName())) {
				game = games.get(i);
			}
		}
		return game;
	}
	/**
	 * Returns the number of games currently active
	 *
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	/**
	 *returns the Id of the next player
	 *
	 *@return the id of the next player
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	/**
	 *returns the Id of the next team
	 *
	 *@return the Id of the next team
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}