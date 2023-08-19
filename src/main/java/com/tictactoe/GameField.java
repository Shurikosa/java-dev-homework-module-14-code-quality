package com.tictactoe;

public class GameField {

    private char[] gameField = new char[9];

    public GameField(){
        initGameField();
    }


    private void initGameField(){
        for(int i = 0; i < 9; i++){
            gameField[i] = ' ';
        }
    }

    void printGameField (){
        System.out.println("\n\n " + gameField[0] + " | " + gameField[1] + " | " + gameField[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameField[3] + " | " + gameField[4] + " | " + gameField[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameField[6] + " | " + gameField[7] + " | " + gameField[8] + " \n");
    }

      boolean checkFinalCombination(final char symbol){
        return (gameField[0] == symbol && gameField[1] == symbol && gameField[2] == symbol) ||
                (gameField[3] == symbol && gameField[4] == symbol && gameField[5] == symbol) ||
                (gameField[6] == symbol && gameField[7] == symbol && gameField[8] == symbol) ||
                (gameField[0] == symbol && gameField[3] == symbol && gameField[6] == symbol) ||
                (gameField[1] == symbol && gameField[4] == symbol && gameField[7] == symbol) ||
                (gameField[2] == symbol && gameField[5] == symbol && gameField[8] == symbol) ||
                (gameField[0] == symbol && gameField[4] == symbol && gameField[8] == symbol) ||
                (gameField[2] == symbol && gameField[4] == symbol && gameField[6] == symbol);
    }

    boolean isGameFieldAvaliable(final byte i){
        return gameField[i] != 'X' && gameField[i] != 'O';
    }

    void fillGameField(final byte i, final char symbol){
       gameField[i] = symbol;
    }


}
