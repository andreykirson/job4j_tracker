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

        List<Student> students = new ArrayList();
        students.add(new Student(72, "Sidorov"));
        students.add(new Student(68, "Sikorsky"));
        students.add(new Student(50, "Klochkov"));
        students.add(new Student(45, "Dobrobabin"));
        students.add(new Student(20, "Rodari"));
        students.add(new Student(85, "Jane"));
        students.add(new Student(100, "Jane"));

        Map<String, Student> test = listToMap.listToMap(students);
        assertEquals(6, test.size());
        assertEquals(85, test.get("Jane").getScore());

    }
}