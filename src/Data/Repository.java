package Data;

import java.io.IOException;
import java.util.List;

public interface Repository <T,K>{
    List<T> readAll() throws IOException;

    void create(T file) throws IOException;
    T readByLine(K id) throws IOException;
    void update(K line, T newLine) throws IOException;;
    void delete(K line) throws IOException;;
}

