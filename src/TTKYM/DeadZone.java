package TTKYM;

import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Players.Player;

import java.util.ArrayList;

public class DeadZone extends Tile{
    ArrayList<PlayerPiece> deadPieces;

    public DeadZone() {
        super(0);
    }

    public void putPieceInDeadZone(PlayerPiece piece) {
        this.deadPieces.add(piece);
    };
    public  ArrayList<PlayerPiece> getDeadPieces() {
        return this.deadPieces;
    }

    @Override
    public String toString() {
        return "DeadZone";
    }
}
