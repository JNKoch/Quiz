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
        answer1.inputAnswerInt(25);
        Answers1.add(answer1);

        Answer answer2 = answerFactory.createWrongAnswer();
        answer2.inputAnswerInt(23);
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

    public ArrayList<QuizItem> getQAndAFromFile() throws IOException {
        final String DELIMITER = ";";
        final String RIGHT_ANSWER = "*";
        String[] data;
        String question;
        String line;

        ArrayList<Answer> Answers = new ArrayList<>();
        ArrayList<QuizItem> quizItems = new ArrayList<>();
        FileRepository fileRepository = new QuizItemFileRepository("src/QuizLogic/Data.txt");
        AnswerFactory answerFactory = new AnswerFactory();
        QuizItemFactory quizItemFactory = new QuizItemFactory();

        //fileRepository.create("Wer steht im Finale;Deutschland;Spanien*;");
        List<String> lines = fileRepository.readAllLines();

        for (int i = 0; i < lines.size(); i++) {
            line = fileRepository.readLine(i);
            data = line.split(DELIMITER);
            question = data[0].trim();
            System.out.println(data.length);
            for (int j = 1; j <= 2; j++) {
                String textAnswer = data[j].trim();
                if (textAnswer.endsWith(RIGHT_ANSWER)) {
                    Answer answer = answerFactory.createRightAnswer();
                    answer.inputAnswer(textAnswer.substring(0, textAnswer.length() - 1));
                    Answers.add(answer);
                } else {
                    Answer answer = answerFactory.createWrongAnswer();
                    answer.inputAnswer(textAnswer);
                    Answers.add(answer);
                }
                quizItems.add(quizItemFactory.createQuizItemString(question, Answers));
            }
        }
        return quizItems;
    }
}