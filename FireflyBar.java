import greenfoot.*;  

public class FireflyBar extends Actor {
    private int maxHealth;
    private int currentHealth;
    private int width = 200;
    private int height = 15;

    public FireflyBar(int hp) {
        this.maxHealth = hp;
        this.currentHealth = hp;
        updateImage();
    }

    public void update(int hp) {
        this.currentHealth = hp;
        updateImage();
    }

    private void updateImage() {
        int width = 200;
        int height = 10;
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.RED);
        image.fillRect(0, 0, width, height);

        image.setColor(Color.GREEN);
        int greenWidth = (int)((double) currentHealth / maxHealth * width);
        image.fillRect(0, 0, greenWidth, height);

        setImage(image);
    }
    
    public void updateHealth(int value) {
        currentHealth = value;                   // Set nilai HP sekarang
            if (currentHealth < 0) currentHealth = 0;   // Jangan sampai negatif
        
            if (currentHealth > maxHealth) currentHealth = maxHealth; // Jangan lebih dari max
        updateImage();                           // Gambar ulang health bar sesuai nilai baru
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
    
}
