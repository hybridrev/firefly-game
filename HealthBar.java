import greenfoot.*;

public class HealthBar extends Actor {
    private int maxHp;
    private int currentHp;

    public HealthBar(int hp) {
        this.maxHp = hp;
        this.currentHp = hp;
        updateImage();
    }

    public void update(int hp) {
        this.currentHp = hp;
        updateImage();
    }

    private void updateImage() {
        int width = 70;
        int height = 3;
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.RED);
        image.fillRect(0, 0, width, height);

        image.setColor(Color.GREEN);
        int greenWidth = (int)((double) currentHp / maxHp * width);
        image.fillRect(0, 0, greenWidth, height);

        setImage(image);
    }
}

