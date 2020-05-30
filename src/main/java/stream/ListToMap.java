package stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {

    public Map<String, Student> listToMap(List<Student> students) {
        return (students
                .stream()
                .collect(Collectors.toMap(Student::getSurname, Function.identity(), (existing, replacement) -> existing)));
    }
}
