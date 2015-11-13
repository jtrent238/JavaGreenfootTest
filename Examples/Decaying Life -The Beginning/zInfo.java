import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zInfo extends Actor
{
    /**
     * Act - do whatever the zInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int health;
   public zInfo()
   {
       health = 10;
   }
   public boolean canSee(Class clss)
   {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
   }
   public void eat(Class clss)
   {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
   } 
   public boolean atWorldEdge()
   {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
   }
}    

