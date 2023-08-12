package com.tictactoe;

import java.util.Scanner;

public class App {
    enum VARIANTS{
          WIN,LOST,DRAW;
    }

    private static void writeResultMassage(final VARIANTS variant){
        if(VARIANTS.WIN.equals(variant)){
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(VARIANTS.LOST.equals(variant)){
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(VARIANTS.DRAW.equals(variant)){
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private static VARIANTS resultVariant (final int win){
        if ( win == 1) return VARIANTS.WIN;
        else if (win == 2 ) return VARIANTS.LOST;
        else  return VARIANTS.DRAW;

    }

    private static boolean checkFinalCombination(final char[] gameField, final char symbol){
        if((gameField[0]==symbol && gameField[1]==symbol && gameField[2]==symbol) ||
                (gameField[3]==symbol && gameField[4]==symbol && gameField[5]==symbol) ||
                (gameField[6]==symbol && gameField[7]==symbol && gameField[8]==symbol) ||
                (gameField[0]==symbol && gameField[3]==symbol && gameField[6]==symbol) ||
                (gameField[1]==symbol && gameField[4]==symbol && gameField[7]==symbol) ||
                (gameField[2]==symbol && gameField[5]==symbol && gameField[8]==symbol) ||
                (gameField[0]==symbol && gameField[4]==symbol && gameField[8]==symbol) ||
                (gameField[2]==symbol && gameField[4]==symbol && gameField[6]==symbol)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte input;
        byte rand;
        byte i;
        boolean gameFieldAvailable = false;
        byte winner = 0;
        char gameField[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        System.out.println("Enter gameField number to select. Enjoy!\n");

        boolean gameFieldEmpty = false;
        while (true) {
            System.out.println("\n\n " + gameField[0] + " | " + gameField[1] + " | " + gameField[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + gameField[3] + " | " + gameField[4] + " | " + gameField[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + gameField[6] + " | " + gameField[7] + " | " + gameField[8] + " \n");
            if(!gameFieldEmpty){
                for(i = 0; i < 9; i++)
                    gameField[i] = ' ';
                gameFieldEmpty = true;
            }

            if(winner !=0){
                writeResultMassage(
                        resultVariant(winner));
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (gameField[input - 1] == 'X' || gameField[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        gameField[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }

            if(checkFinalCombination(gameField, 'X')){
                   winner = 1;
            }

            gameFieldAvailable = false;
            for(i=0; i<9; i++){
                if(gameField[i] != 'X' && gameField[i] != 'O'){
                    gameFieldAvailable = true;
                    break;
                }
            }

            if(!gameFieldAvailable){
                winner = 3;

            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (gameField[rand - 1] != 'X' && gameField[rand - 1] != 'O') {
                    gameField[rand - 1] = 'O';
                    break;
                }
            }

            if(checkFinalCombination(gameField, 'O')) {
                winner = 2;
            }

        }
    }
}
