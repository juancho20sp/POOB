import java.util.Random;

public class Dice{

    private Circle  circles [] = new Circle[6];
    private Rectangle r1;
    private int value;
    private boolean isVisible;

    /**
     * Create a Dice object
     */
    public Dice(){
        r1 = new Rectangle();
        r1.changeSize(40,40);
        r1.makeVisible();
        value = 1;
        isVisible = false;
    }
    /**
     * Returns value's attribute
     */
    public int getValue(){
        return value;
    }

    /**
     * Throws the Dice and pass the value to value's attribute
     */
    public void roll(){
        Random aleatorio = new Random();
        value = aleatorio.nextInt(5) + 1;
    }

    /**
     * Changes Dice's color
     * @param color the color desired
     */
    public void changeColor(String colorChange){
    }

    /**
     * Move Dice horizontally
     * @param distance the desired distance in pixels
     */
    public int moveHorizontal(int distance){
        return distance;
    }
    /**
     * Makes the Dice visible in the Screen
     */
    public void makeVisible(){
    }

    /**
     * Makes the Dice invisible in the Screen
     */
    public void makeInvisible(){

    }
}