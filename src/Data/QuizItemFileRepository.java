package Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
    public void delete(String filePath) throws IOException {
        Files.deleteIfExists(Path.of(filePath));
    }

    public void testStart() {
        try {
            QuizItemRepository fileRepository = new QuizItemFileRepository("Quiz_Covis/src/DasQuiz4/DataTest.txt");
            fileRepository.create("Dies ist eine neue Zeile.");

            List<String> lines = fileRepository.readAll();
            lines.forEach(System.out::println);

            String line = fileRepository.readByLine(0);
            System.out.println("\n Zeile 1: " + line + "\n");

            fileRepository.update(2, "Dies ist die aktualisierte Zeile.");

            line = fileRepository.readByLine(1);
            System.out.println("\n Aktualisierte Zeile 1: " + line +"\n");

            fileRepository.delete(4);

            lines = fileRepository.readAll();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
