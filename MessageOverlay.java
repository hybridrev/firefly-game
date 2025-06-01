import greenfoot.*;

public class MessageOverlay extends Menu {
    public MessageOverlay(String message, int width, int height) {
        GreenfootImage img = new GreenfootImage(width, height);

        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", true, false, 24));
        img.drawString(message, 30, height / 2);

        setImage(img);
    }
}
