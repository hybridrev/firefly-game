import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private GreenfootImage bg1;
    private GreenfootImage bg2;
    private int scrollX;
    
    public static FireflyBar hp = new FireflyBar(10);
    static Board score = new Board("");

    public MyWorld()
    {    
        // setting canvas dan background
        super(872, 490, 1);
        scrollX = 0;
        setBackground("bg1.png");
        bg1 = new GreenfootImage("bg1.png");
        bg2 = new GreenfootImage("bg2.png");
        setupScene();
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
        
        if (tipsOverlay != null) {
            tipsTimer--;
            if (tipsTimer <= 0) {
                removeObject(tipsOverlay);
                tipsOverlay = null;
            }
        }

    }
    
    private boolean memeticSpawned = false;
    private boolean swarmStarted = false;

    // kasih delay swarm untuk muncul
    private int delayMemetic = 100000; // 1 detik (jika 60 FPS)
    private int delaySwarm = 360;  // 2 detik setelah Memetic muncul
    private int delayTimer = 0;

    // mengatur jumlah swarm dari index 0 sampai 2
    private int[] jumlahTipe = {10, 5, 3};
    private int currentTipe = 0;
    private int currentJumlah = 0;
    private int spawnDelay = 20;
    private int spawnTimer = spawnDelay; 
    
    private int tipsTimer = 300; // 5 detik di 60 FPS
    private MessageOverlay tipsOverlay;
    
    private void setupScene() {
        tipsOverlay = new MessageOverlay("Objective: Kill Boss Swarm to win a game!", 860, 60);
        addObject(tipsOverlay, getWidth()/2, 60); // posisikan di atas layar
        
        // setting object
        Firefly firefly = new Firefly();
            addObject(firefly,130,250);

        score.setValue(0);
        addObject(score,40,469);
        // atur darah
        addObject(hp, 180, 470);
        hp.updateHealth(20);
    }
    
    public void act() {
        scrollBackground();
        
        // kasih delay musuh muncul
        if (!memeticSpawned) {
            delayTimer--;
            if (delayTimer <= 0) {
                Memetic memetic = new Memetic();
                    addObject(memetic, 890, 240);
                memeticSpawned = true;
                delayTimer = delaySwarm; // mulai hitung delay sebelum Swarm
            }
        return;
        }

        if (!swarmStarted) {
            delayTimer--;
            if (delayTimer <= 0) {
                swarmStarted = true;
            }
        return;
        }

        // Spawn Swarm setelah semua delay selesai
        spawnTimer--;
        if (spawnTimer <= 0) {
            if (currentTipe < jumlahTipe.length) {
                if (currentJumlah < jumlahTipe[currentTipe]) {
                    Swarm swarm = new Swarm(currentTipe);
                    addObject(swarm, 890, Greenfoot.getRandomNumber(480));
                    currentJumlah++;
                } else {
                    currentTipe++;
                    currentJumlah = 0;
                }
            spawnTimer = spawnDelay;
            }
        }
    }
}

