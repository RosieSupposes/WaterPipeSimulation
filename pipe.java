/**
 * Pipe class. This is the template we create all the pipes we place on the grid from, and 
 * assigns them all their variables. This class also contains all of the flow code to 
 * simulate water flowing through pipes. 
 */
public class pipe {
    private int x;
    private int y;
    private final int MAX_CONNECTIONS = 4;
    private pipe[] next = new pipe[MAX_CONNECTIONS]; //the four directions a pipe can face, and so the max connections the pipe can have
    private int orientation;
    private int pipeType;
    private boolean north = false;
    private boolean south = false;
    private boolean east = false;
    private boolean west = false;
    private boolean water = false;
    private String filename;
    private String filenameWater;
    private int id;
    /**
     * The constructor class that we create the pipe objects from. We use if else statements
     * to set the filenames and directions the pipe faces, based off the pipetype and orientation of the pipe
     * which we set in either the actionlistener or mouselistener in the main class. Also adds pipes
     * to an array (the grid).
     */
    public pipe (int x, int y, int orientation, int pipeType, int id){
        this.x = x; //this is the x position of the pipe object
        this.y = y; //this is the y position of the pipe object
        this.orientation = orientation; //the "orientation" of the pipe object or the rotation of the pipe
        this.pipeType = pipeType; // what type of pipe it is, straight, curved, source, sink or junctions
        this.id = id; //the specific pipe in the array. A unique number to compare to other objects in array
        if(this.pipeType == 0){
            if(orientation == 1){
                this.north = true;
                this.south = true;
                this.filename = "Vertical Straight Pipe.png";
                this.filenameWater = "Vertical Straight Pipe with Water.png";
            }else{
                this.east = true;
                this.west = true;
                this.filename = "Horizontal Straight Pipe.png";
                this.filenameWater = "Horizontal Straight Pipe with Water.png";
            }
        }
        if(this.pipeType == 1){
            if(orientation == 0){
                this.north = true;
                this.west = true;
                this.filename = "Top Left Curve Pipe.png";
                this.filenameWater = "Top Left Curve Pipe with Water.png";
            }
            if(orientation == 1){
                this.north = true;
                this.east = true;
                this.filename = "Top Right Curve Pipe.png";
                this.filenameWater = "Top Right Curve Pipe with Water.png";
            }
            if(orientation == 2){
                this.south = true;
                this.east = true;
                this.filename = "Bottom Right Curve Pipe.png";
                this.filenameWater = "Bottom Right Curve Pipe with Water.png";
            }
            if(orientation == 3){
                this.south = true;
                this.west = true;
                this.filename = "Bottom Left Curve Pipe.png";
                this.filenameWater = "Bottom Left Curve Pipe with Water.png";
            }
        }
        if(this.pipeType == 2){
            if(orientation == 0){
                this.north = true;
                this.filename = "Top Water Sink.png";
                this.filenameWater = "Top Water Sink with Water.png";
            }
            if(orientation == 1){
                this.east = true;
                this.filename = "Right Water Sink.png";
                this.filenameWater = "Right Water Sink with Water.png";
            }
            if(orientation == 2){
                this.south = true;
                this.filename = "Bottom Water Sink.png";
                this.filenameWater = "Bottom Water Sink with Water.png";
            }
            if(orientation == 3){
                this.west = true;
                this.filename = "Left Water Sink.png";
                this.filenameWater = "Left Water Sink with Water.png";
            }
        }
        if(this.pipeType == 3){
            if(orientation == 0){
                this.north = true;
                this.filename = "Top Water Source.png";
                this.filenameWater = "Top Water Source.png";
            }
            if(orientation == 1){
                this.east = true;
                this.filename = "Right Water Source.png";
                this.filenameWater = "Right Water Source.png";
            }
            if(orientation == 2){
                this.south = true;
                this.filename = "Bottom Water Source.png";
                this.filenameWater = "Bottom Water Source.png";
            }
            if(orientation == 3){
                this.west = true;
                this.filename = "Left Water Source.png";
                this.filenameWater = "Left Water Source.png";
            }
        }
        if(this.pipeType == 4){
            if(this.orientation==0){
                this.west=true;
                this.north=true;
                this.east=true;
                this.filename="Threeway North.png";
                this.filenameWater="Threeway North with water.png";
            }
            if(this.orientation==1){
                this.north=true;
                this.east=true;
                this.south=true;
                this.filename="Threeway East.png";
                this.filenameWater="Threeway East with water.png";
            }
            if(this.orientation==2){
                this.east=true;
                this.south=true;
                this.west=true;
                this.filename="Threeway South.png";
                this.filenameWater="Threeway South with water.png";
            }
            if(this.orientation==3){
                this.south=true;
                this.west=true;
                this.north=true;
                this.filename="Threeway West.png";
                this.filenameWater="Threeway West with water.png";
            }
        }
        if(this.pipeType==5){
            this.north=true;
            this.south=true;
            this.west=true;
            this.east=true;
            this.filename="Four Way Pipe.png";
            this.filenameWater="Four Way with water.png";
        }
    }
    /**
     * returns x coordinate of pipe
     */
    public int getX(){
        return(this.x);
    }
    /**
     * returns y coordinate of pipe
     */
    public int getY(){
        return(this.y);
    }
    /**
     * returns whether or not the pipe faces north
     */
    public boolean getNorth(){
        return(this.north);
    }
    /**
     * returns whether or not the pipe faces south
     */
    public boolean getSouth(){
        return(this.south);
    }
    /**
     * returns whether or not the pipe faces east
     */
    public boolean getEast(){
        return(this.east);
    }
    /**
     * returns whether or not the pipe faces west
     */
    public boolean getWest(){
        return(this.west);
    }
    /**
     * returns the id of the pipe
     */
    public int getID(){
        return(id);
    }
    /**
     * this returns the x grid position of the pipe. Where the grid starts at (25,50) and has 25 pixel squares.
     */
    public int getTX(){
        return((this.x-25)/25);
    }
    /**
     * this returns the y grid position of the pipe. Where the grid starts at (25,50) and has 25 pixel squares.
     */
    public int getTY(){
        return((this.y-50)/25);
    }
    /**
     * returns pipeType of the pipe
     */
    public int getPipeType(){
        return(this.pipeType);
    }

    /**
     * This checks whether the space in the "next" array is empty or not before putting the "link" pipe into the array.
     * Then breaks to avoid the same pipe being put in the array again. 
     */
     public void link(pipe link){
        for(int i = 0;i<MAX_CONNECTIONS;i++){
            if(next[i] ==null){
                next[i]=link;
                break;
            }
        }
    }
    /**
     * Resets the array every time a pipe is created because the links between the pipes may have changed 
     * with the placing of a new pipe and so the "next" array needs to be reset (pipes need to recreate their links).
     */
    public void reset(){
        for(int i = 0; i<MAX_CONNECTIONS; i++){
            next[i] = null;
        }
    }
    /**
     * Gets next pipe in array. 
     */
    public pipe getNext(int i){
        return(this.next[i]);
    }
    /**
     * checks if water = true, and if it does returns the water version of the filename. Meaning the pipe will
     * be drawn full of water instead. If water does not equal true, it returns the normal version of the pipe
     * image. (filename refers to the png images drawn on the grid). This is used to check which image should go
     * into the "image" array in the main class. 
     */
    public String getImage(){
        if(this.water){
            return(this.filenameWater);
        }else{
            return(this.filename);
        }
    }
    /**
     * returns water status of the a pipe. 
     */
    public boolean getWater(){
        return(water);
    }
    /**
     * sets whether the component has water in it or not.
     */
    public void setWater(Boolean water){
        this.water = water;
    }
    /**
     * runs all the code related to simulating flow. It is run through this method because the rest
     * of the flow code is private and to run the flow simulation through the Main class it needs to
     * be public. So this public method runs the private methods in this class. 
     */
    public void startFlow(pipe back){
        water(back);
    }
    /**
     * sets the pipe in the array to have water in it (using .setWater(true)) and then sets the next pipe 
     * it's linked to, as the "back" pipe and runs the water code on the back pipe again. It repeats this 
     * until there are no pipes next (linked to it) in the array. 
     */
    private void water(pipe back){
        Main.position[this.getTX()][this.getTY()].setWater(true); // sets water to true
        pipe nextOne = this.flow(back); 
        if(nextOne != null){
            back = this; 
            nextOne.water(back);
        }
    }
    /**
     * This is code to simulate flow. It checks the four directions the pipe could be connected to and then
     * if there are any pipes conneced to the pipe in those directions the code checks the four directions
     * of that pipe and whether or not they have water in them and then checks it doesn't loop back on itself
     * by comparing the ids of the  next pipe (nextOne) and the back pipe (back) to make sure they aren't the same
     * pipe. Then it checks if it's a junction and sets it be water. 
     */
    private pipe flow(pipe back){
        for(int i=0;i<MAX_CONNECTIONS;i++){
           pipe nextOne = null;
           if(this.next[i]!= null){
               nextOne = this.next[i];
           }
           for(int k=0; k<MAX_CONNECTIONS;k++){
               if(nextOne!=null&& !Main.position[nextOne.getTX()][nextOne.getTY()].getWater()){
                   if(nextOne.getNext(k)!=null&&nextOne.getID()!=back.getID()){
                       if(this.id==nextOne.getNext(k).getID()){
                           if(this.pipeType==4){
                               nextOne.water(this);
                           }else if(this.pipeType==5){
                               nextOne.water(this);
                           }else{
                               return(nextOne);
                           }
                       }
                   }
               }
           }
        }
        return (null);
    }
}
