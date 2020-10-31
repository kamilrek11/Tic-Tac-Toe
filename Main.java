package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] table = new char[9];
        char turn;
        boolean flag;
        boolean endGame = false;
        int player = 0;
        int x = 0;
            System.out.println("---------");
            for (int i = 0; i < table.length; i++) {
                if (i == 0 || i == 3 || i == 6) {
                    System.out.print("| ");
                }
                System.out.print("  ");
                if (i == 2 || i == 5 || i == 8) {
                    System.out.println("|");
                }
            }
            System.out.println("---------");
            do {
                if (player % 2 == 0 ) {
                    turn = 'X';
                    x++;
                } else {
                    turn = 'O';
                }
                do {
                    flag = false;
                    System.out.print("Enter the coordinates: ");
                    int m = scanner.nextInt();
                    int n = scanner.nextInt();
                    if (m > 3 || n > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (table[m + 8 - 3 * n] != Character.MIN_VALUE) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        flag = true;
                        table[m + 8 - 3 * n] = turn;
                        System.out.println("---------");
                        for (int i = 0; i < table.length; i++) {
                            if (i == 0 || i == 3 || i == 6) {
                                System.out.print("| ");
                            }
                            if (table[i] == Character.MIN_VALUE){
                                System.out.print("  ");
                            } else {
                                System.out.print(table[i] + " ");
                            }
                            if (i == 2 || i == 5 || i == 8) {
                                System.out.println("|");
                            }
                        }
                        System.out.println("---------");
                    }
                } while (!flag);

                if (table[0] == 'X' && table[1] == 'X' && table[2] == 'X' ||
                        table[3] == 'X' && table[4] == 'X' && table[5] == 'X' ||
                        table[6] == 'X' && table[7] == 'X' && table[8] == 'X' ||
                        table[0] == 'X' && table[3] == 'X' && table[6] == 'X' ||
                        table[1] == 'X' && table[4] == 'X' && table[7] == 'X' ||
                        table[2] == 'X' && table[5] == 'X' && table[8] == 'X' ||
                        table[0] == 'X' && table[4] == 'X' && table[8] == 'X' ||
                        table[2] == 'X' && table[4] == 'X' && table[6] == 'X') {
                    System.out.println("X wins");
                    endGame = true;
                }
                if (table[0] == 'O' && table[1] == 'O' && table[2] == 'O' ||
                        table[3] == 'O' && table[4] == 'O' && table[5] == 'O' ||
                        table[6] == 'O' && table[7] == 'O' && table[8] == 'O' ||
                        table[0] == 'O' && table[3] == 'O' && table[6] == 'O' ||
                        table[1] == 'O' && table[4] == 'O' && table[7] == 'O' ||
                        table[2] == 'O' && table[5] == 'O' && table[8] == 'O' ||
                        table[0] == 'O' && table[4] == 'O' && table[8] == 'O' ||
                        table[2] == 'O' && table[4] == 'O' && table[6] == 'O') {
                    System.out.println("O wins");
                    endGame = true;
                }

                if (x == 5 && !endGame) {
                    System.out.println("Draw");
                    endGame = true;
                }
                player++;
            } while (!endGame);
    }
}
