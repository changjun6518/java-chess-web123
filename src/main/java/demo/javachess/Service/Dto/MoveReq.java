package demo.javachess.Service.Dto;

import lombok.Getter;

@Getter
public class MoveReq {
    private final String from;
    private final String to;

    public MoveReq(String from, String to) {
        this.from = from;
        this.to = to;
    }

}
