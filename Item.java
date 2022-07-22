public class Item
{
    private String aNomItem;
    private int aWeight;

    /**
     * Natural constructor that creates an item
     * @param pNomItem Name's Item
     * @param pWeight Weight of the item
     */
    public Item(final String pNomItem,final int pWeight)
    {
        this.aNomItem=pNomItem;
        this.aWeight=pWeight;
    }//Item()
    /**
     * Return the name's Item
     * @return aNomItem
     */
    public String getNomItem(){return this.aNomItem;}//getNomItem()
    /**
     * Return the weight of the item
     * @return aWeight
     */
    public int getWeight(){return this.aWeight;}//getWeight()

}
 