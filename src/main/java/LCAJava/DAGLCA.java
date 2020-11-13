package LCAJava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DAGLCA{

    static ArrayList<NodeForDAG> aVisited, bVisited; // arraylists of the values that have been checked previously
    static ArrayList<Integer> lca = new ArrayList<>(); // arraylist of all the lcas, the highest indexed one is the lca
    public static void main(String[] args){
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

        System.out.println("should be  2: " + getLCA(DAG4, DAG5));
        System.out.println("should be  6: " + getLCA(DAG8, DAG9));
        System.out.println("should be  0: " + getLCA(DAG1, DAG5));

    }

    static int getLCA(NodeForDAG first, NodeForDAG second) {
        if(lca != null) {lca.clear();}
        if(aVisited != null) {aVisited.clear();}
        if(bVisited != null) {bVisited.clear();}
        NodeForDAG aOriginal = first; NodeForDAG bOriginal = second;
        if(aOriginal == bOriginal) {return aOriginal.value;} //if they are the same node
        aVisited = new ArrayList<>();
        bVisited = new ArrayList<>();
        aVisited.add(aOriginal);
        bVisited.add(bOriginal);
        return getLCARecursive(aOriginal.parents, bOriginal.parents);
    }

    static int getLCARecursive(ArrayList<NodeForDAG> aList, ArrayList<NodeForDAG> bList) {
        // parameters are lists of parents of everything checked in aList and bList in the recursion before this
        // or from the original method getLCA if it is the first iteration of this method

        // check for intersection of aList and bList and everything before bList
        ArrayList<NodeForDAG> tempBList = bVisited;
        tempBList.addAll(bList);
        for(int i = 0; i < aList.size(); i++){
            for(int j = 0; j < tempBList.size(); j++){
                if(aList.get(i).value == tempBList.get(j).value){
                    lca.add(aList.get(i).value);
                }
            }
        }

        // check for intersection of bList and aList and everything before aList
        ArrayList<NodeForDAG> tempAList = aVisited;
        tempAList.addAll(aList);
        for(int i = 0; i < bList.size(); i++){
            for(int j = 0; j < tempAList.size(); j++){
                if(bList.get(i).value == tempAList.get(j).value){
                    lca.add(bList.get(i).value);
                }
            }
        }
        
        // add to visited list
        aVisited = tempAList; bVisited = tempBList;

        // send parents of the new list just checked to the method
        ArrayList<NodeForDAG> aParents = new ArrayList<>();
        ArrayList<NodeForDAG> bParents = new ArrayList<>();
        for(int i = 0; i < aList.size(); i++){
            if(aList.get(i).parents != null)
                aParents.addAll(aList.get(i).parents);
        }
        for(int i = 0; i < bList.size(); i++){
            if(bList.get(i).parents != null)
                bParents.addAll(bList.get(i).parents);
        }

        if(lca.size() == 0 && aParents != null && bParents != null){
            return getLCARecursive(aParents, bParents);
        }

        System.out.println(lca.toString());
        return Collections.max(lca);
    }
}

class NodeForDAG{
    int value;
    ArrayList<NodeForDAG> parents = new ArrayList<>();

    NodeForDAG(int num, ArrayList<NodeForDAG> array){
        value = num;
        parents = array;
    }
}
