package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 03/06/2015.
 */
public class Newline extends Node  {

    Type newlineNodeType;
    Boolean isEnd;
    Boolean stop;

    public enum Type{
        FOR,
        FOREND,
        IF,
        IFEND,
        ELSE,
        FUNCTION,
        FUNCEND,
        ELSEEND,
        NEWLINE,
        RETURN,
        NONE
    }

    public Newline(Node parent, Type type)
    {
        super(Node.Type.NEWLINE, parent);
        this.isCurrentNode = true;
        this.newlineNodeType = type;
        isEnd = false;
        stop = false;
        if(type == Type.FOREND || type == Type.IFEND || type == Type.ELSEEND || type == Type.FUNCEND){
            isEnd = true;
        }
    }


}
