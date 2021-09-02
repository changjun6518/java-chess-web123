package demo.javachess.domain;

import demo.javachess.domain.State;
import demo.javachess.domain.Team;

public class Playing implements State {

    private final Team movedTurn;

    public Playing(Team movedTurn) {
        this.movedTurn = movedTurn;
    }

    @Override
    public Team getMoveTurn() {
        return movedTurn;
    }

    @Override
    public Team getNextTurn() {
        return movedTurn.getOpposingState();
    }

}
