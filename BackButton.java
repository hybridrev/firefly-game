// BackButton.java
import greenfoot.*;

public class BackButton extends Actor {
    public BackButton() {
        setImage("backButton.png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new StartMenu());
        }
    }
}
