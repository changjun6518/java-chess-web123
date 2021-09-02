package demo.javachess.Service.Dto;

import demo.javachess.domain.State;
import demo.javachess.domain.Finished;
import lombok.Getter;

import java.util.Objects;

@Getter
public class StateRes {
    private final boolean finished;
    private final String movedTurn;
    private final String nextTurn;

    public StateRes(boolean finished, String movedTurn, String nextTurn) {
        this.finished = finished;
        this.movedTurn = movedTurn;
        this.nextTurn = nextTurn;
    }

    public static StateRes from(final State state) {
        return new StateRes(Objects.equals(state.getClass(), Finished.class),
                state.getMoveTurn().name(),
                state.getNextTurn().name());
    }

}
