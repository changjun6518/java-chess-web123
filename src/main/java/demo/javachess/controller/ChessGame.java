package demo.javachess.controller;

import demo.javachess.domain.board.Board;
import demo.javachess.domain.board.BoardFactory;
import demo.javachess.domain.calculator.Calculator;
import demo.javachess.domain.piece.ColorCase;
import demo.javachess.domain.util.Command;
import demo.javachess.view.InputView;
import demo.javachess.view.OutputView;

public class ChessGame {
    private static final int COMMAND_INDEX = 0;
    private static final int SOURCE_POSITION_INDEX = 1;
    private static final int TARGET_POSITION_INDEX = 2;

    private Board board;
    private Calculator calculator;
    private String[] inputCommand;
    public ChessGame() {
        calculator = new Calculator();
    }

    public void run() {
        OutputView.printInputStartGuideMessage();
        ColorCase currentTurn = ColorCase.WHITE;
        Command command;

        while (!(command = inputCommandWithValidation()).isEnd()) {
            if (command.isStart()) {
                board = BoardFactory.createBoard();
                OutputView.printBoard(board.getBoard());
            }
            try {
                if (command.isMove()) {
                    board.move(inputCommand[SOURCE_POSITION_INDEX], inputCommand[TARGET_POSITION_INDEX], currentTurn);
                    currentTurn = reverseTurn(currentTurn);
                    OutputView.printBoard(board.getBoard());
                }
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }

            if (command.isStatus()) {
                OutputView.printPoint(calculator.calculatePoint(board, ColorCase.WHITE),
                        calculator.calculatePoint(board, ColorCase.BLACK));
            }

            if (board.isFinished()) {
                OutputView.printGameFinish();
                break;
            }
        }
    }

    private ColorCase reverseTurn(ColorCase color) {
        if (color == ColorCase.WHITE) {
            return ColorCase.BLACK;
        }
        return ColorCase.WHITE;
    }

    private Command inputCommandWithValidation() {
        try {
            inputCommand = InputView.inputCommand();
            moveCommandValidate(inputCommand);
            return Command.of(inputCommand[COMMAND_INDEX]);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputCommandWithValidation();
        }
    }

    private void moveCommandValidate(String[] inputCommand) {
        if (inputCommand[COMMAND_INDEX].equals("move") && inputCommand.length != 3) {
            throw new IllegalArgumentException("move source target 순으로 입력하시오! - 예. move b2 b3");
        }
    }
}
