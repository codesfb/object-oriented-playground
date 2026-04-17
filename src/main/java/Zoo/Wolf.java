package Zoo;
public  class Wolf extends  Animal{
    private String name;
    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }
    public void run(){
        System.out.println("Wolf is running!");
    }

}
