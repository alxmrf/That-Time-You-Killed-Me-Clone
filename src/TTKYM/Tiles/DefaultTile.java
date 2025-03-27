package TTKYM.Tiles;

import BoardGameBuilder.TileOccupant;
import BoardGameBuilder.Tile;

abstract class  DefaultTile extends Tile {
    private int tileNumber;


    protected void setTileNumber(Integer tileNumber) throws IllegalArgumentException {
        if (tileNumber < 0 || tileNumber > 16) {
            throw new IllegalArgumentException("Illegal tile number: " + tileNumber + " (must be between 0 and 16)");
        }
        this.tileNumber = tileNumber;
    }

    @Override
    protected void setPiece(TileOccupant tileOccupant) {

    }
    public int getTileNumber() {
        return this.tileNumber;
    }
}