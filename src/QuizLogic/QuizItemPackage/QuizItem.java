package QuizLogic.QuizItemPackage;

public interface QuizItem {

    boolean checkAnswers(int input);

    void printQuizItems();

    int returnAnswersSize();
}
