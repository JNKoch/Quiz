package Data;

import java.io.IOException;
import java.util.List;

public interface Repository <T,K>{
    List<T> read() throws IOException;

    T create(T name) throws IOException;
    T readById(K id) throws IOException;
    T update(T name);
    T delete(T name);
}

