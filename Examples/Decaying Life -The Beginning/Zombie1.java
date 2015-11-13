import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Zombie1 extends zInfo
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    /**
     * Act - do whatever the Zombie1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        image1 = new GreenfootImage("ZombieRight.png");
        image2 = new GreenfootImage("ZombieLeft.png");
    }
    public void movement()
    {
        Actor a = (Actor) getWorld().getObjects(Player.class).get(0);
         if (getX() > a.getX())
        {
            setLocation(getX()-1, getY());
            setImage(image2);          
        }
        else if (getX() < a.getX()) 
        {
            setLocation(getX()+1, getY());
            setImage(image1);
        } 
        if(canSee(Laser.class))
        {
            getWorld().removeObject(this);
        }
    }
}
