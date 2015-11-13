import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot2 extends Actor
{
    /**
     * Act - do whatever the Shot2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 5;
    private int counter;
    public void act() 
    {
        setLocation(getX()+speed,getY());
        Actor z = getOneIntersectingObject(Tank.class);
        if (z!=null)
        {
            TheWorld q = (TheWorld)getWorld();
            q.updateLives();
            counter = counter + 1;
            getWorld().removeObject(this);
            if(counter==5){
                getWorld().removeObject(z);
            }
        }
        
        if (Greenfoot.getRandomNumber(100)<3)
        {
            getWorld().removeObject(this);
        }
    }    
}
