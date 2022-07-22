import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Double;
import java.util.HashMap;

public class GameEngine
{
    private Parser                      aParser;
    private UserInterface               aGui;
    private Player                      aPlayer;
    private Room                        aChargedRoom;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.createRooms();
    }//GameEngine()

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println( "I'm Lili, a teenager. My life is simple." );
        this.aGui.println("I just finished school now, i should go home. My home is in the south.");
        this.aGui.println( "Type 'help' if you need help." );
        this.aGui.print( "\n" );
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
    }//printWelcome()

    /**
     * Create all the rooms and link their exits together. Create also items and key rooms.
     */
    private void createRooms()
    {
        // create the rooms
        Room vOutside=new Room("outside the main entrance of the highschool","highschool.jpg");
        Room vStreet=new Room("in the street","street.jpg");
        Room vSpawnForest=new Room("in the middle of a forest...","spawnforest.jpg");
        Room vMiddleForest=new Room("in the middle of a forest...","middleforest.jpg");
        Room vMiddleForest2=new Room("in the middle of a forest...","middleforest2.jpg");
        Room vTransitionForest=new Room("in the middle of a forest...","transitionforest.jpg");
        Room vRuinsForest=new Room("in the middle of a forest...","finalforest.jpg");
        Room vBedRoom1=new Room("in a bedroom","bedroom1.jpg");
        Room vBedRoom2=new Room("in a bedroom","bedroom2.jpg");
        Room vLibraryRoom=new Room("in a library","library.jpg");
        Room vTrainingRoom=new Room("in a training room","trainingroom.jpg");
        Room vCorridorBedRooms=new Room("in a corridor","corridorbedrooms.jpg");
        Room vCorridorTransition=new Room("in a corridor","corridortransition.jpg");
        Room vCorridorLittle=new Room("in a corridor", "corridorlittle.jpg");
        Room vCorridorExit=new Room("in a corridor","corridorexit.jpg");
        Room vCafeteria=new Room("in a cafeteria","cafeteria.jpg");
        Room vMainHall=new Room(" in a giant room","mainhall.jpg");
        Room vTortureRoom=new Room("in a dark room...", "tortureroom.jpg");
        Room vLab=new Room("in a lab","laboratory.jpg");
        Room vHospital=new Room("in a hospital","hospital.jpg");
        Room vArmory=new Room("in the armory","armory.jpg");
        Room vControlRoom=new Room("in the control room","controlroom.jpg");
        Room vExit=new Room("outside","exit.jpg");
        Room vMinefield=new Room("in front of a minefield","minefield.jpg");
        Room vEnd=new Room("escaping","end.jpg");

        // initialise room exits
        vOutside.setExits("North",vStreet);
        vStreet.setExits("South",vOutside);

        vStreet.setExits("North",vSpawnForest);

        vSpawnForest.setExits("East",vMiddleForest);
        vMiddleForest.setExits("West",vSpawnForest);
        vMiddleForest.setExits("North",vMiddleForest2);
        vMiddleForest2.setExits("South",vMiddleForest);
        vMiddleForest2.setExits("East",vTransitionForest);
        vTransitionForest.setExits("West",vMiddleForest2);
        vTransitionForest.setExits("North",vRuinsForest);
        vRuinsForest.setExits("South",vTransitionForest);

        vRuinsForest.setExits("North",vBedRoom1);

        vBedRoom1.setExits("South",vCorridorBedRooms);
        vCorridorBedRooms.setExits("South",vBedRoom1);
        vCorridorBedRooms.setExits("Porte2",vTrainingRoom);
        vCorridorBedRooms.setExits("Porte3",vLibraryRoom);
        vCorridorBedRooms.setExits("Porte1",vBedRoom2);
        vBedRoom2.setExits("Porte1",vCorridorBedRooms);
        vLibraryRoom.setExits("Porte3",vCorridorBedRooms);
        vTrainingRoom.setExits("Porte2",vCorridorBedRooms);
        vCorridorBedRooms.setExits("Porte4",vCafeteria);
        vCafeteria.setExits("Porte4",vCorridorBedRooms);
        vCorridorBedRooms.setExits("East",vCorridorTransition);
        vCorridorTransition.setExits("West",vCorridorBedRooms);
        vCorridorTransition.setExits("Est",vMainHall);
        vMainHall.setExits("West",vCorridorTransition);

        vCorridorTransition.setExits("Porte",vCorridorLittle);

        vCorridorLittle.setExits("Porte1",vControlRoom);
        vControlRoom.setExits("South",vCorridorLittle);
        vCorridorLittle.setExits("Porte2",vArmory);
        vArmory.setExits("South",vCorridorLittle);
        vCorridorLittle.setExits("Porte3",vHospital);
        vHospital.setExits("South",vCorridorLittle);
        vCorridorLittle.setExits("Porte4",vLab);
        vLab.setExits("South",vCorridorLittle);
        vCorridorLittle.setExits("Porte5",vTortureRoom);
        vTortureRoom.setExits("South",vCorridorLittle);
        vCorridorLittle.setExits("Corridor",vCorridorExit);
        vCorridorExit.setExits("South",vCorridorLittle);

        vCorridorExit.setExits("Porte",vExit);

        vExit.setExits("North",vMinefield);
        vMinefield.setExits("South",vExit);
        vMinefield.setExits("North",vEnd);

        //items test
        //Item vItemTest1=new Item("Item1", 1);
        //vOutside.getItemList().addItem(vItemTest1);

        //Item vItemTest2=new Item("Item2", 50);
        //vOutside.getItemList().addItem(vItemTest2);

        //items jeu
        Item vBag= new Item("Bag", 5);
        vMiddleForest.getItemList().addItem(vBag);

        Item vPin=new Item("Pin",2);
        vBedRoom1.getItemList().addItem(vPin);

        this.aPlayer=new Player(vOutside);  // start game outside

        //spawn
        this.aPlayer.setSpawnRoom(vBedRoom1);

        //time
        this.aPlayer.setKeyRoom(vBedRoom1);

        //Rooms

        this.aPlayer.setStrenghtRoom(vTrainingRoom);
        this.aPlayer.setIntelligenceRoom(vLibraryRoom);
        this.aPlayer.setCafeteriaRoom(vCafeteria);
        this.aPlayer.setSecondBedRoom(vBedRoom2);
        //trap door
        Door vTrapDoor1= new Door(false,true,false);
        vStreet.addDoor("North",vTrapDoor1);

        //Door vTrapDoor2=new Door(false,true);
        //vRuinsForest.addDoor("North",vTrapDoor2);

        //locked door
        Door vLockedDoor1=new Door(true,false,false);
        vCorridorTransition.addDoor("Porte",vLockedDoor1);
        Door vLockedDoor2=new Door(true,false,false);
        vCorridorBedRooms.addDoor("Porte1",vLockedDoor2);

        //lost door
        Door vLostDoor=new Door(false,false,true);
        vRuinsForest.addDoor("North",vLostDoor);
        //story room

        this.aPlayer.setLabRoom(vLab);
        this.aPlayer.setControlRoom(vControlRoom);

        //final room
        this.aPlayer.setFinalRoom(vEnd);
    }//createRooms()

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param pCommandLine the command we entered
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) )
        {this.printHelp();}
        else if ( vCommandWord.equals( "go" ) )
        {this.goRoom( vCommand );}
        else if ( vCommandWord.equals( "quit" ) ) {
            if ( vCommand.hasSecondWord() )
            {this.aGui.println( "Quit what?" );}
            else
                this.endGame();}
        else if (vCommandWord.equals("back"))
        {this.aPlayer.goBack();}
        else if (vCommandWord.equals("look"))
        {this.look();}
        else if (vCommandWord.equals("eat"))
        {this.aPlayer.eat(vCommand);}
        else if (vCommandWord.equals("take"))
        {this.aPlayer.take(vCommand);}
        else if (vCommandWord.equals("drop"))
        {this.aPlayer.drop(vCommand);}
        else if (vCommandWord.equals("inventory"))
        {this.aPlayer.inventory();}
        else if (vCommandWord.equals("equip"))
        {this.aPlayer.equip(vCommand);}
        else if (vCommandWord.equals("note"))
        {this.charge();}
        else if (vCommandWord.equals("tonote"))
        {this.discharge();}
        else if (vCommandWord.equals("break"))
        {this.aPlayer.gobreak(vCommand);}
        else if (vCommandWord.equals("train"))
        {this.aPlayer.train();}
        else if (vCommandWord.equals("test"))
        {this.test(vCommand);}
    }//interpretCommand(.)

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */

    private void printHelp() 
    {
        this.aGui.println( "I'm lost. I'm alone." );
        this.aGui.println( "Your command words are: " + this.aParser.getCommandString() );
    }//printHelp()

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param pCommand the command we entered
     */
    private void goRoom( final Command pCommand ) 
    {
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Go where?" );
            return;
        }

        String vDirection = pCommand.getSecondWord();

        // Try to leave current room.
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExitsRoom( vDirection );
        Door vDoor=this.aPlayer.getCurrentRoom().getDoor(vDirection);
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );

        if (vNextRoom!=null) {
            if (vDoor!=null){
                if (vDoor.isTraped())
                {this.aGui.println("What is this strange forest?");
                    this.aGui.println("I was walking in the street and...");
                    this.aGui.println("I don't remember. I need to find my way!");
                    this.aPlayer.clearPreviousStack();
                    this.aPlayer.getItemList().clearInventory();}
                if (vDoor.isLocked())
                {HashMap vInventory=this.aPlayer.getItemList().getItemListHMP();
                    if (vInventory.containsKey("Lockpick") && this.aPlayer.getStats().getIntelligence()>=12)
                    {vDoor.setLocked(false);
                        this.aGui.println("The door is open, i should go");}
                    if (vInventory.containsKey("Lockpick") && this.aPlayer.getStats().getIntelligence()<=12)
                    {this.aGui.println("I need the knowledge to use the Lockpick");}
                    if (this.aPlayer.getStats().getStrenght()>=12)
                    {vDoor.setLocked(false);
                        this.aGui.println("I can break this door!");
                        this.aGui.println("The door is open, i should go");} 
                    else 
                    {this.aGui.println("I can't open this door... I need something to open it or more strenght...");
                        return;}}
                if (vDoor.isLost())
                {HashMap vInventory=this.aPlayer.getItemList().getItemListHMP();
                    if (vInventory.containsKey("A map and a pencil"))
                    {vDoor.setLostDoor(false);
                        this.aGui.println("With this map i can get out of here");}
                    else
                    {this.aGui.println("I need a map to get out of here!");
                        return;}}}
            this.aPlayer.setCurrentRoom(vNextRoom);
            this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
            if (this.aPlayer.getCurrentRoom()==this.aPlayer.getFinalRoom())
            {this.aGui.println("I escaped!");
                this.aGui.enable( false );}

            if(this.aPlayer.getTime() == 0)
            {this.aPlayer.setCurrentRoom(this.aPlayer.getSpawnRoom());
                this.aPlayer.setDay(this.aPlayer.getDay()+1);
                this.aGui.println("Day "+this.aPlayer.getDay());
                this.aGui.println("I feel weakened");
                if (this.aPlayer.getDay()==6)
                {this.aGui.println("I feel so wea...");
                    this.aGui.enable( false );}
            }
            else
            {this.aPlayer.setMoreTime(-4);
            }

            this.aPlayer.addPreviousRoom();
            if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            {this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );}

            if (this.aPlayer.getKeyRoom()==this.aPlayer.getCurrentRoom())
            {this.aPlayer.setTime(100);
                this.aPlayer.setKeyRoom(this.aPlayer.popPreviousRoom());
                this.aPlayer.clearPreviousStack();
                this.aGui.println("Where am i?");}

            if(this.aPlayer.getCafeteriaRoom()==this.aPlayer.getCurrentRoom())
            {this.aGui.println("I could eat here!");}
            printStory();
            if (this.aPlayer.getFood()<=0)
            {this.aGui.println("I feel so wea...");
                this.aGui.enable( false );}
            if (this.aPlayer.getFood()<=5)
            {this.aGui.println("I'm hungry, i should eat");}
            this.aPlayer.setLessFood(1);
        }
    }//goRoom(.)

    /**
     * quit the game
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }//endGame()

    /**
     * type the commands found in the text document
     * @param pName the name of the file
     */
    public void test(final Command pCommand)
    {
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "What text?" );
            return;
        }
        else {String vText = pCommand.getSecondWord();
            try{Scanner vSc=new Scanner(new File("./"+vText+".txt"));
                while(vSc.hasNextLine())
                {interpretCommand(vSc.nextLine());}
            }
            catch(final FileNotFoundException pE)
            {this.aGui.println("exception : file not found");}}
    }//test(.)

    /**
     * print the location info
     */
    public void printLocationInfo()
    {
        System.out.println(this.aPlayer.getCurrentRoom().getLongDescription());
        System.out.println(this.aPlayer.getCurrentRoom().getImageName());
        System.out.println();
    }//printLocationInfo()

    /**
     * initialize the graphical user interface
     * @param pUserInterface the user interface
     */
    public void setGui(UserInterface pUserInterface)
    {
        this.aGui=pUserInterface;
        this.aPlayer.setGui(aGui);
        this.printWelcome();
    }//setGui(.)

    /**
     * charge the beamer, note the place we are in
     */
    private void charge()
    {
        Beamer vBeamer=new Beamer("A map and a pencil",2,aChargedRoom);
        HashMap vInventory=this.aPlayer.getItemList().getItemListHMP();
        if(!vInventory.containsKey("A map and a pencil"))
        {
            this.aGui.println("I'm lost.");
        }
        else
        {
            vBeamer.Charging(this.aPlayer.getCurrentRoom());
            this.aGui.println("I will note my way from now.");
        }
    }//charge()

    /**
     * print the location info
     */
    public void look()
    {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    }//look()

    /**
     * set the current room where the beamer charged the room
     */
    private void discharge()
    {
        Beamer vBeamer=new Beamer("A map and a pencil",2,aChargedRoom);
        HashMap vInventory=this.aPlayer.getItemList().getItemListHMP();
        if(!vInventory.containsKey("A map and a pencil"))
        {
            this.aGui.println("I don't have anything to write my way down");
        }
        else
        {
            vBeamer.Discharging();
            this.aPlayer.clearPreviousStack();
            this.aPlayer.setCurrentRoom(vBeamer.getChargedRoom());
            this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
            if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            {this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
            }
        }
    }//discharge()

    /**
     * print story in key rooms
     */
    public void printStory()
    {
        if (this.aPlayer.getCurrentRoom()==this.aPlayer.getLabRoom())
        {this.aGui.println("There are blood samples. My name is on the vials.");}
        if (this.aPlayer.getCurrentRoom()==this.aPlayer.getControlRoom())
        {this.aGui.println("There are files of lots of teenagers my age");
            this.aGui.println("Some marked with a red cross other with a green cross");}
    }//printStory()
}

