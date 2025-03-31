package TTKYM;

import BoardGameBuilder.SquareBoard;
import TTKYM.Pieces.TileOccupants.TileOccupant;

import java.util.ArrayList;

public abstract class Board{
    protected final Integer BOARD_SIZE = 4;
    protected ArrayList<ArrayList<Tile>> boardArray;


    protected Board() {
        ;
    }

    public abstract void signalBoards();


    public void printBoard(){
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            System.out.println(this.boardArray.get(i).toString());
        }
    }

    public void putPieceInTile(int tileNumber, TileOccupant tileOccupant) {
        for(int i = 0; i < this.BOARD_SIZE; i++) {
            for(int j = 0; j < this.BOARD_SIZE; j++) {
                if (this.boardArray.get(i).get(j).equals(tileOccupant)) {}
            }
        }

    }



    private void InitializeBoardArray() {
        this.boardArray = new ArrayList<>(this.BOARD_SIZE);
        int counter = 0;
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            this.boardArray.add(new ArrayList<>(this.BOARD_SIZE));
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                this.boardArray.get(i).add(new Tile(counter));
                counter++;
            }
        }
    }

    public void putPlayerInTile(Integer tileNumber) {

    }

    public void removePieceInTile(int row, int col) {
        this.boardArray.get(row).remove(col);
    }



}
