package com.example.jonny.myfirstapp;

import java.util.ArrayList;

/**
 * Created by Jonny on 14/05/2015.
 */
public class VarVal extends Node {


    Type varNodeType;
    String value;

    public enum Type {
        STRING,
        INT,
        BOOL
    }

    public VarVal(Node parent, Type type, String value) {
        super(Node.Type.VARVAL, parent);
        this.isCurrentNode = true;
        this.varNodeType = type;
        this.value = value;
    }
}


 /*   public void doFunctionCallParams(Node currentNode) {
        fillVariablesArrayFull();
        //Function f = getFunctionFromName(((FunctionCall) currentNode).functionName);
        Node  functionNode = tree.getFunctionNodeByName(tree, ((FunctionCall) currentNode).functionName);
        ArrayList<Variable> functionParams = ((Function) functionNode).parameters;
        ArrayList<ArrayList<Node>> functionCallParams = ((FunctionCall) currentNode).parameters;
        if(functionParams.size() == functionCallParams.size()){
            ((FunctionCall) currentNode).paramsFinished = true;
        }

        if (((Function)functionNode).parameters.size() == 0) {
            ((FunctionCall) currentNode).paramsFinished = true;
        }
    }*/