package demo.javachess.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SQUARE_ID")
    private Long id;

    @Embedded
    private Position position;

    @Enumerated(EnumType.STRING)
    private Team team;
    @Enumerated(EnumType.STRING)
    private Piece piece;


    public Square(Position position, Team team, Piece piece) {
        this.position = position;
        this.team = team;
        this.piece = piece;
    }

    protected Square() {

    }

    public static Square of(Position position, Team team, Piece piece) {
        return new Square(position, team, piece);
    }

    public boolean movable(final Board board, final Position to) {
        return piece.findPossiblePaths(board, position).contains(to);
    }


    public boolean isBlank() {
        return team.equals(Team.NONE) && piece == Piece.NONE;
    }

    public boolean isSameTeam(Square targetSquare) {
        return team == targetSquare.getTeam();
    }

    public boolean isOtherTeam(Square targetSquare) {
        return team != targetSquare.getTeam() && (team != Team.NONE && targetSquare.team != Team.NONE);
    }

    public boolean isWhite() {
        return team == Team.WHITE;
    }

    private boolean isBlack() {
        return team == Team.BLACK;
    }
    public boolean isFirstTurn() {
        return (isWhite() && position.getRank() == 2) |
                (isBlack() && position.getRank() == 7);
    }


    public void update(final Piece piece, final Team team) {
        this.piece = piece;
        this.team = team;
    }

    public String getPositionValue() {
        return String.valueOf(position.getFile()) + String.valueOf(position.getRank());
    }

    public String getPieceTeam() {
        if (piece == Piece.NONE) {
            return "BLANK";
        }
        return team.name() + "_" + piece.name();
    }
}
