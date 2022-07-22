
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    private boolean aCharge;
    private Room    aChargedRoom;

    /**
     * The Beamer constructor. (It's a natural constructor)
     * @param pName The item's name
     * @param pWeight The weight of the item
     * @param pChargedRoom The room where the beamer is charged
     */
    public Beamer(final String pName,final int pWeight, final Room pChargedRoom)
    {
        super(pName,pWeight);
        this.aCharge=false;
        this.aChargedRoom=pChargedRoom;
    }//Beamer(.)

    /**
     * Store a Room
     * @param pChargedRoom The room stored
     */
    public void Charging(final Room pChargedRoom)
    {
        this.aCharge=true;
        this.aChargedRoom=pChargedRoom;
    }//Charging(.)

    /**
     * Remove the room stored
     */
    public void Discharging()
    {
        this.aCharge=false;
    }//Discharging()

    /**
     * @return the room stored
     */
    public Room getChargedRoom()
    {
        return this.aChargedRoom;
    }//getChargedRoom()
}
