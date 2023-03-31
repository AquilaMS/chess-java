package boardgame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private int rows;
    private int column;
    private Piece[][] pieces;

    public Board(int rows, int column) {
        this.rows = rows;
        this.column = column;
        pieces = new Piece[rows][column];
    }

    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
}
