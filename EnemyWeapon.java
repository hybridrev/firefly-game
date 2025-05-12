import greenfoot.*; 

public class EnemyWeapon extends Actor
{
    public EnemyWeapon(){
        setImage("Weapon.png");
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
            MyWorld world = (MyWorld)getWorld();
            world.hp.add(-1);

            if (world.hp.getValue() == 0) {
                Lose g = new Lose();
                getWorld().addObject(g, 420, 240);
                Greenfoot.stop();
            }

            getWorld().removeObject(this);
        }
    }    
}
