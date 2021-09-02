package demo.javachess.domain;

public interface State {
    Team getMoveTurn();

    Team getNextTurn();
}
