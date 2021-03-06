package com.example.jonny.myfirstapp;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by Jonny on 18/08/2015.
 */
public class VarTree extends Activity {
    ArrayList<VarTree> children;
    ArrayList<Variable> variables;
    VarTree parent;
    Boolean tempCurrentScope;
    Boolean isCurrentScope;

    public VarTree(VarTree another, Boolean copy) {
        this.children = another.children; // you can access
        this.variables = another.variables;
        this.parent = another.parent;
        this.tempCurrentScope = another.tempCurrentScope;
        this.isCurrentScope = another.isCurrentScope;
    }

    public VarTree ( VarTree parent){
        this.parent = parent;
        this.children = null;
        this.variables = new ArrayList<Variable>();
        this.tempCurrentScope = true;
        this.isCurrentScope = false;
    }

    public VarTree findTempCurVarNode(VarTree tree){
        VarTree newTree = null;
        if (tree.tempCurrentScope == true){
            return tree;
        }
        if(tree.children != null) {
            for (int i = 0; i < tree.children.size(); i++) {
                newTree = findTempCurVarNode(tree.children.get(i));
                if (newTree != null) {
                    return newTree;
                }
            }
        }
        return newTree;
    }

    public VarTree clearVarTreeIsCurrent(VarTree varTree){
        varTree.isCurrentScope = false;
        if(varTree.children != null) {
            for (int i = 0; i < varTree.children.size(); i++) {
                clearVarTreeIsCurrent(varTree.children.get(i));
            }
        }
        return varTree;
    }

    public VarTree findCurVarNode(VarTree tree){
        VarTree newTree = null;
        if (tree.isCurrentScope == true){
            return tree;
        }
        if(tree.children != null) {
            for (int i = 0; i < tree.children.size(); i++) {
                newTree = findCurVarNode(tree.children.get(i));
                if (newTree != null) {
                    return newTree;
                }
            }
        }
        return newTree;
    }


    public VarTree addNode(VarTree varTree) {
        VarTree varNode = findTempCurVarNode(varTree);
        VarTree newNode = new VarTree(varNode);
        varNode.tempCurrentScope = false;
        if(varNode.children == null) {
            varNode.children = new ArrayList<VarTree>();
        }
        varNode.children.add(newNode);
        return varTree;
    }



}
