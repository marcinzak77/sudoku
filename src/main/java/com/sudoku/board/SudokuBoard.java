package com.sudoku.board;

public class SudokuBoard extends Prototype {
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
        return new SudokuBoard(board.getSudokuRows());
    }

}
