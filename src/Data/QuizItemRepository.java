package Data;

import java.io.IOException;
import java.util.List;

public interface QuizItemRepository {

    List<String> readAllLines() throws IOException;

    void create(String line) throws IOException;
    String readLine(int lineNumber) throws IOException;
    void updateLine(int lineNumber, String newline) throws IOException;
    void deleteLine(int lineNumber) throws IOException;

    void delete(String filePath) throws IOException;
}
