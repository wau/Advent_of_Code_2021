import java.util.Scanner;



public class day2 {
    //part 1: ans: 1924923
    //part 2: ans: 1982495697

    static private class Vector {
        int horizontal;
        int depth;
        int aim;
        Vector(int horizontal, int depth, int aim) {this.horizontal = horizontal; this.depth = depth; this.aim = aim;};
    }

    /*static Vector filterString(String s) {
        int spaceIdx = s.indexOf(" ")+1;

        if (s.contains("forward")) {
            return new Vector(Integer.parseInt(s.substring(spaceIdx)), 0);
        }
        else if (s.contains("down")) {
            return new Vector(0, Integer.parseInt(s.substring(spaceIdx)), Integer.parseInt(s.substring(spaceIdx)));
        }
        else if (s.contains("up")) {
            return new Vector(0, -Integer.parseInt(s.substring(spaceIdx)), -Integer.parseInt(s.substring(spaceIdx)));
        }
        return null;
    }*/

    static Vector filterString(String s, int aim) {
        int spaceIdx = s.indexOf(" ")+1;

        if (s.contains("forward")) {
            return new Vector(Integer.parseInt(s.substring(spaceIdx)), aim*Integer.parseInt(s.substring(spaceIdx)), 0);
        }
        else if (s.contains("down")) {
            return new Vector(0, 0, Integer.parseInt(s.substring(spaceIdx)));
        }
        else if (s.contains("up")) {
            return new Vector(0, 0, -Integer.parseInt(s.substring(spaceIdx)));
        }
        return null;
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Vector[] array = new Vector[1000];
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < 1000; i++) {
            array[i]= filterString(sc.nextLine(), aim);
            assert array[i] != null;
            horizontal += array[i].horizontal;
            depth += array[i].depth;
            aim += array[i].aim;
        }

        System.out.println(horizontal*depth);
    }
}
