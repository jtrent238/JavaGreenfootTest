import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 5;
    public void act() 
    {
        if (Greenfoot.getRandomNumber(100)<50){
            if (Greenfoot.getRandomNumber(100)<50)
            {
                setLocation(getX(),getY()+speed);
            } else {
                setLocation(getX(),getY()-speed);
            }
        }    
        if (Greenfoot.getRandomNumber(100)<10)
        {
            getWorld().addObject(new Shot2(),getX(),getY()+5);
        }
        Actor a = getOneIntersectingObject(Shot2.class);
        Actor k = getOneIntersectingObject(Shot.class);
        if(a!=null)
        {
            getWorld().removeObject(k);
        }
        if (getX()<14){ //close to left edge
            getWorld().removeObject(a);
        }    
        if (getY()>getWorld().getHeight()-14){ //close to bottom
            getWorld().removeObject(a);
        }    
        if (getY()<14){ //close to top edge
            getWorld().removeObject(a);
        }    
        if (getX()>getWorld().getWidth()-14){ //close to right
            getWorld().removeObject(a);
        }    
    }
}