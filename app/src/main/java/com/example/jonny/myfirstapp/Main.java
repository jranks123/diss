package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 19/03/2015.
 */

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.app.Activity;
import android.widget.*;
import android.util.Log;

import java.util.ArrayList;


public class Main extends Activity {

    Node tree;
    Button btnPrint;
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnSemicolon;
    Button btnLoops;
    Button btnVar;
    Button btnNewVar;
    Button btnNewVarInt;
    Button btnNewVarString;
    Button btnNewVarBool;
    Button btnPrintBack;
    Button btnPrintVar;
    Button btnPrintText;
    Button btnPrintTree;
   // Button btnEnterVarStringName;
    Button btnEnterVarName;
    Button btnEnterVarValue;
  //  Button btnEnterVarIntName;
    //Button btnEnterVarIntValue;
    Button btnStringVarEquals;
    Button btnIntVarEquals;
    Button btnPrintTextMenu;
    String tempVarName;
    EditText edtEnterString;
    Button btnRun;
    Button btnFor;
    Button btnForNewVar;
    Button btnForNewVarEnter;
    Button btnForNewVarValueEnter;
    Button btnForNewVarValueUpperEnter;
    Button btnForLess;
    Button btnForGreater;
    Button btnForPlus;
    Button btnForMinus;
    Button btnForEndLoop;
    Boolean forLoopIsOpen;

    Button btnOperator;
    Button btnOperatorAdd;
    Button btnOperatorSub;
    Button btnOperatorMulti;
    Button btnOperatorDiv;

    Button btnEnterText;
    Button btnEquals;


    Button btnExistingVar;

    Button btnTypeInput;

    Variable newVar;
    Button btnEnterString;
    TextView code;
    TextView output;
    ArrayList<Button> printMenu;
    ArrayList<Button> homeMenu;
    ArrayList<Button> varButtons;
    ArrayList<Variable> variables;
    ArrayList<Boolean> openLoops;
    String tempString1;
    String s;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tree = new Node(Node.Type.ROOT, null);
        btnPrint =(Button)findViewById(R.id.print);
        btnPrintBack = (Button)findViewById(R.id.printBack);
        btnLoops = (Button)findViewById(R.id.loops);
        btnVar = (Button)findViewById(R.id.var);
        btnNewVar = (Button) findViewById(R.id.varNew);
        btnNewVarInt = (Button) findViewById(R.id.varNewInt);
        btnNewVarString = (Button) findViewById(R.id.varNewString);
        btnNewVarBool = (Button) findViewById(R.id.varNewBool);
        btnPrintVar =  (Button) findViewById(R.id.btnPrintVar);
        btnPrintText =  (Button) findViewById(R.id.btnPrintText);
        variables = new ArrayList<Variable>();
        openLoops = new ArrayList<Boolean>();
        btnSemicolon =(Button)findViewById(R.id.semicolon);
        btnEnterString = (Button)findViewById(R.id.btnEnterTextString);
        edtEnterString = (EditText) findViewById(R.id.edtEnterTextString);
      //  btnEnterVarStringName = (Button) findViewById(R.id.btnEnterVarStringName);
        btnEnterVarValue = (Button) findViewById(R.id.btnEnterVarValue);
        btnEnterVarName = (Button) findViewById(R.id.btnEnterVarName);

        // btnEnterVarIntName = (Button) findViewById(R.id.btnEnterVarIntName);
     //   btnEnterVarIntValue = (Button) findViewById(R.id.btnEnterVarIntValue);
        btnStringVarEquals = (Button) findViewById(R.id.btnStringVarEquals);
        btnIntVarEquals = (Button) findViewById(R.id.btnIntVarEquals);

        btnEnterText = (Button) findViewById(R.id.btnEnterText);
        btnEquals = (Button) findViewById(R.id.btnEquals);

        btnExistingVar = (Button) findViewById(R.id.btnExistingVar);
        btnTypeInput = (Button) findViewById(R.id.btnTypeInput);

        btnForNewVar = (Button) findViewById(R.id.btnForNewVar);
        btnForNewVarEnter = (Button) findViewById(R.id.btnForNewVarEnter);
        btnForNewVarValueEnter = (Button) findViewById(R.id.btnForNewVarValueEnter);
        btnForNewVarValueUpperEnter = (Button) findViewById(R.id.btnForNewVarValueUpperEnter);
        btnForLess = (Button) findViewById(R.id.btnForLess);
        btnForGreater = (Button) findViewById(R.id.btnForGreater);
        btnForPlus = (Button) findViewById(R.id.btnForPlus);
        btnForMinus = (Button) findViewById(R.id.btnForMinus);
        btnForEndLoop = (Button) findViewById(R.id.btnForEndLoop);
        forLoopIsOpen = false;

        btnOperator = (Button) findViewById(R.id.btnOperator);
        btnOperatorAdd = (Button) findViewById(R.id.btnOperatorAdd);
        btnOperatorSub = (Button) findViewById(R.id.btnOperatorSub);
        btnOperatorMulti = (Button) findViewById(R.id.btnOperatorMulti);
        btnOperatorDiv = (Button) findViewById(R.id.btnOperatorDiv);

        btnRun = (Button) findViewById(R.id.run);
        varButtons = new ArrayList<Button>();
        btnPrintTextMenu = (Button) findViewById(R.id.btnPrintTextMenu);
        homeMenu = new ArrayList<Button>();
        homeMenu.add(btnPrint);
        homeMenu.add(btnLoops);
        homeMenu.add(btnVar);
        printMenu = new ArrayList<Button>();
        printMenu.add(btnPrintBack);
        printMenu.add(btnSemicolon);
        printMenu.add(btnEnterString);
        code = (TextView)findViewById(R.id.codeText);
        code.setMovementMethod(new ScrollingMovementMethod());
        output = (TextView) findViewById(R.id.runText);
        output.setMovementMethod(new ScrollingMovementMethod());
        btnPrintTree = (Button)findViewById(R.id.printTree);
        tempString1 = "HELLOOO";
        btnFor = (Button) findViewById(R.id.btnFor);

        // tempAddVar();
    }




    public void hideButtons(ArrayList<Button> b){
        for(int i = 0; i < b.size(); i++ ){
            b.get(i).setVisibility(View.GONE);
        }
    }

    public void showButtons(ArrayList<Button> b){
        for(int i = 0; i < b.size(); i++ ){
            b.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void clearVar(){
        /*for(int i = 0; i < variables.size(); i++)
            variables.get(i).value = null;*/
        variables = new ArrayList<Variable>();
    }



    public boolean checkVarExists(String var, Variable.Type type){
        for(int i = 0; i < variables.size(); i++){
            Variable v = variables.get(i);
            if(v.name.equals(var) && v.varNodeType == type ){
                return true;
            }
        }
        return false;
    }





   public void hideVarButtons(){
        for(int i = 0; i < varButtons.size(); i++){
               varButtons.get(i).setVisibility(View.GONE);
        }
    }


    public void updateVariableValue(String value, String name, Variable.Type type){
        for(int i = 0; i < variables.size(); i++){
            Variable v = variables.get(i);
            if(v.name.equals(name) && v.varNodeType == type){
               v.value = value;
            }
        }
    }

    public String getVariableValue(String name, Variable.Type type){
        for(int i = 0; i < variables.size(); i++){
            Variable v = variables.get(i);
            if(v.name.equals(name) && v.varNodeType == type){
                if(v.value != null) {
                    return v.value;
                }
            }
        }
        s = "<i>" + name + "<i>";
        return (null);
    }

    public void backTree(Node tree, String treeLimit, int steps, String childToDelete) {
        tree = tree.moveUpTreeLimit(tree, treeLimit);
        tree = tree.moveUpTreeSteps(tree, steps);
        tree = tree.removeChildren(tree, childToDelete);
    }


    public void visitNode(Node tree){
        Node.Type nodeType = tree.nodeType;
        if (nodeType == Node.Type.PRINT){
            code.append(Html.fromHtml(getString(R.string.print)));
        }
        else if(nodeType == Node.Type.STRING){
            code.append("\"");
            code.append(((Str)tree).value);
            code.append("\"");
        }
        else if(nodeType == Node.Type.VARVAL){
            //(((Variable)node.parent.parent).value) = value;
            Variable.Type type = null;
            if(((VarVal)tree).value != null) {
                if (tree.returnAssignVar(tree).varNodeType == Variable.Type.STRING) {
                    type = Variable.Type.STRING;
                    code.append("\"");
                    code.append(((VarVal) tree).value);
                    code.append("\"");
                } else if (tree.returnAssignVar(tree).varNodeType == Variable.Type.INT) {
                    type = Variable.Type.INT;
                    code.append(((VarVal) tree).value);
                }
                Variable v = (tree.returnAssignVar(tree));
                if (!checkVarExists(v.name, v.varNodeType)) {
                    Variable var = new Variable(null, type, v.name, null);
                    variables.add(var);
                }
            }
        }
        else if (nodeType == Node.Type.SMCLN){
                Variable.Type type = null;
                code.append(" ;\n");
             //   if( tree.parent.parent.nodeType == Node.Type.DEC ){
                if(tree.isXbeforeY(tree, Node.Type.DEC, Node.Type.SEQ)){
                    Variable v;// = new Variable(null, null, null, null);
                        try {
                             v = tree.returnAssignVar(tree);
                        }catch (NullPointerException e){
                            //for case when there is a declaration without an assignment
                                v = tree.returnDecVar(tree);
                        }
                    type = v.varNodeType;
                    if (!checkVarExists(v.name, v.varNodeType)) {
                            Variable var = new Variable(null, type, v.name, null);
                            variables.add(var);
                        }
                }

        }
        else if(nodeType == Node.Type.DEC){
            switch(((Dec)tree).varNodeType){
                case STRING:
                    code.append(Html.fromHtml(getString(R.string.string)));
                    break;
                case INT:
                    code.append(Html.fromHtml(getString(R.string.integer)));
                    break;
                default:
                    break;
            }
        }
        else if(nodeType == Node.Type.FORLOOP){
            switch(((Loops)tree).varNodeType){
                case FOR:
                    code.append("\n" + Html.fromHtml(getString(R.string.forLoop)));
                    if(((Loops) tree).limiter != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(Html.fromHtml(s) + " = ");
                        if(!checkVarExists(((Loops) tree).limiter.toString(), Variable.Type.INT)){
                            String name = ((Loops) tree).limiter.toString();
                            Variable v = new Variable(null, Variable.Type.INT, name, null );
                            variables.add(v);
                        }
                    }
                    if(((Loops) tree).lowerLim != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(((Loops) tree).lowerLim.toString() + "; " + Html.fromHtml(s));
                    }
                    if(((Loops) tree).operator != null){
                        code.append(" " + ((Loops) tree).operator.toString() + " ");
                    }
                    if(((Loops) tree).upperLim != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(((Loops) tree).upperLim.toString() + "; " + Html.fromHtml(s));
                    }
                    if(((Loops) tree).plusOrMinus != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(" " + ((Loops) tree).plusOrMinus.toString() + " ) {\n");
                    }
                    break;
            }
        }
        else if(nodeType == Node.Type.END){
            code.append("}\n\n");
        }
        else if(nodeType == Node.Type.VAR){
            if (((Variable)tree).name != null){
                s = "<i>" + ((Variable)tree).name + "</i>";
                code.append(Html.fromHtml(s));
            }
        }
        else if(nodeType == Node.Type.ASSIGN){
            code.append(" = ");
        }
        else if(nodeType == Node.Type.OP && ((Operator)tree).opNodeType != null){
            String op = ((Operator) tree).opNodeType.toString();
            if(op.equals("ADD")){
                code.append(" + ");
            }
            else if(op.equals("SUB")){
                code.append(" - ");
            }
            else if(op.equals("MULTI")){
                code.append(" * ");
            }
            else if(op.equals("DIV")){
                code.append(" / ");
            }
        }

    }

    public void visitNodeRun(Node tree){
       if (tree.nodeType == Node.Type.PRINT) {
           try {
               if (tree.right.nodeType == Node.Type.STRING) {
                   output.append(((Str) tree.right).value);
                   output.append("\n");
               }

           } catch (NullPointerException e) {

           }

           try {
               if (tree.left.nodeType == Node.Type.EVAL) {
                   if ((tree.left.left) != null) {

                       String varName = ((Variable) tree.left.left).name;
                       String varValue = getVariableValue(varName, ((Variable) tree.left.left).varNodeType);
                       output.append(varValue + "\n");
                   } else {
                       output.append("trolololsds");
                   }
               }
           } catch (NullPointerException e) {

           }
       }
        if(tree.nodeType == Node.Type.ASSIGN){
            String varValue = ((VarVal) tree.left.right).value;
            String varName = ((Variable)tree.parent).name;
            Variable.Type type = ((Variable)tree.parent).varNodeType;
            updateVariableValue(varValue, varName, type);
        }
        if(tree.nodeType == Node.Type.DEC){
            Variable v = ((Variable)tree.left);
            Variable.Type type = v.varNodeType;
            String name = v.name;
            if(!checkVarExists(name, type)) {
                Variable var = new Variable(null, type, name, null);
                variables.add(var);
            }
        }
        if(tree.nodeType == Node.Type.FORLOOP){
            String varValue = ((Loops) tree).lowerLim.toString();
            String varName = ((Loops) tree).limiter;
            updateVariableValue(varValue, varName, Variable.Type.INT);
        }

    }



    public void DisplayTree(Node tree){

        Boolean leftChild = false;
        Boolean rightChild = false;
        if (tree.left != null){
            leftChild = true;
            Log.d("Going left", tree.left.nodeType.toString());
            if(tree.left.nodeType.equals(Node.Type.VAR)){
                Log.d("type is", ((Variable) tree.left).varNodeType.toString());
            }
            if (tree.left.isCurrentNode){
                Log.e("And IS", "CURRENT " + tree.left.nodeType.toString());
            }else{
           //     Log.e("IS Not ", "CURRENT");
            }
            DisplayTree(tree.left);

        }
        if (tree.right != null){
            rightChild = true;
            Log.d("Going right", tree.right.nodeType.toString());
            if(tree.right.nodeType.equals(Node.Type.VAR)){
                Log.d("type is" , ((Variable)tree.right).varNodeType.toString());
            }
            if (tree.right.isCurrentNode){
                Log.e("And IS", "CURRENT " + tree.right.nodeType.toString());
            }else{
             //   Log.e("IS Not ", "CURRENT");
            }
            DisplayTree(tree.right);

        }
        if(!leftChild) {
            Log.d("no l children for ", tree.nodeType.toString());
        }
        if(!rightChild){
            Log.d("No r children for ", tree.nodeType.toString());

        }
    }



    public void printTree(Node tree){
        visitNode(tree);
        if (tree.left != null){
            printTree(tree.left);
        }
        if (tree.right != null){
            printTree(tree.right);
        }
    }

    public void runCode(Node tree){
        visitNodeRun(tree);
        if (tree.left != null) {
                if(tree.left.nodeType == Node.Type.FORLOOP){
                    Integer loopAmount = Math.abs(((Loops) tree.left).upperLim - ((Loops) tree.left).lowerLim);
                    String varValue = ((Loops) tree.left).lowerLim.toString();
                    String varName = ((Loops) tree.left).limiter;
                    if(!checkVarExists(varName, Variable.Type.INT)) {
                        variables.add(new Variable(null, Variable.Type.INT, varName, varValue));
                    }else{
                        updateVariableValue(varValue, varName, Variable.Type.INT);
                    }
                    for (int i = 0; i < loopAmount; i++) {
                        runCode(tree.left.right);
                        if(i != loopAmount-1) {
                            if (((Loops) tree.left).plusOrMinus == "--") {
                                String newValue = String.valueOf(Integer.parseInt(getVariableValue(((Loops) tree.left).limiter, Variable.Type.INT)) - 1);
                                updateVariableValue(newValue, ((Loops) tree.left).limiter, Variable.Type.INT);
                            } else {
                                String newValue = String.valueOf(Integer.parseInt(getVariableValue(((Loops) tree.left).limiter, Variable.Type.INT)) + 1);
                                updateVariableValue(newValue, ((Loops) tree.left).limiter, Variable.Type.INT);
                            }
                        }
                    }

                }else{
                    runCode(tree.left);
                }
        }
        if (tree.right != null){
            runCode(tree.right);
        }
    }



    public void clearButtons(){
        LinearLayout col2 = (LinearLayout)findViewById(R.id.buttons);
        for (int i = 0; i < col2.getChildCount(); i++) {
            View a = col2.getChildAt(i);
            a.setVisibility(View.GONE);
        }
    }

    public void showVarButtons(Variable.Type varType){
        varButtons.clear();
        Node.Type nodeType = tree.findCurNode(tree).nodeType;
        if(nodeType != Node.Type.PRINT && nodeType != Node.Type.OP){
            if(!tree.isXbeforeY(tree.findCurNode(tree), Node.Type.EVAL, Node.Type.SEQ)) {
                btnNewVar.setVisibility(View.VISIBLE);
            }
        }
        LinearLayout ll = (LinearLayout) findViewById(R.id.buttons);
        for(int i = 0; i < variables.size(); i++) {
            if (varType == null || variables.get(i).varNodeType == varType){
                final Button b = new Button(this);
                s = "<b><i>" + variables.get(i).name + "</i></b>";
                b.setText(Html.fromHtml(s));
                b.setId(i);
                b.setContentDescription(variables.get(i).varNodeType.toString());
                if (variables.get(i).varNodeType == Variable.Type.INT) {
                    b.setBackgroundColor(0xFFFF0000);
                }
                b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                       /* if(tree.findCurNode(tree).nodeType == Node.Type.SEQ){
                            tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                        }*/
                        if (b.getContentDescription().equals(Variable.Type.STRING.toString())) {
                            tree = tree.addNode(tree, Node.Type.VAR, "left", "String");
                        }
                        if (b.getContentDescription().equals(Variable.Type.INT.toString())) {
                            tree = tree.addNode(tree, Node.Type.VAR, "left", "Int");
                        }
                        tree.setVarName(tree, b.getText().toString());
                        btnNewVar.setVisibility(View.GONE);
                        //  b.setVisibility(View.GONE);
                        if(tree.isXbeforeY(tree.findCurNode(tree), Node.Type.EVAL, Node.Type.SEQ)){
                            btnOperator.setVisibility(View.VISIBLE);
                        }
                        if (tree.findCurNode(tree).parent.parent.nodeType == Node.Type.SEQ) {
                            btnEquals.setVisibility(View.VISIBLE);
                        } else {
                            btnSemicolon.setVisibility(View.VISIBLE);
                        }
                        code.setText("");
                        if (tree != null) {
                            printTree(tree);
                        }
                        varButtons.add(b);
                        hideVarButtons();

                    }
                });
                ll.addView(b);
            }
        }
    }


    public void onBtnClicked(View v){

        Boolean clearScreen = false;
       // if((v.getId() != R.id.semicolon) && (v.getId() != R.id.run)){
       //     btnRun.setVisibility(View.GONE);
      //  }
        switch(v.getId()){
            case R.id.print:
                Log.d("DEBUG", "PRESS PRINT");
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", null);
                tree = tree.addNode(tree, Node.Type.PRINT, "left", null);
                tree = tree.addNode(tree, Node.Type.EVAL, "left", null);

                hideButtons(homeMenu);
                clearButtons();
                if(variables.size() > 0) {
                    btnVar.setVisibility(View.VISIBLE);
                }
                btnPrintTextMenu.setVisibility(View.VISIBLE);
                break;

            case R.id.btnPrintTextMenu:
                clearButtons();
                edtEnterString.setVisibility(View.VISIBLE);
                btnEnterString.setVisibility(View.VISIBLE);
                btnPrintBack.setVisibility(View.VISIBLE);
                break;

            case R.id.printBack:
                Log.d("DEBUG", "PRESS PRINT BACK");
                btnPrintBack.setVisibility(View.GONE);
                clearButtons();
                showButtons(homeMenu);
                edtEnterString.setVisibility(View.GONE);
                edtEnterString.setText("");
                backTree(tree, "SEQ", 1, "right");
                break;

            case R.id.run:
                output.setText("");
                runCode(tree);
                clearVar();
                break;


            case R.id.loops:
                clearButtons();
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", null);
                btnFor.setVisibility(View.VISIBLE);
                break;

            case R.id.btnFor:
                forLoopIsOpen = true;
                openLoops.add(true);
                clearButtons();
                tree = tree.addNode(tree, Node.Type.FORLOOP, "left", "For");
                //DisplayTree(tree);
                btnForNewVar.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForNewVar:
                clearButtons();
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarEnter.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForNewVarEnter:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).limiter = edtEnterString.getText().toString().trim();
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarValueEnter.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForNewVarValueEnter:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).lowerLim = Integer.parseInt(edtEnterString.getText().toString().trim());
                btnForLess.setVisibility(View.VISIBLE);
                btnForGreater.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForLess:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).operator = "<";
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarValueUpperEnter.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForGreater:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).operator = ">";
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarValueUpperEnter.setVisibility(View.VISIBLE);
                break;


            case R.id.btnForNewVarValueUpperEnter:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).upperLim = Integer.parseInt(edtEnterString.getText().toString().trim());
                btnForPlus.setVisibility(View.VISIBLE);
                btnForMinus.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForPlus:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).plusOrMinus = "++";
                showButtons(homeMenu);
                break;

            case R.id.btnForMinus:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).plusOrMinus = "--";
                showButtons(homeMenu);
                break;

            case R.id.btnForEndLoop:
                clearButtons();
                forLoopIsOpen = false;
                openLoops.remove(openLoops.size() - 1);
                tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpToStartOfForLoop(tree);
                tree = tree.moveUpOneStep(tree);
                tree = tree.moveUpOneStep(tree);
                //  btnRun.setVisibility(View.VISIBLE);
                showButtons(homeMenu);
                break;


            case R.id.clear:
                tree = new Node(Node.Type.ROOT, null);
                clearButtons();
                forLoopIsOpen = false;
                output.setText("");
                variables.clear();
                showButtons(homeMenu);
                break;

            case R.id.printTree:
                DisplayTree(tree);
                break;



            case R.id.semicolon:
                Log.d("DEBUG", "PRESS ;");
                tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
                tree = tree.moveUpTreeLimit(tree, "SEQ");
                clearButtons();
                showButtons(homeMenu);
                edtEnterString.setVisibility(View.GONE);
                break;

            case R.id.var:
                clearButtons();
                if(tree.findCurNode(tree).nodeType == Node.Type.SEQ || tree.findCurNode(tree).nodeType == Node.Type.ROOT){
                    tree = tree.addNode(tree, Node.Type.SEQ, "right", "none");
                    tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "none");
                }else if(tree.findCurNode(tree).nodeType == Node.Type.EVAL || tree.findCurNode(tree).nodeType == Node.Type.OP){
                    if (tree.returnAssignVar(tree.findCurNode(tree)).varNodeType == Variable.Type.STRING) {
                        tree.addNode(tree, Node.Type.VAR, "left", "String");
                    }else if (tree.returnAssignVar(tree.findCurNode(tree)).varNodeType == Variable.Type.INT) {
                        tree.addNode(tree, Node.Type.VAR, "left", "Int");
                    }
                }
                showVarButtons(null);
                break;

            case R.id.varNew:
                clearButtons();
                tree = tree.addNode(tree, Node.Type.DEC, "left", "none");
                break;

            case R.id.varNewString:
                tree = tree.updateDec(tree, Dec.Type.STRING);
                break;

            case R.id.varNewInt:
                tree = tree.updateDec(tree, Dec.Type.INT);
                break;


            case R.id.btnEnterVarName:
                if(((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.STRING ){
                    tree = tree.addNode(tree, Node.Type.VAR, "left", "String");
                }else if(((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.INT ){
                    tree = tree.addNode(tree, Node.Type.VAR, "left", "Int");
                }
                tree.setVarName(tree, edtEnterString.getText().toString().trim());
                clearButtons();
                break;



            case R.id.btnEquals:
                clearButtons();
                tree = tree.addNode(tree, Node.Type.ASSIGN, "right", null);
                tree = tree.addNode(tree, Node.Type.EVAL, "left", null);
                break;

            case R.id.btnTypeInput:
                tree = tree.addNode(tree, Node.Type.VARVAL, "right", null);
                break;


            case R.id.btnEnterVarValue:
                tree = tree.addNode(tree, Node.Type.VARVAL, "right", edtEnterString.getText().toString().trim());
                break;


            case R.id.btnEnterTextString:
                tree = tree.updateVarVal(tree, edtEnterString.getText().toString().trim());
                clearButtons();
                break;

            case R.id.btnOperator:
                tree = tree.addNode(tree, Node.Type.OP, "right", null);
                break;

            case R.id.btnOperatorAdd:
                tree = tree.updateOp(tree, Operator.Type.ADD);
                break;

            case R.id.btnOperatorSub:
                tree = tree.updateOp(tree, Operator.Type.SUB);
                break;

            case R.id.btnOperatorMulti:
                tree = tree.updateOp(tree, Operator.Type.MULTI);
                break;

            case R.id.btnOperatorDiv:
                tree = tree.updateOp(tree, Operator.Type.DIV);
                break;
        }

        edtEnterString.setText("");
        code.setText("");
        if(tree != null) {
            Node.Type currentNodeType = tree.findCurNode(tree).nodeType;
            printTree(tree);
            if(openLoops.size() > 0 && currentNodeType == Node.Type.SEQ){
                btnForEndLoop.setVisibility(View.VISIBLE);
            }
            if(openLoops.size() == 0 ){
                btnForEndLoop.setVisibility(View.GONE);
            }
          //  if((v.getId() == R.id.semicolon) || (v.getId() == R.id.btnForPlus)  || (v.getId() == R.id.btnForMinus || (v.getId() == R.id.run) || (v.getId() == R.id.clear))){
           if(currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.ROOT || (currentNodeType == Node.Type.FORLOOP )){
               if((currentNodeType == Node.Type.FORLOOP )){
                   if(((Loops) tree.findCurNode(tree)).plusOrMinus != null ){
                       btnLoops.setVisibility(View.VISIBLE);
                   }
               }else {
                   btnLoops.setVisibility(View.VISIBLE);
               }
            }else{
                btnLoops.setVisibility(View.GONE);
            }
            if(currentNodeType == Node.Type.SEQ && openLoops.size() == 0){
                btnRun.setVisibility(View.VISIBLE);
            }else{
                btnRun.setVisibility(View.GONE);
            }
            if(currentNodeType == Node.Type.OP && ((Operator) tree.findCurNode(tree)).opNodeType == null){
                clearButtons();
                if(tree.returnAssignVar(tree.findCurNode(tree)).varNodeType == Variable.Type.INT){
                    btnOperatorAdd.setVisibility(View.VISIBLE);
                    btnOperatorSub.setVisibility(View.VISIBLE);
                    btnOperatorMulti.setVisibility(View.VISIBLE);
                    btnOperatorDiv.setVisibility(View.VISIBLE);
                }else if (tree.returnAssignVar(tree.findCurNode(tree)).varNodeType == Variable.Type.STRING){
                    btnOperatorAdd.setVisibility(View.VISIBLE);
                }
            }else if(currentNodeType == Node.Type.OP && ((Operator) tree.findCurNode(tree)).opNodeType != null){
                clearButtons();
                btnTypeInput.setVisibility(View.VISIBLE);
                if(variables.size() > 0) {
                    btnVar.setVisibility(View.VISIBLE);
                }
               /* Variable.Type varType = tree.returnAssignVar(tree.findCurNode(tree)).varNodeType;
                if(varType == Variable.Type.STRING) {
                    showVarButtons(null);
                }else if (varType == Variable.Type.INT){
                    showVarButtons(varType);
                }*/
            }
            else if(currentNodeType == Node.Type.DEC){
                clearButtons();
                if( ((Dec)tree.findCurNode(tree)).varNodeType == Dec.Type.NONE) {
                    btnNewVar.setVisibility(View.GONE);
                    btnNewVarInt.setVisibility(View.VISIBLE);
                    btnNewVarString.setVisibility(View.VISIBLE);
                }else {
                    edtEnterString.setVisibility(View.VISIBLE);
                    btnEnterVarName.setVisibility(View.VISIBLE);
                }
            }
            else if(currentNodeType == Node.Type.VAR){
                clearButtons();
                //Node node = tree.findCurNode(tree);
                if(tree.isXbeforeY(tree.findCurNode(tree), Node.Type.EVAL, Node.Type.SEQ)){
                Variable.Type varType = tree.returnAssignVar(tree.findCurNode(tree)).varNodeType;
                if(varType == Variable.Type.STRING) {
                    showVarButtons(null);
                }else if (varType == Variable.Type.INT){
                    showVarButtons(varType);
                }
                }else {
                    edtEnterString.setText("");
                    btnEquals.setVisibility(View.VISIBLE);
                    btnSemicolon.setVisibility(View.VISIBLE);
                }
            }

            else if(currentNodeType == Node.Type.PRINT){
                btnPrintBack.setVisibility(View.VISIBLE);
                btnSemicolon.setVisibility(View.VISIBLE);

            }
            else if(currentNodeType == Node.Type.VARVAL){
                clearButtons();
                if(((VarVal)tree.findCurNode(tree)).value == null){
                    edtEnterString.setVisibility(View.VISIBLE);
                    btnEnterVarValue.setVisibility(View.VISIBLE);
                }else {
                    btnSemicolon.setVisibility(View.VISIBLE);
                    btnOperator.setVisibility(View.VISIBLE);
                }
            }
            else if(currentNodeType == Node.Type.STRING){
                clearButtons();
                btnSemicolon.setVisibility(View.VISIBLE);
                btnOperator.setVisibility(View.VISIBLE);
            }
            if ((currentNodeType != Node.Type.VARVAL) && (currentNodeType != Node.Type.STRING) && (currentNodeType != Node.Type.VAR) ){
                btnOperator.setVisibility(View.GONE);
            }
            if(currentNodeType != Node.Type.ROOT){
                //IF CURRENT NODE IS EVAL BASICALLY
                if(tree.findCurNode(tree).parent.nodeType == Node.Type.ASSIGN){
                    clearButtons();
                    btnTypeInput.setVisibility(View.VISIBLE);
                   // TODO fix this so that it checks that there are ints
                    if(variables.size() > 0) {
                        btnVar.setVisibility(View.VISIBLE);
                    }
                  //  edtEnterString.setVisibility(View.VISIBLE);
                  //  btnEnterVarValue.setVisibility(View.VISIBLE);
                }
            }
        }
    }




}
