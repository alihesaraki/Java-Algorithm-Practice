package Algorithms.DivideAndConquer;

import java.util.Arrays;

public class ClosestPairOfPoints {

    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };

        double minDistance = findClosestPair(points);
        System.out.println("The smallest distance is: " + minDistance);
    }

    private static double findClosestPair(Point[] points) {
        // Sort the points based on the x coordinate
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.x, p2.x));

        return findClosestPairUtil(points, 0, points.length - 1);
    }

    private static double findClosestPairUtil(Point[] points, int left, int right) {
        // If there are 3 or fewer points, use a brute-force approach
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        // Find the middle point
        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        // Recursively find the smallest distance in both halves
        double leftDist = findClosestPairUtil(points, left, mid);
        double rightDist = findClosestPairUtil(points, mid + 1, right);

        // Find the smaller of the two distances
        double minDist = Math.min(leftDist, rightDist);

        // Build an array of points close to the vertical line at x = midPoint.x
        Point[] strip = new Point[right - left + 1];
        int j = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDist) {
                strip[j] = points[i];
                j++;
            }
        }

        // Find the closest pair of points in the strip
        return Math.min(minDist, stripClosest(strip, j, minDist));
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double minDist = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }

    private static double stripClosest(Point[] strip, int size, double d) {
        double min = d;

        // Sort the points in the strip by y coordinate
        Arrays.sort(strip, 0, size, (p1, p2) -> Double.compare(p1.y, p2.y));

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; j++) {
                double dist = distance(strip[i], strip[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    private static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
