public class Door
{
    private boolean aLocked;
    private boolean aTraped;
    private boolean aLostDoor;

    /**
     * Natural constructor of Door
     * @param pLocked if the lock is open or not
     * @param pTraped if the door is trap or not
     * @param pLostDoor if the door is lost or not
     */
    public Door(final boolean pLocked, final boolean pTraped, final boolean pLostDoor)
    {
        this.aLocked=pLocked;
        this.aTraped=pTraped;
        this.aLostDoor=pLostDoor;
    }//Door(.)

    /**
     * return if the lock is open or not
     * @return aLocked
     */
    public boolean isLocked()
    {
        return this.aLocked;
    }//isLocked()

    /**
     * return if the door is traped or not
     * @return aTraped
     */
    public boolean isTraped()
    {
        return this.aTraped;
    }//isTraped()

    /**
     * set if the lock is open or not
     * @param pLocked the lock open or not
     */
    public void setLocked(final boolean pLocked)
    {
        this.aLocked=pLocked;
    }//setLocked(.)

    /**
     * return if the door is lost or not
     * @return if the door is lost or not
     */
    public boolean isLost()
    {
        return this.aLostDoor;
    }//isLost()

    /**
     * set if the door is lost or not
     * @param pLostDoor the door lost or not
     */
    public void setLostDoor(final boolean pLostDoor)
    {
        this.aLostDoor=pLostDoor;
    }//setLostDoor(.)
}
