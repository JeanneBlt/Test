import java.util.Stack;
import java.util.HashMap;

public class Player
{
    private Room                        aCurrentRoom;
    private Stack<Room>                 aPreviousRooms;
    private ItemList                    aItemList;
    private UserInterface               aGui;
    private double                      aTime;
    private int                         aMaxWeight;
    private int                         aDay;
    private Room                        aKeyRoom;
    private Room                        aFinalRoom;
    private Room                        aSpawnRoom;
    private Stats                       aStats;
    private Room                        aStrenghtRoom;
    private Room                        aIntelligenceRoom;
    private Room                        aLabRoom;
    private Room                        aControlRoom;
    private Room                        aCafeteriaRoom;
    private int                         aFood;
    private Room                        aSecondBedRoom;

    /**
     * Constructor of Player
     * @param pCurrentRoom The room where the player is
     */
    public Player(final Room pCurrentRoom)
    {
        this.aCurrentRoom=pCurrentRoom;
        this.aPreviousRooms=new Stack();
        this.aItemList=new ItemList();
        this.aTime=Double.POSITIVE_INFINITY;
        this.aMaxWeight=15;
        this.aDay=1;
        this.aStats=new Stats(6,6);
        this.aFood=10;
    }//PLayer(.)

    /**
     * set the spawn room
     * @param pRoom The spawn room is the last part of the game
     */
    public void setSpawnRoom(final Room pRoom){this.aSpawnRoom=pRoom;}//setSpawnRoom(.)

    /**
     * set the second bed room
     * @param pRoom The second bedroom
     */
    public void setSecondBedRoom(final Room pRoom){this.aSecondBedRoom=pRoom;}//setSecondBedRoom(.)

    /**
     * set the spawn room
     * @param pRoom The room when the time system begin
     */
    public void setKeyRoom(final Room pRoom){this.aKeyRoom=pRoom;}//setKeyRoom(.)

    /**
     * set the spawn room
     * @param pRoom The final room
     */
    public void setFinalRoom(final Room pRoom){this.aFinalRoom=pRoom;}//setFinalRoom(.)

    /**
     * set the spawn room
     * @param pRoom The training room
     */
    public void setStrenghtRoom(final Room pRoom){this.aStrenghtRoom=pRoom;}//setFinalRoom(.)

    /**
     * set the library room
     * @param pRoom The library room
     */
    public void setIntelligenceRoom(final Room pRoom){this.aIntelligenceRoom=pRoom;}//setIntelligence(.)

    /**
     * set the laboratory room
     * @param pRoom The laboratory room
     */
    public void setLabRoom(final Room pRoom){this.aLabRoom=pRoom;}//setLabRoom(.)

    /**
     * set the control room
     * @param pRoom The control room
     */
    public void setControlRoom(final Room pRoom){this.aControlRoom=pRoom;}//setControlRoom(.)

    /**
     * set the cafeteria room
     * @param pRoom The cafeteria room
     */
    public void setCafeteriaRoom(final Room pRoom){this.aCafeteriaRoom=pRoom;}//setCafeteriaRoom(.)

    /**
     * Return the spawn room
     * @return aSpawnRoom
     */
    public Room getSpawnRoom(){return this.aSpawnRoom;}//getSpawnRoom()

    /**
     * Return the room when the time system begin
     * @return aKeyRoom
     */
    public Room getKeyRoom(){return this.aKeyRoom;}//getKeyRoom()

    /**
     * Return the final room
     * @return aFinalRoom
     */
    public Room getFinalRoom(){return this.aFinalRoom;}//getFinalRoom()

    /**
     * Return the library room
     * @return aIntelligenceRoom
     */
    public Room getIntelligenceRoom(){return this.aIntelligenceRoom;}//getIntelligenceRoom()

    /**
     * Return the training room
     * @return aStrenghtRoom
     */
    public Room getStrenghtRoom(){return this.aStrenghtRoom;}//getStrenghtRoom()

    /**
     * Return the lab room
     * @return aLabRoom
     */
    public Room getLabRoom(){return this.aLabRoom;}//getLabRoom()

    /**
     * Return the control room
     * @return aControlRoom
     */
    public Room getControlRoom(){return this.aControlRoom;}//getControlRoom()

    /**
     * return the second bed room
     * @return aSecondBedRoom
     */
    public Room getSecondBedRoom(){return this.aSecondBedRoom;}//getSecondBedRoom()

    /**
     * Return the cafeteria room
     * @return aCafeteriaRoom
     */
    public Room getCafeteriaRoom(){return this.aCafeteriaRoom;}//getCafeteriaRoom()

    /**
     * return stats
     * @return aStats
     */
    public Stats getStats()
    {
        return this.aStats;
    }//getStats()

    /**
     * Initialise the graphical user interface
     * @param pUserInterface The user interface
     */
    public void setGui(final UserInterface pUserInterface)
    {
        this.aGui=pUserInterface;
    }//setGui(.)

    /**
     * return the current room
     * @return aCurrentRoom
     */
    public Room getCurrentRoom(){return this.aCurrentRoom;}//getCurrentRoom()

    /**
     * set the current room
     * @param pCurrentRoom The current room
     */
    public void setCurrentRoom(final Room pCurrentRoom){this.aCurrentRoom=pCurrentRoom;}//setCurrentRoom(.)

    /**
     * set the time
     * @param pTime the time
     */
    public void setTime(final double pTime){this.aTime=pTime;}//setTime(.)

    /**
     * set the hunger bar
     * @param pFood the hunger bar
     */
    public void setFood(final int pFood){this.aFood=pFood;}//setFood(.)

    /**
     * add time
     * @param pTime point of time
     */
    public void setMoreTime(final double pTime){this.aTime=this.aTime+pTime;}//setMoreTime(.)

    /**
     * remove food's point
     * @param pFood point of food
     */
    public void setLessFood(final int pFood){this.aFood=this.aFood-pFood;}//setLessFood(.)

    /**
     * get the points of food
     * @return aFood
     */
    public int getFood(){return this.aFood;}//getFood()

    /**
     * clear the stack of room we went in
     */
    public void clearPreviousStack()
    {
        this.aPreviousRooms.clear();
    }//clearPreviousStack()

    /**
     * return the last room we went in
     * @return aPreviousRooms.pop()
     */
    public Room popPreviousRoom()
    {
        return this.aPreviousRooms.pop();
    }// popPreviousRoom()

    /**
     * add an another room to the stack of room we went in
     */
    public void addPreviousRoom()
    {
        this.aPreviousRooms.push(this.aCurrentRoom);
    }//addpreviousRoom()

    /**
     * return the list of items
     * @return aItemList
     */
    public ItemList getItemList()
    {
        return this.aItemList;
    }//getItemList()

    /**
     * return the points of time
     * @return aTime
     */
    public double getTime(){return this.aTime;}//getTime()

    /**
     * set the number of the day
     * @param pDay the day
     */
    public void setDay(final int pDay){this.aDay=pDay;}//setDay(.)

    /**
     * return the day we are in
     * @return aDay
     */
    public int getDay(){return this.aDay;}

    /**
     * takes the player into the previous Room he/she was in.
     */
    public void goBack()
    {
        if (this.aPreviousRooms.empty())
        {this.aGui.println("I can't go back");}
        else {this.aCurrentRoom=popPreviousRoom();
            this.aGui.println(this.aCurrentRoom.getLongDescription() );
            if (this.aCurrentRoom.getImageName() != null)
            {this.aGui.showImage(this.aCurrentRoom.getImageName() );
                if (this.aFood<=0)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
                if (this.aFood<=5)
                {this.aGui.println("I'm hungry, i should eat");}
                setLessFood(1);
                if(this.aTime <= 0)
                {setCurrentRoom(getSpawnRoom());
                    this.aDay+=1;
                    this.aGui.println("Day "+this.aDay);
                    this.aGui.println("I feel weakened");
                    passedDays();
                    if (getCurrentRoom().getImageName() != null )
                    {this.aGui.showImage(getCurrentRoom().getImageName() );}
                    if (this.aDay==6)
                    {this.aGui.println("I feel so wea...");
                        this.aGui.enable( false );}
                }
                else
                {this.setMoreTime(-4);
                }
            }}
    }//goBack()

    /**
     * allows the player to eat
     * @param pCommand the command we entered
     */
    public void eat(final Command pCommand)
    {
        if (getCurrentRoom()==getCafeteriaRoom())
        {this.aGui.println("I have eaten now and I am not hungry any more");
            setFood(20);
            if(this.aTime <= 0)
            {setCurrentRoom(getSpawnRoom());
                this.aDay+=1;
                this.aGui.println("Day "+this.aDay);
                this.aGui.println("You feel weakened");
                passedDays();
                if (getCurrentRoom().getImageName() != null )
                {this.aGui.showImage(getCurrentRoom().getImageName() );}
                if (this.aDay==6)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
            }
            else
            {this.setMoreTime(-2);
            }}

        HashMap vInventory=getItemList().getItemListHMP();
        if(vInventory.containsKey("Bread"))
        {this.aGui.println("I have eaten now and I am not hungry any more");
            setFood(20);
            if(this.aTime <= 0)
            {setCurrentRoom(getSpawnRoom());
                this.aDay+=1;
                this.aGui.println("Day "+this.aDay);
                this.aGui.println("You feel weakened");
                passedDays();
                if (getCurrentRoom().getImageName() != null )
                {this.aGui.showImage(getCurrentRoom().getImageName() );}
                if (this.aDay==6)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
            }
            else
            {this.setMoreTime(-2);
            }}
        else
        {this.aGui.println("There is nothing to eat here.");}
    }//eat(.)

    /**
     * allows the player to take an item
     * @param pCommand the command we entered
     */
    public void take(final Command pCommand)
    {
        String vItemName=pCommand.getSecondWord();
        Item vItem=this.aCurrentRoom.getItemList().getItem(vItemName);
        if (vItem!=null)
        {if (vItem.getWeight()<this.aMaxWeight)
            {
                if (getCurrentRoom().getItemList().getItemListHMP().containsKey("Bag"))
                {this.aGui.println("There is a notebook, a pencil and bread in the bag.");
                    this.aGui.println("I could note my path with the notebook");
                    this.aGui.println("I should equip this bag.");
                    ;}
                getItemList().addItem(vItem);
                getCurrentRoom().getItemList().removeItem(vItemName);
                this.aGui.println("Inventory:"+getItemList().getItemListDescription());
                if(this.aTime <= 0)
                {setCurrentRoom(getSpawnRoom());
                    this.aDay+=1;
                    this.aGui.println("Day "+this.aDay);
                    this.aGui.println("I feel weakened");
                    passedDays();
                    if (getCurrentRoom().getImageName() != null )
                    {this.aGui.showImage(getCurrentRoom().getImageName() );}
                    if (this.aDay==6)
                    {this.aGui.println("I feel so wea...");
                        this.aGui.enable( false );}
                }
                else
                {this.setMoreTime(-1);
                }    
            }
            else
            {this.aGui.println("This is too heavy!");}
            if (this.aFood<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aFood<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            setLessFood(1);}

        else
        {this.aGui.println("take what?");}
    }//take(.)

    /**
     * allows the player to drop an item
     * @param pCommand the command we entered
     */
    public void drop(final Command pCommand)
    {
        String vItemName=pCommand.getSecondWord();
        Item vItem=getItemList().getItemListHMP().get(vItemName);
        if (vItem!=null)
        {   getItemList().removeItem(vItem.getNomItem());
            getCurrentRoom().getItemList().addItem(vItem);
            this.aGui.println("Inventory:"+getItemList().getItemListDescription());
            if(this.aTime <= 0)
            {setCurrentRoom(getSpawnRoom());
                this.aDay+=1;
                this.aGui.println("Day "+this.aDay);
                this.aGui.println("I feel weakened");
                passedDays();
                if (getCurrentRoom().getImageName() != null )
                {this.aGui.showImage(getCurrentRoom().getImageName() );}
                if (this.aDay==6)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
            }
            else
            {this.setMoreTime(-1);
            }
            if (this.aFood<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aFood<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            setLessFood(1);
        }
        else
        {this.aGui.println("take what?");}
    }//drop(.)

    /**
     * allows the player to check his inventory
     */
    public void inventory()
    {
        this.aGui.println("Inventory:"+getItemList().getItemListDescription());
    }

    /**
     * allows the player to equip an item
     * @param pCommand the command we entered
     */
    public void equip(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() )
        {this.aGui.println( "Equip what?" );}
        else{
            String vItemName=pCommand.getSecondWord();
            Item vItem=getItemList().getItemListHMP().get(vItemName);
            if(vItem!=null){
                if (getItemList().getItemListHMP().containsKey("Bag"))
                {this.aMaxWeight=this.aMaxWeight*2;
                    this.aGui.println("I can carry more items");
                    Item vNotebook_Pencil=new Item("A map and a pencil",1);
                    Item vBread=new Item("Bread",2);
                    getItemList().addItem(vNotebook_Pencil);
                    getItemList().addItem(vBread);
                    getItemList().removeItem(vItem.getNomItem());
                    this.aGui.println("Inventory:"+getItemList().getItemListDescription());
                    if(this.aTime <= 0)
                    {setCurrentRoom(getSpawnRoom());
                        this.aDay+=1;
                        this.aGui.println("Day "+this.aDay);
                        this.aGui.println("I feel weakened");
                        passedDays();
                        if (getCurrentRoom().getImageName() != null )
                        {this.aGui.showImage(getCurrentRoom().getImageName() );}
                        if (this.aDay==6)
                        {this.aGui.println("I feel so wea...");
                            this.aGui.enable( false );}
                    }
                    else
                    {this.setMoreTime(-1);
                    }
                }
                else
                {this.aGui.println("You can't equip this item");}}
            else 
            {this.aGui.println("You don't have this item");}
            if (this.aFood<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aFood<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            setLessFood(1);}
    }//equip(.)

    /**
     * system of days that remove time more days passed
     */
    public void passedDays()
    {
        if (this.aDay==2)
        {this.aTime=80;}
        if (this.aDay==3)
        {this.aTime=60;}
        if (this.aDay==4)
        {this.aTime=40;}
        if (this.aDay==5)
        {this.aTime=30;}
    }//passedDays()

    /**
     * allows the player to break an item
     * @param pCommand the command we entered
     */
    public void gobreak(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() )
            this.aGui.println( "Break what?" );
        else{
            String vItemName=pCommand.getSecondWord();
            Item vItem=getItemList().getItemListHMP().get(vItemName);
            if(vItem!=null){
                if (getItemList().getItemListHMP().containsKey("Pin"))
                {Item vLockpick=new Item("Lockpick",2);
                    getItemList().addItem(vLockpick);
                    getItemList().removeItem(vItem.getNomItem());
                    this.aGui.println("Inventory:"+getItemList().getItemListDescription());
                    if(this.aTime == 0)
                    {setCurrentRoom(this.aSpawnRoom);
                        this.aDay+=1;
                        this.aGui.println("Day "+this.aDay);
                        this.aGui.println("I feel weakened");
                        passedDays();
                        if (getCurrentRoom().getImageName() != null )
                        {this.aGui.showImage(getCurrentRoom().getImageName() );}
                        if (this.aDay==6)
                        {this.aGui.println("I feel so wea...");
                            this.aGui.enable( false );}
                    }
                    else
                    {this.setMoreTime(-1);
                    }
                }
                else
                {this.aGui.println("You broke the item");
                    getItemList().removeItem(vItem.getNomItem());}}
            else 
            {this.aGui.println("You don't have this item");}
            if (this.aFood<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aFood<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            setLessFood(1);}
    }//goBreak(.)

    /**
     * allows the player to train and increase his stats
     */
    public void train()
    {
        if(getCurrentRoom()==getStrenghtRoom())
        {this.aStats.setMoreStrenght(2);
            this.aGui.println("I trained my strenght.");
            if(this.aTime <= 0)
            {setCurrentRoom(getSpawnRoom());
                this.aDay+=1;
                this.aGui.println("Day "+this.aDay);
                this.aGui.println("I feel weakened");
                passedDays();
                if (getCurrentRoom().getImageName() != null )
                {this.aGui.showImage(getCurrentRoom().getImageName() );}
                if (this.aDay==6)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
            }
            else
            {setMoreTime(-50);
            }
            if (this.aFood<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aFood<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            setLessFood(5);
        }
        if(getCurrentRoom()==getIntelligenceRoom())
        {this.aStats.setMoreIntelligence(2);
            this.aGui.println("I trained my intelligence.");
            if(this.aTime <= 0)
            {setCurrentRoom(getSpawnRoom());
                this.aDay+=1;
                this.aGui.println("Day "+this.aDay);
                this.aGui.println("I feel weakened");
                passedDays();
                if (getCurrentRoom().getImageName() != null )
                {this.aGui.showImage(getCurrentRoom().getImageName() );}
                if (this.aDay==6)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
            }
            else
            {this.setMoreTime(-40);
            }
            if (this.aFood<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aFood<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            setLessFood(5);}
    }//train()
}
