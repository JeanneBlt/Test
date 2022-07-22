
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private static final String[] aValidCommands = 
        { "go", "quit", "help", "eat", "look", "back", "take", "drop","inventory", "equip","note","go note","break", "train", "test"};

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {

    } // CommandWords()

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     * @param pString the command string
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<this.aValidCommands.length; i++ ) {
            if ( this.aValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    } // isCommand()

    /**
     * shows the commands that can be typed
     * @return the string of command
     */
    public String getCommandList()
    {
        StringBuilder vCo = new StringBuilder();
        for(int i=0;i<aValidCommands.length;i++)
        {vCo.append(aValidCommands[i]+" ");}
        return vCo.toString();
    }//getCommandList()
} // CommandWords