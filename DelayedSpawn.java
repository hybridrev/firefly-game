import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DelayedSpawn extends Actor {
    private int delay;
    private int tipe;

    public DelayedSpawn(int delay, int tipe) {
        this.delay = delay;
        this.tipe = tipe;
        
        GreenfootImage img = new GreenfootImage(1, 1); // ukuran 1x1 px transparan
        setImage(img);
    }

    public void act() {
        delay--;
        if (delay <= 0) {
            Enemy e;
            if (tipe == 20)
                e = new Memetic();
            else
                e = new Swarm(tipe);

            getWorld().addObject(e, 856, Greenfoot.getRandomNumber(480));
            getWorld().removeObject(this);
        }
    }
}

