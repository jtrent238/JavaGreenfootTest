import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int age=0;
    /**
     * Act - do whatever the counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + age++, 24, Color.BLUE,Color.BLACK));
    }    
    public void addScore()
    {
       
        
    }
}
