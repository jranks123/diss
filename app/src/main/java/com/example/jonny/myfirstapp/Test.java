package com.example.jonny.myfirstapp;

import android.util.Log;
import android.view.View;

/**
 * Created by Jonny on 22/08/15.
 */
public class Test {


    public Test()
    {


    }

    //Boolean function with 1 int parameter
    public Node test1(Node tree){
        //Function
        tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "FUNCTION");
        tree = tree.addNode(tree, Node.Type.FUNCTION, "left", null);
        //Bool
        tree = tree.updateFuncType(tree, Function.Type.BOOL);
        tree = tree.updateFuncIsDec(tree, true);
        //Enter Function Name
        tree = tree.updateFuncName(tree, "a");
        //Add Parameter
        tree = tree.addNode(tree, Node.Type.STARTPARAM, "left", null);
        tree = tree.addNode(tree, Node.Type.PARAMETER, "right", null);
        tree = tree.addNode(tree, Node.Type.DEC, "left", "none");
        //Int
        tree = tree.updateDec(tree, Dec.Type.INT);
        //Enter name of variable
        tree = tree.addNode(tree, Node.Type.VAR, "left", "Int");
        tree.setVarName(tree, "x", false);
        //Finish Declaraiton
        tree = tree.addNode(tree, Node.Type.ENDPARAM, "left", null);
        tree = tree.moveUpTreeLimit(tree, "FUNCTION");
        tree = tree.addNode(tree, Node.Type.BLANK, "right", null);
        tree = tree.addNode(tree, Node.Type.RESETRETURN, "right", null);
        tree = tree.moveUpOneStep(tree);
        tree = tree.addNode(tree, Node.Type.STARTFUNC, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "right", "FUNCEND");
        tree = tree.addNode(tree, Node.Type.END, "right", null);
        tree = tree.moveUpTreeLimit(tree, "STARTFUNC");
        tree = tree.addNode(tree, Node.Type.NONE, "left", null);
        tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "NEWLINE");
        tree = tree.moveUpTreeLimit(tree, "SEQ");
        tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "RETURN");
        tree = tree.addNode(tree, Node.Type.RETURN, "left", "true");
        tree = tree.addNode(tree, Node.Type.EVAL, "left", "BOOL");
        tree = tree.addNode(tree, Node.Type.VARVAL, "left", "true");
        tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
        tree = tree.moveUpTreeLimit(tree, "SEQ");
        tree = tree.moveUpTreeLimit(tree, "NONE");
        Node functionNode = tree.findCurNode(tree).parent.parent.parent;
        functionNode = tree.setFuncParamFinished(functionNode, true);
        functionNode = tree.setFuncEndDec(functionNode, true);

        return tree;
    }

    //String function with 1 int parameter
    public Node test2(Node tree){
        //Function
        tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "FUNCTION");
        tree = tree.addNode(tree, Node.Type.FUNCTION, "left", null);
        //Bool
        tree = tree.updateFuncType(tree, Function.Type.STRING);
        tree = tree.updateFuncIsDec(tree, true);
        //Enter Function Name
        tree = tree.updateFuncName(tree, "a");
        //Add Parameter
        tree = tree.addNode(tree, Node.Type.STARTPARAM, "left", null);
        tree = tree.addNode(tree, Node.Type.PARAMETER, "right", null);
        tree = tree.addNode(tree, Node.Type.DEC, "left", "none");
        //Int
        tree = tree.updateDec(tree, Dec.Type.INT);
        //Enter name of variable
        tree = tree.addNode(tree, Node.Type.VAR, "left", "Int");
        tree.setVarName(tree, "x", false);
        //Finish Declaraiton
        tree = tree.addNode(tree, Node.Type.ENDPARAM, "left", null);
        tree = tree.moveUpTreeLimit(tree, "FUNCTION");
        tree = tree.addNode(tree, Node.Type.BLANK, "right", null);
        tree = tree.addNode(tree, Node.Type.RESETRETURN, "right", null);
        tree = tree.moveUpOneStep(tree);
        tree = tree.addNode(tree, Node.Type.STARTFUNC, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "right", "FUNCEND");
        tree = tree.addNode(tree, Node.Type.END, "right", null);
        tree = tree.moveUpTreeLimit(tree, "STARTFUNC");
        tree = tree.addNode(tree, Node.Type.NONE, "left", null);
        tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "NEWLINE");
        tree = tree.moveUpTreeLimit(tree, "SEQ");
        tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "RETURN");
        tree = tree.addNode(tree, Node.Type.RETURN, "left", "true");
        tree = tree.addNode(tree, Node.Type.EVAL, "left", "STRING");
        tree = tree.addNode(tree, Node.Type.VARVAL, "left", "true");
        tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
        tree = tree.moveUpTreeLimit(tree, "SEQ");
        tree = tree.moveUpTreeLimit(tree, "NONE");
        Node functionNode = tree.findCurNode(tree).parent.parent.parent;
        functionNode = tree.setFuncParamFinished(functionNode, true);
        functionNode = tree.setFuncEndDec(functionNode, true);

        return tree;
    }


    public Node doTest(View v){
        Node tree = new Node(Node.Type.ROOT, null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "right", null);
        tree = tree.moveUpTreeLimit(tree, "ROOT");

        return tree;

    }


    public Node loadTest(int i){
        Node tree = new Node(Node.Type.ROOT, null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "right", null);
        tree = tree.moveUpTreeLimit(tree, "ROOT");
       switch (i){
           case 1:
               tree = test1(tree);
               break;

           case 2:
               tree = test2(tree);
               break;
        }


       return tree;
    }
}
