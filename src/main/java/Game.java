import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    private int[][] table;
    private int tableSize;
    private List<Player> myPlayers = new LinkedList<>();
    public static Object obj = new Object();
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

    public synchronized void start()
    {
        printTable();

        for(Player p : myPlayers)
           new Thread( p ).start();



        while(!tableEmpty())
            for(int i=0; i< myPlayers.size(); i++ )
            {
                try {
                    wait(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (myPlayers.get(i))
                {
                    myPlayers.get(i).notify();
                }
            }


        try {
            wait(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0; i< myPlayers.size(); i++ ) //notify again so the threads see that the game is finish and close
        {
            try {
                wait(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (myPlayers.get(i))
            {
                myPlayers.get(i).notify();
            }
        }

        System.out.println("Tabla dupa ce jocul sa terminat.");
        printTable();
        System.out.println("Punctaje obtinute: ");
        String winnerName="";
        int winnerScore=0;
        for(Player p : myPlayers)
            {
                System.out.println(p.getName() + " a obtinut " + p.punctajObtinut());
                if(winnerScore<p.punctajObtinut())
                {
                    winnerName=p.getName();
                    winnerScore=p.punctajObtinut();
                }
            }
        System.out.println(winnerName + " a castigat!");


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
