package TTKYM.Pieces;

import TTKYM.Pieces.Abstracts.PieceBundle;
import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Pieces.Abstracts.Pushable;

public class WhitePieces extends PieceBundle {


    //SingleTon
    private static final WhitePieces whitePiecesInstance = new WhitePieces();
    public static WhitePieces getInstance(){
        return whitePiecesInstance;
    }


    //Constructor
    private WhitePieces() {
        this.CreatePlayerPieces();
    }


    @Override
    public void CreatePlayerPieces() {
        for (int i = 0; i < 6; i++) {
            WhitePawn piece = new WhitePawn(this);
            playerPieces.add(piece);
        };
    }



    @Override
    public PlayerPiece getPlayerPiece() {
        if (this.counter > 5){
            return null;
        }
        WhitePieces.WhitePawn pawn = (WhitePieces.WhitePawn) this.playerPieces.get(this.counter);
        this.counter++;
        return pawn;
    }
    @Override
    public String toString() {
        return "WhitePieces";
    }

    private static class WhitePawn extends PlayerPiece implements  Pushable {

        private WhitePawn(WhitePieces parentBundle) {
            super(parentBundle);
        }
        @Override
        public String toString() {
            return "WhitePawn" ;
        }

    }

}
