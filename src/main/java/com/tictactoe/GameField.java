package com.tictactoe;

public class GameField {
    private char[] gameField = new char[9];

    public GameField() {
        initGameField();
    }

    private void initGameField() {
        int gamefieldSize = 9;
        for (int i = 0; i < gamefieldSize; i++) {
            gameField[i] = ' ';
        }
    }

    public void printGameField() {
        System.out.println("\n\n " + gameField[0] + " | " + gameField[1] + " | " + gameField[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameField[3] + " | " + gameField[4] + " | " + gameField[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameField[6] + " | " + gameField[7] + " | " + gameField[8] + " \n");
    }

    public boolean checkFinalCombination(final char symbol) {
        return (gameField[0] == symbol && gameField[1] == symbol && gameField[2] == symbol) ||
                (gameField[3] == symbol && gameField[4] == symbol && gameField[5] == symbol) ||
                (gameField[6] == symbol && gameField[7] == symbol && gameField[8] == symbol) ||
                (gameField[0] == symbol && gameField[3] == symbol && gameField[6] == symbol) ||
                (gameField[1] == symbol && gameField[4] == symbol && gameField[7] == symbol) ||
                (gameField[2] == symbol && gameField[5] == symbol && gameField[8] == symbol) ||
                (gameField[0] == symbol && gameField[4] == symbol && gameField[8] == symbol) ||
                (gameField[2] == symbol && gameField[4] == symbol && gameField[6] == symbol);
    }

    public boolean isGameFieldAvaliable(final byte i) {
        return gameField[i] != 'X' && gameField[i] != 'O';
    }

    public void fillGameField(final byte i, final char symbol) {
        gameField[i] = symbol;
    }
}
