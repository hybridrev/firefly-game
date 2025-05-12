import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor
{
    int tipe;
    int hp;
    private boolean reachedTarget = false;
    private int targetX;
    private int dy;
    private int direction;

    public Enemy(){
        tipe = 3;
        setImage("Swarm.png");
    }
    public Enemy(int tipe){
        this.tipe = tipe;
        this.hp = tipe+1;
        setImage("Swarm"+tipe+".png");
        
        targetX = Greenfoot.getRandomNumber(200) + 550;
        dy = Greenfoot.getRandomNumber(4) + 2;
        direction = 1;
    }
    int hitung=0;
    int batasTembak = Greenfoot.getRandomNumber(150) + 50;
    public void act()
    {
        hitung++;
        if (hitung >= batasTembak) {
            hitung=0;
            EnemyWeapon semburan = new EnemyWeapon(); 
            getWorld().addObject(semburan,getX(),getY());
            // suara
            Greenfoot.playSound("Proyektil.wav");
        }
        if (!reachedTarget) {
            // Gerak ke kiri dulu
            setLocation(getX() - 3, getY());
            if (getX() <= targetX) {
                reachedTarget = true; // mulai fase gerak acak
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
            if(hp==0){
                MyWorld.score.add(1); //Skor
                meledak();
            }
        }
        else if(MyWorld.score.getValue() == 100) { 
            Win g = new Win();
            getWorld().addObject(g, 420, 240); // Tambah objek game over
            Greenfoot.stop(); // Hentikan game
        }
        
        //jika karakter bertabrakan dengan musuh = hancur
        else if(isTouching(Firefly.class)){
            MyWorld.hp.add(-1);
            //Apabila darah habis = game over
            if(MyWorld.hp.getValue()==0){
                //Munculin gambar gameover
                Lose g = new Lose();
                getWorld().addObject(g, 420, 240);
                Greenfoot.stop();                
            }
            meledak();            
        }
    }

    void meledak()
    {
    Greenfoot.playSound("Ledakan.wav");

        // Tambahkan ledakan animasi
        Ledakan b = new Ledakan();
        getWorld().addObject(b, getX(), getY());

        // Tambahkan objek delay untuk spawn musuh baru
        getWorld().addObject(new DelayedSpawn(100, tipe), getX(), getY()); // 50 frame delay

        // Hapus musuh saat ini
        getWorld().removeObject(this);
    }
}
