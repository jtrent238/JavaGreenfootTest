import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class leveUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelUp extends pInfo
{
    /**
     * Act - do whatever the leveUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer = 100;
    public void act() 
    {
        timer--;
        if(timer == 0)
        {
            getWorld().removeObject(this);
        }
    } 
}
