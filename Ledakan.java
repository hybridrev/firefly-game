import greenfoot.*; 

/**
 Firefly suka ayam
 */
public class Ledakan extends Actor
{
    Ledakan()
    {
        setImage("Ledakan.png");
    }    
    int hitung=0;
    public void act() 
    {
        hitung++;
        if(hitung==15){
           getWorld().removeObject(this);
        }
    }    
}
