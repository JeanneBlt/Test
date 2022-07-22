import java.util.HashMap;

public class ItemList
{
    private HashMap<String, Item>       aItems;

    /**
     * constructor of ItemList
     */
    public ItemList()
    {
        this.aItems=new HashMap();
    }//ItemList()

    /**
     * return the item whose name we have
     * @param pNameItem name of the item
     * @return aItem.get(pNameItem) the item whose name we have 
     */
    public Item getItem(final String pNameItem)
    {
        return this.aItems.get(pNameItem);
    }//getItem(.)

    /**
     * return the list of items
     * @return HasMap of the list of items
     */
    public HashMap<String,Item> getItemListHMP()
    {
        return this.aItems;
    }//getItemListHMP()

    /**
     * clear the inventory
     */
    public void clearInventory()
    {
        this.aItems.clear();
    }//clearInventory()

    /**
     * remove an item in the hashmap
     * @param pItem an item
     */
    public void removeItem(final String pItem)
    {
        this.aItems.remove(pItem);
    }//removeItem(.)

    /**
     * add an item in the hashmap
     * @param pItem an item
     */    
    public void addItem(final Item pItem)
    {
        this.aItems.put(pItem.getNomItem(),pItem);
    }//addItem(.)

    /**
     * show the list of items
     * @return a string of items
     */
    public String getItemListDescription()
    {
        StringBuilder vReturnString = new StringBuilder(" ");
        if (aItems.isEmpty())
        {vReturnString.append("no items.");}
        else {
            for(String vS : this.aItems.keySet())
            {vReturnString.append("   "+vS);}}
        return vReturnString.toString();
    }//getItemListDescription()

}
