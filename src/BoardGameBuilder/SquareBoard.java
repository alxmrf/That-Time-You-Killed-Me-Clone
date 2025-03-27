package BoardGameBuilder;

import java.util.ArrayList;

public abstract class SquareBoard {

    protected final int BOARD_SIZE;
    protected ArrayList<ArrayList<Tile>> boardArray;


    protected SquareBoard(int BOARDSIZE, Tile defaultTile) {
        this.BOARD_SIZE = BOARDSIZE;
        this.InitializeBoardArray(defaultTile);
    }

    private void InitializeBoardArray(Tile tile) {
        this.boardArray = new ArrayList<>(this.BOARD_SIZE);
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            this.boardArray.add(new ArrayList<>(this.BOARD_SIZE));
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                this.boardArray.get(i).add(tile);
            }
        }
    }

    public abstract void putPieceInTile(Tile tile);

    public abstract void removePieceInTile(Tile tile);

    public void printBoard(){
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            System.out.println(this.boardArray.get(i).toString());
        }

    }


}
