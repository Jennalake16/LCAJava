package LCAJava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DAGLCA{

    static ArrayList<NodeForDAG> aVisited, bVisited; // arraylists of the values that have been checked previously
    static ArrayList<Integer> lca = new ArrayList<>(); // arraylist of all the lcas, the highest indexed one is the lca
    public static void main(String[] args){
        // I wrote the code using an explanation of the algorithm that I found online which helped me a lot
        // https://jgrapht.org/javadoc-1.4.0/org/jgrapht/alg/lca/NaiveLCAFinder.html

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
