
/**
 * Write a description of class Dicese here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dicese
{
    // instance variables - replace the example below with your own
    private int n;
    
    public static int wins = 0;
    public static int timesPlayed = 0;
    
    private Dice dices[];

    /**
     * Constructor for objects of class Dicese
     */
    public Dicese(int n)
    {
        this.n = n;
        
        dices = new Dice[n];
        
        int size = 60;
        
        for(int i = 0; i < n; i++){
            dices[i] = new Dice(1, 10);
            dices[i].moveHorizontal(size * i);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return n + y;
    }
    
    /**
     * Reset game
     */    
    public void reset(){
        wins = 0;
        timesPlayed = 0;
    }
    
    /**
     * Play game once
     */
    public void play(){
        for(int i = 0; i < this.n; i++){
            dices[i].roll();
        }
        
        // Aumentar el número de partidas jugadas
        timesPlayed++;
    }
    
    /**
     * Play game 'n' times
     * 
     * @param The number of times the game will be played
     */
    public void play(int times){
        for(int i = 0; i < times; i++){
            // Tiramos los dados
            for(int j = 0; j < this.n; j++){
                dices[i].roll();
            }
            
            
            // Aumentar el número de partidas jugadas
            timesPlayed++;
        }
    }
    
    /**
     * Is winning state
     * @return true if is winning, false otherwides
     */
    public boolean isWinningState(){
        boolean isWin = true;
        int value = dices[0].getValue();
        
        for(int i = 0; i < this.n; i++){
            if(value != dices[i].getValue()){
                isWin = false;
            }
        }
        
        // Si gana, se aumenta el número de victorias
        if (isWin){
            wins++;
        }
        
        return isWin;
    }
    
    /**
     * Get the percentage of winning states
     */
    public int percentageOfWinningStates(){
        return 0;
    }
    
    /**
     * Make game visible 
     */
    public void makeVisible(){
    }
    
    /**
     * Make game invisible
     */
    public void makeInvisible(){
    }
    
    
    /**
     * Move game 
     * @param Horizontal units to move (int)
     * @param Vertical units to move (int)
     */
    
    
    
        
    
}
