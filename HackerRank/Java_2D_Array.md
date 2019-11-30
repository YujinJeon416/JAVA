> https://www.hackerrank.com/challenges/java-2d-array/problem?h_r=next-challenge&h_v=zen


# 1st try

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] arr;
    private static int[] dy = {0,0,0,1,2,2,2};
    private static int[] dx = {0,1,2,1,0,1,2};


    public static int hourglass(int y, int x){
        int sum = 0;
        for (int i=0;i<7;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            sum += arr[ny][nx];
        }
        return sum;
    }


    public static void main(String[] args) {
        arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();
        int result = Integer.MIN_VALUE;
        for (int y=0; y<4; y++){
            for (int x=0; x<4; x++){
                int sum = hourglass(y,x);
                if (result < sum) result = sum;
            }
        }
        System.out.println(result);
    }
}
```