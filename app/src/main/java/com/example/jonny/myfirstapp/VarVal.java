package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 14/05/2015.
 */
public class VarVal extends Node {


    Type varNodeType;
    String value;

    public enum Type {
        STRING,
        INT,
        BOOL
    }

    public VarVal(Node parent, Type type, String value) {
        super(Node.Type.VARVAL, parent);
        this.isCurrentNode = true;
        this.varNodeType = type;
        this.value = value;
    }
}