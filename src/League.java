/**
 * @author EricMcEvoy
 * League entity class
 */
import java.util.ArrayList;


public class League {
	private static int leagueID = 1; //Class member variable for tracking Leagues
	private int lID; //Instance variable identifier for each League
	private String name;
	private ArrayList<Game> games; 
	private ArrayList<Team> teams; //Squads in this case, teams selected per game
	
	//constructor
	public League(String name){
		this.lID = leagueID++;
		this.name = name;
		teams = new ArrayList<Team>();
		games = new ArrayList<Game>();
	}
	
	public void addTeam(Team t){
		this.teams.add(t);
	}
	
	public void removeTeam(Team t){
		if(teams.contains(t)){
			this.teams.remove(t);
		}
	}
	
	public ArrayList<Team> teams(){
		return teams;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void addGame(Game g){
		this.games.add(g);
	}
	
}
