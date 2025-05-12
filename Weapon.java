import greenfoot.*; 

public class Weapon extends Actor
{
    Weapon(){
        setImage("Weapon.png");
    }
    public void act() 
    {
        setLocation(getX(), getY()-40);
        if(getY()<=50){
            getWorld().removeObject(this);
        }
    }    
}