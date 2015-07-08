package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 26/05/2015.
 */
public class Operator extends Node {

    Type opNodeType;
    Boolean isConditional;

    public enum Type {
        ADD,
        SUB,
        MULTI,
        DIV,
        CONCAT,
        AND,
        OR,
        OPENBRACKET,
        CLOSEBRACKET,
        MORETHAN,
        LESSTHAN,
        MORETHANEQUALS,
        LESSTHANEQUALS,
        EQUALS,
        NOTEQUALS,
        NONE
    }

    public Operator(Node parent, Type type){
        super(Node.Type.OP, parent);
        this.isCurrentNode = true;
        this.opNodeType = type;
        this.isConditional = false;
    }
}
