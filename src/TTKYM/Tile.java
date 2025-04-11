package TTKYM;

import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Pieces.TileOccupants.TileOccupant;

public class Tile {
    PlayerPiece playerPiece = null;
    TileOccupant ocupant = null;
    int x_pos;
    int y_pos;
    int tileNumber;

    //constructor

    public Tile(int tileNumber) {
        this.tileNumber = tileNumber;
        int [] decomposed_number = decomposeTileNumber(this.tileNumber);
        this.x_pos = decomposed_number[0];
        this.y_pos = decomposed_number[1];
    }

    public static int[] decomposeTileNumber(int tileNumber){

        /*
         * This method is a very bad solution, but implementing a good solution would require
         * me to reestructure various methods and classes, or to make a function that while prettier
         * would cost a lot of computational power so this is the best solution for now
         * */

        return switch (tileNumber){

            case 1 -> new int[]{1, 1};
            case 2 -> new int[]{2, 1};
            case 3 -> new int[]{3, 1};
            case 4 -> new int[]{4, 1};
            case 5 -> new int[]{1, 2};
            case 6 -> new int[]{2, 2};
            case 7 -> new int[]{3, 2};
            case 8 -> new int[]{4, 2};
            case 9 -> new int[]{1, 3};
            case 10 -> new int[]{2, 3};
            case 11 -> new int[]{3, 3};
            case 12 -> new int[]{4, 3};
            case 13 -> new int[]{1, 4};
            case 14 -> new int[]{2, 4};
            case 15 -> new int[]{3, 4};
            case 16 -> new int[]{4, 4};
            default -> new int[]{0, 0};
        };

    }

    public int getTileNumber() {
        return tileNumber;
    }


    public void putTileOccupantInTile(TileOccupant tileOccupant) {
        this.ocupant = tileOccupant;
    }


    public boolean hasPlayerPiece(){
        if (this.playerPiece == null) {
            System.out.println(this.playerPiece);
            return false;
        };
        return true;
    }

    public PlayerPiece getPlayerPiece() {
        PlayerPiece temp  =  this.playerPiece;
        this.playerPiece = null;
        return temp;
    }

    public void setPlayerPiece(PlayerPiece playerPiece) {
        this.playerPiece = playerPiece;
        System.out.println(this.playerPiece);
        this.playerPiece.setParentTile(this);
    }



    @Override
    public String toString() {
        String returnString = "";
        if (this.playerPiece != null) {
            returnString = returnString + this.playerPiece.toString();
        }
        if (this.ocupant != null) {
            returnString = returnString + this.ocupant.toString();
        }
        if (returnString.isEmpty()) {
            returnString = Integer.toString(this.tileNumber);
        }
        while (returnString.length() <= 8) {
            returnString = returnString + " ";}
        return returnString;
    }


}
