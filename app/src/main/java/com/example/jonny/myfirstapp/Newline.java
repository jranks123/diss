package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 03/06/2015.
 */
public class Newline extends Node  {

    Type newlineNodeType;

    public enum Type{
        FOR,
        FOREND,
        IF,
        IFEND,
        ELSE,
        ELSEEND,
        NONE
    }

    public Newline(Node parent, Type type)
    {
        super(Node.Type.NEWLINE, parent);
        this.isCurrentNode = true;
        this.newlineNodeType = type;
    }


}
