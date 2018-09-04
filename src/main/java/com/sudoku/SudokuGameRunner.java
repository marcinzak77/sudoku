package com.sudoku;

import com.sudoku.service.SudokuGame;

public class SudokuGameRunner {

    public static void main(String[] args) {
        boolean gameFinished = false;

        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }

    }
}
