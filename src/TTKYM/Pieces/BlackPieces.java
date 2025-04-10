package TTKYM.Pieces;

import TTKYM.Pieces.Abstracts.PieceBundle;
import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Pieces.Abstracts.Pushable;

public class BlackPieces extends PieceBundle {
    //Singleton
    private static BlackPieces instance = new BlackPieces();
    public static BlackPieces getInstance(){
        return instance;
    }

    //Constructor
    private BlackPieces() {
        this.CreatePlayerPieces();
    }

    @Override
    public void CreatePlayerPieces() {
            for (int i = 0; i < 6; i++) {
                BlackPawn piece = new BlackPawn(this);
                playerPieces.add(piece);
            };
    }

    @Override
    public PlayerPiece getPlayerPiece() {
        if (this.counter > 5){
            return null;
        }
        BlackPawn pawn = (BlackPawn) this.playerPieces.get(this.counter);
        this.counter++;
        return pawn;
    }


    private static class BlackPawn extends PlayerPiece implements Pushable {
        private BlackPawn(PieceBundle PARENT_BUNDLE) {
           super( PARENT_BUNDLE);
        }

        @Override
        public String  toString() {
            return "BlackPawn";
        }
    }
}
