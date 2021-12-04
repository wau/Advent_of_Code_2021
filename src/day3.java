import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3 {
    static int nbits = 12;
    static int scanlines =  1000;

    // part 1 ans: 1071734
    //part 2 ans: 6124992
    static int oxygen(List<String> input) {
        List<String> oxygen = new ArrayList<String>(input);
        List<String>  zeros = new ArrayList<String>();
        List<String>  ones = new ArrayList<String>();

        for (int j = 0; j < nbits; j++) {
            if (oxygen.size() <= 1)
                break;

            for (String i : oxygen) {
                if (i.charAt(j) == '1')
                    ones.add(i);
                else
                    zeros.add(i);
            }
            oxygen = (ones.size() >= zeros.size()) ? new ArrayList<>(ones) : new ArrayList<>(zeros);
            ones.clear();
            zeros.clear();
        }
        return Integer.parseInt(oxygen.get(0), 2);
    }

    static int co2(List<String> input) {
        List<String> co2 = new ArrayList<String>(input);
        List<String> zeros = new ArrayList<String>();
        List<String> ones = new ArrayList<String>();

        for (int j = 0; j < nbits; j++) {
            if (co2.size() <= 1)
                break;

            for (String i : co2) {
                if (i.charAt(j) == '1')
                    ones.add(i);
                else
                    zeros.add(i);
            }
            co2 = (ones.size() < zeros.size()) ? new ArrayList<>(ones) : new ArrayList<>(zeros);
            ones.clear();
            zeros.clear();
        }
        return Integer.parseInt(co2.get(0), 2);
    }

    static int solution2(List<String> input) {return co2(input) * oxygen(input);};

    static int solution1(String[] input) {
        int[] result = new int[nbits];

        for (String i: input) {
            for (int j = 0; j < nbits; j++) {
                if (i.charAt(j) == '1')
                    result[j]++;
            }
        }
        StringBuilder binarytxt = new StringBuilder();
        StringBuilder ibinarytxt = new StringBuilder();
        for (int i = 0; i < nbits; i++) {
            if(result[i] > input.length / 2) {
                binarytxt.append('1');
                ibinarytxt.append('0');
            }
            else {
                binarytxt.append('0');
                ibinarytxt.append('1');
            }
        }
        return Integer.parseInt(String.valueOf(binarytxt), 2) * Integer.parseInt(String.valueOf(ibinarytxt), 2);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("input: ");
       // String[] input = new String[scanlines]; changed for solution2;
        List<String> input  = new ArrayList<String>();
        for (int i = 0; i < scanlines; i++) {
           // input[i] = sc.nextLine();
            input.add(sc.nextLine());
        }
        System.out.println(solution2(input));
    }
}
