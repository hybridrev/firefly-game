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
            setLocation(m.getX(), m.getY());
        }
        // mengambil data input dari keyboard
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 5, getY()); // kiri
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 5, getY()); // kanan
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 5); // atas
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 5); // bawah
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
