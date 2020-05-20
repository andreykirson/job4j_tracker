package pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Andrey");
        student.setSecondName("Ivanov");
        student.setGroup("Newbie");
        student.setReceiptDate(new Date());

        System.out.println("Name" + student.getFirstName() + "Second Name" + student.getSecondName() + "in group" + student.getGroup() + "Receip tDate" + student.getReceiptDate());

    }
}
