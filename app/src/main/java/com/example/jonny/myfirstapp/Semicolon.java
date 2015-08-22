package com.example.jonny.myfirstapp;

import java.util.ArrayList;

/**
 * Created by Jonny on 18/08/2015.
 */
public class Semicolon extends Node {

    public enum Type {
        RETURN,
        NONE
    }

    Type type;

    public Semicolon(Node parent, Type type)
    {
        super(Node.Type.SMCLN, parent);
        this.isCurrentNode = true;
        this.type = type;


    }
}
