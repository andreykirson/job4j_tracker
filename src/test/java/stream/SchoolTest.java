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
        List Students = new ArrayList();
        Students.add(new Student(72, "Sidorov"));
        Students.add(new Student(68, "Sikorsky"));
        Students.add(new Student(50, "Klochkov"));
        Students.add(new Student(45, "Dobrobabin"));
        Students.add(new Student(20, "Rodari"));
        Students.add(new Student(85, "Jane"));

        List<Student> ClassAExpected = new ArrayList();
        ClassAExpected.add(new Student(72, "Sidorov"));
        ClassAExpected.add(new Student(85, "Jane"));

        List<Student> ClassBExpected = new ArrayList();
        ClassBExpected.add(new Student(68, "Sikorsky"));

        List<Student> ClassCExpected = new ArrayList();
        ClassCExpected.add(new Student(45, "Dobrobabin"));
        ClassCExpected.add(new Student(20, "Rodari"));

        List <Student> classA = collect(Students, (Student student) -> student.getScore() > 70 & student.getScore() < 100);
        Assert.assertEquals(classA, ClassAExpected);
    }

}