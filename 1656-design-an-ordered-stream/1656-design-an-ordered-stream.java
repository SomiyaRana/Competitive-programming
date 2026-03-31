import java.util.*;

class OrderedStream {
    String[] stream;
    int ptr;

    public OrderedStream(int n) {
        stream = new String[n + 1]; // 1-based indexing
        ptr = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> result = new ArrayList<>();

        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr]);
            ptr++;
        }

        return result;
    }
}