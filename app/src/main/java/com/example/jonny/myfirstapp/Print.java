package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 29/05/2015.
 */
public class Print extends Node {
    Type printNodeType;

    public enum Type{
        STRING,
        INT,
        NONE
    }

    public Print (Node parent, Type type)
    {
        super(Node.Type.PRINT, parent);
        this.isCurrentNode = true;
        this.printNodeType = type;
    }
}
