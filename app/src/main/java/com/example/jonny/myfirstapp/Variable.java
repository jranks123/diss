package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 24/03/2015.
 */
public class Variable extends Node {


    Type varNodeType;
    String name;
    String value;

    public enum Type{
        STRING,
        INT,
        BOOL
    }

    public Variable(Node parent, Type type, String name, String value)
    {
        super(Node.Type.VAR, parent);
        this.isCurrentNode = true;
        this.varNodeType = type;
        this.name = name;
        this.value = value;
    }

    public String getName(Node tree){
        Node node = findCurNode(tree);
        return ((Variable)node).name;
    }

    public String getValue(Node tree){
        Node node = findCurNode(tree);
        return ((Variable)node).value;
    }







}
