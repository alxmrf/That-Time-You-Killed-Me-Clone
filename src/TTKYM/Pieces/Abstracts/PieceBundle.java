package TTKYM.Pieces.Abstracts;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;

public abstract class PieceBundle {
    protected ArrayList<PlayerPiece> playerPieces = new ArrayList<>(6);
    protected int counter = 0;


    protected abstract void CreatePlayerPieces();


    public abstract PlayerPiece getPlayerPiece();

}
