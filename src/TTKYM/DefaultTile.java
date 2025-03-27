package TTKYM;

import BoardGameBuilder.Tile;
import BoardGameBuilder.TileOccupant;

import java.util.ArrayList;

public class DefaultTile extends Tile {


    @Override
    protected void setPiece(TileOccupant tileOccupant) {
        this.tileOccupants.add(tileOccupant);
    }

    @Override
    public ArrayList<TileOccupant> getPieces() {
        return this.tileOccupants;
    }
}
