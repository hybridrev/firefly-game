import greenfoot.*;

public class Firefly extends Actor
{
    Firefly(){
        setImage("SpaceStation.png");
    }
    int hitung=0;
    boolean keyHeld = false;
    public void act()
    {
        // mengambil data input dari mouse
        if(Greenfoot.mouseDragged(this)){
            MouseInfo m = Greenfoot.getMouseInfo();
            setLocation(getX(), m.getY());
        }
        // mengambil data input dari keyboard
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 5, getY()); // kiri
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 5, getY()); // kanan
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 10); // atas
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 10); // bawah
        }
        // peluru yang dikeluarkan
        if(Greenfoot.isKeyDown("space")){
            keyHeld = true;
        } else {
            keyHeld = false;
        }
        
        if (keyHeld) {
        hitung++;
            if (hitung >= 5) {
                hitung = 0;
                Weapon weapon = new Weapon(); 
                getWorld().addObject(weapon, getX(), getY());
                Greenfoot.playSound("peluru1.wav");
            }
        } else {
        hitung = 0;
        }
    }
}
