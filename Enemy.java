import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor
{
    int tipe;
    int hp;

    public Enemy(){
        tipe = 3;
        setImage("Swarm.png");
    }
    public Enemy(int tipe){
        this.tipe = tipe;
        this.hp = tipe+1;
        setImage("Swarm"+tipe+".png");
    }

    public void act()
    {
        setLocation(getX(), getY()+2);
        
        if(getY()==499){ 
            setLocation(getX(), 0);
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
        else if(MyWorld.score.getValue() >= 101) { 
            Win g = new Win();
            getWorld().addObject(g, 150, 250); // Tambah objek game over
            Greenfoot.stop(); // Hentikan game
        }
        
        //jika karakter bertabrakan dengan musuh = hancur
        else if(isTouching(Firefly.class)){
            MyWorld.hp.add(-1);
            //Apabila darah habis = game over
            if(MyWorld.hp.getValue()==0){
                //Munculin gambar gameover
                Lose g = new Lose();
                getWorld().addObject(g, 150, 250);
                Greenfoot.stop();                
            }
            meledak();            
        }
        else if(getY()>= 480) {
            MyWorld.hp.add(-1);
            if(MyWorld.hp.getValue()==0){
                //Munculin gambar gameover
                Lose g = new Lose();
                getWorld().addObject(g, 150, 250);
                Greenfoot.stop();
            }
            meledak();
        }
    }

    void meledak()
    {
        Greenfoot.playSound("Ledakan.wav");
        Enemy e;
        if(this instanceof Swarm)
            e = new Swarm(tipe);
        else
            e = new Memetic();
        getWorld().addObject(e,Greenfoot.getRandomNumber(300),5);            
        Ledakan b = new Ledakan();
        getWorld().addObject(b, getX(), getY());
        getWorld().removeObject(this); 
    }
}
