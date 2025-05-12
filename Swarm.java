import greenfoot.*;

public class Swarm extends Enemy
{
    public Swarm(){
        super();
    }
    public Swarm(int tipe){
        super(tipe);
    }
    public void act() 
    {
        super.act();
        turn(0);

    }
}