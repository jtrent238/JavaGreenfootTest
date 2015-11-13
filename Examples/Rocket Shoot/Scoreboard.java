import greenfoot.*;
import java.awt.*;
public class Scoreboard extends Actor
{
    private int score;
    private String text;
    public Scoreboard(String label, int startValue)
    {
        score = startValue;
        text = label;
        GreenfootImage img = new GreenfootImage(200,25);
        img.setColor(Color.RED);
        img.setFont( new Font("Chiller",Font.BOLD,32) );
        img.drawString(text + ": " + score,5,20);
        setImage(img);
    }
    public void changeScore(int howMuch)
    {
        score = score + howMuch;
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text + ": " + score,5,20);
    }
    public int getScore()
    {
        return score;
    }
}