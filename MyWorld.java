import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    static Board hp = new Board("HP:");
    static Board score = new Board("Kill:");

    public MyWorld()
    {    
        // setting canvas dan background
        super(846, 480, 1);
        setupScene();
        setBackground("Background.png");
    }

    private void setupScene()
    {
        // setting object
        Firefly firefly = new Firefly();
        addObject(firefly,100,250);

        for(int i=0;i<5;i++){
            Swarm swarm = new Swarm(i);
            addObject(swarm,846, 
                Greenfoot.getRandomNumber(480));
        }
        Memetic memetic = new Memetic();
        addObject(memetic,846,
            Greenfoot.getRandomNumber(480));
        
        score.setValue(0);
        addObject(score,55,25);
        hp.setValue(20);
        addObject(hp, 150, 25);
    }
    
    GreenfootSound music = new GreenfootSound("music.wav");
    
    public void started(){
        music.playLoop();
    }
    
    public void stopped() {
        music.pause(); 
    }
}

