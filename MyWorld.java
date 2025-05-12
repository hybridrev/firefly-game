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
        addObject(firefly,0,0);

        for(int i=0;i<3;i++){
            Swarm swarm = new Swarm(i);
            addObject(swarm, Greenfoot.getRandomNumber(250), 
                Greenfoot.getRandomNumber(250));
        }
        Memetic memetic = new Memetic();
        addObject(memetic,129,92);
        
        score.setValue(0);
        addObject(score,47,17);
        hp.setValue(20);
        addObject(hp, 47, 47);
    }
    
    GreenfootSound music = new GreenfootSound("music.wav");
    
    public void started(){
        music.playLoop();
    }
    
    public void stopped() {
        music.pause(); 
    }
}

