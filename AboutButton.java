// AboutButton.java
import greenfoot.*;

public class AboutButton extends Menu {
    public AboutButton() {
        setImage("aboutButton.png"); // Gambar tombol about
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new AboutWorld());
        }
    }
}
