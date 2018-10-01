package week_2.task_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static FileWriter writer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int[] A = new int[sc.nextInt()];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        writer = new FileWriter("output.txt");
        mergeSort(A, 0, A.length - 1);

        for (int a : A) {
            writer.write(a + " ");
        }
        writer.flush();
        writer.close();
    }

    private static void mergeSort(int[] A, int start, int end) throws IOException {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(A, start, middle);
            mergeSort(A, middle + 1, end);

            writer.write((start + 1) + " " + (end + 1) + " " + A[start] + " " + A[end] + " \r\n");
            merge(A, start, middle, end);
        }
    }

    private static void merge(int[] A, int start, int middle, int end) {

        int i, j, k;
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int[] leftA = Arrays.copyOfRange(A, start, middle + 1);
        int[] rightA = Arrays.copyOfRange(A, middle + 1, end + 1);

        i = 0;
        j = 0;
        k = start;

        while (i < n1 && j < n2) {
            if (leftA[i] <= rightA[j]) {
                A[k] = leftA[i];
                i++;
            } else {
                A[k] = rightA[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = leftA[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = rightA[j];
            j++;
            k++;
        }
    }
}
