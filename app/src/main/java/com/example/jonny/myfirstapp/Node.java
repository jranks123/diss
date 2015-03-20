package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 20/03/2015.
 */
public class Node {

    public enum Type{
        SEQ,
        PRINT,
        A,
        B,
        C;
    }

    Type nodeType;
    Node left;
    Node right;
    Node parent;
    Boolean isCurrentNode;

    public Node (Type type, Node parent){
        this.left = null;
        this.right = null;
        this.parent = parent;
        this.nodeType = type;
        this.isCurrentNode = true;
    }

    public Node addNode(Node node, Type type, String direction){

        if (direction == "left"){
            node.left = new Node(type, node);
        }else if (direction == "right"){
            node.right = new Node(type, node);
        }
        return node;
    }



}
