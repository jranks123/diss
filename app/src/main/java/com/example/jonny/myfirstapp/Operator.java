package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 26/05/2015.
 */
public class Operator extends Node {

    Type opNodeType;

    public enum Type {
        ADD,
        SUB,
        MULTI,
        DIV
    }

    public Operator(Node parent, Type type){
        super(Node.Type.OP, parent);
        this.isCurrentNode = true;
        this.opNodeType = type;
    }
}
