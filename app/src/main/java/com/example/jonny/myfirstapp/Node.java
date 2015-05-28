package com.example.jonny.myfirstapp;

import android.util.Log;

/**
 * Created by Jonny on 20/03/2015.
 */
public class Node {


    public enum Type{
        NONE,
        ROOT,
        SEQ,
        EVAL,
        STRING,
        PRINT,
        VAR,
        DEC,
        VARVAL,
        ASSIGN,
        FORLOOP,
        SMCLN,
        OP,
        END;
    }


    //SUPER


    Type nodeType;
    Node left;
    Node right;
    Node parent;
    Boolean isCurrentNode;
    Boolean found;

    public Node (Type type, Node parent){
        this.parent = parent;
        this.nodeType = type;
        this.isCurrentNode = true;
    }



    public Node findCurNode(Node tree){
        Log.e("LOOKING AT NODE",  tree.nodeType.toString());
        Node newTree = new Node(Node.Type.ROOT, null);
        if (tree.isCurrentNode == true){
            Log.e("ADDNODE", "Current node findCurNode " + tree.nodeType.toString());
            return tree;
        }
        if (tree.left != null) {
          //  Log.e("ABOUT TO LOOK AT NODE",  tree.left.nodeType.toString());
            newTree = findCurNode(tree.left);

        }
        if (tree.right != null) {
        //    Log.e("ABOUT TO LOOK AT NODE",  tree.right.nodeType.toString());
            newTree = findCurNode(tree.right);
        }
        return newTree;
    }


    public Node addNode(Node tree, Type type, String direction, String value){
        Node node = findCurNode(tree);
        if (direction == "left"){
            if(type == Type.STRING){
                node.left = new Str(node, value);
            }else if (type == Type.VAR){
                if(value == "String") {
                    node.left = new Variable(node, Variable.Type.STRING, null, null);
                }
                if(value == "Int") {
                    node.left = new Variable(node, Variable.Type.INT, null, null);
                }
            }else if (type == Type.DEC){
                if(value == "String")
                    node.left = new Dec(node, Dec.Type.STRING);
                if(value == "Int")
                    node.left = new Dec(node, Dec.Type.INT);
            }else if (type == Type.VARVAL){
                node.left = new VarVal(node, VarVal.Type.STRING, value);
               // (((Variable)node.parent.parent).value) = value;
            }else if(type == Type.FORLOOP){
                if(value == "For"){
                    node.left = new Loops(node, Loops.Type.FOR);
                }
            }
            else{
                node.left = new Node(type, node);
            }
            node.isCurrentNode = false;
        }

        else if (direction == "right"){
            if(type == Type.STRING){
                node.right = new Str(node, value);
            }else if (type == Type.VAR){
                if(value == "String") {
                    node.right = new Variable(node, Variable.Type.STRING, value, null);
                }
            }else if (type == Type.DEC){
                if(value == "String") {
                    node.right = new Dec(node, Dec.Type.STRING);
                }
            }else if (type == Type.VARVAL){
                node.right = new VarVal(node, VarVal.Type.STRING, value);
              //  (((Variable)node.parent).value) = value;
            }else if (type == Type.OP) {
                node.right = new Operator(node, null);
            }else{
                node.right = new Node(type, node);
            }
            node.isCurrentNode = false;
        }
       // node = findCurNode(tree);
       // Log.d("DEBUG", node.nodeType.toString());
        return tree;
    }

    public Node updateOp(Node tree, Operator.Type type ){
        Node node = findCurNode(tree);
        ((Operator)node).opNodeType = type;
        return tree;
    }


    public Node addPrintStringNode(Node tree, Type type, String direction){
        Node node = findCurNode(tree);
        Log.d("ADDNODES", node.nodeType.toString());
        if (direction == "left"){
            Log.d("ADDNODES", "Adding " + type.toString() + " to left");
            node.left = new Node(type, node);
            node.isCurrentNode = false;
        }else if (direction == "right"){
            Log.d("ADDNODES", "Adding " + type.toString() + " to right");
            node.right = new Node(type, node);
            node.isCurrentNode = false;
        }
        // node = findCurNode(tree);
        // Log.d("DEBUG", node.nodeType.toString());
        return tree;
    }

    public Node setVarName(Node tree, String value){
        Node node = findCurNode(tree);
        ((Variable)node).name = value;
        return tree;
    }

    public Node setVarValue(Node tree, String value){
        Node node = findCurNode(tree);
        ((Variable)node).value = value;
        return tree;
    }

    public Variable returnAssignVar(Node node){
      //  Node node = tree.findCurNode(tree);
        while(node.nodeType != Node.Type.ASSIGN){
            node = node.parent;
        }
        return ((Variable)node.parent);
    }

    public Node moveUpTreeLimit(Node tree, String limit){
        Log.e("ADDNODE", "moving up tree");
        Node node;
       do{
           node = findCurNode(tree);
           Log.d("DEBUG", "Current node before = " + node.nodeType.toString());
           node.isCurrentNode = false;
           node.parent.isCurrentNode = true;
           Log.d("DEBUG", "Current node = " + node.parent.nodeType.toString());

        }while (!node.parent.nodeType.toString().equals(limit));
        return tree;
    }

    public Node moveUpTreeSteps(Node tree, Integer limit){
        Node node;
        for(int i  = 0; i < limit; i++) {
            node = findCurNode(tree);
            Log.d("DEBUG", "Current node before = " + node.nodeType.toString());
            node.isCurrentNode = false;
            node.parent.isCurrentNode = true;
            Log.d("DEBUG", "Current node = " + node.parent.nodeType.toString());
        }
        return tree;

    }

    public Node moveDownOneStep(Node tree, String direction){
        Node node;
        node = findCurNode(tree);
        node.isCurrentNode = false;
        if(direction.equals("left")){
            node.left.isCurrentNode = true;
        }else if(direction.equals("right")){
            node.right.isCurrentNode = true;
        }else{
            Log.d("THERE", "IS A PROBLEM");
        }
        return tree;
        }

    public Node moveUpOneStep(Node tree){
        Node node;
        node = findCurNode(tree);
        node.isCurrentNode = false;
        node.parent.isCurrentNode = true;
        return tree;
    }



    public Node moveUpToStartOfForLoop(Node tree){
        Node node;
        while(findCurNode(tree).nodeType != Type.FORLOOP){
            node = findCurNode(tree);

            node.isCurrentNode = false;
            node.parent.isCurrentNode = true;
        }
        return tree;
    }




    public Node removeChildren(Node tree, String direction){
        Node node = findCurNode(tree);
        if(direction == "left") {
            node.left = null;
        }
        if(direction == "right") {
            node.right = null;
        }
        return tree;
    }




}
