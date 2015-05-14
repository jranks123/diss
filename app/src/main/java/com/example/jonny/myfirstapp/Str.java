package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 09/04/2015.
 */
public class Str extends Node {

    String value;


    public Str(Node parent, String value) {
        super(Node.Type.VAR, parent);
        this.value = value;
        this.nodeType = Node.Type.STRING;
    }

    public String getValue(){
        return this.value;
    }


}
