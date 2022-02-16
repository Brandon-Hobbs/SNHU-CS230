package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.eduwith additional code from Brandon Hobbs
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

	//The singleton pattern makes sure than only a single instance of a class is allowed, i.e. GameService,
	//This is done by making the constructor private
	//And then only allow the creation via a method and only if the class does not exist, e.g., a null
	
	//first create the only GameService allowed and set to null	
	private static GameService service = null;
	
	//private constructor to block the creation
	private GameService() {
		
	}
	
	//add a method to create the single GameService instance
	public static GameService getGameService() {
		
		//only add the new instance called service if null
		//otherwise, return the single instance
		if (service == null) {
			
				service = new GameService();
				//System.out.println("new service");
		}
		else {//little debug branch
			
			//System.out.println("not created");
		}
		
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

		// if found, simply return the existing instance
		
		//getGame(string) will iterator over games
		//just need to run method and evaluate
		//If getGame does not find the Game in games called name null is returned
		//If the Game is found just return the one from games
		//If the Game is not found add one called name
		if (getGame(name) != null) {
			
			game = getGame(name);
		}
		
		else {
			
			game = new Game(nextGameId++, name);
			games.add(game);
		}
			
	// return the new/existing game instance to the caller
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

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		//create a local iterator variable named currGame of type Game
		//loop foreach in the list games
		//if currGame is the same as id return currGame and break
		for (Game currGame:games) {
			
			if (currGame.getId() == id) {
				
				game = currGame;
				break;
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

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		//create a local iterator variable named currGame of type Game
		//loop foreach in the list games
		//if currGame is the same as name return currGame and break
		
		for (Game currGame:games) {
			
			if(currGame.getName().equalsIgnoreCase(name)) {
				
				game = currGame;
				break;
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
}
