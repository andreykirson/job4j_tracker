package io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        while (matches != 0) {
            System.out.println("Игрок 1 возьмите  от 1 до 3 сипчек");
            int playerFirst = Integer.valueOf(input.nextLine());
            matches = matches - playerFirst;
            System.out.println("На столе осталось " + matches + " сипчек");
            if (matches == 0) {
                System.out.println("Игрок 1 выйграл");
                break;
            }

            System.out.println("Игрок 2 возьмите  от 1 до 3 сипчек");
            int playerSecond = Integer.valueOf(input.nextLine());
            matches = matches - playerSecond;
            System.out.println("На столе осталось " + matches  + " сипчек");
            if (matches == 0) {
                System.out.println("Игрок 2 выйграл");
                break;
            }

        }
    }
}
