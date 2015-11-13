import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround extends World
{
    /**
     * Constructor for objects of class BackGround.
     * 
     */
    private int zombieSpawnTimer;   
    private int levelCount;
    public BackGround()
    {    
        super(1100, 350, 1);         
        addObject(new healthBox(), (Greenfoot.getRandomNumber(1050)+ 30), 310);
        addObject(new ammoBox(), (Greenfoot.getRandomNumber(1050)+ 30), 310);
        addObject(new Shop(), 550, 305);
        addObject(new ShopHUD(), 550, 220);
        addObject(new Player(), 250, 295);
        addObject(new ScoreCounter(), 1030, 15);
        addObject(new AmmoCounter(), 80, 15);
        addObject(new HealthCounter(), 220, 15);
        addObject(new KillsCounter(), 550, 15);
     }
        public void act()
    {
        runZombieSpawnTimer();
    }
              private void runZombieSpawnTimer()
    {
        zombieSpawnTimer = (zombieSpawnTimer+1)%105;
        if (zombieSpawnTimer == 0)
        {
            spawnZombie();
        }
    }
    private void spawnZombie()
    {    
        int scoreV = ((ScoreCounter)getObjects(ScoreCounter.class).get(0)).getValue();
        if (getObjects(Zombie1.class).size() != 30)
        {
            addObject(new Zombie1(), (Greenfoot.getRandomNumber(1020) + 880), 295);
            addObject(new Zombie1(), (Greenfoot.getRandomNumber(1020) + 880), 295);
            addObject(new Zombie1(), (Greenfoot.getRandomNumber(1020) + 880), 295);
            addObject(new Zombie1(), (Greenfoot.getRandomNumber(100) + 25), 295);
            addObject(new Zombie1(), (Greenfoot.getRandomNumber(100) + 25), 295);
            addObject(new Zombie1(), (Greenfoot.getRandomNumber(100) + 25), 295);
             if(scoreV/2500 > levelCount)
              {
                  addObject(new Zombie1(), (Greenfoot.getRandomNumber(1020) + 880), 295);
                  addObject(new Zombie1(), (Greenfoot.getRandomNumber(100) + 25), 295);
                  levelCount++;
              }
       }
   }
}