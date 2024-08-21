package hus.oop.lab9.library;

import java.util.Date;
public class Rent {
    Item item;
    Student student;
    Date begin;
    Date end;

    public Rent(Item item, Student student, Date begin, Date end) {
        this.item = item;
        this.student = student;
        this.begin = begin;
        this.end = end;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Rent[" +
                "item=" + item +
                ", student=" + student +
                ", begin=" + begin +
                ", end=" + end +
                ']';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }
}
