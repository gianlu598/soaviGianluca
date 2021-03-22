package it.unibo.cautiousExplorer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCautiousExplorer {
    private MoveVirtualRobot appl;
    private CautiousExplorer app;

    @Before
    public void systemSetUp() {
        System.out.println("TestCautiousExplorer | setUp: robot should be at DEN-DOWN ");
        app = new CautiousExplorer();
        appl = new MoveVirtualRobot();
    }

    @After
    public void  terminate() {
        System.out.println("%%%  TestCautiousExplorer |  terminates ");
    }

    @Test
    public void testPlan() {
        //Hypothesis 1 -> w*b*
        System.out.println("testPlan Hypothesis 1 | testWork ");

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
        System.out.println(sb.toString());
        assertTrue( sb.toString().matches("w+b+")  );

    }



}
