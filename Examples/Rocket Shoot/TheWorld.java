import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheWorld extends World
{
    private Scoreboard score;
    private Scoreboard lives;
    private int y = 100;
    /**
     * Constructor for objects of class TheWorld.
     * 
     */
    public TheWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        addObject(new Tank(),getWidth()-100,getHeight()/2);
        lives = new Scoreboard("Lives",5);
        score = new Scoreboard("Score",0);
        addObject(score, 100, 680);
        addObject(lives, getWidth()-10, 680);
        int y = 175;
        for(int b=0;b<5;b++){
            int x = 100;
            addObject(new Enemy(),x,y);
            y = y + 100;
        }
    }

    public void act()
    {

    }

    public void updateScoreForTankKill()
    {
        score.changeScore(+1);
        if (score.getScore()==5){
            for(int b=0;b<10;b++){
                int x = 100;
                addObject(new Enemy(),x,y);
                y = y + 50;
            }
        }else if (score.getScore()==15){
            addObject(new Plane(),getWidth()/8,getHeight()/2);
        }else if (score.getScore()==16){
            for(int h=0;h<2;h++){
                int x = Greenfoot.getRandomNumber(100);
                addObject(new Plane(),x,y);
                y = y + 300;
            }
        }else if (score.getScore()==18){
            addObject(new Plane(),getWidth()/8,getHeight()/2-100);
            addObject(new Plane(),getWidth()/8,getHeight()/2+200);
            for(int b=0;b<5;b++){
                int x = 100;
                addObject(new Enemy(),x,y);
                y = y + 150;
            }
        }else if (score.getScore()==25)
        {
        
        }
    }

    public void updateLives()
    {
        lives.changeScore(-1);
        if (lives.getScore()==0){
            Greenfoot.stop();
        }
    }
}
