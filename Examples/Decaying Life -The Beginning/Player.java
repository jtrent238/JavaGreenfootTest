import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends pInfo
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean readEnter = true;
    private boolean isEnter = true;
    public int Ammo, checkAmmo, checkHealth, maxAmmo, maxHealth, aBox, hBox; 
    private int ySpeed;
    private int apexTimer;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    private GreenfootImage image5;
    private GreenfootImage image6;
    private GreenfootImage image7; 
    private GreenfootImage image8;
    private int timer;
    private int laserCount;
    private int levelCount;
    public static GreenfootSound bgMusic = new GreenfootSound("slayerz.wav");
    public GreenfootSound shoot = new GreenfootSound ("gunShot.wav");
   public Player()
   {
        image1 = new GreenfootImage("charStill.png");
        image2 = new GreenfootImage("charShootRight.png");
        image3 = new GreenfootImage("charShootLeft.png");
        image4 = new GreenfootImage("charMoveRight1.png");
        image5 = new GreenfootImage("charMoveLeft1.png");
        image6 = new GreenfootImage("charMoveRight2.png");
        image7 = new GreenfootImage("charMoveLeft2.png");
        image8 = new GreenfootImage("laser.png");
        Ammo = 20;
        maxAmmo  = 20;
        maxHealth = 30;
        aBox = 20;
        hBox = 10;
    }
   public void act() 
   {
       Movement();
       Shooting();
       Collecting();
       Death();
       Life();
        if(!readEnter && !Greenfoot.isKeyDown("x"))
       {
           readEnter = true;
       }   
       if(!isEnter && !Greenfoot.isKeyDown("z"))
       {
           isEnter = true;
       }  
       int scoreV = ((ScoreCounter)getWorld().getObjects(ScoreCounter.class).get(0)).getValue();
       if (scoreV/2500 > levelCount)
       {
            getWorld().addObject(new levelUp(), 550, 150);
            levelCount++;
       }
       if (scoreV/500 > laserCount)
       {
            getWorld().addObject(new Laser(),(Greenfoot.getRandomNumber(1050) + 50), 300);
            getWorld().addObject(new Laser(),(Greenfoot.getRandomNumber(1050) + 50), 300);
            laserCount++;  
       }
   }
    public void Movement()
    {
        timer++;
        if (Greenfoot.isKeyDown("right"))
        { 
            move(4);
            if (getImage() != image4 && getImage() != image6) timer = 0;
            if (timer%10 == 0)
            {
               if (timer%20 ==  0)
               {
                   setImage(image4);
               }
               else
               {
                   setImage(image6);
               }
            }        
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            move(-4);
            if (getImage() != image5 && getImage() != image7) timer =0;
            if (timer%10 == 0)
            {
                if (timer%20 == 0)
                {
                    setImage(image5);
                }
                else
                {
                    setImage(image7);
                }
            }
        }
        else
        {
            setImage(image1);
        }
        if(Greenfoot.isKeyDown("x"))
        {
            setImage(image2);
        }
        if(Greenfoot.isKeyDown("z"))
        {
            setImage(image3);
        }
        int groundLevel = getWorld().getHeight() - getImage().getHeight()/2;
        boolean onGround = (getY() == groundLevel);     
        if (!onGround)
        {
           if (ySpeed == 0 && apexTimer > 0) apexTimer--; 
           if (ySpeed == 0 && apexTimer > 0) return;
            ySpeed++; 
            setLocation(getX(), getY()+ySpeed); 
            if (getY()>=groundLevel) 
            {
                setLocation(getX(), groundLevel); 
                Greenfoot.getKey(); 
           }
        }
        else 
        {
            if ("space".equals(Greenfoot.getKey())) 
            {
                ySpeed = -15; 
                setLocation(getX(), getY()+ySpeed);
                apexTimer = 4;  
            }
        }      
   }
   public void Shooting()
    {
        if(Greenfoot.isKeyDown("x") && readEnter)
        {
              if(Ammo>0)
              {
               getWorld().addObject(new BulletR(getRotation()), getX() +45 , getY() -5);
               readEnter = false;
               Ammo--;
               shoot.play();
               shoot.setVolume(100);
                if (!getWorld().getObjects(AmmoCounter.class).isEmpty())
               {
                  ((AmmoCounter) getWorld().getObjects(AmmoCounter.class).get(0)).add(-1);
               }
              }
              else
              {
                 Greenfoot.playSound("noAmmo.mp3");
              } 
        }
        if(Greenfoot.isKeyDown("z") && isEnter)
        {
              if(Ammo>0)
              {
               getWorld().addObject(new BulletL(getRotation()), getX() -45 , getY() -5);
               isEnter = false;
               Ammo--;
               shoot.play();
               shoot.setVolume(100);
               if (!getWorld().getObjects(AmmoCounter.class).isEmpty())
               {
                  ((AmmoCounter) getWorld().getObjects(AmmoCounter.class).get(0)).add(-1);
               }
              }
              else
              {
                 Greenfoot.playSound("noAmmo.mp3");
              } 
        }
    }
   public void Collecting()
    {
        int healthV = ((HealthCounter)getWorld().getObjects(HealthCounter.class).get(0)).getValue();
        if(canSee(healthBox.class))
        {
            eat(healthBox.class);
            if (healthV >= 20)
            {
               checkHealth = maxHealth - healthV;
               healthV = healthV + checkHealth;
               if (!getWorld().getObjects(HealthCounter.class).isEmpty())
               {
                  ((HealthCounter) getWorld().getObjects(HealthCounter.class).get(0)).add(checkHealth);
               }
            }
            else
            {
                healthV = healthV + hBox;
                if (!getWorld().getObjects(HealthCounter.class).isEmpty())
                {
                  ((HealthCounter) getWorld().getObjects(HealthCounter.class).get(0)).add(10);
                }
            }
            Greenfoot.playSound("healthPickup.mp3");
        }
        if(canSee(ammoBox.class))
        {
            eat(ammoBox.class);
            if (Ammo>0)
            {
               checkAmmo = maxAmmo - Ammo;
               Ammo = Ammo + checkAmmo; 
               if (!getWorld().getObjects(AmmoCounter.class).isEmpty())
               {
                  ((AmmoCounter) getWorld().getObjects(AmmoCounter.class).get(0)).add(checkAmmo);
               }
            }
            else
            {
                Ammo = Ammo + aBox;
                if (!getWorld().getObjects(AmmoCounter.class).isEmpty())
                {
                  ((AmmoCounter) getWorld().getObjects(AmmoCounter.class).get(0)).add(20);
                }
            }
            Greenfoot.playSound("ammoPickup.mp3");
        }
        if(Ammo == 0)
        {
            if (getWorld().getObjects(ammoBox.class).size() != 1)
            {
                getWorld().addObject(new ammoBox(), (Greenfoot.getRandomNumber(1000)+ 30), 310);
            }
            else
            {
                
            }
        }
        if (healthV <= 15)
        {
            if (getWorld().getObjects(healthBox.class).size() != 1)
            {
                getWorld().addObject(new healthBox(), (Greenfoot.getRandomNumber(1000)+ 30), 310);
            }
            else
            {
                
            }
        }
        int Points = ((ScoreCounter)getWorld().getObjects(ScoreCounter.class).get(0)).getValue();
        if(canSee(Shop.class))
        {
            if(Greenfoot.isKeyDown("a"))
            {
             if(Points >= 1000)
              {              
              ((ScoreCounter) getWorld().getObjects(ScoreCounter.class).get(0)).add(-1000);  
              if (healthV >= 20)
              {
               checkHealth = maxHealth - healthV;
               healthV = healthV + checkHealth;
               if (!getWorld().getObjects(HealthCounter.class).isEmpty())
               {
                  ((HealthCounter) getWorld().getObjects(HealthCounter.class).get(0)).add(checkHealth);
               }
              }
              else
              {
                 healthV = healthV + hBox;
                if (!getWorld().getObjects(HealthCounter.class).isEmpty())
                {
                  ((HealthCounter) getWorld().getObjects(HealthCounter.class).get(0)).add(10);
                }
              }
            }
          }
        }
        if(canSee(Shop.class))
        {
            if(Greenfoot.isKeyDown("s"))
            {
             if(Points >= 1500)
              {              
              ((ScoreCounter) getWorld().getObjects(ScoreCounter.class).get(0)).add(-1500);  
              if (Ammo >= 10)
              {
               checkAmmo = maxAmmo - Ammo;
               Ammo = Ammo + checkAmmo;
               if (!getWorld().getObjects(AmmoCounter.class).isEmpty())
               {
                  ((AmmoCounter) getWorld().getObjects(AmmoCounter.class).get(0)).add(checkAmmo);
               }
              }
              else
              {
                 Ammo = Ammo + 10;
                if (!getWorld().getObjects(AmmoCounter.class).isEmpty())
                {
                  ((AmmoCounter) getWorld().getObjects(AmmoCounter.class).get(0)).add(10);
                }
              }
            }
          }
        }
    }
   public void Life()
    {
        if(canSee(Zombie1.class))
        {       
            if (!getWorld().getObjects(HealthCounter.class).isEmpty())
            {
                  ((HealthCounter) getWorld().getObjects(HealthCounter.class).get(0)).add(-1);              
            }
        }
    }
   public void Death()
    {
        int healthV = ((HealthCounter)getWorld().getObjects(HealthCounter.class).get(0)).getValue();
         if(healthV >= 1)
         {
           bgMusic.playLoop();
           bgMusic.setVolume(40);
        }
        else if (healthV <= 0)
        {
           Greenfoot.stop();
           bgMusic.stop();
        }
        if(canSee(Laser.class))
        {
            Greenfoot.stop();
            bgMusic.stop();
        }
    }   
}