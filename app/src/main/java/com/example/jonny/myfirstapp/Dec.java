package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 10/04/2015.
 */
public class Dec extends Node {


    Type varNodeType;

    public enum Type{
        STRING,
        INT,
        BOOL
    }

    public Dec(Node parent, Type type)
    {
        super(Node.Type.DEC, parent);
        this.isCurrentNode = true;
        this.varNodeType = type;
    }







}
