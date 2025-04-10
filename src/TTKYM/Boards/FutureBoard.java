package TTKYM.Boards;
import TTKYM.Board;

public class FutureBoard extends Board {
    private static FutureBoard futureBoardInstance = new FutureBoard(PresentBoard.getInstance());
    private PresentBoard presentBoard = PresentBoard.getInstance();

    private FutureBoard(PresentBoard presentBoard) {
        this.presentBoard = presentBoard;
    }

    public static FutureBoard getInstance(){
        return futureBoardInstance;
    }

    @Override
    public void signalBoards() {}
}
