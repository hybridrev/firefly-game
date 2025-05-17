// AboutButton.java
import greenfoot.*;

public class AboutButton extends Actor {
    public AboutButton() {
        setImage("aboutButton.png"); // Gambar tombol about
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new AboutWorld());
        }
    }
}
