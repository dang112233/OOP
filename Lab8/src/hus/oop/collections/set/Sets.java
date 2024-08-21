package hus.oop.collections.set;

import java.util.*;

public class Sets {

    public static Set<Integer> intersectionManual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new HashSet<>();
        for (int num : first) {
            if (second.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection;
    }

    public static Set<Integer> unionManual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new HashSet<>(first);
        union.addAll(second);
        return union;
    }

    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    public static Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new HashSet<>(first);
        union.addAll(second);
        return union;
    }

    public static List<Integer> toList(Set<Integer> source) {
        return new ArrayList<>(source);
    }

    public static List<Integer> removeDuplicates(List<Integer> source) {
        return new ArrayList<>(new LinkedHashSet<>(source));
    }

    public static List<Integer> removeDuplicatesManual(List<Integer> source) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : source) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static String firstRecurringCharacter(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return String.valueOf(c);
            }
            seen.add(c);
        }
        return null;
    }

    public static Set<Character> allRecurringChars(String s) {
        Set<Character> recurringChars = new HashSet<>();
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                recurringChars.add(c);
            }
            seen.add(c);
        }
        return recurringChars;
    }

    public static Integer[] toArray(Set<Integer> source) {
        return source.toArray(new Integer[0]);
    }

    public static int getFirst(TreeSet<Integer> source) {
        return source.first();
    }

    public static int getLast(TreeSet<Integer> source) {
        return source.last();
    }

    public static int getGreater(TreeSet<Integer> source, int value) {
        Integer greater = source.higher(value);
        return greater != null ? greater : -1;
    }
}
