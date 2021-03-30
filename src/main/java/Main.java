public class Main {
    public static void main ( String[] args)  {
        Game myGame = new Game();
        myGame.initTable( 8 );
        myGame.addPlayer(new Player("Player 1"));
        myGame.addPlayer(new Player("Player 2"));
        myGame.addPlayer(new Player("Player 3"));
        myGame.start();
    }

}
