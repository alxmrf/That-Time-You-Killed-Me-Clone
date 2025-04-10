package TTKYM.Boards;

import TTKYM.Board;

public class PresentBoard extends Board {

    private static PresentBoard presentBoardInstance = new PresentBoard();
    private FutureBoard futureBoard = FutureBoard.getInstance();
    private PastBoard pastBoard =  PastBoard.getInstance();


    //Singleton Implementation
    private PresentBoard(){
    }
    public static PresentBoard getInstance(){
        return presentBoardInstance;
    }


    @Override
    public void signalBoards() {

    }


}
