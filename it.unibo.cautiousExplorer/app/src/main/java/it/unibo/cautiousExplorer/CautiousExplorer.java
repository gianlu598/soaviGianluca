package it.unibo.cautiousExplorer;

public class CautiousExplorer {

    public String cautiousExplorer() {
        MoveVirtualRobot appl = new MoveVirtualRobot();
        int counter = 0;
        StringBuilder sb = new StringBuilder("");
        boolean collision = false;
        while (!collision){
            collision = appl.moveForward(300);
            counter++;
            sb.append("w");
        }
        collision = false;
        for(int i=0; i<counter && !collision; i++){
            collision = appl.moveBackward(300);
            sb.append("b");
        }
        return sb.toString();
    }

    public static void main(String[] args)   {
        CautiousExplorer app = new CautiousExplorer();
        System.out.println("Hello my friend!");
        app.cautiousExplorer();
        System.out.println("Giretto turistico finito!");

    }
}
