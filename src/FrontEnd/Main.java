package FrontEnd;

import QuizLogic.Controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //TextFileRepository fileRepository = new TextFileRepository("Quiz_Covis/src/DasQuiz4/DataTest.txt");
        //fileRepository.testStart();
        Controller controller = new Controller();
        controller.start();
    }
}
