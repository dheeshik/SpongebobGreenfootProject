import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Sbob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sbob extends Actor
{
    /**
     * Act - do whatever the Sbob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    
    public ArrayList<String> ingredients = new ArrayList<String>();
    public void act()
    {
        HitTrap();
        catchIngredient();
        System.out.println(ingredients);
        
        if(Greenfoot.isKeyDown("right")){
            this.setLocation(getX()+1, getY());
        }
        
        if(Greenfoot.isKeyDown("left")){
            this.setLocation(getX()-1, getY());
        }
        
    }
    private void HitTrap(){
        Actor trap = getOneObjectAtOffset(0, 0, CrabTrap.class);
        if (trap != null){
            Greenfoot.playSound("bonk.wav");
            getWorld().removeObject(trap);
            ingredients.clear();
            
        }
    }
    private void catchIngredient(){
        Actor lettuce = getOneObjectAtOffset(0, 0, Lettuce.class);
        Actor bun = getOneObjectAtOffset(0, 0, Bun.class);
        Actor cheese = getOneObjectAtOffset(0, 0, Cheese.class);
        Actor patty = getOneObjectAtOffset(0, 0, Patty.class);
        Actor tomato = getOneObjectAtOffset(0, 0, Tomato.class);
        
        if (lettuce != null){
            getWorld().removeObject(lettuce);
            ingredients.add("lettuce");
            Greenfoot.playSound("lettuce.mp3");
        }
        if (bun != null){
            getWorld().removeObject(bun);
            ingredients.add("bun");
            Greenfoot.playSound("bread.mp3");
        }
        if (cheese != null){
            getWorld().removeObject(cheese);
            ingredients.add("cheese");
            Greenfoot.playSound("tomato.mp3");
        }
        if (patty != null){
            getWorld().removeObject(patty);
            ingredients.add("patty");
            Greenfoot.playSound("tomato.mp3");
        }
        if (tomato != null){
            getWorld().removeObject(tomato);
            ingredients.add("tomato");
            Greenfoot.playSound("tomato.mp3");
        }
    }
    
}
