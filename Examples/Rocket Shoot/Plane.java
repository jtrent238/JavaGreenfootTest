import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane extends Actor
{
    /**
     * Act - do whatever the Plane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 1;
    private int counter;
    public void act() 
    {
        setLocation(getX()+speed,getY());
        if (Greenfoot.getRandomNumber(100)<100)
        {
            getWorld().addObject(new Shot2(),getX(),getY());
            getWorld().addObject(new Shot2(),getX(),getY()+75);
            getWorld().addObject(new Shot2(),getX(),getY()-75);
        }
        Actor a = getOneIntersectingObject(Shot2.class);
        Actor k = getOneIntersectingObject(Shot.class);
        Actor po = getOneIntersectingObject(Shot.class);
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
        if(po!=null)
        {
            counter = counter + 1;
            if (counter == 25)
            {
                TheWorld tommy = (TheWorld)getWorld();
                tommy.updateScoreForTankKill();
                getWorld().removeObject(this);
            }
        }
        if (Greenfoot.getRandomNumber(100)<50)
        {
            getWorld().removeObject(a);
            getWorld().removeObject(a);
            getWorld().removeObject(a);
            getWorld().removeObject(a);
            getWorld().removeObject(a);
            getWorld().removeObject(a);
        }
    }
}