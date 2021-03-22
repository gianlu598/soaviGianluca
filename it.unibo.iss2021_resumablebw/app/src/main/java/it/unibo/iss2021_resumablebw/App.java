/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unibo.iss2021_resumablebw;

import it.unibo.annotations.ArilRobotSpec;
import it.unibo.consolegui.ConsoleGui;
import it.unibo.interaction.IssOperations;
import it.unibo.supports.IssCommSupport;
import it.unibo.supports.RobotApplicationStarter;
import it.unibo.wenv.ClientBoundaryWebsockArilAsynch;
import it.unibo.wenv.RobotInputController;

@ArilRobotSpec
public class App {
    private RobotInputController controller;
    private ConsoleGui console;

    //Constructor
    public App(IssOperations rs){
        IssCommSupport rsComm = (IssCommSupport)rs;
        controller = new RobotInputController(rsComm, true, true );
        rsComm.registerObserver( controller );
        console = new ConsoleGui(controller);
        System.out.println("ClientBoundaryWebsockBasicAsynch | CREATED with rsComm=" + rsComm);
    }

    public RobotInputController getController(){
        return this.controller;
    }

    public void setController(RobotInputController c){
        this.controller = c;
    }

    public String doBoundary(){
        System.out.println("ClientBoundaryWebsockBasicAsynch | doBoundary " + controller  );
        return controller.doBoundary();
    }

    public static void main(String args[]){
        try {
            System.out.println("ClientBoundaryWebsockBasicAsynch | main start n_Threads=" + Thread.activeCount());
            Object appl = RobotApplicationStarter.createInstance(App.class);
            System.out.println("ClientBoundaryWebsockBasicSynch  | appl n_Threads=" + Thread.activeCount());
            String trip = ((App)appl).doBoundary();
            System.out.println("ClientBoundaryWebsockBasicAsynch | trip="   );
            System.out.println( trip  );
            System.out.println("ClientBoundaryWebsockBasicAsynch | main end n_Threads=" + Thread.activeCount());
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}