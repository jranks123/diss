package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 14/08/2015.
 */
public class Return extends Node {

    Boolean returnValSet;
    Boolean isInitialReturn;

    public Return(Node parent, Boolean isInitialReturn)
    {
        super(Node.Type.RETURN, parent);
        this.isCurrentNode = true;
        this.returnValSet = false;
        this.isInitialReturn = isInitialReturn;
    }
}
