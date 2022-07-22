public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;
    private Player      aPlayer;

    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGui( aGui );
    }
}
