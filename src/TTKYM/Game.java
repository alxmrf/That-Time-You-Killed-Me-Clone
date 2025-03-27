package TTKYM;

import TTKYM.Boards.FutureBoard;
import TTKYM.Boards.PastBoard;
import TTKYM.Boards.PresentBoard;

public class Game {

    private PastBoard  pastBoard;
    private PresentBoard presentBoard;
    private FutureBoard futureBoard;

    public Game(){
        this.setUpBoards();
    }

    private void setUpBoards(){
        this.futureBoard = new FutureBoard();
        this.presentBoard = new PresentBoard();
        this.pastBoard = new PastBoard();

    }




}
