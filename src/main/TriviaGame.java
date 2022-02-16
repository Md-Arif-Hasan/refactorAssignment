package main;


import java.util.ArrayList;
import java.util.LinkedList;

public class TriviaGame {

    ArrayList <Player>players=new ArrayList<>();

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }


    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
    Player player=new Player(playerName,0,0,false);

        players.add(player);

        announce(playerName + " was added");
        announce("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        Player curPlayer =players.get(currentPlayer);
        announce(curPlayer.getPlayerName() + " is the current player");
        announce("They have rolled a " + roll);

        if (curPlayer.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                curPlayer.setPlaces(curPlayer.getPlaces()+roll) ;
                if (curPlayer.getPlaces()> 11) curPlayer.setPlaces(curPlayer.getPlaces()-12) ;;

                announce(players.get(currentPlayer)
                        + "'s new location is "
                        + curPlayer.getPlaces());
                announce("The category is " + currentCategory());
                askQuestion();
            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            curPlayer.setPlaces(curPlayer.getPlaces()+roll) ;
            if (curPlayer.getPlaces()> 11) curPlayer.setPlaces(curPlayer.getPlaces()-12) ;;

            announce(curPlayer.getPlayerName()
                    + "'s new location is "
                    + curPlayer.getPlaces());
            announce("The category is " + currentCategory());
            askQuestion();
        }

    }

    //refactor for loop
    private void askQuestion() {
        if (currentCategory() == "Pop")
            announce(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            announce(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            announce(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            announce(rockQuestions.removeFirst());
    }


    //Refactor if-else
    private String currentCategory() {
        Player curPlayer =players.get(currentPlayer);
        if (curPlayer.getPlaces() == 0) return "Pop";
        if (curPlayer.getPlaces() == 4) return "Pop";
        if (curPlayer.getPlaces() == 8) return "Pop";
        if (curPlayer.getPlaces() == 1) return "Science";
        if (curPlayer.getPlaces() == 5) return "Science";
        if (curPlayer.getPlaces() == 9) return "Science";
        if (curPlayer.getPlaces() == 2) return "Sports";
        if (curPlayer.getPlaces() == 6) return "Sports";
        if (curPlayer.getPlaces() == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        Player curPlayer =players.get(currentPlayer);
        if (curPlayer.inPenaltyBox) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                curPlayer.setPurses(curPlayer.getPurses()+1);
                announce(curPlayer.getPlayerName()
                        + " now has "
                        + curPlayer.getPurses()
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }


        } else {

            announce("Answer was correct!!!!");
            curPlayer.setPurses(curPlayer.getPurses()+1);
            announce(curPlayer.getPlayerName()
                    + " now has "
                    +curPlayer.getPurses()
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        Player curPlayer =players.get(currentPlayer);
        announce("Question was incorrectly answered");
        announce(curPlayer.getPlayerName()  + " was sent to the penalty box");

        curPlayer.setInPenaltyBox(true);

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        Player curPlayer =players.get(currentPlayer);
        return !(curPlayer.getPurses()== 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}