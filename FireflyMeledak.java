import greenfoot.*;

public class FireflyMeledak extends Actor {
    private int timer = 30; // tampil selama 20 act()

    public FireflyMeledak() {
        setImage("Meledak.png"); // gambar ledakan tunggal
    }

    public void act() {
        timer--;
        if (timer <= 0) {
            getWorld().removeObject(this); // hapus ledakan setelah waktunya habis
        }
    }
}
