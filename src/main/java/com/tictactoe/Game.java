package com.tictactoe;

import java.util.Scanner;

public class Game {

    private GameField gameField = new GameField();
    static final Scanner scan = new Scanner(System.in);

    enum VARIANTS{
          WIN,LOST,DRAW,GOING
    }



    private byte input(){

        while (true) {
            final byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (!gameField.isGameFieldAvaliable((byte) (input -1 )))
                    System.out.println("That one is already in use. Enter another.");
                else {
                   return input;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private boolean checkDraw (){
        for(byte i = 0; i < 9; i++){
            if(gameField.isGameFieldAvaliable(i)){
                return true;
            }
        }
        return false;
    }

    private  byte doPC(){
        while (true) {
            byte random = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (gameField.isGameFieldAvaliable(((byte)(random - 1)))) {

                return random;
            }
        }
    }

    private boolean playHumanAndChekResult(){
        byte input = input();
        gameField.fillGameField((byte) (input - 1), 'X');

      return gameField.checkFinalCombination('X');

    }

    private boolean playPCAndCheckResult(){

        byte random = doPC();
        gameField.fillGameField((byte) (random - 1), 'O');

        return gameField.checkFinalCombination('O');

    }

    private VARIANTS playStrategy(){
        if(playHumanAndChekResult()){
            return VARIANTS.WIN ;
        }else if(!checkDraw()){
            return  VARIANTS.DRAW;
        }else if(playPCAndCheckResult()){
            return  VARIANTS.LOST;
        }
        return VARIANTS.GOING;
    }

    public void play () {
        while (true) {
            gameField.printGameField();
            final VARIANTS result =playStrategy();

            if(result != VARIANTS.GOING){
                writeResultMassage(result);
                return;
            }
        }
    }

    private void writeResultMassage(final VARIANTS variant){
        if(VARIANTS.WIN.equals(variant)){
            System.out.println(MESAGE_ON_WON );
        } else if(VARIANTS.LOST.equals(variant)){
            System.out.println(MESAGE_ON_LOST);
        } else if(VARIANTS.DRAW.equals(variant)){
            System.out.println( MESAGE_ON_DRAW);
        }
    }

    private static final String MESAGE_ON_WON = "You won the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private static final String MESAGE_ON_LOST = "You lost the game!\nCreated by Shreyas Saha. Thanks for playing!";
    private static final String MESAGE_ON_DRAW = "It's a draw!\nCreated by Shreyas Saha. Thanks for playing!";
}
