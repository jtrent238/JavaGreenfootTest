import greenfoot.*;

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World
{ 
    {
      act();
    }
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super (600, 400, 1); 
    }
    public void act()
     {
     if(Greenfoot.getRandomNumber(9) < 1)
    addObject(new Wall(), Greenfoot.getRandomNumber(getWidth()),0);  
    }
    {     
    addObject(new Car(),40,300);
    }
    {
    addObject(new Counter(),51,50);
}
}
       