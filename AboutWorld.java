// AboutWorld.java
import greenfoot.*;

public class AboutWorld extends World {
    public AboutWorld() {
        super(872, 490, 1);
        setBackground("Background.png"); // Gambar penjelasan tentang game

        // Tambahkan tombol kembali ke menu
        addObject(new BackButton(), 70, 430);
    }
}
