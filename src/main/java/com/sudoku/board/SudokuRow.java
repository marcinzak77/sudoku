package com.sudoku.board;

public class SudokuRow {
    private SudokuElement[] sudokuElementsRow = new SudokuElement[9];

    public SudokuElement[] getSudokuElementsRow() {
        return sudokuElementsRow;
    }

    public void setSudokuElementsRow(SudokuElement[] sudokuElementsRow) {
        this.sudokuElementsRow = sudokuElementsRow;
    }

}
