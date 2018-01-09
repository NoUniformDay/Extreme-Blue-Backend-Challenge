# Extreme Blue Backend Programming Challenge
Backend programming challenge for job interview for IBM's Extreme Blue program in summer 2017
Instructed to spend 3 hours maximum on the tasks
Task 1:
Imagine you have a football team and you want to track the performance of the players
during a league, The football team has 20 players in the squad with a maximum of 14 players
playing in each game. As the team plays each new game, the team changes due to injuries or
the skills of the opposition. Each player is graded on a number of skills during a game e.g.
tackles, saves, goals, assists and minutes played.

Q1) How would you design this code? Note: we are asking only for a high level design that
shows the relationship between all the entities underlined in the description above.

A1) Code Design
The fundamental entities I feature in my design are that of the League, Team, Game
and Player.In my code design I have adopted the Object-Oriented Paradigm and
implemented the above entities as Java classes with their various relationships. I have
also designed a system of tracking player’s ratings from game to game throughout a
league. Although the task asks for a high-level design, I have included these
relationships in code to further aide my explanations, and for the sake of clarity

A League holds a One-to-Many relationship with Team and Game with them being
represented as instance variables of type ArrayList<Team> and ArrayList<Game>
respectively, being the various teams playing games in the league. I have included
various access methods for adding, removing and retrieving Teams and Games
throughout the league’s lifespan. In League and each other entity I chose to include
both a class and instance member variable for ID, which allows us to allocate and
track entities much easier and linearly (See code).

The Game entity holds a One-to-Two relationship with Team. I represent the two
teams as Team instance variables, for simplicity in this case, one as winner and runner
up. Before the start of each Game, a hasInjuredPlayers() method is called on each
Team object. The nature of this design allows room for more methods like this for
checking the status of teams and players before and after games, as well as switching
players to the Team. At the end of each game, the rateTeam() method is called on
each team object. In my code design for variety in testing I use a Math.random()
generator to pick the winner.

Team holds a One-to-Many relationship with Player. I chose not to separate Team and
Squad into different entities but rather have Squad as a static class member variable
of type ArrayList<Player> considering it is usually fixed for the season or league, 20
max players in this case. Then I have an instance variable of type ArrayList<Player> for
playing teams since it is an object that is changing very frequently.

This also includes various methods for ensuring the correct amount of actual squad
enlisted players are allowed on the team, including those for displaying player details
and average ratings (see code for further detail). One notable method is that of
rateTeam() which iterates through the team’s player objects and provides metrics for
each player to the ratePlayer() method. The ratePlayer() method algorithm takes an
input of a player’s metrics from the game and uses a makeshift algorithm based on
dedicated points for each skills to return a numerical rating for that game and adds it
to the Players running total for the current league.

The Player entity holds a Many-to-One relationship with Team. I was considering
including a separate Rating entity for calculating a player’s rating based on desirable
metrics, but instead for simplicity I included it as a instance method for the Player
entity, along with an instance variable of type ArrayList<Integer> for storing a player’s 
game ratings throughout the League. I decided to use a enumerator to hold the positions
since they’re a constant in football.

[[https://github.com/NoUniformDay/Extreme-Blue-Backend-Challenge/tree/master/images/T1.png/]]

Task 2:

Given 20 soccer players mixed of Goalkeepers, Defenders, Midfielders and Forwards and
sets of formations 4-4- 2, 4-3- 3, etc.
Write a piece of code that returns a set team of 11 players depending on the formation
selected.


