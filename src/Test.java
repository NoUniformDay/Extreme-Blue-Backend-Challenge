/**
 * @author EricMcEvoy
 * Test class
 */
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args){
		/**
		 *  New League, Two squads, Two teams, Multiple Games, Two lists of ratings,
		 *  One for each team for each game, as well as the running average player rating!
		 */
		League league = new League("Premiership");
		Team myTeam = new Team("Manchester United");
		Player p1 = new Player("Wayne Rooney", "F");
		myTeam.addPlayer(p1);
		Player p2 = new Player("Darren Fletcher", "D");
		myTeam.addPlayer(p2);
		Player p3 = new Player("Paul Scholes", "M");
		myTeam.addPlayer(p3);
		Player p4 = new Player("Rud Van Nisteeroy", "D");
		myTeam.addPlayer(p4);
		Player p5 = new Player("Jui Sung Park", "F");
		myTeam.addPlayer(p5);
		Player p6 = new Player("Eric Cantona", "M");
		myTeam.addPlayer(p6);
		Player p7 = new Player("Ryan Giggs", "M");
		myTeam.addPlayer(p7);
		Player p8 = new Player("Roy Keane", "M");
		myTeam.addPlayer(p8);
		Player p9 = new Player("Bobby Charlton", "F");
		myTeam.addPlayer(p9);
		Player p10 = new Player("David Beckham", "D");
		myTeam.addPlayer(p10);
		Player p11 = new Player("Brian Robson", "M");
		myTeam.addPlayer(p11);
		Player p12 = new Player("Gary Neville", "D");
		myTeam.addPlayer(p12);
		Player p13 = new Player("Paul Pogba", "D");
		myTeam.addPlayer(p13);
		Player p14 = new Player("Ole Gun Solkjaer", "F");
		myTeam.addPlayer(p14);
		Player p15 = new Player("Roy Keane", "M");
		myTeam.addPlayer(p15);
		Player p16 = new Player("Edwin Van der Saar", "G");
		myTeam.addPlayer(p16);
		Player p17 = new Player("Patrick Evra", "D");
		myTeam.addPlayer(p17);
		Player p18 = new Player("Andy Cole", "F");
		myTeam.addPlayer(p18);
		Player p19 = new Player("Stephen Bruce", "G");
		myTeam.addPlayer(p19);
		Player p20 = new Player("Michael Carrick", "D");
		myTeam.addPlayer(p20); //20 man squad, with team created from first 14 added
		
		//myTeam.displaySquad(); //displays Squad as added above
	
		
		//Second team, allowing us to test Game class
		
		Team anotherTeam = new Team("Liverpool F.C");
		Player q1 = new Player("Stephen Gerrard", "F");
		anotherTeam.addPlayer(q1);
		Player q2 = new Player("Jamie Carragher", "D");
		anotherTeam.addPlayer(q2);
		Player q3 = new Player("Luis Suarez", "M");
		anotherTeam.addPlayer(q3);
		Player q4 = new Player("Fernando Torres", "D");
		anotherTeam.addPlayer(q4);
		Player q5 = new Player("Daniel Sturridge", "F");
		anotherTeam.addPlayer(q5);
		Player q6 = new Player("Jamie Lipsett", "M");
		anotherTeam.addPlayer(q6);
		Player q7 = new Player("Mark Devenny", "M");
		anotherTeam.addPlayer(q7);
		Player q8 = new Player("Kevin Keegan", "M");
		anotherTeam.addPlayer(q8);
		Player q9 = new Player("Benjamin Schneider", "F");
		anotherTeam.addPlayer(q9);
		Player q10 = new Player("Rhys Becking", "D");
		anotherTeam.addPlayer(q10);
		Player q11 = new Player("Dirk Kuyt", "M");
		anotherTeam.addPlayer(q11);
		Player q12 = new Player("Jamie Rednapp", "D");
		anotherTeam.addPlayer(q12);
		Player q13 = new Player("Henrick Larsson", "D");
		anotherTeam.addPlayer(q13);
		Player q14 = new Player("Patrick Veira", "F");
		anotherTeam.addPlayer(q14);
		Player q15 = new Player("Jack Charlton", "M");
		anotherTeam.addPlayer(q15);
		Player q16 = new Player("Pepe Reina", "G");
		anotherTeam.addPlayer(q16);
		Player q17 = new Player("Patrick Gurney", "D");
		anotherTeam.addPlayer(q17);
		Player q18 = new Player("Andy Chester", "F");
		anotherTeam.addPlayer(q18);
		Player q19 = new Player("Stephen Haddock", "G");
		anotherTeam.addPlayer(q19);
		Player q20 = new Player("Michael Jones", "D");
		anotherTeam.addPlayer(q20); //20 man squad, with team created from first 14 added
		
		//TASK 2 Testing
		String[] formations  = {"442","433","541","343","4321"};
		ArrayList<Player> formattedTeam = myTeam.teamSelection(formations); 
		for(Player p : formattedTeam){
			p.toString();
		}
		/* More testing for fun..
		 *
		//anotherTeam.displaySquad();
		//anotherTeam.displayTeam();
		// Before Game : 
		//displaying current ratings
		//anotherTeam.displaySquad(); //displaying current ratings
	
		Game game1 = new Game(myTeam, anotherTeam);
		Game game2 = new Game(myTeam, anotherTeam);
		Game game3 = new Game(myTeam, anotherTeam); // Ratings changing
		
		// Players get injured
		//p11.setInjured(true);
		//p2.setInjured(true);
		
		Game game4 = new Game(myTeam, anotherTeam); // Injured players not allowed play!
		
		myTeam.substitute(p14, p11);
		myTeam.substitute(p12, p18);
		
		Game game5 = new Game(myTeam, anotherTeam);
		
		myTeam.displaySquad(); //displaying NEW current running ratings
		anotherTeam.displaySquad(); //displaying NEW current running ratings
		
		*/

	}
}
