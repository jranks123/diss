package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 29/05/2015.
 */
public class Eval extends Node{
    Type evalNodeType;

    public enum Type{
        STRING,
        INT,
        BOOL,
        NONE
    }

    public Eval (Node parent, Type type)
    {
        super(Node.Type.EVAL, parent);
        this.isCurrentNode = true;
        this.evalNodeType = type;
    }
}
