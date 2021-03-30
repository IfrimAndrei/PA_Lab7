import java.lang.Runnable;
import java.util.Random;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private int[][] tokenBag;
    private int[] wantedTokens;
    public void setGame(Game game) {
        this.game = game;
    }
    public Player(String name) {
        this.name=name;
    }


    @Override
    public void run( ) {
        tokenBag = new int[game.getTableSize()][game.getTableSize()];
        wantedTokens = new int[2];
        int firstMove=1;


        while(!game.tableEmpty()) {
            if(firstMove==1)//prima mutare e random;
            {
                Random rn = new Random();
                int i,j;
                do {

                     i = rn.nextInt( game.getTableSize() );
                     j = rn.nextInt( game.getTableSize() );
                    wantedTokens[0] = j;
                    wantedTokens[1] = i;
                }
                while(game.getTable()[i][j]==0 && !game.tableEmpty());
                pick(i,j);
                firstMove=0;
            }
            else
            {
                if(game.getTable()[wantedTokens[0]][wantedTokens[1]]!=0)
                {
                    pick(wantedTokens[0],wantedTokens[1]);
                    firstMove=1; //am terminat un ciclu si incepem altul
                }
                else
                {
                    extendingSequence();
                }

            }

        }

    }
    public void pick(int i,int j)
    {
        tokenBag[i][j] = game.getTable()[i][j];
        game.getTable()[i][j] = 0;
        System.out.println( name + " a ales piesa de pe pozitia " + "[" + i + "]" + "[" + j + "]" );
    }
    public void extendingSequence()
    {
        for(int i=0 ; i< game.getTableSize(); i++)
        {
            if(game.getTable()[i][wantedTokens[1]]!=0)
            {
                pick( i,wantedTokens[1] );
                wantedTokens[1]=i;
                return;
            }
        }
        for(int j=0 ; j< game.getTableSize(); j++)
        {
            if ( game.getTable()[wantedTokens[1]][j] != 0 )
            {
                pick( wantedTokens[1], j );
                wantedTokens[0] = j;
                return;
            }
        }
        Random rn = new Random();
        int i,j;
        do {

            i = rn.nextInt( game.getTableSize() );
            j = rn.nextInt( game.getTableSize() );
            wantedTokens[0] = j;
            wantedTokens[1] = i;
        }
        while(game.getTable()[i][j]==0 && !game.tableEmpty());
        pick(i,j);
    }







}
