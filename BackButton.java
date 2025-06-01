// BackButton.java
import greenfoot.*;

public class BackButton extends Menu {
    public BackButton() {
        setImage("backButton.png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new StartMenu());
        }
    }
}
