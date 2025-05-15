import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor
{
    int tipe;
    int hp;
    private boolean reachedTarget = false;
    private int targetX;
    private int target3;
    private int dy;
    private int direction;
    private HealthBar healthBar;

    public Enemy(){
        tipe = 3;
        setImage("Swarm.png");
    }
    public Enemy(int tipe){
        this.tipe = tipe;
        switch (tipe) {
        case 0:
            this.hp = 1; // Tipe 0 punya 2 HP
            break;
        case 1:
            this.hp = 3; // Tipe 1 punya 4 HP
            break;
        case 2:
            this.hp = 6; // Tipe 2 punya 6 HP
            break;
        case 3:
            this.hp = 500; // Tipe lain (jika ada) default ke 3 HP
            healthBar = new HealthBar(hp);
            break;
        default:
            this.hp = 3;
            break;
        }

        setImage("Swarm"+tipe+".png");
        
        target3 = 750;
        targetX = Greenfoot.getRandomNumber(100) + 550;
            if (tipe == 3) {
                dy = 2;
            } else {
                dy = Greenfoot.getRandomNumber(6) + 2;
            }
        direction = 1;
    }
    
    protected void addedToWorld(World world) {
        if (tipe == 3 && healthBar != null) {
            world.addObject(healthBar, getX(), getY() - 30);
        }
    }

    int hitung=0;
    int batasTembak = Greenfoot.getRandomNumber(250) + 50;
    
    public void act()
    {
        hitung++;
        if (hitung >= batasTembak) {
            hitung=0;
            EnemyWeapon semburan = new EnemyWeapon(); 
            getWorld().addObject(semburan,getX(),getY());
            // suara
            // Greenfoot.playSound("peluru1.wav");
        }
        if (!reachedTarget) {
            // Gerak ke kiri dulu
            if (tipe == 3) {
                setLocation(getX() - 2, getY());
            } else {
                setLocation(getX() - 5, getY());
            }
            
            if (tipe == 3) {
                if (getX() <= target3) {
                    reachedTarget = true; // mulai fase gerak acak
                }
            } else {
                if (getX() <= targetX) {
                    reachedTarget = true; // mulai fase gerak acak
                }
            }
            
        } else {
            // Gerakan acak naik turun setelah sampai target
            int newY = getY() + dy * direction;
            
            // Balik arah kalau kena batas atas/bawah
            if (newY <= 0 || newY >= getWorld().getHeight() - 1) {
                direction *= -1;
            }

            setLocation(getX(), newY);
        }

        //jika musuh tertembak = musuh hilang atau mati
        if(isTouching(Weapon.class))
        {
            hp--;
            removeTouching(Weapon.class);
            if (tipe == 3 && healthBar != null) {
                healthBar.update(hp);
            }
            
            if(hp==0){
                MyWorld.score.add(1); //Skor
                meledak();
            }
        }
        
        //jika karakter bertabrakan dengan musuh = hancur
        else if(isTouching(Firefly.class)){
            MyWorld world = (MyWorld) getWorld();
            int currentHP = MyWorld.hp.getCurrentHealth();    // dapatkan nilai HP sekarang
                MyWorld.hp.updateHealth(currentHP - 1);           // kurangi 1 dan update health bar

            if (MyWorld.hp.getCurrentHealth() == 0) {
                Lose g = new Lose();
                getWorld().addObject(g, 420, 240);
                Greenfoot.stop();               
            }
            meledak();            
        }
        
        if (tipe == 3 && healthBar != null && getWorld() != null) {
            try {
                healthBar.setLocation(getX() -15, getY() - 20);
            } catch (IllegalStateException e) {
            // HealthBar sudah tidak ada di world, abaikan
            }
        }

    }

    void meledak()
    {
        Greenfoot.playSound("Ledakan.wav");

        // Tambahkan ledakan animasi
        Ledakan b = new Ledakan();
        getWorld().addObject(b, getX(), getY());
        
        // Tambahkan objek delay untuk spawn musuh baru
        getWorld().addObject(new DelayedSpawn(500, tipe), getX(), getY()); // 500 frame delay

        if (healthBar != null) {
            getWorld().removeObject(healthBar);
        }
        
        if (tipe == 3) {
            for (Object obj : getWorld().getObjects(Enemy.class)) {
                Enemy e = (Enemy) obj;
                if (e != this) {
                    e.forceKill();
                }
            }

            getWorld().addObject(new WinDelay(100), getX(), getY());
        }
        // Hapus musuh saat ini
        getWorld().removeObject(this);
    }
    
    public void forceKill() {
        Greenfoot.playSound("Ledakan.wav");
        getWorld().addObject(new Ledakan(), getX(), getY());
        if (healthBar != null) {
            getWorld().removeObject(healthBar);
        }
        getWorld().removeObject(this);
    }
}
