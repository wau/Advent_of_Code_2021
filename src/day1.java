
import java.util.Scanner;

class day1 {


    static int solution1(int[] arr) {

        int n = arr.length;
        int prev = arr[0];
        int result = 0;

        for (int i = 1; i < n; i++) {
            if ( prev < arr[i])
                result++;

            prev = arr[i];

        }
        return  result;
    }

    static int solution2(int[] arr) {

        int n = arr.length;
        int sum1 = arr[0] + arr[1] + arr[2];
        int sum2 = 0;
        int result = 0;

        for (int i = 1; i < n-2; i++) {
            sum2 =  arr[i] + arr[i+1] + arr[i+2];

            if ( sum1 < sum2) {
                result++;
            }
            sum1 = arr[i] + arr[i+1] + arr[i+2];

        }
        return  result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        int[] array = new int[2000];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < 2000; i++)
        {
            array[i]=sc.nextInt();
        }

        System.out.println(solution2(array));
    }
}