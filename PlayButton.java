// PlayButton.java
import greenfoot.*;

public class PlayButton extends Actor {
    public PlayButton() {
        setImage("playButton.png"); // Gambar tombol play
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
