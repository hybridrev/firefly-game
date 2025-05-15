import greenfoot.*; 

public class EnemyWeapon extends Actor
{
    public EnemyWeapon(){
        setImage("EnemyWeapon.png");
    }

    public void act() 
    {
        // Gerak ke kiri
        setLocation(getX() - 10, getY());

        // Hapus kalau keluar layar
        if (getX() <= 0) {
            getWorld().removeObject(this);
            return;
        }

        // Cek tabrakan dengan Firefly
        if (isTouching(Firefly.class)) {
            MyWorld world = (MyWorld) getWorld();
            int currentHP = MyWorld.hp.getCurrentHealth();    // dapatkan nilai HP sekarang
                MyWorld.hp.updateHealth(currentHP - 1);           // kurangi 1 dan update health bar

            if (MyWorld.hp.getCurrentHealth() == 0) {
                Lose g = new Lose();
                getWorld().addObject(g, 420, 240);
                Greenfoot.stop();               
            }
            
            getWorld().removeObject(this);
        }
    }    
}
