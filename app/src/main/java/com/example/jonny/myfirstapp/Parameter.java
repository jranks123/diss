package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 19/08/15.
 */
public class Parameter extends Node {
    Boolean paramDefFinished;
    Type type;

    public enum Type{
        INT,
        BOOL,
        STRING,
        NONE
    }


    public Parameter(Node parent)
    {
        super(Node.Type.PARAMETER, parent);
        this.isCurrentNode = true;
        this.paramDefFinished = false;
        this.type = Type.NONE;

    }

}


