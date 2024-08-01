package QuizLogic.QuizItemPackage;

import QuizLogic.Answer.Answer;

import java.util.ArrayList;

public interface QuizItem {

    String getQuestion();

    ArrayList<Answer> getAnswers();

    boolean checkAnswers(int input);

    void printQuizItems();

    int returnAnswersSize();

}
