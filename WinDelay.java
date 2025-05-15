import greenfoot.*;

public class WinDelay extends Actor {
    private int timer;

    public WinDelay(int delayFrames) {
        timer = delayFrames;
        GreenfootImage img = new GreenfootImage(1, 1); // ukuran 1x1 px transparan
        setImage(img);
    }

    public void act() {
        timer--;
        if (timer <= 0) {
            getWorld().addObject(new Win(), 420, 240);
            Greenfoot.stop();
        }
    }
}
