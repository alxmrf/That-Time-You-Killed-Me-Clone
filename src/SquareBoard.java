import java.util.ArrayList;

public class SquareBoard {

    private final int BOARD_SIZE;
    private ArrayList<ArrayList<Integer>> boardArray;


    protected SquareBoard(int BOARDSIZE) {
        this.BOARD_SIZE = BOARDSIZE;
        this.InitializeBoardArray();
    }

    private void InitializeBoardArray() {
        this.boardArray = new ArrayList<>(this.BOARD_SIZE);
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            this.boardArray.add(new ArrayList<>(this.BOARD_SIZE));
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                this.boardArray.get(i).add(0);
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            System.out.println(this.boardArray.get(i).toString());
        }

    }


}
