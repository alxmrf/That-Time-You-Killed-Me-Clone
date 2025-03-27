package TTKYM.Boards;

import TTKYM.Board;

public class PastBoard extends Board {
    private  PresentBoard presentBoard;
    public  PastBoard(){

    }




    @Override
    public void signalBoards() {

    }

    public void setPresentBoard(PresentBoard presentBoard) {
        this.presentBoard = presentBoard;
    }
}
