public class Stats
{
    private int aStrenght;
    private int aIntelligence;
    //private int aDexterity;

    /**
     * natural constructor for stats
     * @param pStrenght points of Strenght
     * @param pIntelligence points of Intelligence
     */
    public Stats(final int pStrenght, final int pIntelligence)
    {
        this.aStrenght=pStrenght;
        this.aIntelligence=pIntelligence;
        //this.aDexterity=4;
    }//Stats(.)

    /**
     * return the points of strenght
     * @return aStrenght
     */
    public int getStrenght()
    {
        return this.aStrenght;
    }//getStrenght()

    /**
     * return the points of intelligence
     * @return aIntelligence
     */
    public int getIntelligence()
    {
        return this.aIntelligence;
    }//getIntelligence()

    //public int getDexterity()
    //{
    //    return this.aDexterity;
    //}

    /**
     * add points of strenght
     * @param pStrenght the strenght of the player
     */
    public void setMoreStrenght(final int pStrenght)
    {
        this.aStrenght=this.aStrenght+pStrenght;
    }//setMoreStrenght(.)

    /**
     * add points of intelligence
     * @param pIntelligence the stat of intelligence
     */
    public void setMoreIntelligence(final int pIntelligence)
    {
        this.aIntelligence=this.aIntelligence+pIntelligence;
    }

    //public void setMoreDexterity(final int pDexterity)
    //{
    //    this.aDexterity=this.aDexterity+pDexterity;
    //}
}
