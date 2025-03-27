package BoardGameBuilder;

import java.util.ArrayList;

public abstract class Tile {
    protected ArrayList<TileOccupant> tileOccupants;

    protected abstract void setPiece(TileOccupant tileOccupant);
    public abstract TileOccupant getPiece();

}
