package game.ship;

/**
 * Defines different types of ships. Each ship has a size between 2-5
 */
public enum ShipType {
    CARRIER, BATTLESHIP, SUBMARINE, CRUISER, DESTROYER;

    public static int getSize(ShipType type){
        int size = 0;
        switch (type){
            case CARRIER:
                size = 5;
                break;
            case BATTLESHIP:
                size = 4;
                break;
            case SUBMARINE: case CRUISER:
                size = 3;
                break;
            case DESTROYER:
                size = 2;
                break;
        }
        return size;
    }
}
