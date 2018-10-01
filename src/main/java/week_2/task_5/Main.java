package week_2.task_5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int[] A = new int[sc.nextInt()];
        int k = sc.nextInt();

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        boolean isContinue = true;
        while(isContinue){
            isContinue = false;
            for (int i = 0; i + k < A.length; i++) {
                if (A[i] > A[i + k]) {
                    int temp = A[i];
                    A[i] = A[i + k];
                    A[i + k] = temp;
                    isContinue = true;
                }
            }
        }

        String heCan = "YES";

        for (int i = 0; i + 1 < A.length; i++) {
            if (A[i] > A[i + 1]) {
                heCan = "NO";
                break;
            }
        }

        System.out.println(Arrays.toString(A));

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(heCan);
        }
    }
}
