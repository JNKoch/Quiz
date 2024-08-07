package Data;

import QuizLogic.Answer.*;
import QuizLogic.QuizItemPackage.QuizItem;
import QuizLogic.QuizItemPackage.QuizItemFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public Data() {
    }

    //methode rückgabe
    public ArrayList<QuizItem> generateQuestionAndAnswer() {
/*
    factory anpassen
    interface business logic für daten einbauen
    repository pattern
    CRUD
 */
        ArrayList<QuizItem> quizItems = new ArrayList<>();
        AnswerFactory answerFactory = new AnswerFactory();
        QuizItemFactory quizItemFactory = new QuizItemFactory();

        ArrayList<Answer> Answers1 = new ArrayList<>();
        String question1 = "Wie viel ist 5*5";

        Answer answer1 = answerFactory.createRightAnswer();
        answer1.inputAnswer(25);
        Answers1.add(answer1);

        Answer answer2 = answerFactory.createWrongAnswer();
        answer2.inputAnswer(23);
        Answers1.add(answer2);
        quizItems.add(quizItemFactory.createQuizItemInt(question1, Answers1));

        ArrayList<Answer> Answers2 = new ArrayList<>();
        String question2 = "Wer steht im Finale";

        Answer answer3 = answerFactory.createWrongAnswer();
        answer3.inputAnswer("Deutschland");
        Answers2.add(answer3);

        Answer answer4 = answerFactory.createRightAnswer();
        answer4.inputAnswer("Spanien");
        Answers2.add(answer4);

        quizItems.add(quizItemFactory.createQuizItemString(question2, Answers2));

        return quizItems;
    }


}