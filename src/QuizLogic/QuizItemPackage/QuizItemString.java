package QuizLogic.QuizItemPackage;



import QuizLogic.Answer.Answer;
import QuizLogic.Answer.RightAnswer;

import java.util.ArrayList;

public class QuizItemString implements QuizItem {
    public String question;
    public ArrayList<Answer> answers;

    public QuizItemString(String question, ArrayList<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }
    @Override
    public boolean checkAnswers(int input) {
        int changeListNumberBy = 1;
        boolean checkAnswer;
        checkAnswer = answers.get(input - changeListNumberBy) instanceof RightAnswer;
        return checkAnswer;
    }

    @Override
    public void printQuizItems() {

        System.out.println("-------------------------------");
        System.out.println(question);
        for (int i = 0; i < answers.size(); i++) {
            System.out.println("("+(i+1)+") "+ answers.get(i).getAnswer());
        }
        System.out.println("-------------------------------");
    }

    @Override
    public int returnAnswersSize() {
        return answers.size();
    }

    @Override
    public String toFileVersion() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(question).append(";");
        for (Answer answer : answers) {
            if (answer instanceof RightAnswer) {
                stringBuilder.append(answer.getAnswer()).append("*").append(";");
            } else {
                stringBuilder.append(answer.getAnswer()).append(";");
            }
        }
        return String.valueOf(stringBuilder);
    }
}
