package tests;


import game.ship.Rotation;
import game.ship.Ship;
import game.ship.ShipType;
import java.io.PrintStream;

public class MapTest {

    public static void test(){
        PrintStream out = System.out;
        Ship ship = new Ship(5,5, Rotation.R0, ShipType.CARRIER);
        int[][] map = ship.getMappedShip();
        out.println("   1 2 3 4 5 6 7 8 9 10");
        int x = 1;
        for(int j = 1; j < map[0].length; j++){
            if(x == 10) out.printf("%d ", x);
            else out.printf("%d  ", x);
            for(int i = 1; i < map.length; i++){
                out.printf("%d ", map[i][j]);
            }
            out.println();
            x++;
        }
        out.println();
        out.println("Ship should show on 5,5 5,6 5,7 5,8 5,9");
    }
}
