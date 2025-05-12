import greenfoot.*; 

public class Weapon extends Actor
{
    Weapon(){
        setImage("Weapon.png");
    }
    public void act() 
    {
        setLocation(getX()+50, getY());
        if(getX()>=830){
            getWorld().removeObject(this);
        }
    }    
}