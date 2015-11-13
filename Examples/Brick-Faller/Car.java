import greenfoot.*;

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor

{
    public int verticalSpeed;
    public int horizontalSpeed;
    public int age;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        wrapAtEdge();
        move();
        age();
    }
        public void move()
        {
        if (Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
    } 
    public void bounceAtEdge()
    {
        String edge = hitTheEdge();
        if(edge == "top" || edge == "bottom")
        {
            verticalSpeed = verticalSpeed * -1;
        } else if (edge == "left" || edge == "right")
        {
            horizontalSpeed = horizontalSpeed * -1;
        }
    }
         public String hitTheEdge()
         {
        int x = getX();
        int Y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;
        int leftSide = myWorld.getWidth() - 1;
        if(Y==0)
        {
            return "top";
        } else if (x == rightSide) {
            return "right";
        } else if (Y == bottomSide)
        {
            return "bottom";
        }else if (x ==leftSide) {
            return "left";  
        } else {
            return null;
        }
       }
         public void wrapAtEdge()
       { 
        String edge = hitTheEdge();
        int x = getX();
        int Y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;  
        int leftSide = myWorld.getWidth() - 1;
         if(edge == "left")
         {
            setLocation(600,0);
        }
       else  
         if(edge == "right")
         {
            setLocation(0,300);
         }
        }
        public void age()
          {
            age=0;
         }
        }
        


