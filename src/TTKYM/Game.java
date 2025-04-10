package TTKYM;

import TTKYM.Boards.FutureBoard;
import TTKYM.Boards.PastBoard;
import TTKYM.Boards.PresentBoard;
import TTKYM.Pieces.Abstracts.PlayerPiece;
import TTKYM.Pieces.Abstracts.Pushable;
import TTKYM.Pieces.BlackPieces;
import TTKYM.Pieces.WhitePieces;
import TTKYM.Players.Player;
import TTKYM.enums.Direction;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {



    //Assigment of the Board variables, boards are created as a singleton so there is no way of
    //using a different wrong board
    private final PastBoard  pastBoard = PastBoard.getInstance();
    private final PresentBoard presentBoard = PresentBoard.getInstance();
    private final FutureBoard futureBoard = FutureBoard.getInstance();


    //Assignment of the Piece bundles to a variable, pieces are a singleton as well

    private final BlackPieces blackPieces = BlackPieces.getInstance();
    private final WhitePieces whitePieces = WhitePieces.getInstance();

    //Creates both the Black and white player, and assigns them their pieces and their initial focus

    private final Player whitePlayer = new Player(pastBoard,whitePieces);
    private final Player blackPlayer = new Player(futureBoard,blackPieces);

    public Game(){
        this.setUpPlayerPiecesInBoard();
        this.givePiecesToPlayers();
    }

    /*      Handle Player Movement
    * The functions bellow are for handling the players movement, things like checking if the player
    * move was valid , or if the piece that they are trying to move are really his, see the documentation
    * of each function for more details
    * */

    /*
    * Calculates which moves are valid given the pieces initial board position , for example a piece on the last
    * row of the board cannot move down , so it discards this as a possible move
    * */
    private ArrayList<Direction> getValidMoves(int tileNumber){
        ArrayList<Direction> validMoves = new ArrayList<>();

        int[] decomposedTileNumber = Tile.decomposeTileNumber(tileNumber);
        if (!((decomposedTileNumber[1] - 1)  < 1)  ){
            validMoves.add(Direction.UP);
        }
        if (!((decomposedTileNumber[1] + 1) > 4) ){
            validMoves.add(Direction.DOWN);
        }
        if (!((decomposedTileNumber[0] - 1) < 1)  ){
            validMoves.add(Direction.LEFT);
        }
        if (!((decomposedTileNumber[0] + 1) > 4) ){
            validMoves.add(Direction.RIGHT);
        }

        return validMoves;
    }

    private PlayerPiece tileHasPiece(Board currentBoard, int tileNumber){
        return currentBoard.getPlayerPieceInTile(tileNumber);
    }

    //Moves the piece from the original position to one of its adjacent squares
    //Checking if the move is valid along the way

    private void pushPiece(){}


    private void movePiece(int boardPosition,Player  currentPlayer,Direction movementDirection){

        /*
         *
         * The method movePiece needs refactoring as it is too bloated and it`s structure is too hard to read
         *
         *
         * */
        //gets valid moves
        ArrayList<Direction> validMoves = this.getValidMoves(boardPosition);

        //gets the board that the player making the move is focused at
        Board currentBoard  = currentPlayer.getPlayerFocus();

        //Checks if the board position passed has a pawn in it
        PlayerPiece pawn = this.tileHasPiece(currentBoard,boardPosition);



        if (pawn!= null) {
            if (pawn.getParentBundle() == currentPlayer.getPlayerPieces()) {
                if (validMoves.contains(movementDirection)) {
                    int newTile = boardPosition + Direction.movementValue(movementDirection);
                    if(currentBoard.tileHasPlayerPiece(boardPosition)){
                        PlayerPiece pieceToPush = currentBoard.getPlayerPieceInTile(boardPosition);
                        if (pieceToPush instanceof Pushable){
                            this.pushPiece();
                        }
                    }
                    currentBoard.putPlayerPieceInTile(newTile, pawn);
                }else {
                    System.out.println(movementDirection + " is not a valid move");
                    currentPlayer.getPlayerFocus().putPlayerPieceInTile(boardPosition, pawn);
                }
            }else {
            System.out.println(pawn + " is not a piece of " + currentPlayer);
            currentPlayer.getPlayerFocus().putPlayerPieceInTile(boardPosition, pawn);
            }
        }else{
            System.out.println("No pawn found for tile " + boardPosition);
        }
    }

//    public void movePiece(int BoardPosition, )

    private void gameLoop(){
        //Prints the game to give the player a look of the board
        this.printGame();
        //Scans for commands
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Please enter in which tile the piece you want to move is in, " +
                "\nand in what direction you want to move it" +
                "\nex : 11 up\n"+
                "after each field that you type press enter");
        String stringBoardNumber = scanner.next();
        System.out.println( stringBoardNumber );
        Integer boardNumber = Integer.parseInt(stringBoardNumber);
        String stringDirection = scanner.next();
        System.out.println(stringDirection);
        stringDirection = stringDirection.toUpperCase();

        //Translates from String to TTKYM.enums.Direction
        Direction  direction = switch (stringDirection) {
            case "UP" -> Direction.UP;
            case "DOWN" -> Direction.DOWN;
            case "LEFT" -> Direction.LEFT;
            case "RIGHT" -> Direction.RIGHT;
            default -> null;
        };

        //checks if the direction was valid
        if (direction == null){
            System.out.println("Invalid direction");
            return;
        }

        this.movePiece(boardNumber, whitePlayer, direction);



    }

    //Sets the player pieces in their initial positions, 3 blacks and 3 whites, one in each
    // timeline
    private void setUpPlayerPiecesInBoard() {
        this.pastBoard.putPlayerPieceInTile(1,whitePieces);
        this.presentBoard.putPlayerPieceInTile(1,whitePieces);
        this.futureBoard.putPlayerPieceInTile(1,whitePieces);

        this.pastBoard.putPlayerPieceInTile(16, blackPieces);
        this.presentBoard.putPlayerPieceInTile(16, blackPieces);
        this.futureBoard.putPlayerPieceInTile(16, blackPieces);

    }

    //Links the players with their respective pieces
    private void givePiecesToPlayers() {
        this.blackPlayer.setPlayerPieces(blackPieces);
        this.whitePlayer.setPlayerPieces(whitePieces);
    }

    //Class Functions
    public void printGame(){

        pastBoard.printBoard();
        presentBoard.printBoard();
        futureBoard.printBoard();

    }

    public static  void main ( String[] args ){
        Game game = new Game();
        while (1==1){
            game.gameLoop();
        }
    }
}


