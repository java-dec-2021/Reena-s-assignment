public class Human implements LivingBeing,Wild{

    @Override
    public void breath() {
        // TODO Auto-generated method stub
        System.out.println("I like to breath 02");

        
    }

    @Override
    public void reproduce() {
        // TODO Auto-generated method stub
    System.out.println("I can have cute babies");        
    }

    public void move() {
        System.out.println("I like to drive");
    }

    @Override
    public void Attack() {
        // TODO Auto-generated method stub
        System.out.println("I can attack Lion");
    }

    
}
