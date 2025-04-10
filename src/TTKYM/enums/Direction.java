package TTKYM.enums;

public enum Direction {
        UP, DOWN, LEFT, RIGHT;


        /*
         *Returns a corresponding Int Value for each of the directions that the player can move, this is done
         *to make computation of the movement cleaner
         * */
        public static int movementValue(Direction direction) {
                return switch (direction) {
                        case UP -> -4;
                        case DOWN -> 4;
                        case LEFT -> -1;
                        case RIGHT -> 1;
                };

        }

}
