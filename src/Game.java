/**
 * @author EricMcEvoy
 * Game entity class
 */
import java.util.ArrayList;

public class Game {
	private static int gameID = 1; //class member
	private int gID; //instance member
	Team winner;
	Team runnerUp;
	
	//Constructor
	public Game(Team a, Team b){
		if(a.hasInjuredPlayers() || b.hasInjuredPlayers()){
			return;
		}
		this.gID = gameID++; //Unique id for each game, allocated linearly
		int result = (Math.random() <= 0.5) ? 1 : 2;
		if(result == 1){
			this.winner = a;
			this.runnerUp = b;
		}
		else{
			this.winner = b;
			this.runnerUp = a;
		}
		winner.rateTeam();
		runnerUp.rateTeam();
	}
	
	
	
}
