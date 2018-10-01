package week_2.task_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        sc.nextLine();
        String[] numbers = sc.nextLine().split(" ");
        int[] A = new int[numbers.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(numbers[i]);
        }

        for (int i = 1; i < A.length; i += i) {
            for (int j = 0; j < A.length - i; j += i + i) {
                merge(A, j, i + j - 1, Math.min(j + i + i - 1, A.length - 1));
            }
        }

        System.out.println(Arrays.toString(A));

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(count + "");
        }
    }

    private static void merge(int[] A, int start, int middle, int end) {

        int[] leftA = Arrays.copyOfRange(A, start, middle + 1);
        int[] rightA = Arrays.copyOfRange(A, middle + 1, end + 1);
        int[] subA = Arrays.copyOfRange(A, start, end + 1);

        int a = 0, b = 0;
        for (int i = 0; i < subA.length; i++) {
            if (b < rightA.length && a < leftA.length)
                if (leftA[a] > rightA[b]) {
                    subA[i] = rightA[b++];
                    count += leftA.length - a;
                } else {
                    subA[i] = leftA[a++];
                }
            else if (b < rightA.length) {
                subA[i] = rightA[b++];
            } else {
                subA[i] = leftA[a++];
            }
        }
        for (int i = start, j = 0; j < subA.length; i++, j++) {
            A[i] = subA[j];
        }
//        int[] subA = Arrays.copyOfRange(A, start, end + 1);
//
//        int i = 0, j = 0, k = start;
//
//        while (i < leftA.length || j < rightA.length) {
//            if (j == rightA.length || (i < leftA.length && leftA[i] <= rightA[j])) {
//                for (int l = i + 1; l < subA.length; l++) {
//                    if (leftA[i] > subA[l]) {
//                        count++;
//                    }
//                }
//                A[k] = leftA[i];
//                i++;
//            } else {
//                for (int l = middle + j + 1; l < subA.length; l++) {
//                    if (rightA[j] > subA[l]) {
//                        count++;
//                    }
//                }
//                A[k] = rightA[j];
//                j++;
//            }
//            k++;
//        }
    }
}
