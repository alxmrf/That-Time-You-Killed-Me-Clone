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

    public void pushPlayer(Direction pushDirection,int boardPosition, Board currentBoard){
        Tile currentTile = currentBoard.getTile(boardPosition);
        PlayerPiece pushedPiece = currentTile.getPlayerPiece();
        if(!(this.checkIfMovesIsInbounds(boardPosition,pushDirection))){
            currentBoard.putPlayerPieceInTile(0,pushedPiece);
        }
        int newBoardPosition = boardPosition + Direction.movementValue(pushDirection);
        currentBoard.putPlayerPieceInTile(newBoardPosition,pushedPiece);


    }


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
    /*
    * returns the pawn to its parent tile without changing its original location
    * */
    private void returnPawnToParentTile(PlayerPiece pawn){
        pawn.getCurrentTile().putPlayerPieceInTile(pawn);
    }
    /*
    * Checks if the pawn in the tile that the player is trying to move actually pertains to the player
    * if not the methods puts the pawn back into its current tile
    *
    * this function is merely a helper function to help clean the code
    * */
    private boolean checkPawnOwnership(PlayerPiece pawn, Player currentPlayer){
        if (pawn.getParentBundle() == currentPlayer.getPlayerPieces()){
            return true;
        }
        else {
            System.out.println("This piece isn`t property of this player");
            //Returns the pawn piece to its current tile to preserve its position
            this.returnPawnToParentTile(pawn);
            return false;
        }
    }
    /*
    * Checks if the requested movement is inside the Board`s bounds
    * */
    private boolean checkIfMovesIsInbounds(int boardPosition, Direction movementDirection){
        ArrayList<Direction> validMoves= getValidMoves(boardPosition);

        return validMoves.contains(movementDirection);

    }

    /*
    * This functions moves a player piece from one square to another after doing all the checks to verify that
    * said move is valid, also calls the function to push a pawn if the tile if occupied by a pawn
    * */
    private void movePiece(int boardPosition,Player  currentPlayer,Direction movementDirection){

        //gets the board that the player making the move is focused at
        Board currentBoard  = currentPlayer.getPlayerFocus();
        /*
        * Checks if the board position passed has a pawn in it
        * The pawn checking mechanism works by actually passing the pawn from the tile to the game class
        * not only passing a pointer to the object, this is done to assure that the pawn will not be
        * referenced at the same time by two parts of the program and run onto the risk of it duplicating the pawn
        * as such with this design the pawn must be returned to a tile by the end of the computations
        * it could be another tile or the same current tile
        * */
        PlayerPiece pawn = this.tileHasPiece(currentBoard,boardPosition);

        //Checks if there is a pawn in the selected tile
        if (pawn == null){
            System.out.println("There is no piece on the tile "+boardPosition);
            return;
        }
        if(! this.checkPawnOwnership(pawn,currentPlayer)){
            return;
        }

        if(!checkIfMovesIsInbounds(boardPosition,movementDirection)){
            System.out.println(movementDirection + " is not a valid move");
            this.returnPawnToParentTile(pawn);
            return;
        }

        int newTile = boardPosition + Direction.movementValue(movementDirection);

        if(currentBoard.tileHasPlayerPiece(boardPosition)) {
                this.pushPlayer(movementDirection,boardPosition,currentBoard);
        }
        currentBoard.putPlayerPieceInTile(newTile, pawn);


    }

    /*
    * End of Player movement code
    * */







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


