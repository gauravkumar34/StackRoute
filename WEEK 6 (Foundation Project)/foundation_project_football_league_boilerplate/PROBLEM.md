## Problem Statement: Automating the National Football League for player registration and team allotment of new matches

National Football League(NFL) is a registered association to host football league competitions. 
NFL organized the first league in Spain in 2015.The main aim of NFL is to:

- Promote football as a sport worldwide
- Turn amateur footballers into professional players

Initially NFL started with a league with four teams.The high-level process was:

    1. NFL advertises asking for registration from interested players
    2. Players visit the NFL office for registration, fitness test and other formalities
    3. NFL based on player’s profile allocates them to form the teams

NFL wants to automate its team formation process.

The problem to solve for NFL is to automate the process of player registration and team
formation.

**Proposed Solution**

In the first phase, NFL should be provided a solution where the football players 
can register themselves. Admin can then be able to allot the registered players randomly to 
their respective selected teams based on the league title availability.

Following are the classes to be implemented to solve this business problem.

#### Complete the following model classes as per the requirement.

**class Player**

Define the following properties.Properties should be private.

       -playerId : String
       -playerName : String
       -password : String
       -yearExpr : int
       -teamTitle :String
       
Define parameterized constructor to initialize all the properties

Define Getter for all the properties and setter for leagueTitle

Override the toString() method to display Player details

Override the compare() method to compare players based on playerId

**class PlayerTeam**

Define the following properties.Properties should be private.

       -playerId : String
       -teamTitle : String
             
Define parameterized constructor to initialize all the properties

Define Getter for all the properties

Override the toString() method to display PlayerTeam details

Override the compare() method to compare players based on playerId

#### Complete the following dao classes as per requirement
        
**class PlayerDaoImpl**

Define the following methods :

        +addPlayer(Player player) : boolean
        +findPlayer(String playerId) : Player
        +getAllPlayers() : List<Player>
       
**class PlayerTeamDaoImpl**

Define the following methods :        

        +getAllPlayerTeams(String fileName) : Set<PlayerTeam>
        +addPlayerToTeam(PlayerTeam playerTeam) : boolean
        +getPlayersSetByTeamTitle(String teamTitle) : Set<PlayerTeam>
        
**enum LeagueTeamTitles**

Should have the following constants : 
          
          HIPHOP, WIN2WIN,HAPPYFEET, LUCKYSTRIKE 
        
        
#### Complete the following service class as per requirement
       
**class LeagueTeamServiceImpl**

Define the following methods :

        +addPlayer(Player player) : boolean
        +registerPlayerToLeague(String playerId, String password, LeagueTeamTitles teamTitle) : String
        +getAllRegisteredPlayers() : List<Player>
        +getExistingNumberOfPlayersInTeam(LeagueTeamTitles teamTitle) : int
        +allotPlayersToTeam(String adminName, String password, LeagueTeamTitles teamTitle) : String
               
           
**Note: Do not modify/delete the csv files present in the src/main/resources folder**      

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
 
