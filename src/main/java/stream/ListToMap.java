package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Student> students = new ArrayList();
        students.add(new Student(72, "Sidorov"));
        students.add(new Student(68, "Sikorsky"));
        students.add(new Student(50, "Klochkov"));
        students.add(new Student(45, "Dobrobabin"));
        students.add(new Student(20, "Rodari"));
        students.add(new Student(85, "Jane"));

        Map<String, Student> studentMap = students
                .stream()
                .collect(Collectors.toMap(Student::getSurname, student -> student));

        System.out.println(studentMap.keySet());
    }

}
