package Algorithms.SimplePractice;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        IntersectionOfArrays intersectionFinder = new IntersectionOfArrays();
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};

        List<Integer> intersection = intersectionFinder.findIntersection(array1, array2);
        System.out.println("Intersection of the two arrays: " + intersection);
    }

    private List<Integer> findIntersection(int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        for (int num1 : array1) {
            for (int num2 : array2) {
                if (num1 == num2 && !result.contains(num1)) {
                    result.add(num1);
                }
            }
        }
        return result;
    }
}

