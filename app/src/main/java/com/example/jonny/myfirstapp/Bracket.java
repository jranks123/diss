package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 04/06/2015.
 */
public class Bracket extends Node {
    Type bracketType;

    public enum Type{
        OPEN,
        CLOSE
    }

    public Bracket(Node parent, Type type)
    {
        super(Node.Type.BRACKET, parent);
        this.isCurrentNode = true;
        this.bracketType = type;
    }

}
