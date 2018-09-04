package com.sudoku.board;

public class SudokuBoard {
    private SudokuRow[] sudokuRows;

    public SudokuRow[] getSudokuRows() {
        return sudokuRows;
    }

    public SudokuBoard(SudokuRow[] sudokuRows) {
        this.sudokuRows = sudokuRows;
    }

    @Override
    public String toString() {
        String lineWithEnter = " -------------------------" + "\n";
        String results = lineWithEnter;
        String value;
        int rowNumber = 1;

        for (SudokuRow sudokuRow : sudokuRows) {
            int columnNumber = 0;
            for (SudokuElement sudokuElement : sudokuRow.getSudokuElementsRow()) {
                value = sudokuElement.toString();
                if (columnNumber % 3 == 0) {
                    results += (" | " + value);
                } else results += (" " + value);
                columnNumber++;
            }

            if (rowNumber % 3 == 0) {
                results += " |" + "\n" + lineWithEnter;
            } else results += " |" + "\n";
            rowNumber++;

        }
        return results;
    }

    public SudokuBoard deepCopy(SudokuBoard board) {
        SudokuBoard sudokuBoardCopy = new SudokuBoard(new SudokuRow[9]);
        SudokuRow[] oldRow = board.getSudokuRows();

        for (int j = 0; j < 9; j++) {
            SudokuRow sudokuRow = new SudokuRow();

            for (int i = 0; i < 9; i++) {
                SudokuElement sudokuElement = new SudokuElement();
                sudokuElement.setValue(oldRow[j].getSudokuElementsRow()[i].getValue());
                sudokuRow.getSudokuElementsRow()[i] = sudokuElement;
            }

            sudokuBoardCopy.getSudokuRows()[j] = sudokuRow;
        }

        return sudokuBoardCopy;
    }

}
