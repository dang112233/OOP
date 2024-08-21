package hus.oop.collections.list;

import java.util.*;

public class Lists {

    public static void insertFirst(List<Integer> list, int value) {
        list.add(0, value);
    }

    public static void insertLast(List<Integer> list, int value) {
        list.add(value);
    }

    public static void replace(List<Integer> list, int value) {
        if (list.size() >= 3) {
            list.set(2, value);
        }
    }

    public static void removeThird(List<Integer> list) {
        if (list.size() >= 3) {
            list.remove(2);
        }
    }

    public static void removeEvil(List<Integer> list) {
        list.removeAll(Collections.singletonList(666));
    }

    public static List<Integer> generateSquare() {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            squares.add(i * i);
        }
        return squares;
    }

    public static boolean contains(List<Integer> list, int value) {
        return list.contains(value);
    }

    public static void copy(List<Integer> source, List<Integer> target) {
        target.clear();
        target.addAll(source);
    }

    public static void reverse(List<Integer> list) {
        Collections.reverse(list);
    }

    public static void reverseManual(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }

    public static void insertBeginningEnd(LinkedList<Integer> list, int value) {
        list.addFirst(value);
        list.addLast(value);
    }

}

