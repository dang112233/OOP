package hus.oop.lab12.mylist;

import java.util.ArrayList;
import java.util.List;

public class TestMyList {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        MyArrayList arrayList = new MyArrayList();
        arrayList.append(1.0);
        arrayList.append(2.5);
        arrayList.append(3.8);
        arrayList.append(4.1);
        arrayList.append(5.9);

        BasicStatistic statistic = new BasicStatistic(arrayList);

        System.out.println("MyArrayList data: " + arrayList);
        System.out.println("Max: " + statistic.max());
        System.out.println("Min: " + statistic.min());
        System.out.println("Mean: " + statistic.mean());
        System.out.println("Variance: " + statistic.variance());
    }

    public static void testMyLinkedList() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.append(1.0);
        linkedList.append(2.5);
        linkedList.append(3.8);
        linkedList.append(4.1);
        linkedList.append(5.9);

        BasicStatistic statistic = new BasicStatistic(linkedList);

        System.out.println("MyLinkedList data: " + linkedList);
        System.out.println("Max: " + statistic.max());
        System.out.println("Min: " + statistic.min());
        System.out.println("Mean: " + statistic.mean());
        System.out.println("Variance: " + statistic.variance());
    }
}
