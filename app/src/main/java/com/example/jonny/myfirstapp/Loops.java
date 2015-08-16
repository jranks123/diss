package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 14/05/2015.
 */
public class Loops extends Node {
    Type varNodeType;
    Integer lowerLim;
    Integer upperLim;
    String limiter;
    Operator.Type operator;
    String plusOrMinus;

    public enum Type {
        FOR
    }

    public Loops(Node parent, Type type){
        super(Node.Type.FORLOOP, parent);
        this.isCurrentNode = true;
        this.varNodeType = type;
    }

    public void setLowerLim(Integer low) {
        this.lowerLim=low;
    }
    public void setHigerLim(Integer high) {
        this.upperLim=high;
    }
}
