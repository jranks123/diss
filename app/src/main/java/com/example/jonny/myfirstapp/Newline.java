package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 03/06/2015.
 */
public class Newline extends Node  {

    Type newlineNodeType;

    public enum Type{
        FOR,
        NONE
    }

    public Newline(Node parent, Type type)
    {
        super(Node.Type.NEWLINE, parent);
        this.isCurrentNode = true;
        this.newlineNodeType = type;
    }


}
