package com.example.jonny.myfirstapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by Jonny on 20/03/2015.
 */
public class Node extends Activity {


    public enum Type{
        NONE,
        ROOT,
        SEQ,
        EVAL,
        STRING,
        PRINT,
        VAR,
        DEC,
        VARVAL,
        ASSIGN,
        FORLOOP,
        SMCLN,
        FUNCTION,
        OP,
        BRACKET,
        NEWLINE,
        STARTLOOP,
        STARTFUNC,
        END,
        IF,
        ELSE,
        STARTIF,
        ENDIF,
        RETURN,
        ENDIFCONDITION,
        ENDPROGRAM,
        CONDITION;
    }


    //SUPER


    Type nodeType;
    Node left;
    Node right;
    Node parent;
    Boolean isCurrentNode;
    Boolean found;
    Integer numberOfNewLines;
    Integer numberOfNewLinesPostDelete;
    Integer numberOfNewLinesBeforeCurNode;



    public Node (Type type, Node parent){
        this.parent = parent;
        this.nodeType = type;
        this.isCurrentNode = true;
    }




    public Node findCurNode(Node tree){
        Log.e("LOOKING AT NODE",  tree.nodeType.toString());
        if(tree.nodeType == Node.Type.VAR){
            try {
                Log.e("AND is type", ((Variable) tree).varNodeType.toString());
            }catch (NullPointerException e ){

            }

        }
        Node newTree = null;
        if (tree.isCurrentNode == true){
            Log.e("ADDNODE", "Current node findCurNode " + tree.nodeType.toString());
            return tree;
        }
        if (tree.left != null) {
            newTree = findCurNode(tree.left);
            if(newTree != null){
                return newTree;
            }

        }
        if (tree.right != null) {
            newTree = findCurNode(tree.right);
            if(newTree != null){
                return newTree;
            }
        }
        return newTree;
    }


    public Node addNode(Node tree, Type type, String direction, String value) {
        Node node = findCurNode(tree);
        Node newNode = new Node(Node.Type.NONE, node);
            if (type == Type.STRING) {
                newNode = new Str(node, value);
            }
            else if (type == Type.VAR) {
                if (value == "String") {
                    newNode = new Variable(node, Variable.Type.STRING, null, null);
                }
                else if (value == "Int") {
                    newNode = new Variable(node, Variable.Type.INT, null, null);
                }else if (value == "Bool") {
                    newNode = new Variable(node, Variable.Type.BOOL, null, null);
                }
                else if (value == null){
                    newNode = new Variable(node, null, null, null);
                }
            }
            else if(type == Type.PRINT){
                newNode = new Print(node, Print.Type.NONE);
            }
            else if (type == Type.DEC) {
                newNode = new Dec(node, Dec.Type.NONE);
            }
            else if (type == Type.VARVAL) {
                //TODO: Possibly check that i don't need to make this account for ints
                newNode = new VarVal(node, VarVal.Type.STRING, value);
            }
            else if(type == Type.EVAL){
                if(value == "STRING"){
                    newNode = new Eval(node, Eval.Type.STRING);
                }else if(value == "BOOL"){
                    newNode = new Eval(node, Eval.Type.BOOL);
                }
                else if(value == "INT"){
                    newNode = new Eval(node, Eval.Type.INT);
                }else {
                    newNode = new Eval(node, Eval.Type.NONE);
                }
            }else if(type == Type.FUNCTION){
                newNode = new Function(node);
            }
            else if (type == Type.FORLOOP) {
                if (value == "For") {
                    newNode = new Loops(node, Loops.Type.FOR);
                }
            }
            else if (type == Type.OP) {
                newNode = new Operator(node, null);
            }
            else if (type == Type.NEWLINE) {
                if(value == "FOR") {
                    newNode = new Newline(node, Newline.Type.FOR); //For indentation
                }else if (value == "FOREND") {
                    newNode = new Newline(node, Newline.Type.FOREND); //For indentation
                }else if (value == "IF") {
                    newNode = new Newline(node, Newline.Type.IF); //For indentation
                }else if (value == "IFEND") {
                    newNode = new Newline(node, Newline.Type.IFEND); //For indentation
                }else if (value == "ELSE") {
                    newNode = new Newline(node, Newline.Type.ELSE); //For indentation
                }else if (value == "ELSEEND") {
                    newNode = new Newline(node, Newline.Type.ELSEEND); //For indentation
                }else if (value == "FUNCEND") {
                    newNode = new Newline(node, Newline.Type.FUNCEND); //For indentation
                }else if (value == "FUNCTION") {
                    newNode = new Newline(node, Newline.Type.FUNCTION); //For indentation
                }else if (value == "NEWLINE") {
                    newNode = new Newline(node, Newline.Type.NEWLINE); //For indentation
                }else if (value == "RETURN") {
                    newNode = new Newline(node, Newline.Type.RETURN); //For indentation
                }else{
                    newNode = new Newline(node, Newline.Type.NONE);
                }
            }
            else if(type == Type.BRACKET){
                if(value == "Open"){
                    newNode =  new Bracket(node, Bracket.Type.OPEN);
                }else if(value == "Close"){
                    newNode =  new Bracket(node, Bracket.Type.CLOSE);
                }
            }
            else if(type == Type.RETURN){
                if(value == "true"){
                    newNode =  new Return(node, true);
                }else{
                    newNode =  new Return(node, false);
                }
            }
            else if(type == Type.IF){
                newNode = new If(node);
            }
            else {
                newNode = new Node(type, node);
            }
            if(direction == "left"){
                if(node.left != null){
                    newNode.left = node.left;
                }
                node.left = newNode;
            }else if(direction == "right"){
                if(node.right != null){
                    newNode.right = node.right;
                }
                node.right = newNode;
            }
            node.isCurrentNode = false;
            return tree;
    }



    public Node updateOp(Node tree, Operator.Type type ){
        Node node = findCurNode(tree);
        ((Operator)node).opNodeType = type;
        if((type == Operator.Type.MORETHAN) || (type == Operator.Type.LESSTHAN) || (type == Operator.Type.MORETHANEQUALS) || (type == Operator.Type.LESSTHANEQUALS) ||(type == Operator.Type.NOTEQUALS) ||  (type == Operator.Type.EQUALS)){
            ((Operator)node).isConditional = true;
        }
        return tree;
    }

    public Node updateVarVal(Node tree, String value){
        Node node = findCurNode(tree);
        ((VarVal)node).value = value;
        return tree;
    }


    public Node updateDec(Node tree, Dec.Type type){
        Node node = findCurNode(tree);
        ((Dec)node).varNodeType = type;
        return tree;
    }

    public Node updateFuncType(Node tree, Function.Type type){
        Node node = findCurNode(tree);
        ((Function)node).funcType = type;
        return tree;
    }

    public Node updateFuncName(Node tree, String name){
        Node node = findCurNode(tree);
        ((Function)node).name = name;
        return tree;
    }

    public Node updateFuncIsDec(Node tree, Boolean isDec){
        Node node = findCurNode(tree);
        ((Function)node).isDec = isDec;
        return tree;
    }

    public Node setFuncEndDec(Node tree, Boolean decFinished){
        ((Function)tree).decFinished = decFinished;
        return tree;
    }

    public Node setFuncParamFinished(Node tree, Boolean paramsFinished){
        ((Function)tree).paramsFinished = paramsFinished;
        return tree;
    }

    public Print returnPrintNode(Node node){
        while(node.nodeType != Node.Type.PRINT){
            node = node.parent;
        }
        return ((Print)node);
    }

    public Eval returnEvalNode(Node node){
        while(node.nodeType != Node.Type.EVAL){
            node = node.parent;
        }
        return ((Eval)node);
    }

    public Eval returnEvalVar(Node node){
        while(node.nodeType != Node.Type.EVAL){
            node = node.parent;
        }
        return ((Eval)node);
    }





    public Node updatePrint(Node tree, Print.Type type){
        Node node = findCurNode(tree);
        node = returnPrintNode(node);
        ((Print)node).printNodeType = type;
        return tree;
    }

    public Node updateEval(Node tree, Eval.Type type){
        Node node = findCurNode(tree);
        ((Eval)node).evalNodeType = type;
        return tree;
    }

    public Node updateVarType(Node tree, Variable.Type type){
        Node node = findCurNode(tree);
        ((Variable)node).varNodeType = type;
        return tree;
    }

    public Node deleteEnd(Node tree){
        while (tree.parent.nodeType != Type.NEWLINE){
            tree = tree.parent;
        }
        tree = tree.parent;
        tree = tree.parent;
        if(tree.left != null) {
            if (tree.left.nodeType == Type.NEWLINE) {
                tree.left = null;
                tree.parent.right = tree.right;
                tree.right.parent = tree.parent;
                return tree;
            }
        }
       if(tree.right != null) {
            if (tree.right.nodeType == Type.NEWLINE) {
                if(((Newline)tree.right).newlineNodeType != Newline.Type.ELSE) { //Fix problem when you couldn't delete else from close bracket
                    tree.left.parent = tree.parent;
                    tree.parent.left = tree.left;
                }
                tree.right = null;
                return tree;
            }
        }

        return tree;
    }



    public Node findLine(Node tree, Integer lineNumber, String function){
        if(lineNumber == 0){
            tree.isCurrentNode = true;
        }else {
//        Boolean endTree = false;
            //      Boolean elseTree = false;
            if (tree.left != null) {
                if (tree.left.nodeType.equals(Node.Type.NEWLINE)) {
                    Node newLineNode = tree.left;
                    Newline.Type newLineType = ((Newline) newLineNode).newlineNodeType;
                    Log.d("Newline", " left");
                    numberOfNewLines += 1;
                    if (numberOfNewLines ==
                            lineNumber) {
                        if (newLineType == Newline.Type.ELSEEND || newLineType == Newline.Type.IFEND || newLineType == Newline.Type.FOREND  || newLineType == Newline.Type.FUNCEND) {
                            if (function.equals("delete")) {
                                tree = tree.deleteEnd(tree.left);
                            } else if (function.equals("setCurrent")) {
                                if (newLineType == Newline.Type.FOR) {
                                    tree.left.left.left.isCurrentNode = true;
                                }
                                if (newLineType == Newline.Type.FOREND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "FORLOOP");
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                } else if (newLineType == Newline.Type.IFEND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "IF");
                                   // Node node = tree.findCurNode(tree);
                                  //  ((If)node).cameFromElse = true;
                                    ((Newline)newLineNode).stop = true;
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                } else if (newLineType == Newline.Type.ELSEEND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "IF");
                                  //  Node node = tree.findCurNode(tree);
                                  //  ((If)node).cameFromElse = false;
                                    ((Newline)newLineNode).stop = false;
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                }else if (newLineType == Newline.Type.FUNCEND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "FUNCTION");
                                    //  Node node = tree.findCurNode(tree);
                                    //  ((If)node).cameFromElse = false;
                                   // ((Newline)newLineNode).stop = false;
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                }
                            }
                        } else if (newLineType == Newline.Type.FOR && function.equals("setCurrent")) {
                            tree.left.left.left.isCurrentNode = true;
                        } else if (newLineType == Newline.Type.ELSE && function.equals("setCurrent")) {
                            tree.left.right.isCurrentNode = true;
                        } else if (newLineType == Newline.Type.IF && function.equals("setCurrent")) {
                            tree.left.left.left.right.left.isCurrentNode = true;
                        }else if (newLineType == Newline.Type.FUNCTION && function.equals("setCurrent")) {
                            tree.left.left.right.left.isCurrentNode = true;
                        }else {
                            if (function.equals("delete")) {
                                tree.left = null;
                                if(tree.right != null) {
                                    tree.parent.right = tree.right;
                                    tree.right.parent = tree.parent;
                                }
                            } else if (function.equals("setCurrent")) {
                                tree.isCurrentNode = true;
                            }
                        }
                        return tree;
                    }
                }
                findLine(tree.left, lineNumber, function);

            }

            if (tree.right != null) {
                if (tree.right.nodeType.equals(Node.Type.NEWLINE)) {
                    Node newLineNode = tree.right;
                    Newline.Type newLineType = ((Newline) newLineNode).newlineNodeType;
                    Log.d("Newline", " right");
                    numberOfNewLines += 1;
                    if (numberOfNewLines ==
                            lineNumber) {
                        if (newLineType == Newline.Type.ELSEEND || newLineType == Newline.Type.IFEND || newLineType == Newline.Type.FOREND  || newLineType == Newline.Type.FUNCEND) {
                            if (function.equals("delete")) {
                                tree = tree.deleteEnd(tree.right);
                            } else if (function.equals("setCurrent")) {
                                if (newLineType == Newline.Type.FOR) {
                                    tree.left.left.left.isCurrentNode = true;
                                } else if (newLineType == Newline.Type.FOREND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "FORLOOP");
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                } else if (newLineType == Newline.Type.IFEND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "IF");
                                  //  Node node = tree.findCurNode(tree);
                                   // ((If)node).cameFromElse = true;
                                    ((Newline)newLineNode).stop = true;
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                } else if (newLineType == Newline.Type.ELSEEND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "ELSE");
                                    tree = tree.moveUpTreeLimitNode(tree, "END");
                                    tree = tree.moveUpTreeLimitNode(tree, "NEWLINE");
                                    newLineNode = tree.findCurNode(tree);
                                    ((Newline)newLineNode).stop = false;
                                    tree = tree.moveUpTreeLimitNode(tree, "IF");
                                 //   Node node = tree.findCurNode(tree);
                                 //   ((If)node).cameFromElse = false;
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                }else if (newLineType == Newline.Type.FUNCEND) {
                                    tree = tree.moveUpTreeLimitNode(tree, "FUNCTION");
                                    //  Node node = tree.findCurNode(tree);
                                    //  ((If)node).cameFromElse = false;
                                    // ((Newline)newLineNode).stop = false;
                                    tree = tree.moveUpTreeLimitNode(tree, "SEQ");
                                }
                            }
                        }else if (newLineType == Newline.Type.FOR && function.equals("setCurrent")) {
                            tree.left.left.left.isCurrentNode = true;
                        } else if (newLineType == Newline.Type.ELSE && function.equals("setCurrent")) {
                            tree.right.right.isCurrentNode = true;
                        } else if (newLineType == Newline.Type.IF && function.equals("setCurrent")) {
                            tree.left.left.left.right.left.isCurrentNode = true;
                        } else if (newLineType == Newline.Type.FUNCTION && function.equals("setCurrent")) {
                            tree.left.left.right.left.isCurrentNode = true;
                        } else {
                            if (function.equals("delete")) {
                                tree.right = null;
                                if(tree.left != null) {
                                    tree.left.parent = tree.parent;
                                    tree.parent.left = tree.left;
                                }
                            } else if (function.equals("setCurrent")) {
                                tree.isCurrentNode = true;
                            }
                        }
                        return tree;
                    }
                }
                findLine(tree.right, lineNumber, function);

            }
        }
        return tree;

    }

    public void clearCameFromElse(Node tree){
       /* if(tree.nodeType == Node.Type.IF){
            ((If)tree).cameFromElse = false;
        }
        if(tree.right != null){
            clearCameFromElse(tree.right);
        }
        if(tree.left != null){
            clearCameFromElse(tree.left);
        }*/

    }



    public Node changeCurrentNode(Node tree, Integer lineNumber){
        tree = clearCurrentNode(tree);
      //  tree.findCurNode(tree).isCurrentNode = false;
        numberOfNewLines = 0;
        tree = findLine(tree, lineNumber, "setCurrent");
//        clearCameFromElse(tree);
        numberOfNewLines = 0;
        return tree;
    }

    public Node clearCurrentNode(Node tree){
        if (tree.left != null){
            if(tree.left.isCurrentNode == true){
                tree.left.isCurrentNode = false;
                return tree;
            }else {
                clearCurrentNode(tree.left);
            }
        }
        if (tree.right != null){
            if(tree.right.isCurrentNode == true){
                tree.right.isCurrentNode = false;
                return tree;
            }else {
                clearCurrentNode(tree.right);
            }
        }
        return tree;

    }

    public Node countNewLines(Node tree){
        if (tree.left != null){
            if(tree.left.nodeType.equals(Node.Type.NEWLINE)){
                Log.d("Newline", " left");
                numberOfNewLinesPostDelete += 1;
            }
            countNewLines(tree.left);
        }
        if (tree.right != null){
            if(tree.right.nodeType.equals(Node.Type.NEWLINE)){
                Log.d("Newline", " right");
                numberOfNewLinesPostDelete += 1;
            }
            countNewLines(tree.right);
        }
        return tree;

    }
    public Boolean doCurrentNodeLineNumberCount(Node tree, Boolean curNodeFound, Boolean isIf){
        if(tree.isCurrentNode){
            curNodeFound = true;
            if(tree.nodeType == Node.Type.SEQ){

                if(tree.left != null) {
                    numberOfNewLinesBeforeCurNode += 1;
                    Log.d("added new one ", tree.nodeType.toString());
                    if(tree.left.left != null) {
                        if (tree.left.left.nodeType == Node.Type.IF || tree.left.left.nodeType == Node.Type.FUNCTION) {
                            isIf = true;
                        }
                    }
                    doCurrentNodeLineNumberCount(tree.left, false, isIf);
                }
            }
        }if(!curNodeFound){
            if (tree.left != null && !curNodeFound){
                if(tree.left.nodeType.equals(Node.Type.NEWLINE)){
                    Log.d("Newlineleft after ", tree.nodeType.toString());
                    numberOfNewLinesBeforeCurNode += 1;
                }
                        curNodeFound = doCurrentNodeLineNumberCount(tree.left, curNodeFound, isIf);

            }
            if (tree.right != null && !curNodeFound){
                if(tree.right.nodeType.equals(Node.Type.NEWLINE)){
                    Log.d("Newrightleft after ", tree.nodeType.toString());
                    numberOfNewLinesBeforeCurNode += 1;
                    if(isIf){
                        if(((Newline)tree.right).stop == true){
                          //  ((Newline)tree.right).stop = false;
                            return curNodeFound;
                        }
                    }
                }
                if(!curNodeFound) {
                    curNodeFound = doCurrentNodeLineNumberCount(tree.right, curNodeFound, isIf);
                }
            }
        }
        return curNodeFound;
    }


    public Integer getLineNumberOfCurrentNode(Node tree){
        numberOfNewLinesBeforeCurNode = 0;
        doCurrentNodeLineNumberCount(tree, false, false);
        return numberOfNewLinesBeforeCurNode;
    }


    public Node delete(Node tree, Integer lineNumber){
        numberOfNewLines = 0;
        tree = findLine(tree, lineNumber, "delete");
        numberOfNewLinesPostDelete = 0;
        countNewLines(tree);
        numberOfNewLines = 0;
        tree = changeCurrentNode(tree, numberOfNewLinesPostDelete);
        numberOfNewLinesPostDelete = 0;
        numberOfNewLines = 0;
        return tree;
    }






    public Node setVarName(Node tree, String value){
        Node node = findCurNode(tree);
        ((Variable)node).name = value;
        return tree;
    }

    public Node setVarValue(Node tree, String value){
        Node node = findCurNode(tree);
        ((Variable)node).value = value;
        return tree;
    }

    public Variable.Type getVarType(Node node){
        while(node.nodeType != Node.Type.VAR){
            node = node.parent;
        }
        return ((Variable)node).varNodeType;
    }


    public Variable returnAssignVar(Node node){
        while(node.nodeType != Node.Type.ASSIGN){
            node = node.parent;
        }
        return ((Variable)node.parent);
    }




    public Variable returnDecVar(Node node){

        while(node.nodeType != Node.Type.DEC){
            node = node.parent;
        }
        return ((Variable)node.left);
    }




    public Boolean isXbeforeY(Node node, Node.Type x, Node.Type y){
      //  Node node = findCurNode(tree);
        while(node.nodeType != x || node.nodeType != y){
            if(node.nodeType == x){
                return true;
            }else if (node.nodeType == y){
                return false;
            }else if(node.nodeType == Node.Type.ROOT){
                return false;
            }
            node = node.parent;
        }
        return false;
    }

    public Boolean hasConditionOperatorBeenUsed(Node node){
        //  Node node = findCurNode(tree);
        Boolean endWhile = false;
        while(endWhile == false){
            if(node.nodeType == Type.OP){
                if(((Operator)node).isConditional == true) {
                    return true;
                }
            }else if (node.nodeType == Type.SEQ){
                return false;
            }else if(node.nodeType == Type.ROOT){
                return false;
            }
            node = node.parent;
        }
        return false;
    }



    public Node moveUpTreeLimit(Node tree, String limit){
        Log.e("ADDNODE", "moving up tree");
        Node node = findCurNode(tree);
        /*node.isCurrentNode = false;
        node = node.parent;
        node.isCurrentNode = true;*/
        while (!node.nodeType.toString().equals(limit)){
           Log.e("DEBUG", "Current node before = " + node.nodeType.toString());
           node.isCurrentNode = false;
           node.parent.isCurrentNode = true;
            node = node.parent;

           // Log.e("DEBUG", "Current node = " + node.parent.nodeType.toString());

        }
        return tree;
    }

    public Node moveUpTreeLimitNode(Node tree, String limit){
        Log.e("ADDNODE", "moving up tree");

        while (!tree.nodeType.toString().equals(limit)){
            Log.e("DEBUG", "Current node before = " + tree.nodeType.toString());
            tree.isCurrentNode = false;
            tree.parent.isCurrentNode = true;
            tree = tree.parent;

            Log.e("DEBUG", "Current node = " + tree.parent.nodeType.toString());

        }
        return tree;
    }



    public Node moveUpTreeSteps(Node tree, Integer limit){
        Node node;
        for(int i  = 0; i < limit; i++) {
            node = findCurNode(tree);
            Log.d("DEBUG", "Current node before = " + node.nodeType.toString());
            node.isCurrentNode = false;
            node.parent.isCurrentNode = true;
            Log.d("DEBUG", "Current node = " + node.parent.nodeType.toString());
        }
        return tree;

    }

    public Node moveDownOneStep(Node tree, String direction){
        Node node;
        node = findCurNode(tree);
        node.isCurrentNode = false;
        if(direction.equals("left")){
            node.left.isCurrentNode = true;
        }else if(direction.equals("right")){
            node.right.isCurrentNode = true;
        }else{
            Log.d("THERE", "IS A PROBLEM");
        }
        return tree;
    }

    public Node moveDownDirectionLimit(Node tree, String direction, String limit){
        Node node;
        node = findCurNode(tree);
        while(!node.nodeType.toString().equals(limit)) {
            node.isCurrentNode = false;
            if (direction.equals("left")) {
                node.left.isCurrentNode = true;
            } else if (direction.equals("right")) {
                node.right.isCurrentNode = true;
            } else {
                Log.d("THERE", "IS A PROBLEM");
            }
            node = findCurNode(tree);
        }
        return tree;
    }

    public Node moveUpOneStep(Node tree){
        Node node;
        node = findCurNode(tree);
        node.isCurrentNode = false;
        node.parent.isCurrentNode = true;
        return tree;
    }



    public Node moveUpToStartOfForLoop(Node tree){
        Node node;
        while(findCurNode(tree).nodeType != Type.FORLOOP){
            node = findCurNode(tree);

            node.isCurrentNode = false;
            node.parent.isCurrentNode = true;
        }
        return tree;
    }




    public Node removeChildren(Node tree, String direction){
        Node node = findCurNode(tree);
        if(direction == "left") {
            node.left = null;
        }
        if(direction == "right") {
            node.right = null;
        }
        return tree;
    }




}
