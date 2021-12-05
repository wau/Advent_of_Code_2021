import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day4 {
    //part 1 ans: 55770
    //part 2 ans: 2980
    static int n = 5;
    static List<Integer> numbers = new ArrayList<Integer>();
    static List<Board> boards = new ArrayList<Board>();

    public static class Board {
        public BoardPiece[][] pieces = new BoardPiece[n][n];
        public int choosenPieces;
        public boolean boardWon; //for part 2

        public Board(Scanner reader) {
            for(int i = 0; i < n; i++) {
                String temp = reader.nextLine();
                Scanner scanner = new Scanner(temp);
                for (int j = 0; j < n; j++){
                    pieces[i][j] = new BoardPiece(scanner.nextInt());//scanner.nextInt();
                }
            }
            this.choosenPieces = 0;
            this.boardWon = false;
        }

        public void addNumber(int number) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (found) break;
                    if (this.pieces[i][j].value == number && !this.pieces[i][j].choosen) {
                        this.pieces[i][j].choosen = true;
                        this.choosenPieces++;
                        found = true;
                    }
                }
            }
        }

        public boolean checkWin() {
            for (int i = 0; i < n; i++)
                if (pieces[i][0].choosen && pieces[i][1].choosen && pieces[i][2].choosen && pieces[i][3].choosen && pieces[i][4].choosen)
                    return true;
            for (int j = 0; j < n; j++)  {
                if (pieces[0][j].choosen && pieces[1][j].choosen && pieces[2][j].choosen && pieces[3][j].choosen && pieces[4][j].choosen)
                    return true;
            }
            return false;
        }

        public int sumUnmarked() {
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!pieces[i][j].choosen) {
                        result+= pieces[i][j].value;
                    }
                }
            }
            return result;
        }

        public static class BoardPiece {
            public int value;
            boolean choosen;

            BoardPiece(int value) {
                this.value = value;
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/catarino/IdeaProjects/Avent_of_Code_2021/src/input/day4.txt");
        Scanner sc = new Scanner(file);

        int line = 0;

        sc.useDelimiter("\\D");
        int i = 0;
        while (sc.hasNextInt())
        {
            numbers.add(sc.nextInt());
        }
        sc.close();
        sc = new Scanner(file);

        sc.nextLine();
        sc.nextLine();
        //skip 2 lines
        while (sc.hasNext()) {
            boards.add(new Board(sc));
            if (sc.hasNext())
                sc.nextLine();
        }
        int result = 0;

        for (int num : numbers)
            for (Board board : boards) {
                board.addNumber(num);
                if (board.checkWin() && !board.boardWon) {
                   // System.out.println(board.sumUnmarked()*num);
                    result = board.sumUnmarked()*num; //for part 2
                    board.boardWon = true; // for part 2
                    //System.exit(0);
                }

            }


        System.out.println(result); // for part 2

    }
}
