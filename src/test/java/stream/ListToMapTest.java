package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void whenHasDuplicate() {

        ListToMap listToMap = new ListToMap();

        List<Student> students = List.of(new Student(72, "Sidorov"),
                new Student(68, "Sikorsky"),
                new Student(50, "Klochkov"),
                new Student(45, "Dobrobabin"),
                new Student(20, "Rodari"),
                new Student(85, "Jane"),
                new Student(100, "Jane"));

        Map<String, Student> test = listToMap.listToMap(students);
        assertEquals(6, test.size());
        assertEquals(85, test.get("Jane").getScore());

    }
}