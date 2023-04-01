package boardgame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int column) {
        if(rows != 8 || column != 8){
            throw new BoardException("Invalid board size");
        }
        this.rows = rows;
        this.columns = column;
        pieces = new Piece[rows][column];
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)){
            throw new BoardException("Invalid position");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if(!positionExists(position)){
            throw new BoardException("Invalid position");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)){
            throw new BoardException("Invalid movement");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 & column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Invalid position");
        }
        return piece(position)!=null;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Invalid remove piece position");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }
}
