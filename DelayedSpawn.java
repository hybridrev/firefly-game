import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DelayedSpawn extends Actor {
    private int delay;
    private int tipe;

    public DelayedSpawn(int delay, int tipe) {
        this.delay = delay;
        this.tipe = tipe;
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

