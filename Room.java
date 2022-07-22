import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Room
{

    // ### Attributs ###
    private String aDescription;
    private HashMap<String,Room> aExits;
    private String aImageName;
    private ItemList aItemList;
    private HashMap<String,Door> aDoorHMP;

    /**
     * Crée une pièce décrite par la chaine "description".
     * Au départ, il n'existe aucune sortie.
     * "description" est une chaine comme "cuisine" ou
     * "une cour de jardin".
     * @param pDescription the description of the room
     * @param pImage pImage the picture of the room
     */
    // ### Constructeurs ###

    public Room(final String pDescription, final String pImage)
    {
        this.aDescription= pDescription;
        this.aExits=new HashMap<String,Room>();
        this.aImageName = pImage;
        this.aItemList= new ItemList();
        this.aDoorHMP=new HashMap <String, Door>();
    }//Room(.)

    /**
     * Renvoie la description de la pièce 
     * (telle que définie par le constructeur).
     * @return aDescription
     */
    // ### Accesseurs ###

    public String getDescription() {return this.aDescription;}//getDescription()

    /**
     * Définit les sorties de cette pièce.
     * @param pDirection La direction de la sortie.
     * @param pNeighbor La salle dans la direction donnée.
     */    
    public void setExits(String pDirection, Room pNeighbor)
    {
        this.aExits.put(pDirection,pNeighbor);
    }//setExits(.)

    /**
     * Renvoie une description des sorties de la
     * pièce, par exemple, "Exits : North West".
     * @return Une description des sorties possibles
     * @param pDirection the direction of the exits
     */
    public Room getExitsRoom(final String pDirection)
    {
        return this.aExits.get(pDirection);
    }//getExitsRoom(.)

    /**
     * Renvoie une description des sorties de la
     * pièce, par exemple, "Exits : North West".
     * @return Une description des sorties possibles
     */

    public String getExitString()
    {
        StringBuilder vReturnString = new StringBuilder("Exits: ");
        for(String vS : this.aExits.keySet())
        {vReturnString.append(" "+vS);}
        return vReturnString.toString();
    }//getExitString()

    /**
     * print the description of the room
     * @return the description of the room and exits
     */
    public String getLongDescription()
    {
        return "You are "+this.aDescription+".\n"+getExitString()+".\n"+"There is"+this.aItemList.getItemListDescription();
    }//getLongDescription()

    /**
     * Return a string describing the room's image name
     * @return aImageName
     */
    public String getImageName()
    {
        return this.aImageName;
    }//getImageName()

    /**
     * return the inventory
     * @return aItemList()
     */
    public ItemList getItemList()
    {
        return this.aItemList;
    }//getItemList()

    /**
     * return the direction of the door
     * @return aDoorHMP.get(Direction)
     * @param pDirection direction of the door
     */
    public Door getDoor(final String pDirection)
    {
        return this.aDoorHMP.get(pDirection);
    }//getDoor(.)

    /**
     * add a door who could be trapped or locked
     * @param pDirection the direction of the door
     * @param pDoor the door we had in the room
     */
    public void addDoor(final String pDirection, final Door pDoor)
    {
        this.aDoorHMP.put(pDirection, pDoor);
    }//adDoor(.)

} // Room
