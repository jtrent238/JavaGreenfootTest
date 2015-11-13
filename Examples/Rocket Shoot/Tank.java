import greenfoot.*;

public class Tank extends Actor
{
    private static final int NORTH = 270;
    private static final int SOUTH = 90;
    private static final int EAST = 0;
    private static final int WEST = 180;
    private int speed = 5;
    public void act() 
    {
        moveAround();
    }    

    public void moveAround()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-speed,getY());
            setRotation(WEST);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+speed,getY());
            setRotation(EAST);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-speed);
            setRotation(NORTH);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+speed);
            setRotation(SOUTH);
        }
        if (Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Shot(),getX(),getY()-5);
        }
        Actor a = getOneIntersectingObject(Shot.class);
        
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