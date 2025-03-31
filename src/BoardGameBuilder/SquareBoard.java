package BoardGameBuilder;

import java.util.ArrayList;

public abstract class SquareBoard {



    protected SquareBoard(int BOARDSIZE, Tile defaultTile) {
        this.BOARD_SIZE = BOARDSIZE;
        this.InitializeBoardArray(defaultTile);
    }


    public abstract void putPieceInTile(Tile tile);

    public abstract void removePieceInTile(Tile tile);




}
