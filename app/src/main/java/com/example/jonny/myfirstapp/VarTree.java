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
    Boolean isCurrent;

    public VarTree ( VarTree parent){
        this.parent = parent;
        this.children = new ArrayList<VarTree>();
        this.variables = new ArrayList<Variable>();
    }

}
