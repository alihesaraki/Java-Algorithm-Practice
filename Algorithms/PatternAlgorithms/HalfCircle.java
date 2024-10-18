package Algorithms.PatternAlgorithms;

class HalfCircle {
    public static void main(String[] args) {
        int radius = 5; // radius of the half-circle
        for (int i = 0; i <= radius; i++) {
            for (int j = 0; j <= radius; j++) {
                // Check if the point (j, i) is inside the half-circle
                if ((j * j + i * i <= radius * radius) && (i <= radius)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

