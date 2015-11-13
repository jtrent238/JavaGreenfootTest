import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Actor
{
    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 5;
    public void act() 
    {
        setLocation(getX()-speed,getY());
        Actor z = getOneIntersectingObject(Enemy.class);
        if (z!=null)
        {
            getWorld().removeObject(z);
            TheWorld tommy = (TheWorld)getWorld();
            tommy.updateScoreForTankKill();
        }
        Actor k = getOneIntersectingObject(Shot2.class);
        if(k!=null)
        {
            getWorld().removeObject(k);
        }
        if (Greenfoot.getRandomNumber(100)<3)
        {
            getWorld().removeObject(this);
        }
    }
}
