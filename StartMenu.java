import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartMenu extends World {
    static {
        Greenfoot.setWorld(new StartMenu());
    }

    private GreenfootImage bg1;
    private GreenfootImage bg2;
    private int scrollX;

    public StartMenu()
    {    
        // setting canvas dan background
        super(872, 490, 1);
        scrollX = 0;
        setBackground("bg1.png");
        bg1 = new GreenfootImage("bg1.png");
        bg2 = new GreenfootImage("bg2.png");
        addObject(new GameName(), getWidth()/2, 190);
        addObject(new PlayButton(), getWidth()/2, 300);
        addObject(new AboutButton(), getWidth()/2, 370);
    }
    
    // Background Loop
    private void scrollBackground() {
        scrollX -= 1; // kecepatan scroll

        if (scrollX <= -bg1.getWidth()) {
            scrollX = 0;
        }

        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());

        // gambar bg1 dan bg2 berdampingan
        bg.drawImage(bg1, scrollX, 0);
        bg.drawImage(bg2, scrollX + bg1.getWidth(), 0);

        setBackground(bg);
    }
    
    public void act() {
        scrollBackground();
    }
    
    GreenfootSound music = new GreenfootSound("music.wav");
    
    public void started(){
        music.playLoop();
    }
    
    //public void stopped() {
    //    music.pause(); 
    //}
}
