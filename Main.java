import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * The Main class in which the program is run from. 
 * Molly Henry
 * Version Six - Added keyboard shortcuts for the ease of the user (based on feedback from user testing). 
 */
public class Main extends JFrame implements ActionListener, MouseListener
{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    public String fileName = "absolutely nothing"; // file name of the images of the pipes
    
    public static int mousex;
    public static int mousey;
    public static ArrayList<pipe> pipes = new ArrayList<>();
    public static ArrayList<ImageIcon> Images = new ArrayList<>();
    public static int orientation = 10; // the orientation or rotation position of a pipe, used to set aspects of pipe
    public static int pipeType = 10; // the type of pipe, used to set aspects
    public static int IDS = 0; //unique ID of pipe to compare it to others in the array
    public static pipe[][] position = new pipe[22][23]; // array that the pipes are placed in. 22 and 23 represent the height and width of the grid
    public static boolean delete = false; //delete boolean to determine whether or not to delete a pipe
    public Main() {
        setTitle("Water Simulator");//title of window
        this.getContentPane().setPreferredSize(new Dimension(1200, 600));//size of window
        
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        menu = new JMenu("Options");//tab dropdown on the menu bar
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Delete Pipe");//option on the dropdown tab
        menuItem.setAccelerator(KeyStroke.getKeyStroke("DELETE")); //keyboard shortcut
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Quit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('q'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu = new JMenu("Straight Pipes");
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Vertical");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('v'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Horizontal");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('h'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu = new JMenu("Curved Pipes");
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Top Left");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('1'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Top Right");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('2'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Bottom Right");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('3'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Bottom Left");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('4'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu = new JMenu("Sinks and Sources");
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Right Source");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('l'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Bottom Source");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('k'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Left Source");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('j'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Top Source");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('i'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Top Sink");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('w'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Bottom Sink");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('s'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Right Sink");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('d'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Left Sink");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('a'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu = new JMenu("Junctions");
        menuBar.add(menu);
        
        menuItem = new JMenuItem("Top Threeway Pipe");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('5'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Right Threeway Pipe");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('6'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Bottom Threeway Pipe");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('7'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Left Threeway Pipe");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('8'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Fourway Pipe");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('x'));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        //paints window, creates panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1200,600));
        Canvas myGraphic = new Canvas();
        panel.add(myGraphic);
        
        addMouseListener(this); //mouse listener
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.pack();
        this.toFront();
        this.setVisible(true);
    }
    /**
     * Action listener, registers user pressing keys, and changes to variables that match a type of pipe 
     * (corresponding to the key pressed). It sets the filename of the image, the orientation and pipeType 
     * (for the pipe class to then set the other aspects corresponding to those) and repaints the the 
     * interface to update the colour of the buttons. Also it sets delete to true/false. And there is quit shortcut. 
     */
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd){
            case "Quit" :
                System.exit(0);
            break;
            case "Delete Pipe" :
                delete = true;
                repaint();
            break;
            case "Vertical" :
                pipeType=0;
                orientation=1;
                fileName = "Vertical Straight Pipe.png";
                delete = false;
                repaint();
            break;
            case "Horizontal" :
                pipeType=0;
                orientation=2;
                fileName = "Horizontal Straight Pipe.png";
                delete = false;
                repaint();
            break;
            case "Top Left" :
                pipeType=1;
                orientation=0;
                fileName = "Top Left Curve Pipe.png";
                delete = false;
                repaint();
            break;
            case "Top Right" :
                pipeType = 1;
                orientation = 1;
                fileName = "Top Right Curve Pipe.png";
                delete = false;
                repaint();
            break;
            case "Bottom Left" :
                pipeType=1;
                orientation=3;
                fileName = "Bottom Left Curve Pipe.png";
                delete = false;
                repaint();
            break;
            case "Bottom Right" :
                pipeType=1;
                orientation=2;
                fileName = "Bottom Right Curve Pipe.png";
                delete = false;
                repaint();
            break;
            case "Top Sink" :
                orientation = 0;
                pipeType=2;
                fileName = "Top Water Sink.png";
                delete = false;
                repaint();
            break;
            case "Bottom Sink" :
                orientation = 2;
                pipeType=2;
                fileName = "Bottom Water Sink.png";
                delete = false;
                repaint();
            break;
            case "Right Sink" :
                orientation = 1;
                pipeType=2;
                fileName = "Right Water Sink.png";
                delete = false;
                repaint();
            break;
            case "Left Sink" :
                orientation = 3;
                pipeType=2;
                fileName = "Left Water Sink.png";
                delete = false;
                repaint();
            break;
            case "Left Source" :
                orientation = 3;
                pipeType=3;
                fileName = "Left Water Source.png";
                delete = false;
                repaint();
            break;
            case "Right Source" :
                orientation = 1;
                pipeType=3;
                fileName = "Right Water Source.png";
                delete = false;
                repaint();
            break;
            case "Top Source" :
                orientation = 0;
                pipeType=3;
                fileName = "Top Water Source.png";
                delete = false;
                repaint();
            break;
            case "Bottom Source" :
                orientation = 2;
                pipeType=3;
                fileName = "Bottom Water Source.png";
                delete = false;
                repaint();
            break;
            case "Right Threeway Pipe" :
                pipeType=4;
                orientation=1;
                fileName="Threeway East.png";
                delete = false;
                repaint();
            break;
            case "Top Threeway Pipe" :
                pipeType=4;
                orientation=0;
                fileName="Threeway North.png";
                delete = false;
                repaint();
            break;
            case "Bottom Threeway Pipe" :
                pipeType=4;
                orientation=2;
                fileName="Threeway South.png";
                delete = false;
                repaint();
            break;
            case "Left Threeway Pipe" :
                pipeType=4;
                orientation=3;
                fileName="Threeway West.png";
                delete = false;
                repaint();
            break;
            case "Fourway Pipe" :
                pipeType = 5;
                fileName = "Four Way Pipe.png";
                delete = false;
                repaint();
            break;
            default:
                //
            break;
        }
    }
    /**
     * mouse listeners, that we aren't using. 
     */
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    /**
     * mouse listener for registering when the mouse button is released (very similar to 
     * being clicked). We use this for the buttons, where we use if statements to say if you 
     * click in a specific area (indicated visually with the paint function), then you set 
     * which pipe you are going to place, similar to the actionPerformed class. This is 
     * also where we tell the program to create a pipe. If you click within an area (the grid)
     * then you paint a pipe there, and run several more methods to add the pipe to the array
     * and check that what it is linked to and whether there is water running into it.
     */
    public void mouseReleased(MouseEvent e){
        //coordinates of where mouse was released
        mousex=e.getX();
        mousey=e.getY();
        //rounded coordinates so that the pipes could be printed inline on a grid
        int roundedMouseX = (mousex/25)*25;
        int roundedMouseY = (mousey/25)*25;
        //button to set delete to true, so you can remove pipes
        if(mousex>=1000&&mousex<=1200&&mousey>=50&&mousey<=250){
            delete=true;
            repaint();
        }
        //all the buttons to set the pipe types
        if(mousex>=615&&mousex<=784&&mousey>=278&&mousey<=355){
            pipeType=0;
            orientation=2;
            fileName = "Horizontal Straight Pipe.png";
            delete=false;
        }
        if(mousex>=615&&mousex<=784&&mousey>=365&&mousey<=440){
            pipeType=0;
            orientation=1;
            fileName = "Vertical Straight Pipe.png";
            delete=false;
        }
        
        if(mousex>=815&&mousex<=891&&mousey>=278&&mousey<=354){
            pipeType=1;
            orientation=0;
            fileName = "Top Left Curve Pipe.png";
            delete=false;
        }
        if(mousex>=815&&mousex<=891&&mousey>=365&&mousey<=440){
            pipeType=1;
            orientation = 3;
            fileName = "Bottom Left Curve Pipe.png";
            delete=false;
        }
        if(mousex>=907&&mousex<=984&&mousey>=277&&mousey<=354){
            pipeType=1;
            orientation=1;
            fileName = "Top Right Curve Pipe.png";
            delete=false;
        }
        if(mousex>=907&&mousex<=985&&mousey>=364&&mousey<=441){
            pipeType=1;
            orientation=2;
            fileName = "Bottom Right Curve Pipe.png";
            delete=false;
        }
        
        if(mousex>=1015&&mousex<=1090&&mousey>=280&&mousey<=355){
            orientation = 1;
            pipeType=2;
            fileName = "Right Water Sink.png";
            delete=false;
        }
        if(mousex>=1110&&mousex<=1185&&mousey>=280&&mousey<=355){
            orientation = 2;
            pipeType=2;
            fileName = "Bottom Water Sink.png";
            delete=false;
        }
        if(mousex>=1015&&mousex<=1090&&mousey>=365&&mousey<=445){
            orientation = 0;
            pipeType=2;
            fileName = "Top Water Sink.png";
            delete=false;
        }
        if(mousex>=1110&&mousex<=1185&&mousey>=365&&mousey<=445){
            orientation = 3;
            pipeType=2;
            fileName = "Left Water Sink.png";
            delete=false;
        }
        
        if(mousex>=1015&&mousex<=1090&&mousey>=480&&mousey<=555){
            orientation = 1;
            pipeType=3;
            fileName = "Right Water Source.png";
            delete=false;
        }
        if(mousex>=1110&&mousex<=1185&&mousey>=480&&mousey<=555){
            orientation = 2;
            pipeType=3;
            fileName = "Bottom Water Source.png";
            delete=false;
        }
        if(mousex>=1015&&mousex<=1090&&mousey>=565&&mousey<=640){
            orientation = 0;
            pipeType=3;
            fileName = "Top Water Source.png";
            delete=false;
        }
        if(mousex>=1110&&mousex<=1185&&mousey>=565&&mousey<=640){
            orientation = 3;
            pipeType=3;
            fileName = "Left Water Source.png";
            delete=false;
        }
        
        if(mousex>=815&&mousex<=985&&mousey>=480&&mousey<=640){
            pipeType = 5;
            fileName = "Four Way Pipe.png";
            delete=false;
        }
        
        if(mousex>=615&&mousex<=690&&mousey>=480&&mousey<=555){
            pipeType=4;
            orientation=0;
            fileName="Threeway North.png";
            delete=false;
        }
        if(mousex>=710&&mousex<=785&&mousey>=480&&mousey<=555){
            pipeType=4;
            orientation=1;
            fileName="Threeway East.png";
            delete=false;
        }
        if(mousex>=710&&mousex<=785&&mousey>=565&&mousey<=640){
            pipeType=4;
            orientation=2;
            fileName="Threeway South.png";
            delete=false;
        }
        if(mousex>=615&&mousex<=690&&mousey>=565&&mousey<=640){
            pipeType=4;
            orientation=3;
            fileName="Threeway West.png";
            delete=false;
        }
        //paints pipe onto grid if you click within grid, you aren't deleting something and the spot is empty
        //which it checks with the "check" method. Creates pipe at the x and y positions of the grid 
        if(!delete){
            if(check(roundedMouseX,roundedMouseY)){
                createPipe(roundedMouseX, roundedMouseY);
                repaint();
            }
        }
        //to delete pipes from the grid
        //checks the whole pipe array, and if the x and y square you clicked on match a position of one of the pipes 
        //in the array (and delete is true) then you set that position to null, remove the pipe from the pipe array
        //remove the image from the image array and then runs the badWater, link, beginFlow, and repaint methods. 
        //this, in order, removes the water, sets the links, starts the water and draws the board again
        for(int i=0; i<pipes.size();i++){
            if(roundedMouseX == pipes.get(i).getX()&&roundedMouseY==pipes.get(i).getY()&& delete){
                position[pipes.get(i).getTX()][pipes.get(i).getTY()] = null;
                pipes.remove(i);
                Images.remove(i);
                badWater();
                link();
                beginFlow();
                repaint();
            }
        }
    }
    /**
     * Creates the pipe. Checks to make sure you have clicked within the bounds of the grid then runs the setWater method to 
     * set it to either have water or not. Then gives it a unique ID, and creates a pipe object from the pipe class with 
     * variables set by the location clicked and either the actionlistener or button triggered most recently. Then creates
     * an image using the getImage method in the pipe class. Then it adds that image to the image array and the pipe to the
     * pipe array. It sets the position of the of the pipe (on the grid) equal to the pipe object and then runs the badWater
     * setPipes, link, setPipes again and beginFlow methods to remove water, set arrays from both classes equal, set links
     * between the pipes, match arrays again and then run the water flow simulation. 
     */
    public void createPipe(int m,int n){
        if(m>=25 && m<575 && n>=50 && n<625) {
            setWater(); 
            IDS=IDS+1; //creates unique id
            pipe pipe = new pipe(m, n, orientation, pipeType, IDS); //creates pipe from pipe class
            ImageIcon Image = new ImageIcon(pipe.getImage()); //creates new image to, defined by getImage method in class 
            Images.add(Image); //adds image created above to array
            pipes.add(pipe); //adds pipe created above to array
            position[(pipe.getTX())][(pipe.getTY())] = pipe; //adds pipe to position array of the grid
            badWater();
            setpipes();
            link();
            setpipes();
            beginFlow();
        }
    }
    /**
     * This method runs when a pipe is created to check which other pipes that pipe is connected
     * to. For the whole pipe array, it checks if the pipe is pointing in each direction (defined
     * by compass point). And then it also checks that it's position is not right against the wall
     * (TY = 0 or 22, or TX = 21 or 0). And then it checks the position array for a pipe in the 
     * direction we were checking. If it passes all these checks then the original and the one we 
     * found in that direction are set as linked.
     */
    public void link() {
        for (pipe pipe : pipes) {
            position[pipe.getTX()][pipe.getTY()].reset();
            if (pipe.getNorth() && pipe.getTY() != 0 && position[pipe.getTX()][pipe.getTY() - 1] != null) {
                position[pipe.getTX()][pipe.getTY()].link(position[pipe.getTX()][pipe.getTY() - 1]);
            }
            if (pipe.getSouth() && pipe.getTY() != 22 && position[pipe.getTX()][pipe.getTY() + 1] != null) {
                position[pipe.getTX()][pipe.getTY()].link(position[pipe.getTX()][pipe.getTY() + 1]);
            }
            if (pipe.getEast() && pipe.getTX() != 21 && position[pipe.getTX() + 1][pipe.getTY()] != null) {
                position[pipe.getTX()][pipe.getTY()].link(position[pipe.getTX() + 1][pipe.getTY()]);
            }
            if (pipe.getWest() && pipe.getTX() != 0 && position[pipe.getTX() - 1][pipe.getTY()] != null) {
                position[pipe.getTX()][pipe.getTY()].link(position[pipe.getTX() - 1][pipe.getTY()]);
            }
        }
    }
    /**
     * This method checks the whole grid for a water source (pipeType=3) and says that the next pipe,
     * the one attached to it, should have water flowing through it. 
     * This runs after a pipe is created to check whether there should be water runnning through pipes or not. 
     * It checks the whole grid (which is 22 x 23 squares, so for k<22, l<23), and if there is pipe in that location
     * it then checks if that pipe is a source (pipeType = 3). And if it is sets "next" to be that pipe, then runs
     * startFlow in the pipe class on the "next" pipe. And then it runs setWater to set any pipes that need to have
     * water in them to show that. And then it repaints the board to visually show that. 
     */
    public void beginFlow(){
        pipe back = new pipe (0,0,0,0,0);
        for (int k=0; k<22;k++){
            for(int l=0;l<23;l++){
                if(position[k][l]!=null){
                    if(position[k][l].getPipeType()==3){
                        pipe next = position[k][l];
                        next.startFlow(back);
                        setWater();
                        repaint();
                    }
                }
            }
        }
    }
    /**
     * Removes water from pipes. Checks the whole pipe array and at every position sets the pipe there to have no water. 
     * This is so the program can run other checks after this, to make sure that water is still flowing into some pipes
     * and can set those pipes to water = true then. 
     */
    public void badWater(){
        for (pipe pipe : pipes) {
            position[pipe.getTX()][pipe.getTY()].setWater(false);
        }
        setWater();
    }
    /**
     * For the whole pipe array it sets the image array to have the image of the pipe in that position. This is because
     * after the flow code (water simulation code) is run, it updates what image is attached to pipes and so the image 
     * array needs to be updated with this information. There are two images each pipe type could be, the normal one (filename)
     * or the one full of water (filenameWater). 
     */
    public void setWater(){
        for(int i=0;i<pipes.size();i++){
            Images.set(i, new ImageIcon(position[pipes.get(i).getTX()][pipes.get(i).getTY()].getImage()));
        }
    }
    /**
     * set both arrays to be the same. Because we have two arrays and changing one does not change the other. 
     * There are two arrays in this program that relate to the pipe objects, "pipe" and position[][], and changing
     * one of them doesn't automatically change the other. So setpipes updates the pipe array to be equal to the 
     * other. 
     */
    public void setpipes(){
        for(int i=0;i<pipes.size();i++){
            pipe pipe = pipes.get(i);
            pipes.set(i,position[pipe.getTX()][pipe.getTY()]);
            pipes.get(i).link(null);
        }
    }
    /**
     * checks the whole pipe array, and checks whether "m" is equal to the pipes x coordinate and "n" is equal to the 
     * y coordinate, and whether delete equals false. If m and n are equal to the x and y coord, it returns false. 
     * This is used to check whether the position you clicked on the grid is empty and if another pipe 
     * can be created there. Otherwise returns true, meaning it checked and the spot is empty. 
     * Used in mouseReleased method, where m and n are x and y coords of where you clicked and the program is checking 
     * to see if a pipe can be drawn/created there. 
     */
    public boolean check(int m, int n){
        for (pipe pipe : pipes) {
            if (m == pipe.getX() && n == pipe.getY() && !delete) {
                return (false);
            }
        }
        return (true);
    }
    @Override
    /**
      this is the paint method. This paints the entire GUI, starting with the menu bar, and then setting
      the background to white. Then it checks for which pipe is currently selected by checking the filename
      and sets the background of that button to a light green. It also checks if delete = true to set the
      delete button to red. Using for loops it draws the grid in which we place the pipes. It also paints
      on all the images of the buttons, and then all the individual pipe objects we have created through the
      pipe class at their required x and y coordinates on the grid.
     */
    public void paint (Graphics g){
        super.paint(g); //paints menubar
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white); 
        g2d.fillRect(0,50,1300,700); // fills background of GUI
        Color selected = new Color (125,225,100); //green colour for delete button
        Color selectedTrash = new Color (225,150,150); //red colour for delete button
        //colours background of delete button red when selected
        if (delete){
            g2d.setColor(selectedTrash);
            g2d.fillRect(1000,50,200,200);
        }
        //colours background of selected button green
        if (fileName.equals( "Horizontal Straight Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(615,280,170,75);
        }
        if (fileName.equals("Vertical Straight Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(615,365,170,78);
        }
        
        if (fileName.equals("Top Left Curve Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(815,280,75,75);
        }
        if (fileName.equals("Top Right Curve Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(910,280,75,75);
        }
        if (fileName.equals("Bottom Left Curve Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(815,365,75,75);
        }
        if (fileName.equals("Bottom Right Curve Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(910,365,75,75);
        }
        
        if (fileName.equals("Bottom Water Sink.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1110,280,75,75);
        }
        if (fileName.equals("Top Water Sink.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1015,365,75,80);
        }
        if (fileName.equals("Left Water Sink.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1110,365,75,80);
        }
        if (fileName.equals("Right Water Sink.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1015,280,75,75);
        }
        
        if (fileName.equals("Right Water Source.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1015,480,75,75);
        }
        if (fileName.equals("Left Water Source.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1110,565,75,80);
        }
        if (fileName.equals("Top Water Source.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1015,565,75,80);
        }
        if (fileName.equals("Bottom Water Source.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(1110,480,75,75);
        }
        
        if (fileName.equals("Threeway East.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(710,480,75,75);
        }
        if (fileName.equals("Threeway South.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(710,565,75,80);
        }
        if (fileName.equals("Threeway North.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(615,480,75,75);
        }
        if (fileName.equals("Threeway West.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(615,565,75,80);
        }
        
        if (fileName.equals("Four Way Pipe.png") && !delete){
            g2d.setColor(selected);
            g2d.fillRect(815,480,170,165);
        }
        // makes grid
        g2d.setColor(Color.black);
        for(int i = 25;i<576;i=i+25) {
            g2d.drawLine(i, 50, i, 625);
        }
        for(int i = 50; i<626;i=i+25){
            g2d.drawLine(25, i, 575, i);
        }
        Image pipe;
        //variables of all the images for the buttons
        ImageIcon curveButton = new ImageIcon ("Curved Pipe Button.png");
        ImageIcon straightButton = new ImageIcon("Straight Pipe Button.png");
        ImageIcon sinkButton = new ImageIcon("Water Sink Button.png");
        ImageIcon sourceButton = new ImageIcon("Water Source Button.png");
        ImageIcon trashButton = new ImageIcon("trash Can.png");
        ImageIcon Header = new ImageIcon("Header.png");
        ImageIcon threewayButton = new ImageIcon("Three Way Button.png");
        ImageIcon fourwayButton = new ImageIcon("Four Way Button.png");
        //paints the pipe objects on at their x and y coordinates for the whole pipe array. 
        for(int i=0;i<pipes.size();i++) {
            pipe = Images.get(i).getImage();
            g2d.drawImage(pipe,pipes.get(i).getX(),pipes.get(i).getY(),this);
        }
        //paints button images on at specified coordinates
        trashButton.paintIcon(this,g,1000,50);
        Header.paintIcon(this,g,600,50);
        straightButton.paintIcon(this,g,600,250);
        curveButton.paintIcon(this,g,800,250);
        sinkButton.paintIcon(this,g,1000,250);
        sourceButton.paintIcon(this,g,1000,450);
        fourwayButton.paintIcon(this,g,800,450);
        threewayButton.paintIcon(this,g,600,450);
    }
}