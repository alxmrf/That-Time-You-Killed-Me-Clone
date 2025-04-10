package TTKYM;
import TTKYM.Pieces.Abstracts.PieceBundle;
import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Pieces.TileOccupants.TileOccupant;
import java.util.ArrayList;

public abstract class Board {
    protected final Integer BOARD_SIZE = 6;
    protected ArrayList<ArrayList<Tile>> boardArray;


    protected Board() {
        this.InitializeBoardArray();
    }

    //board initialization
    private void InitializeBoardArray() {
        this.boardArray = new ArrayList<>(this.BOARD_SIZE);

        int counter = 1;
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            this.boardArray.add(new ArrayList<>(this.BOARD_SIZE));
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if (i == 0) {
                    this.boardArray.get(i).add(new DeadZone());
                } else if (i == 5) {
                    this.boardArray.get(i).add(new DeadZone());
                } else if (j == 0) {
                    this.boardArray.get(i).add(new DeadZone());
                } else if (j == 5) {
                    this.boardArray.get(i).add(new DeadZone());
                } else {
                    this.boardArray.get(i).add(new Tile(counter));
                    counter++;
                }

            }
        }
    }


    //Communication between different timeline boards

    public abstract void signalBoards();

    public Tile getTile(int tileNumber){
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if (this.boardArray.get(i).get(j).getTileNumber() == tileNumber) {
                    return this.boardArray.get(i).get(j);
                }
            }
        }
        return null;
    }

    //put tile ocuppants inside the tile
    public void putPieceInTile(int tileNumber, TileOccupant tileOccupant) {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                System.out.println(this.boardArray.get(i).get(j).getTileNumber());
                if (this.boardArray.get(i).get(j).getTileNumber() == tileNumber) {
                    this.boardArray.get(i).get(j).putTileOccupantInTile(tileOccupant);
                }
            }
        }
    }


    //Puts a player piece in the specified tile calling the getPlayerPiece method in the PieceBundle class
    public void putPlayerPieceInTile(int tileNumber, PieceBundle playerPieceColor) {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if (this.boardArray.get(i).get(j).getTileNumber() == tileNumber) {
                    this.boardArray.get(i).get(j).putPlayerPieceInTile(playerPieceColor.getPlayerPiece());
                    playerPieceColor.test();
                    System.out.println(this.boardArray.get(i).get(j).toString());

                    return;
                }
            }
        }
    }

    //Puts a player piece in the specific tile by recieving a Player piece  in the arguments
    public void putPlayerPieceInTile(int tileNumber, PlayerPiece playerPiece) {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if (this.boardArray.get(i).get(j).getTileNumber() == tileNumber) {
                    this.boardArray.get(i).get(j).putPlayerPieceInTile(playerPiece);
                    return;
                }
            }
        }
    }

    public PlayerPiece getPlayerPieceInTile(int tileNumber) {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if (this.boardArray.get(i).get(j).getTileNumber() == tileNumber) {
                    return this.boardArray.get(i).get(j).getPlayerPiece();
                }
            }
        }
        return null;
    }

    public boolean tileHasPlayerPiece(int tileNumber) {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                if (this.boardArray.get(i).get(j).getTileNumber() == tileNumber) {
                    return this.boardArray.get(i).get(j).hasPlayerPiece();
                }
            }
        }
        return false;
    }

    ;


    //Class general functionality
    public void printBoard(){
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            System.out.println(this.boardArray.get(i).toString());
        }
        System.out.println("\n");
    }



}
