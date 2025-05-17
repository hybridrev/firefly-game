import greenfoot.*;

public class Firefly extends Actor
{
    private int frameCounter = 0;
    private int frameDelay = 2;
    private int currentFrame = 1; // nilai 1 atau 2
    
    Firefly(){
        setImage("SpaceStation" + "_1.png");
    }
    
    private void animate() {
        frameCounter++;
        if (frameCounter >= frameDelay) {
            frameCounter = 0;
            currentFrame = (currentFrame == 1) ? 2 : 1;
            setImage("SpaceStation" + "_" + currentFrame + ".png");
        }
    }
    
    // efek terkena tembakan musuh
    public void kenaHit() {
        // Efek berkedip/animasi
        GreenfootImage img = getImage();
        img.setTransparency(150); // semi transparan
        setImage(img);

        // Tambah suara efek (opsional)
        Greenfoot.playSound("Meledak.wav"); // pastikan file "hit.wav" ada di folder sounds/

        // Timer untuk mengembalikan normal (bisa pakai delay frame)
        Greenfoot.delay(10); // pause sebentar
        img.setTransparency(255); // normal kembali
        setImage(img);
    }

    
    int hitung=0;
    boolean keyHeld = false;
    public void act()
    {
        animate();
        // mengambil data input dari mouse
        if(Greenfoot.mouseDragged(this)){
            MouseInfo m = Greenfoot.getMouseInfo();
            setLocation(getX(), getY());
        }
        // mengambil data input dari keyboard
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
