public class CrazyEights{
    public static void main(String[] args){
        boolean keepPlaying = true;

        while(keepPlaying){
            Game g = new Game();
            keepPlaying = g.play();
        }
        System.out.println("Thank you for playing --> Game OVER");
    }
}