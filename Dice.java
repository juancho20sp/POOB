import java.util.Random;

public class Dice{

    private Circle  circles [] = new Circle[7];
    private Rectangle r1;
    private int value;
    private boolean isVisible;

    /**
     * Create a Dice object
     */
    public Dice(){
        r1 = new Rectangle();
        r1.changeSize(200,200);
        r1.makeVisible();
        
        int iniX = 50;
        int iniY = 50;
        
        circles[0] = new Circle(iniX, iniY);
        circles[0].makeVisible();
        
        circles[1] = new Circle(3*iniX, iniY);
        circles[1].makeVisible();
        
        circles[2] = new Circle(iniX, 2*iniY);
        circles[2].makeVisible();
        
        circles[3] = new Circle(2*iniX, 2*iniY);
        circles[3].makeVisible();
        
        circles[4] = new Circle(3*iniX, 2*iniY);
        circles[4].makeVisible();
        
        circles[5] = new Circle(iniX, 3*iniY);
        circles[5].makeVisible();
        
        circles[6] = new Circle(3*iniX, 3*iniY);
        circles[6].makeVisible();
        
        //roll();
        isVisible = true;
    }
    /**
     * Returns value's attribute
     * @return returns the value of the dice
     */
    public int getValue(){
        return value;
    }

    /**
     * Throws the Dice and pass the value to value's attribute
     */
    public void roll(){
        for (int i = 0; i < value; i++) {
            circles[i].makeInvisible();
        }
        
        Random aleatorio = new Random();
        value = aleatorio.nextInt(5) + 1;
        
        int xPos = 15;
        int yPos = 15;
        
        for (int i = 0; i < value; i++){
            circles[i] = new Circle(xPos + (i*xPos), yPos + (i*yPos));
            
            xPos += 4;
            yPos += 4;
        }
    }

    /**
     * Changes Dice's color
     * @param color the color desired
     */
    public void changeColor(String colorChange){
        r1.changeColor(colorChange);
    }

    /**
     * Move Dice horizontally
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        r1.moveHorizontal(distance);
        
        for (int i = 0; i < value; i++){
            circles[i].moveHorizontal(distance);
        }
    }
    
    /**
     * Makes the Dice visible in the Screen
     */
    public void makeVisible(){
        r1.makeVisible();
        
        for (int i = 0; i < value; i++){
            circles[i].makeVisible();
        }
    }

    /**
     * Makes the Dice invisible in the Screen
     */
    public void makeInvisible(){
        r1.makeInvisible();
        
        for (int i = 0; i < value; i++){
            circles[i].makeInvisible();
        }
    }
}