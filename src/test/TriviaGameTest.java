package test;
import main.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TriviaGameTest {
    FakeTriviaGame game ;

    @Test
    public void correctlyAnswered() {
        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.roll(2);
        game.wasCorrectlyAnswered();

        assertEquals(Arrays.asList(
                "Chet was added",
                "They are player number 1",
                "Pat was added",
                "They are player number 2",
                "Chet is the current player",
                "They have rolled a 2",
                "Chet's new location is 2",
                "The category is Sports",
                "Sports Question 0",
                "Answer was correct!!!!",
                "Chet now has 1 Gold Coins."), game.getMessages());
    }

    @Test
    public void wronglyAnswered() {
        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.roll(1);
        game.wrongAnswer();

        assertEquals(Arrays.asList(
                "Chet was added",
                "They are player number 1",
                "Pat was added",
                "They are player number 2",
                "Chet is the current player",
                "They have rolled a 1",
                "Chet's new location is 1",
                "The category is Science",
                "Science Question 0",
                "Question was incorrectly answered",
                "Chet was sent to the penalty box"), game.getMessages());
    }

    class FakeTriviaGame extends TriviaGame {
        List<String> messages = new ArrayList<>();

        public FakeTriviaGame(ArrayList<Player> playerList, HashMap<QuestionType, LinkedList<Questions>> questionList) {
            super(playerList, questionList);
        }

        @Override
        protected void announce(Object message) {
            messages.add(String.valueOf(message));
        }

        protected List<String> getMessages() {
            return messages;
        }
    }
}