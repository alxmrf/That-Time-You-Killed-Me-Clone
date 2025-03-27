package TTKYM.Boards;

import TTKYM.Board;

public class PresentBoard extends Board {
    private FutureBoard futureBoard;
    private PastBoard pastBoard;
    public PresentBoard(){

    }

    @Override
    public void signalBoards() {

    }

    public void setFutureBoard(FutureBoard futureBoard) {
        this.futureBoard = futureBoard;
    }

    public void setPastBoard(PastBoard pastBoard) {
        this.pastBoard = pastBoard;
    }
}
