package LCAJava;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class DAGLCATest {

    @Test
    public void test(){
        ArrayList<NodeForDAG> DAG1Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG2Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG3Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG4Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG5Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG6Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG7Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG8Parents = new ArrayList<>();
        ArrayList<NodeForDAG> DAG9Parents = new ArrayList<>();

        NodeForDAG DAG0 = new NodeForDAG(0, null);
        DAG1Parents.add(DAG0);
        NodeForDAG DAG1 = new NodeForDAG(1, DAG1Parents);
        DAG2Parents.add(DAG0);
        NodeForDAG DAG2 = new NodeForDAG(2, DAG2Parents);
        DAG3Parents.add(DAG1);
        DAG3Parents.add(DAG2);
        NodeForDAG DAG3 = new NodeForDAG(3, DAG3Parents);
        DAG4Parents.add(DAG1);
        DAG4Parents.add(DAG2);
        NodeForDAG DAG4 = new NodeForDAG(4, DAG4Parents);
        DAG5Parents.add(DAG2);
        NodeForDAG DAG5 = new NodeForDAG(5, DAG5Parents);
        DAG6Parents.add(DAG2);
        NodeForDAG DAG6 = new NodeForDAG(6, DAG6Parents);
        DAG7Parents.add(DAG6);
        NodeForDAG DAG7 = new NodeForDAG(7, DAG7Parents);
        DAG8Parents.add(DAG5);
        DAG8Parents.add(DAG6);
        NodeForDAG DAG8 = new NodeForDAG(8, DAG8Parents);
        DAG9Parents.add(DAG6);
        DAG9Parents.add(DAG7);
        NodeForDAG DAG9 = new NodeForDAG(9, DAG9Parents);

        assertEquals(2, DAGLCA.getLCA(DAG4, DAG5));
        assertEquals(6, DAGLCA.getLCA(DAG8, DAG9));
        assertEquals(0, DAGLCA.getLCA(DAG1, DAG5));
    }
}
