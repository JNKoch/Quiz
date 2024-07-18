package QuizLogic.QuizItemPackage;


import QuizLogic.Answer.Answer;

import java.util.ArrayList;

public class QuizItemFactory {

    public QuizItem createQuizItemString(String question, ArrayList<Answer> answers) {
        return new QuizItemString(question,answers);
    }
    public QuizItem createQuizItemInt(String question, ArrayList<Answer> answers) {
        return new QuizItemInteger(question,answers);
    }
}
