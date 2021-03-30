import java.lang.Runnable;
import java.util.Random;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private int[][] tokenBag;
    public void setGame(Game game) {
        this.game = game;
    }
    public Player(String name) {
        this.name=name;
    }


    @Override
    public void run( ) {
        tokenBag = new int[game.getTableSize()][game.getTableSize()];
        int firstMove=0;
        Random rn = new Random();
        int i;
        int j;
        while(!game.tableEmpty()) {
            do {
                i = rn.nextInt( game.getTableSize() );
                j = rn.nextInt( game.getTableSize() );
            }while (game.getTable()[i][j]==0);
            tokenBag[i][j] = game.getTable()[i][j];
            game.getTable()[i][j] = 0;
            System.out.println( name + " a ales piesa de pe pozitia " + "[" + i + "]" + "[" + j + "]" );
        }

    }
    public void pick()
    {
        
    }







}
