package FrontEnd;

import Data.QuizItemFileRepository;
import QuizLogic.Answer.Answer;
import QuizLogic.Answer.RightAnswer;
import QuizLogic.Controller;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //QuizItemFileRepository fileRepository = new QuizItemFileRepository("src/QuizLogic/DataTest.txt");
        //fileRepository.testStart();
        Controller controller = new Controller();
        controller.start();
    }
}
