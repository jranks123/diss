package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 06/06/2015.
 */
public class Condition extends Node{
    Boolean conditionEnded;
    Boolean isTrue;


    public Condition(Node parent)
    {
        super(Node.Type.CONDITION, parent);
        this.isCurrentNode = true;
        this.conditionEnded = false;
        this.isTrue = false;
    }
}
