package Algorithms.GreedAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {
        int[][] activities = { {0, 6}, {1, 4}, {3, 5}, {5, 7}, {5, 9}, {8, 9} };
        System.out.println("Selected activities:");
        selectActivities(activities);
    }

    private static void selectActivities(int[][] activities) {
        // Sort activities based on their finish time
        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

        int n = activities.length;
        int lastSelectedActivity = 0; // The first activity is always selected
        System.out.println("Activity: " + activities[lastSelectedActivity][0]);

        for (int i = 1; i < n; i++) {
            // If the start time of the current activity is greater than or equal
            // to the finish time of the last selected activity, select it
            if (activities[i][0] >= activities[lastSelectedActivity][1]) {
                System.out.println("Activity: " + activities[i][0]);
                lastSelectedActivity = i;
            }
        }
    }
}

