package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a game
 *
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 *
 * @author jevon.watts@snhu.edu
 *
 */
/**
 * The Game class inherits attributes and methods from the Entity superclass
 *
 */
public class Game extends Entity {
	/**
	 * A list of the active teams
	 */
	private static List<Team> teams = new ArrayList<Team>();
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * Construct a new team instance
	 *
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addTeam(String name) {
		// a local team instance
		Team team = null;
		//search through the teams if the team name exist return it.
		for(int i = 0; i < teams.size(); ++i) {
			if (name.equalsIgnoreCase(teams.get(i).getName())) {
				team = teams.get(i);
			}
		}
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			team = new Team((long) teams.size(), name);
			teams.add(team);
		}
		// return the new/existing team instance to the caller
		return team;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}
}
