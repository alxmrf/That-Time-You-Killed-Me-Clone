package TTKYM.Boards;

import TTKYM.Board;

public class FutureBoard extends Board {

    private PresentBoard presentBoard;



    @Override
    public void signalBoards() {

    }

    public void setPresentBoard(PresentBoard presentBoard) {
        this.presentBoard = presentBoard;
    }
}
