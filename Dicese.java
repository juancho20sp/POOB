            
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
        private int rows;
        private int columns;
        
        public static int wins = 0;
        public static int timesPlayed = 0;
        
        private Dice dices[];
        private Dice dicesV2[][];
            
    /**
     * Constructor for objects of class Dicese version 1
     */
    public Dicese(int n)
    {
        if(n >= 2 && n < 7){
            this.n = n;
        
            dices = new Dice[n];
        
            int size = 60;
            for(int i = 0; i < n; i++){
                dices[i] = new Dice(1, 10);
                dices[i].moveHorizontal(size * i);
            }
            
        } else {
            System.out.println("La medida debe estar entre 2 y 6 (inclusivo)");
        }
    }
     
    
    /**
     * Constructor for objects of class Dicese version 2
     */
    public Dicese(int rows, int columns)
    {
        if(rows >= 2 && rows < 7 && columns >=2 && columns <7 && rows == columns){
            this.rows = rows;
            this.columns = columns;
        
            dicesV2 = new Dice[rows][columns];
        
            int size = 60;
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    dicesV2[i][j] = new Dice(1, 10);                 
                    dicesV2[i][j].moveHorizontal(size * j);
                    dicesV2[i][j].moveVertical(size * i);
                }
                
            }
            
        } else {
            System.out.println("La medida de filas y columnas debe" +
            " ser la misma " +
            "y estar entre 2 y 6");
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
     * Print result of rolling the dice
     */
    public void printResult(){
        String res = "";
        
        if (this.rows != 0 && this.columns != 0){
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    dicesV2[i][j].roll();
                    res += dicesV2[i][j].getValue();
                }
                
                res += "\n";
            }
            
            System.out.println("\n");
        } else {
            for(int i = 0; i < this.n; i++){
                dices[i].roll();
                res += dices[i].getValue();
            }
        }
        
        
        
        // Mostramos el resultado del lanzamiento
        System.out.println(res);
    }
                
    /**
     * Play game once
     */
    public void play(){ 
        // Imprimimos el resultado
        printResult();
        
        // Verificamos victoria
        boolean w = isWinningState();
        
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
                dices[j].roll();
            }
        
            // Imprimimos el resultado
            printResult();
    
            // Verificamos victoria
            boolean w = isWinningState();
    
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
        
        if(this.rows != 0 && this.columns != 0 && rows == columns){
            boolean winRow = false;
            boolean winColumn = false;
            boolean winDiag = false;
            
            int value = dicesV2[0][0].getValue();
            
            // Victoria por fila
            for(int i = 0; i < this.rows; i++){  
                boolean valid = true;
                
                for(int j = 0; j < this.columns - 1; j++){
                    if (value == dicesV2[i][j+1].getValue() - 1){
                        valid = valid && true;
                    } else {
                        valid = valid && false;
                    }
                        
                }
                
                if (valid){
                    winRow = true;
                    break;
                }
                value = dicesV2[i][0].getValue();
            }
            
            // Victoria por columna
            value = dicesV2[0][0].getValue();
            for(int i = 0; i < this.rows; i++){ 
                boolean valid = true;
                for(int j = 0; j < this.columns - 1; j++){
                    if (value == dicesV2[j+1][i].getValue() - 1){
                        valid = valid && true;
                    } else {
                        valid = valid && false;
                    }
                }
                
                if (valid){
                    winColumn = true;
                    break;
                }
                value = dicesV2[0][i].getValue();
            }
            
            // Victoria por diagonal
            value = dicesV2[0][0].getValue();            
            for(int i = 0; i < this.rows-1; i++){
                for(int j = 0; j < this.columns-1; j++){
                    if(value == dicesV2[i+1][j+1].getValue() - 1){
                        winDiag = winDiag && true;
                    } else {
                        winDiag = winDiag && false;
                    }
                }
                
            }
            
            //if(!winRow && !winColumn && !winDiag){
            //    isWin = false;
            //}
            
            System.out.println("Por fila: " + winRow);
            System.out.println("Por columna: " + winColumn);
            System.out.println("Por diagonal: " + winDiag);
            
        } else {
            int value = dices[0].getValue();
        
            for(int i = 0; i < this.n - 1; i++){
                if(value != dices[i + 1].getValue() - 1){
                    isWin = false;
                }
                
                value = dices[i+1].getValue();
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
    public float percentageOfWinningStates(){
        System.out.println("Total partidas: " + timesPlayed);
        System.out.println("Total victorias: " + wins);
        
        float percentage = 0;
        
        if (timesPlayed > 0){
            percentage = (float)(wins * 100) / timesPlayed;
            System.out.println("Porcentaje de victorias: " + percentage + "%");
        
        }        
        
        return percentage;
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
