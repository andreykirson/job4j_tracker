package stream;

import java.util.Objects;

public class Student {

    int score;
    String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String toString() {
        return "{"
                +
                "score='"
                +
                score
                +
                '\''
                +
                ", surname="
                + surname
                +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}