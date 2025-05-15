import greenfoot.*; 

public class Weapon extends Actor
{
    Weapon(){
        setImage("WeaponAk.png");
    }
    public void act() 
    {
        setLocation(getX()+60, getY());
        if(getX()>=830){
            getWorld().removeObject(this);
        }
    }    
}