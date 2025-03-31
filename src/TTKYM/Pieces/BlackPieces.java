package TTKYM.Pieces;

import TTKYM.Pieces.Abstracts.PieceBundle;
import TTKYM.Pieces.Abstracts.PlayerPiece;

public class BlackPieces extends PieceBundle {

    public BlackPieces() {
        this.istantiatePieces(new BlackPawn());
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


    private class BlackPawn implements PlayerPiece {
        private BlackPawn() {
        }


        @Override
        public PlayerPiece CreatePlayerPiece() {
            return new BlackPawn();
        }
    }
}
