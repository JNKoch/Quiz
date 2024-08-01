package Data;

import QuizLogic.Answer.Answer;
import QuizLogic.Answer.AnswerFactory;
import QuizLogic.QuizItemPackage.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class QuizItemFileRepository implements QuizItemRepository {

    private final Path FILE_PATH;

    public QuizItemFileRepository(String fileName) {
        this.FILE_PATH = Paths.get(fileName);
    }

    @Override
    public List<String> readAll() throws IOException {

        return Files.readAllLines(FILE_PATH);
    }

    @Override
    public void create(String line) throws IOException {
        Files.write(FILE_PATH, (line + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }

    @Override
    public String readByLine(Integer lineNumber) throws IOException {
        List<String> lines = readAll();
        if (lineNumber < 0 || lineNumber >= lines.size()) {
            throw new IndexOutOfBoundsException("Ungültige Zeilennummer: " + lineNumber);
        }
        return lines.get(lineNumber);
    }

    @Override
    public void update(Integer lineNumber, String newline) throws IOException {
        List<String> lines = readAll();
        if (lineNumber < 0 || lineNumber >= lines.size()) {
            throw new IndexOutOfBoundsException("Ungültige Zeilennummer: " + lineNumber);
        }
        lines.set(lineNumber, newline);
        Files.write(FILE_PATH, lines);
    }

    public void updateWithQuizItem(Integer lineNumber, QuizItem quizItem) throws IOException {
        List<String> lines = readAll();
        String newLine;
        if (lineNumber < 0 || lineNumber >= lines.size()) {
            throw new IndexOutOfBoundsException("Ungültige Zeilennummer: " + lineNumber);
        } else {
            newLine = quizItem.toFileVersion();
        }

        lines.set(lineNumber, newLine);
        Files.write(FILE_PATH, lines);
    }

    @Override
    public void delete(Integer lineNumber) throws IOException {
        List<String> lines = readAll();
        if (lineNumber < 0 || lineNumber >= lines.size()) {
            throw new IndexOutOfBoundsException("Ungültige Zeilennummer: " + lineNumber);
        }
        lines.remove(lineNumber);
        Files.write(FILE_PATH, lines);
    }

    @Override
    public void deleteAll() throws IOException {
        Files.deleteIfExists(FILE_PATH);
    }

    public void testStart() throws IOException{


        this.create("Dies ist eine neue Zeile.");

        List<String> lines = this.readAll();
        lines.forEach(System.out::println);

        String line = this.readByLine(0);
        System.out.println("\n Zeile 1: " + line + "\n");

        this.update(2, "Dies ist die aktualisierte Zeile.");

        line = this.readByLine(1);
        System.out.println("\n Aktualisierte Zeile 1: " + line +"\n");

        this.delete(4);

        lines = this.readAll();
        lines.forEach(System.out::println);

        AnswerFactory answerFactory = new AnswerFactory();
        ArrayList<Answer> Answers1 = new ArrayList<>();
        String question1 = "Wie viel ist 5*5";

        Answer answer1 = answerFactory.createRightAnswer();
        answer1.inputAnswerInt(25);
        Answers1.add(answer1);

        Answer answer2 = answerFactory.createWrongAnswer();
        answer2.inputAnswerInt(23);
        Answers1.add(answer2);

        updateWithQuizItem(1, new QuizItemInteger(question1,Answers1));

    }
}
