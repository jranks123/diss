package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 06/06/2015.
 */
public class If extends Node{
    Boolean conditionEnded;
    Boolean isTrue;


    public If(Node parent)
    {
        super(Node.Type.IF, parent);
        this.isCurrentNode = true;
        this.conditionEnded = false;
        this.isTrue = false;
    }
}
