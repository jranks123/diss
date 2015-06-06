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
        BRACKET,
        NEWLINE,
        STARTLOOP,
        END,
        IF,
        CONDITION;
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
        if(tree.nodeType == Node.Type.VAR){
            try {
                Log.e("AND is type", ((Variable) tree).varNodeType.toString());
            }catch (NullPointerException e ){

            }

        }
        Node newTree = new Node(Node.Type.ROOT, null);
        if (tree.isCurrentNode == true){
            Log.e("ADDNODE", "Current node findCurNode " + tree.nodeType.toString());
            return tree;
        }
        if (tree.left != null) {
            newTree = findCurNode(tree.left);

        }
        if (tree.right != null) {
            newTree = findCurNode(tree.right);
        }
        return newTree;
    }


    public Node addNode(Node tree, Type type, String direction, String value) {
        Node node = findCurNode(tree);
        Node newNode = new Node(Node.Type.NONE, node);
            if (type == Type.STRING) {
                newNode = new Str(node, value);
            }
            else if (type == Type.VAR) {
                if (value == "String") {
                    newNode = new Variable(node, Variable.Type.STRING, null, null);
                }
                else if (value == "Int") {
                    newNode = new Variable(node, Variable.Type.INT, null, null);
                }else if (value == "Bool") {
                    newNode = new Variable(node, Variable.Type.BOOL, null, null);
                }
                else if (value == null){
                    newNode = new Variable(node, null, null, null);
                }
            }
            else if(type == Type.PRINT){
                newNode = new Print(node, Print.Type.NONE);
            }
            else if (type == Type.DEC) {
                newNode = new Dec(node, Dec.Type.NONE);
            }
            else if (type == Type.VARVAL) {
                //TODO: Possibly check that i don't need to make this account for ints
                newNode = new VarVal(node, VarVal.Type.STRING, value);
            }
            else if(type == Type.EVAL){
                newNode = new Eval(node, Eval.Type.NONE);
            }
            else if (type == Type.FORLOOP) {
                if (value == "For") {
                    newNode = new Loops(node, Loops.Type.FOR);
                }
            }
            else if (type == Type.OP) {
                newNode = new Operator(node, null);
            }
            else if (type == Type.NEWLINE) {
                if(value == "for") {
                    newNode = new Newline(node, Newline.Type.FOR); //For indentation
                }else{
                    newNode = new Newline(node, null);
                }
            }
            else if(type == Type.BRACKET){
                if(value == "Open"){
                    newNode =  new Bracket(node, Bracket.Type.OPEN);
                }else if(value == "Close"){
                    newNode =  new Bracket(node, Bracket.Type.CLOSE);
                }
            }
            else {
                newNode = new Node(type, node);
            }
            if(direction == "left"){
                node.left = newNode;
            }else if(direction == "right"){
                node.right = newNode;
            }
            node.isCurrentNode = false;
            return tree;
    }



    public Node updateOp(Node tree, Operator.Type type ){
        Node node = findCurNode(tree);
        ((Operator)node).opNodeType = type;
        return tree;
    }

    public Node updateVarVal(Node tree, String value){
        Node node = findCurNode(tree);
        ((VarVal)node).value = value;
        return tree;
    }


    public Node updateDec(Node tree, Dec.Type type){
        Node node = findCurNode(tree);
        ((Dec)node).varNodeType = type;
        return tree;
    }

    public Print returnPrintNode(Node node){
        while(node.nodeType != Node.Type.PRINT){
            node = node.parent;
        }
        return ((Print)node);
    }

    public Eval returnEvalNode(Node node){
        while(node.nodeType != Node.Type.EVAL){
            node = node.parent;
        }
        return ((Eval)node);
    }

    public Eval returnEvalVar(Node node){
        while(node.nodeType != Node.Type.EVAL){
            node = node.parent;
        }
        return ((Eval)node);
    }





    public Node updatePrint(Node tree, Print.Type type){
        Node node = findCurNode(tree);
        node = returnPrintNode(node);
        ((Print)node).printNodeType = type;
        return tree;
    }

    public Node updateEval(Node tree, Eval.Type type){
        Node node = findCurNode(tree);
        ((Eval)node).evalNodeType = type;
        return tree;
    }

    public Node updateVarType(Node tree, Variable.Type type){
        Node node = findCurNode(tree);
        ((Variable)node).varNodeType = type;
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

    public Variable.Type getVarType(Node node){
        while(node.nodeType != Node.Type.VAR){
            node = node.parent;
        }
        return ((Variable)node).varNodeType;
    }


    public Variable returnAssignVar(Node node){
        while(node.nodeType != Node.Type.ASSIGN){
            node = node.parent;
        }
        return ((Variable)node.parent);
    }



    public Variable returnDecVar(Node node){

        while(node.nodeType != Node.Type.DEC){
            node = node.parent;
        }
        return ((Variable)node.left);
    }



    public Boolean isXbeforeY(Node node, Node.Type x, Node.Type y){
      //  Node node = findCurNode(tree);
        while(node.nodeType != x || node.nodeType != y){
            if(node.nodeType == x){
                return true;
            }else if (node.nodeType == y){
                return false;
            }else if(node.nodeType == Node.Type.ROOT){
                return false;
            }
            node = node.parent;
        }
        return false;
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
