package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author Oyetunde Oloyede
 *
 */
/**
 * The Team class inherits attributes and methods from the Entity superclass
 *
 */
public class Team extends Entity {
	/**
	 * A list of the active players
	 */
	private static List<Player> players = new ArrayList<Player>();
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * Construct a new team instance
	 *
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Player addPlayer(String name) {
		// a local team instance
		Player player = null;
		//search through the teams if the team name exist return it.
		for(int i = 0; i < players.size(); ++i) {
			if (name.equalsIgnoreCase(players.get(i).getName())) {
				player = players.get(i);
			}
		}
		// if not found, make a new team instance and add to list of teams
		if (player == null) {
			player = new Player((long) players.size(), name);
			players.add(player);
		}
		// return the new/existing team instance to the caller
		return player;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}