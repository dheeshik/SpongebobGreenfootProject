import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShoppingList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShoppingList extends Actor
{
    public String text = "";
    GreenfootImage img = new GreenfootImage(200, 100);
    /**
     * Act - do whatever the ShoppingList wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ShoppingList(){
        img.drawString("<ingredients needed>", 0, 10);
        setImage(img);
    }
    public void act()
    {
        String scoreboardText = text;
        img.clear();
        img.drawString(scoreboardText, 2, 20);
        setImage(img);
    }
}
