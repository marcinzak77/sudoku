package com.sudoku.service;

import com.sudoku.board.SudokuBoard;

import java.util.*;
import java.util.stream.Collectors;

import static com.sudoku.board.SudokuElement.EMPTY;

public class AutoSudokuResolver{
    private NumberValidator numberValidator = new NumberValidator();

    public List<Integer> findAllExistingNumbersInRow(SudokuBoard sudokuBoard, int row) {
        List<Integer> currentValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int currentSudokuNumber = sudokuBoard.getSudokuRows()[row].getSudokuElementsRow()[i].getValue();

            if (currentSudokuNumber != EMPTY) {
                currentValues.add(currentSudokuNumber);
            }
        }

        return currentValues;

    }

    public void findAllSudokuNumbersInRow(SudokuBoard sudokuBoard, int row) {


        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        possibleValues.removeAll(findAllExistingNumbersInRow(sudokuBoard, row));

        while (possibleValues.iterator().hasNext()) {

            for (int i = 0; i < 9; i++) {
                if (sudokuBoard.getSudokuRows()[row].getSudokuElementsRow()[i].getValue().equals(EMPTY)) {


                    int value = possibleValues.iterator().next();

                    int numberInRow = findAllExistingNumbersInRow(sudokuBoard, row).size();
                    numberValidator.setValidSudokuNumber(sudokuBoard, i, row, value);

                    if (numberInRow < findAllExistingNumbersInRow(sudokuBoard, row).size()) {


                        possibleValues.remove((Integer) value);
                        break;
                    }
                }
            }

        }
    }

    public HashMap<Integer, Integer> findAmountOfPossiblities(SudokuBoard sudokuBoard, int row, int column, List<Integer> possibleValues) {
        return null;
    }

    public HashMap<Integer, List<Integer>> findAllPlacementInRow(SudokuBoard sudokuBoard, int row) {
        Map<Integer, List<Integer>> allPlacementInRow = new HashMap<>();
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> existingValues = findAllExistingNumbersInRow(sudokuBoard,row);
        possibleValues.removeAll(existingValues);
        List<Integer> emptyPositionList = new ArrayList<>();

        for (int j = 0; j < 9; j++) {
            if (sudokuBoard.getSudokuRows()[row].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
                emptyPositionList.add((Integer)j);
            }
        }

        for (int value: possibleValues) {
            List<Integer> positionList = new ArrayList<>();

            for (int empty: emptyPositionList) {
                if (!numberValidator.checkAllSudokuConditions(sudokuBoard, empty, row, value)) {
                    positionList.add(empty);
                    allPlacementInRow.put(value, positionList);
                }
            }
        }

        return (HashMap<Integer, List<Integer>>)allPlacementInRow;

    }

    public boolean findThatRowCantBeResolved(HashMap<Integer, List<Integer>> allPlacements) {
        int amountOfValuesInThisSamePlace;

        List<Integer> onePossibility = allPlacements.entrySet().stream()
                                    .filter(s -> s.getValue().size()<2)
                                    .map(Map.Entry::getKey)
                                    //.flatMap(Collection::stream)
                                    .collect(Collectors.toList());

//        if (!onePossibility.isEmpty()) {
//            for (:
//                 ) {
//
//            }
//            return true;
//        }
        System.out.println(onePossibility);

        return false;

    }


    public SudokuBoard findAllSudokuNumbers(SudokuBoard sudokuBoard) {
        Random generator = new Random();
        SudokuBoard sudokuBoardCopy;
        SudokuBoard[] sudokuBoardCopyBeforeRow = new SudokuBoard[9];
        boolean firstAttemp = false;


        for (int i = 0; i < 9; i++) {
            HashMap<Integer, List<Integer>> allPlacements = findAllPlacementInRow(sudokuBoard, i);
            System.out.println(allPlacements);
            sudokuBoardCopy = sudokuBoard.deepCopy(sudokuBoard);
            sudokuBoardCopyBeforeRow[i] = sudokuBoard.deepCopy(sudokuBoard);

            boolean isDone = false;

            while (!isDone) {
                if (allPlacements.isEmpty() && (findAllExistingNumbersInRow(sudokuBoard, i).size() == 9)) {
                    break;
                }
                allPlacements = findAllPlacementInRow(sudokuBoard, i);
                int currentValue = 0;
                int currentColumn;

                if (findThatRowCantBeResolved(allPlacements)) {
                    System.out.println("-------------hit");
                    break;
                }


                for (Map.Entry<Integer, List<Integer>> entry : allPlacements.entrySet()) {

                    if (entry.getValue().size() == 1) {
                        sudokuBoardCopy = sudokuBoard.deepCopy(sudokuBoard);
                        currentValue = entry.getKey();
                    }
                }

                if (currentValue == 0) {
                    List<Integer> keys = new ArrayList<>(allPlacements.keySet());

                    if (!keys.isEmpty()) {
                        currentValue = keys.get(generator.nextInt(keys.size()));

                    } else {

                        sudokuBoard = sudokuBoardCopyBeforeRow[i];
                        allPlacements = findAllPlacementInRow(sudokuBoard, i);
                       // currentValue = allPlacements.entrySet().stream().findAny().get().getKey();
                    }
                }


                try {
                    currentColumn = allPlacements.get(currentValue).get(0);
                    numberValidator.setValidSudokuNumber(sudokuBoard, currentColumn, i, currentValue);
                    allPlacements.remove(currentValue);
                    isDone = allPlacements.isEmpty();
                } catch (Exception e) {
                    System.out.println("can't resolve sudoku");
                 //   sudokuBoard = sudokuBoardCopyBeforeRow[i];
                }


                if (allPlacements.isEmpty() && (findAllExistingNumbersInRow(sudokuBoard, i).size() < 9)) {
                    if (i == 0){
                        sudokuBoard = sudokuBoardCopyBeforeRow[0];

                    } else {

                        i = i - 1;
                        sudokuBoard = sudokuBoardCopyBeforeRow[i];

                        isDone = false;
                    }
                }


            }
            System.out.println("Current row: " + i);
            System.out.println(sudokuBoard);
        }






        return sudokuBoard;
        //findAllSudokuNumbersInRow(sudokuBoard, 0);


    }
}



//             findAllSudokuNumbersInBox(sudokuBoard, 3, 3);
//             findAllSudokuNumbersInRow(sudokuBoard, 3);
//             findAllSudokuNumbersInBox(sudokuBoard, 0,3);
//             findAllSudokuNumbersInRow(sudokuBoard, 1);
//             findAllSudokuNumbersInBox(sudokuBoard,6,3);
//             findAllSudokuNumbersInRow(sudokuBoard, 2);
//             findAllSudokuNumbersInBox(sudokuBoard,6,0);
//             findAllSudokuNumbersInRow(sudokuBoard, 6);





//           sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 3, 3);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 0,0);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 0,3);
//           System.out.println(sudokuBoard);
//        sudokuBoard =
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 6,3);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,3,0);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,0,6);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,6,6);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,6,0);

 //       public void findAllSudokuNumbersInBox(SudokuBoard sudokuBoard, int row, int column) {
//        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        List<Integer> existingValues = numberValidator.getValuesFromSudokuBox(sudokuBoard, row, column);
//        HashMap<Integer, Integer> amountOfPossiblePlacements = new HashMap<>();
//        possibleValues.removeAll(existingValues);
//        SudokuBoard backUpBoard = sudokuBoard.deepCopy(sudokuBoard);
//
//
//        int startRow = numberValidator.getStartRowAndColumn(row, column)[0];
//        int startColumn = numberValidator.getStartRowAndColumn(row, column)[1];
//
//        while (!possibleValues.isEmpty()) {
//
//            for (Integer value: possibleValues) {
//                amountOfPossiblePlacements.put(value, 1);
//            }
//
//            int counter = 0;
//
//            for (int value : possibleValues) {
//                for (int i = startRow; i < (startRow + 3); i++) {
//                    for (int j = startColumn; j < (startColumn + 3); j++) {
//                        if (sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
//
//                                if (!numberValidator.checkAllSudokuConditions(sudokuBoard, j, i, value)) {
//                                    counter = amountOfPossiblePlacements.get(value);
//                                    counter++;
//                                    amountOfPossiblePlacements.put(value, counter);
//
//                            }
//                        }
//                    }
//                }
//            }
//
//
//
//
//        if (counter == 0) {
//
//            sudokuBoard = backUpBoard;
//        }
//
//
//            int currentNumber = possibleValues.get(0);
//            int currentAmount = amountOfPossiblePlacements.get(currentNumber);
//            for (Map.Entry<Integer, Integer> entry: amountOfPossiblePlacements.entrySet()) {
//                if (entry.getValue()<currentAmount) {
//                    currentAmount = entry.getValue();
//                    currentNumber = entry.getKey();
//                }
//            }
//
//
//
//            for (int i = startRow; i < (startRow + 3); i++) {
//                for (int j = startColumn; j < (startColumn + 3); j++) {
//
//                    if (sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
//
//                        numberValidator.setValidSudokuNumber(sudokuBoard, j, i, currentNumber);
//                        System.out.println(currentNumber + " " + currentAmount + " " + counter + " " + possibleValues);
//                        System.out.println(sudokuBoard);
//                        if (!sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
//                            existingValues = numberValidator.getValuesFromSudokuBox(sudokuBoard, row, column);
//                            amountOfPossiblePlacements.clear();
//                            possibleValues.removeAll(existingValues);
//                        }
//                    }
//                }
//            }
//        }
//
//     //   return sudokuBoard;
//    }


