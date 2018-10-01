package week_2.task_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int size = sc.nextInt();

        int[] A = new int[size];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        quickSort(A, 0, A.length - 1);

        System.out.println(Arrays.toString(A));

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int a : A) {
                writer.write(a + " ");
            }
        }
    }

    private static void quickSort(int[] A, int l, int r) {
        if (l < r) {
            int q = partition(A, l, r);
            quickSort(A, l, q);
            quickSort(A, q + 1, r);
        }
    }

    private static int partition(int[] A, int l, int r) {
        int v = A[(l + r) / 2];
        int i = l;
        int j = r;

        while (i <= j) {
            while (A[i] < v) i++;
            while (A[j] > v) j--;

            if (i >= j) break;

            swap(A, i++, j--);
        }
        return j;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
