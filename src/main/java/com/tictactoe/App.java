package com.tictactoe;

public class App {
    static Game game;
    private static void printStartGameField(){
        System.out.println("Enter gameField number to select. Enjoy!\n");
        System.out.println("\n\n 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 \n");
    }
    public static void main(String[] args) {
        printStartGameField();
      game = new Game();
      game.play();
    }
}
