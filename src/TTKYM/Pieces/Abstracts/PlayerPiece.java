package TTKYM.Pieces.Abstracts;

import TTKYM.Tile;

public abstract class PlayerPiece {
    private final PieceBundle PARENT_BUNDLE;
    private Tile currentTile;

    protected PlayerPiece(PieceBundle parentBundle) {
        this.PARENT_BUNDLE = parentBundle;
    }


    public PieceBundle getParentBundle(){
        return this.PARENT_BUNDLE;
    };

    public void setParentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }
    public Tile getCurrentTile() {
        return this.currentTile;
    }


}
