package stream;

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
}
