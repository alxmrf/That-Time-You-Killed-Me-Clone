package TTKYM;

import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Pieces.TileOccupants.TileOccupant;

import java.util.ArrayList;

public class Tile {
    PlayerPiece playerPiece = null;
    TileOccupant ocupant = null;
    int tileNumber;


    public Tile(int tileNumber) {
        this.tileNumber = tileNumber;
    }
    protected void setPiece(TileOccupant tileOccupant) {
        this.tileOccupants.add(tileOccupant);
    }

    @Override
    public boolean equals(Object obj) {
        if
    }

    public ArrayList<TileOccupant> getPieces() {
        return this.tileOccupants;
    }
}
