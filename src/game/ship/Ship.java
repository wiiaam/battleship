package game.ship;

public class Ship {

    private int startLocationX;
    private int startLocationY;
    private Rotation rotation;
    private ShipType type;
    private boolean[] hits;


    public Ship(int startLocationX, int startLocationY, Rotation rotation, ShipType type) throws ShipOutOfBoundsException{
        this.startLocationX = startLocationX;
        this.startLocationY = startLocationY;
        this.rotation = rotation;
        this.type = type;
        if(startLocationX < 0 || startLocationX > 10 || startLocationY < 0 || startLocationY > 10) throw new ShipOutOfBoundsException();
        switch (rotation){
            case R0:
                if(startLocationY + ShipType.getSize(type)- 1 > 10) throw new ShipOutOfBoundsException();
                break;
            case R90:
                if(startLocationX - ShipType.getSize(type) + 1 < 1) throw new ShipOutOfBoundsException();
                break;
            case R180:
                if(startLocationY - ShipType.getSize(type) + 1 < 1) throw new ShipOutOfBoundsException();
                break;
            case R270:
                if(startLocationX + ShipType.getSize(type) - 1 > 10) throw new ShipOutOfBoundsException();
                break;
        }
        clearHits();
    }

    public void clearHits(){
        int size = ShipType.getSize(type);
        hits = new boolean[size];

    }

    public boolean fire(int x, int y) {
        return getMappedShip()[x][y] > 0;
    }

    public void setLocation(int x, int y){

    }

    public int[][] getMappedShip(){
        int[][] map = new int[11][11];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = 0;
            }
        }
        int pos = 1;
        switch (rotation){
            case R0:
                for(int i = startLocationY; pos <= ShipType.getSize(type); i++){
                    map[startLocationX][i] = pos;
                    pos++;
                }

                break;

            case R90:
                for(int i = startLocationX; pos <= ShipType.getSize(type); i--){
                    map[i][startLocationY] = pos;
                    pos++;
                }
                break;

            case R180:
                for(int i = startLocationY; pos <= ShipType.getSize(type); i--){
                    map[startLocationX][i] = pos;
                    pos++;
                }
                break;

            case R270:
                for(int i = startLocationX; pos <= ShipType.getSize(type); i++){
                    map[i][startLocationX] = pos;
                    pos++;
                }
                break;

        }

        return map;
    }
}
