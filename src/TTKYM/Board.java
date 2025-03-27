package TTKYM;

import BoardGameBuilder.SquareBoard;
import BoardGameBuilder.Tile;

public abstract class Board extends SquareBoard {


    protected Board(int BOARDSIZE, Tile defaultTile) {
        super(BOARDSIZE, defaultTile);
    }

    public abstract void signalBoards();

    @Override
    public void putPieceInTile(Tile tile) {
        int tileNumber = tile.getTileNumber();
        int row = 0;
        int col = 0;
        int count = 0;
        int offset = 0;
        for(int i = 0; i<= tileNumber; i++) {
            count++;
            col++;
            if(count > this.BOARD_SIZE){
                offset++;
                row++;
                col = 0;
                count = 1;
            }
        }
        col += offset;
        this.boardArray.get(row).add(col,tile);
    }

    @Override
    public void removePieceInTile(Tile tile) {
        int tileNumber = tile.getTileNumber();
        int row = 0;
        int col = 0;
        int count = 0;
        int offset = 0;
        for(int i = 0; i<= tileNumber; i++) {
            count++;
            col++;
            if(count > this.BOARD_SIZE){
                offset++;
                row++;
                col = 0;
                count = 1;
            }
        }
        col += offset;
        this.boardArray.get(row).remove(col);
    }

    public void removePieceInTile(int row, int col) {
        this.boardArray.get(row).remove(col);
    }



}
