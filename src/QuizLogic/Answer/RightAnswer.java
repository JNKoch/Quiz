package QuizLogic.Answer;

public class RightAnswer implements Answer {
    Object rightAnswer;
    int rightAnswerInt;

    public RightAnswer() {
    }


    public Object getAnswer() {
        return rightAnswer.toString();
    }

    @Override
    public void inputAnswer(Object answer) {
        this.rightAnswer = answer;
    }

}
