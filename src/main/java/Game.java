import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Game {
    private int[][] table;
    private int tableSize;
    private List<Player> myPlayers = new LinkedList<>();

    public void initTable(int size)
    {
        Random rn = new Random();
        tableSize=size;
        table=new int[tableSize][tableSize];
        for(int i=0; i<tableSize; i++)
            for(int j=0; j<tableSize ; j++)
                if(i!=j)
                {
                    table[i][j]=rn.nextInt(10) + 1;
                }
    }

    public void start()
    {
        printTable();

        for(Player p : myPlayers)
            new Thread(p).start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tabla dupa ce jocul sa terminat.");
        printTable();

    }
    public int[][] getTable( ) {
        return table;
    }

    public int getTableSize( ) {
        return tableSize;
    }

    public void addPlayer(Player player)
    {
        player.setGame( this );
        myPlayers.add( player );
    }
    public boolean tableEmpty()
    {
        for(int i=0; i<tableSize; i++)
            for(int j=0; j<tableSize ; j++)
                if(table[i][j]!=0)
                    return false;
        return true;
    }
    public void printTable()
    {
        for(int i=0; i < tableSize; i++) {
            for ( int j = 0 ; j < tableSize ; j++ ) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
