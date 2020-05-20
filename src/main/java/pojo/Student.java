package pojo;

import java.util.Date;

public class Student {
    private String firstName;
    private String secondName;
    private String group;
    private Date receiptDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        secondName = secondName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        receiptDate = receiptDate;
    }
}
