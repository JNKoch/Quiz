package Data;

import java.io.IOException;
import java.util.List;

public interface QuizItemRepository extends Repository<String,Integer>{

    List<String> readAll() throws IOException;

    void create(String line) throws IOException;
    String readByLine(Integer lineNumber) throws IOException;
    void update(Integer lineNumber, String newline) throws IOException;
    void delete(Integer lineNumber) throws IOException;

    void delete(String filePath) throws IOException;
}
