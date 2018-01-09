/**
 * @author EricMcEvoy
 * Player entity class
 */
import java.util.ArrayList;


public class Player {
	private static int playerID = 1; //class member player identifier, independent of object instances
	private int pID;
	private String pName; 
	private boolean isInjured;
	private ArrayList<Integer> ratings; //as a percentage per game
	private Position position;
	private enum Position{
		G,
		D,
		M,
		F,
	}; // G = Goal-keeper, D = Defender, M = Mid-fielder, F = Forward
	
	public Player(String name, Position position){
		this.pName = name;
		this.pID = playerID++;
		ratings = new ArrayList<Integer>();
		this.position = position; 
	}
	
	public Player(String name, String position){
		this.pName = name;
		this.pID = playerID++;
		ratings = new ArrayList<Integer>();
		this.position = Position.valueOf(position);
	}
	
	public int getID(){
		return this.pID;
	}	
	public String getName(){
		return this.pName;
	}
	public void setName(String name){
		this.pName = name;
	}
	
	public void ratePlayer(int tackles, int saves, int goals, int assists, int minutesPlayed){
		//Algorithm for rating a player based off above metrics
		//I'm not exactly a Football fan and rating is quite subjective 
		//I'm allocating a score in points for each skill.
		//The total rating is calculated by the summing of the product of each number
		//of skills per game by the respective points
		//Tackle : 1 point
		//Assists : 3 points
		//Saves : 4 points
		//Minutes played : minutesPlayed/90
		//Goals : 5 points
		Integer rating = (tackles*1) + (assists*3) +(minutesPlayed/90) + (saves*4) + (goals*5);
		
		this.ratings.add(rating); //added to player ratings for League thus far
	}
	
	public Integer currentLeagueRating(){
		int size = this.ratings.size();
		int total = 0;
		for(Integer i : ratings){
			total+= i;
		}
		int average = (total == 0 ?  0 : total/size);
		return average;
	}

	public boolean isInjured() {
		return this.isInjured;
	}

	public void setInjured(boolean b) {
		this.isInjured = b;
	}
	
	public String position(){
		return this.position.name();
	}
	
	
	public String toString(){
		System.out.println("Position: "+this.position() +" ID: "+this.getID()+" || Name : "+this.getName()+" || Rating to date: "+ this.currentLeagueRating()+" points");
		return "";
	}
	
		
}
	

