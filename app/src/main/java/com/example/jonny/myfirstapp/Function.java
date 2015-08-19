package com.example.jonny.myfirstapp;

import java.util.ArrayList;

/**
 * Created by jacob on 05/08/15.
 */
public class Function extends Node{
    String name;
    Type funcType;
    Boolean isDec;
    Boolean decFinished;
    Boolean paramsFinished;
    Boolean hasReturn;
    ArrayList<Node> parameters;

    public enum Type {
        INT,
        BOOL,
        STRING,
        VOID
    }


    public Function(Node parent)
    {
        super(Node.Type.FUNCTION, parent);
        this.name = null;
        this.isCurrentNode = true;
        this.funcType = null;
        this.isDec = false;
        this.paramsFinished = false;
        this.decFinished = false;
        this.hasReturn = false;
        this.parameters = new ArrayList<Node>();
    }
}
