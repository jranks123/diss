package com.example.jonny.myfirstapp;

import java.util.ArrayList;

/**
 * Created by Jonny on 17/08/2015.
 */
public class FunctionCall extends Node{


    Type type;
    String functionName;
    ArrayList<ArrayList<Node>> parameters;
    Boolean paramsFinished;

    public enum Type {
        STRING,
        INT,
        BOOL,
        VOID,
        NONE
    }

    public FunctionCall(Node parent, Type type)
    {
        super(Node.Type.FUNCCALL, parent);
        this.isCurrentNode = true;
        this.type = type;
        this.functionName = null;
        this.parameters = new ArrayList<ArrayList<Node>>();
        paramsFinished = false;
    }


}
