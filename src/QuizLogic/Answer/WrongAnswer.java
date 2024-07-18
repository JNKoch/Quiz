package QuizLogic.Answer;

public class WrongAnswer implements Answer{
    String wrongAnswer;
    int wrongAnswerInt;
    public WrongAnswer() {
    }


    public String getAnswer() {
        return wrongAnswer;
    }

    @Override
    public int getAnswerInt() {
        return wrongAnswerInt;
    }

    @Override
    public void inputAnswer(String answer) {
        this.wrongAnswer = answer;
    }

    @Override
    public void inputAnswerInt(int answer) {
        this.wrongAnswerInt = answer;
    }
}
