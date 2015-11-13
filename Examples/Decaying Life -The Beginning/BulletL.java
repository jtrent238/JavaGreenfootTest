import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletL extends Player
{
    /**
     * Act - do whatever the BulletL wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private int direction, speed;
    public int kills; 
    public BulletL(int dir)
    {
        direction = 0;
        speed = -5;
    }
    public void act() 
    {
     setLocation(getX() + speed, getY());
     setRotation(direction);
     move(speed);
     Damage();
    }
    public void Damage()
    {
       Actor enemy = getOneIntersectingObject(Zombie1.class);
       if(enemy != null) 
       {
              getWorld().removeObject(enemy);    
              if (!getWorld().getObjects(ScoreCounter.class).isEmpty())
              {
                  ((ScoreCounter) getWorld().getObjects(ScoreCounter.class).get(0)).add(10);
              }
              if (!getWorld().getObjects(KillsCounter.class).isEmpty())
              {
                  ((KillsCounter) getWorld().getObjects(KillsCounter.class).get(0)).add(1);              
              }
              getWorld().removeObject(this);
              kills++;
       }
               else
              {
                          if(getX() >= getWorld().getWidth() - 1)
                          getWorld().removeObject(this);
                          else if(getX() <= 1)
                          getWorld().removeObject(this);
                          else if (getY() >=getWorld().getHeight() -1)
                          getWorld().removeObject(this);
                          else if(getY() <= 1)
                          getWorld().removeObject(this);
              }
    }  
}
