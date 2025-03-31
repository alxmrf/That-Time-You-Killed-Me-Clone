package TTKYM.Pieces.Abstracts;

import java.util.ArrayList;

public abstract class PieceBundle {
    protected ArrayList<PlayerPiece> playerPieces = new ArrayList<>(6);
    protected int counter = 0;


    protected <T extends PlayerPiece> void istantiatePieces(T prototype) {
        for (int i = 0; i < 6; i++) {
            @SuppressWarnings("unchecked")
            T piece = (T) prototype.CreatePlayerPiece();
            playerPieces.add(piece);
        }
    };


    public abstract PlayerPiece getPlayerPiece();

}
