package TTKYM.Boards;

import TTKYM.Board;

public class PastBoard extends Board {
    private static PastBoard pastBoardInstance = new PastBoard();
    private  PresentBoard presentBoard =  PresentBoard.getInstance();

    private PastBoard(){
    }
    public static PastBoard getInstance(){
        return pastBoardInstance;
    }




    @Override
    public void signalBoards() {

    }

}
