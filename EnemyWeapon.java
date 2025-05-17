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
            Firefly f = (Firefly) getOneIntersectingObject(Firefly.class);

            if (f != null) {
                f.kenaHit(); // efek visual
            }
            
            int currentHP = MyWorld.hp.getCurrentHealth();    // dapatkan nilai HP sekarang
                MyWorld.hp.updateHealth(currentHP - 1);           // kurangi 1 dan update health bar

            if (MyWorld.hp.getCurrentHealth() == 0) {
                Lose g = new Lose();
                getWorld().addObject(g, 420, 240);
                
                Actor firefly = getOneIntersectingObject(Firefly.class);
                    if (firefly != null) {
                    world.removeObject(firefly);
                    fireflyMeledak();
                }
            }
            
            getWorld().removeObject(this);
        }
    }
    
    public void fireflyMeledak() {
        FireflyMeledak e = new FireflyMeledak();
        getWorld().addObject(e, getX(), getY());
        Greenfoot.playSound("Meledak.wav");
    }
}
