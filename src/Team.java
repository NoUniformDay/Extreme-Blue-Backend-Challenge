/**
 * @author EricMcEvoy
 * Team class for creating and managing teams
 */
import java.util.ArrayList;
import java.util.Collections;


import javax.swing.JOptionPane;

public class Team {
	private static int teamID = 1; //Class member variable for overall team tracking and allocation
	private int tID; //Instance variable identifier for team object
    private String name; //Team instance name
	private static ArrayList<Player> squad; //20 fixed class members for league
	private ArrayList<Player> playingTeam; //Varying assortment of players for each game

	// Constructor
	public Team(String name){
		playingTeam = new ArrayList<Player>();
		this.tID = teamID++; // Allocates new ID to instance ID variable
		if(Team.getSquad() == null){ //If first time initializing a team, a Squad is created
			setSquad(new ArrayList<Player>());
			System.out.println("Select your 20 Player squad");
		}	
	}
	
	// add player to team
	public void addPlayer(Player p) {
		if(!(getSquad().contains(p)) && getSquad().size() <= 20){ // Initial squad pick
			Team.getSquad().add(p);
		}
		if (playingTeam.size() >= 14) {
			return;
		}
		else{
			this.playingTeam.add(p);
		}
	}

	// remove player from team
	public void removePlayer(Player p) {
		this.playingTeam.remove(p);
	}
	
	//Swap players (substitute)
	public void substitute(Player on, Player off){
		// Check if valid substitution
		if(playingTeam.contains(on) && !(playingTeam.contains(off)) && !(Team.getSquad().contains(off))){
			this.playingTeam.remove(off);
			this.playingTeam.add(on);
		}
		else{
			System.out.println("Invalid player substitution");
		}
	}
	
	
	public void rateTeam(){
		for(Player p : this.playingTeam){
			p.ratePlayer(1, 1, 1, 1, 90); 
		}
	}
	
	public void displayTeam(){
		for(Player p : this.playingTeam){
			System.out.println("Current Playing Team : ID: "+p.getID()+" || Name : "+p.getName()+" || Rating to date: "+p.currentLeagueRating()+" points || Position : "+p.position());
		}
	}
	
	public void displaySquad(){
		for(Player p : getSquad()){
			if(this.playingTeam.contains(p)){
				System.out.println("Current Playing Team : ID: "+p.getID()+" || Name : "+p.getName()+" || Rating to date: "+p.currentLeagueRating()+" points");
			}
			else{
				System.out.println("Current Squad Member : ID: "+p.getID()+" || Name : "+p.getName()+" || Rating to date: "+p.currentLeagueRating()+" points");
			}
		}
	}

	public static ArrayList<Player> getSquad() {
		return squad;
	}

	public static void setSquad(ArrayList<Player> squad) {
		Team.squad = squad;
	}
	
	public int teamSize(){
		return this.playingTeam.size();
	}
	
	public boolean hasInjuredPlayers(){
		Boolean hasInjuries = false;
		for(Player p : this.playingTeam){
			if(p.isInjured()){
				System.out.println(p.getName() + " is injured, add a replacement for the Game to begin");
				hasInjuries = true;
			}
		}
		return hasInjuries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//-------------------------------------------------------------------------------//
	/**
	 * TASK 2 
	 * @param ArrayList<Player> players
	 * @param String[] formation : sets formations in format DMF e.g 442, 433, 4321 etc
	 * @return "A set team of 11 players depending on the formation"
	 */
	public ArrayList<Player> teamSelection(String[] formations){ 
		ArrayList<Player> availablePlayers = this.getSquad(); //All 20 members of selected team
		ArrayList<Player> formattedTeam = new ArrayList<Player>(); // Set team of players to be returned based on formation
		
		//Split up according to position played
		ArrayList<Player> keepers = new ArrayList<Player>(); 
		ArrayList<Player> defenders = new ArrayList<Player>();
		ArrayList<Player> midfielders = new ArrayList<Player>();
		ArrayList<Player> forwards = new ArrayList<Player>();
		
		for(Player p : availablePlayers){
			if(p.position() == "G") keepers.add(p);
			if(p.position() == "D") defenders.add(p);
			if(p.position() == "M") midfielders.add(p);
			if(p.position() == "F") forwards.add(p);
		}
		
		//Allowing user to choose formation of any size
		String chosenFormat = (String) JOptionPane.showInputDialog(null,"Please choose a formation?",
				"formations",
				JOptionPane.QUESTION_MESSAGE, null,
				formations, 
				formations[0]);
		
		//Split chosen format to allocate players of that position to team, randomly
		int formatLength = chosenFormat.length(); // Allows for possibility of longer than typical formations such as 4-3-2-1
		int[] formationSteps = new int[formatLength]; // for storing parsed chosen formation DMF to [D,M,F]
		
		for(int i=0;i<formatLength;i++){
			formationSteps[i] = Integer.parseInt(chosenFormat.substring(i, i+1)); //DMF to [D,M,F]
			System.out.println("Formation step "+i+" : "+formationSteps[i]);
		}
		//First choose Goalkeeper
		Collections.shuffle(keepers); //random selection
		formattedTeam.add(keepers.get(0)); 
		
		Collections.shuffle(defenders);
		Collections.shuffle(midfielders);
		Collections.shuffle(forwards);
		
		//loops iterate through each format step 
		int position = 0;
		for (int j = 0; j < formationSteps[position]; j++) {
			formattedTeam.add(defenders.get(j));	
		}
		position++; // on to Midfielder
		for (int j = 0; j < formationSteps[position]; j++) {

			formattedTeam.add(midfielders.get(j));
		}
		position++; // on to forward
		for (int j = 0; j < formationSteps[position]; j++) {

			formattedTeam.add(forwards.get(j));
			
		}
		position++; // on to possible extra formation e.g lone striker in 4-3-2-1
		if (formationSteps.length > 3 ) {
			for (int j = 0; j < formationSteps[position]; j++) {
				formattedTeam.add(forwards.get(j));
			}
		}
	
		return formattedTeam;

	}
	//-------------------------------------------------------------------------------//
}
