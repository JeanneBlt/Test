
public class Command
{

    // ## Attributs ## 

    private String aCommandWord;
    private String aSecondWord;

    // ## Constructeurs ##

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     * @param pCommandWord the first word we entered
     * @param pSecondWord the second word we entered
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord=pCommandWord;
        this.aSecondWord=pSecondWord;
    }//Command(.)

    // ## Accesseurs ##
    /**
     * Return the command word (the first word) of this command
     * @return aCommandWord
     */
    public String getCommandWord() {return this.aCommandWord;}//getCommandWord()

    /**
     * Return the second word of this command
     * @return aSecondWord the second word we entered
     */
    public String getSecondWord() {return this.aSecondWord;}//getSecondWord()

    /**
     * Return true if the command has a second word.
     * @return aSecondWord the second word we entered
     */
    public boolean hasSecondWord()

    {
        return this.aSecondWord!=null;
    }//hasSecondWord()

    /**
     * Return true if this command was not understood.
     * @return aCommandWord the command we entered
     */
    public boolean isUnknown()
    {
        return this.aCommandWord==null;
    }//isUnknown()

} // Command
