import greenfoot.*;

public class Firefly extends Actor
{
    Firefly(){
        setImage("Firefly.png");
    }
    int hitung=0;
    public void act()
    {
        // mengambil data input dari mouse
        if(Greenfoot.mouseDragged(this)){
            MouseInfo m = Greenfoot.getMouseInfo();
            setLocation(m.getX(), getY());
        }
        // mengambil data input dari keyboard
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 5, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 5, getY());
        }
        // peluru yang dikeluarkan
        hitung++;
        if(hitung==10){
            hitung=0;
            Weapon weapon = new Weapon(); 
            getWorld().addObject(weapon,getX(),getY());
            // suara
            Greenfoot.playSound("Proyektil.wav");
        }
    }
}
