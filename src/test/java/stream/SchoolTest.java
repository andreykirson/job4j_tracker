package stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static stream.School.collect;

import static org.hamcrest.core.Is.is;

public class SchoolTest {

    @Test
    public void classA() {
        List<Student> students = List.of(new Student(72, "Sidorov"),
                new Student(68, "Sikorsky"),
                new Student(50, "Klochkov"),
                new Student(45, "Dobrobabin"),
                new Student(20, "Rodari"),
                new Student(85, "Jane"));

        List<Student> classAExpected = new ArrayList();
        classAExpected.add(new Student(72, "Sidorov"));
        classAExpected.add(new Student(85, "Jane"));

        List<Student> classA = collect(students, (Student student) -> student.getScore() >= 70 & student.getScore() <= 100);
        assertThat(classA, is(classAExpected));
    }

    @Test
    public void classB() {
        List<Student> students = new ArrayList();
        students.add(new Student(72, "Sidorov"));
        students.add(new Student(68, "Sikorsky"));
        students.add(new Student(50, "Klochkov"));
        students.add(new Student(45, "Dobrobabin"));
        students.add(new Student(20, "Rodari"));
        students.add(new Student(85, "Jane"));

        List<Student> classAExpected = new ArrayList();
        classAExpected.add(new Student(68, "Sikorsky"));
        classAExpected.add(new Student(50, "Klochkov"));

        List<Student> classA = collect(students, (Student student) -> student.getScore() >= 50 & student.getScore() < 70);
        assertThat(classA, is(classAExpected));
    }

    @Test
    public void classC() {
        List<Student> students = new ArrayList();
        students.add(new Student(72, "Sidorov"));
        students.add(new Student(68, "Sikorsky"));
        students.add(new Student(50, "Klochkov"));
        students.add(new Student(45, "Dobrobabin"));
        students.add(new Student(20, "Rodari"));
        students.add(new Student(85, "Jane"));

        List<Student> classAExpected = new ArrayList();
        classAExpected.add(new Student(45, "Dobrobabin"));
        classAExpected.add(new Student(20, "Rodari"));

        List<Student> classA = collect(students, (Student student) -> student.getScore() > 0 & student.getScore() < 50);
        assertThat(classA, is(classAExpected));
    }

}