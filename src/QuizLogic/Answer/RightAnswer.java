package QuizLogic.Answer;

public class RightAnswer implements Answer {
    String rightAnswer;
    int rightAnswerInt;

    public RightAnswer() {
    }


    public String getAnswer() {
        return rightAnswer;
    }

    @Override
    public int getAnswerInt() {
        return rightAnswerInt;
    }

    @Override
    public void inputAnswer(String answer) {
        this.rightAnswer = answer;
    }

    @Override
    public void inputAnswerInt(int answer) {
        this.rightAnswerInt = answer;
    }
}
