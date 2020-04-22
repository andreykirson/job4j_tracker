package pojo;

import java.util.Date;

public class Student {
    private String FirstName;
    private String SecondName;
    private String group;
    private Date ReceiptDate;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        ReceiptDate = receiptDate;
    }
}
