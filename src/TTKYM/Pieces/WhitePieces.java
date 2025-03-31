package TTKYM.Pieces;

import TTKYM.Pieces.Abstracts.PieceBundle;
import TTKYM.Pieces.Abstracts.PlayerPiece;

public class WhitePieces extends PieceBundle {

    public WhitePieces() {
        this.istantiatePieces(new WhitePawn());
    }


    @Override
    public PlayerPiece getPlayerPiece() {
        return null;
    }

    private class WhitePawn implements PlayerPiece {
        private WhitePawn() {

        }

        @Override
        public PlayerPiece CreatePlayerPiece() {
            return new WhitePawn();
        }
    }

}
