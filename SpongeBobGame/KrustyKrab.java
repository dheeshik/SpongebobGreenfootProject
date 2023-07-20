import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class KrustyKrab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KrustyKrab extends World
{
    public boolean wonGame = false;
    String ingredientsNeededMessage = "";
    Sbob sbob;
    ShoppingList shoppingList;
    /**
     * Constructor for objects of class KrustyKrab.
     * 
     */
    public KrustyKrab()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 452, 1);
        prepare();
    }
    public void dropTrap(){
        CrabTrap t = new CrabTrap();
        addObject(t,25+Greenfoot.getRandomNumber(getWidth()-50),10);
    }
    public void dropLettuce(){
        Lettuce l = new Lettuce();
        addObject(l,25+Greenfoot.getRandomNumber(getWidth()-50),10);
    }
    public void dropBun(){
        Bun b = new Bun();
        addObject(b,25+Greenfoot.getRandomNumber(getWidth()-50),10);
    }
    public void dropCheese(){
        Cheese c = new Cheese();
        addObject(c,25+Greenfoot.getRandomNumber(getWidth()-50),10);
    }
    public void dropTomato(){
        Tomato t = new Tomato();
        addObject(t,25+Greenfoot.getRandomNumber(getWidth()-50),10);
    }
    public void dropPatty(){
        Patty p = new Patty();
        addObject(p,25+Greenfoot.getRandomNumber(getWidth()-50),10);
    }
    public void act(){
        checkAllIngredients();
        
        checkWin();
        
        if (!wonGame){
            if (Greenfoot.getRandomNumber(500)==1){
                switch (Greenfoot.getRandomNumber(5)){
                    case 0:
                        dropLettuce();
                    case 1:
                        dropBun();
                    case 2:
                        dropCheese();
                    case 3:
                        dropTomato();
                    case 4:
                        dropPatty();
            }
            
            }
            if (Greenfoot.getRandomNumber(200)==1){
                dropTrap();
            }
        }
    }
    private void prepare(){
        shoppingList = new ShoppingList();
        addObject(shoppingList, 100,60);
        
        sbob = new Sbob();
        addObject(sbob, 399, 400);
    }
    private void checkWin(){
        if (ingredientsNeededMessage == ""){
            wonGame = true;
            WinScreen winscreen = new WinScreen();
            addObject(winscreen, 400, 200);
        }
    }
    private void checkAllIngredients(){
        ingredientsNeededMessage = "";
        int numBuns = Collections.frequency(sbob.ingredients, "bun");
        int numCheese = Collections.frequency(sbob.ingredients, "cheese");
        int numLettuce = Collections.frequency(sbob.ingredients, "lettuce");
        int numTomatos = Collections.frequency(sbob.ingredients, "tomato");
        int numPatties = Collections.frequency(sbob.ingredients, "patty");
        if (numBuns < 2){
            ingredientsNeededMessage += "buns, ";
        }
        if (numCheese == 0){
            ingredientsNeededMessage += "cheese, ";
        }
        if (numLettuce == 0){
            ingredientsNeededMessage += "lettuce, ";
        }
        if (numTomatos == 0){
            ingredientsNeededMessage += "tomato, ";
        }
        if (numPatties == 0){
            ingredientsNeededMessage += "patty, ";
        }
        shoppingList.text = ingredientsNeededMessage;
    }
}
