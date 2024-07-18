package QuizLogic;

import Data.Data;
import FrontEnd.Console;
import QuizLogic.QuizItemPackage.QuizItem;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    int rightAnswers = 0;
    int wrongAnswers = 0;
    final int START = 1;
    final int EXIT = 2;
    Console console;
    Data data;

    public Controller() {

        data = new Data();
        console = new Console();
    }

    public void start() throws IOException {
        ArrayList<QuizItem> quizItems = data.getQAndAFromFile();
        console.menu();
        switch (console.rangeOfInput(2)) {
            case START:// sachen liste übergeben
                for (QuizItem quizItem : quizItems) {
                    quizItem.printQuizItems();
                    sumAnswers(quizItem, console.rangeOfInput(quizItem.returnAnswersSize()));
                }
                console.printFinalScores(rightAnswers, wrongAnswers);
               break;
            case EXIT:
                System.exit(0);
        }
    }//creational patterns design patterns structure behavior
    private void sumAnswers(QuizItem quizItem, int Eingabe) {
        if ( quizItem.checkAnswers(Eingabe)) {
            console.print("Die Antwort ist richtig");
            rightAnswers++;
        }  else {
            console.print("Die Antwort ist falsch");
            wrongAnswers++;
        }
    }
}
