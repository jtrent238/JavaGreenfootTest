import greenfoot.*;

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
      /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
     setLocation(getX(), getY()+1);
     eat();
    }
    public void eat()
    {
    Actor Car;
    Car = getOneObjectAtOffset(0, 0, Car.class);
    if  (Car != null)
    {
        World world;
        world = getWorld();
        world.removeObject(Car);
        Greenfoot.stop();
    }    
     } 
  }    
