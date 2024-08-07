package QuizLogic.Answer;

public class WrongAnswer implements Answer{
    Object wrongAnswer;
    int wrongAnswerInt;
    public WrongAnswer() {
    }


    public Object getAnswer() {
        return wrongAnswer.toString();
    }

    @Override
    public void inputAnswer(Object answer) {
        this.wrongAnswer = answer;
    }

}
