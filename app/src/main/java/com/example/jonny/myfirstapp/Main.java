package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 19/03/2015.
 */

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.app.Activity;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.util.Log;

import java.util.ArrayList;


public class Main extends Activity {

    VarTree varTree;
    Node tree;
    Button btnPrint;
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

    Button btnSetEvalTypeString;
    Button btnSetEvalTypeInt;
    Button btnSetEvalTypeBool;

    Button btnLogTree;
    Button btnEnterVarName;
    Button btnEnterVarValue;
    Button btnPrintTextMenu;
    EditText edtEnterString;
    Button btnRun;
    Button btnDelete;
    Button btnUpLine;
    Button btnDownLine;
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

    Button btnOperator;
    Button btnOperatorAdd;
    Button btnOperatorConcat;
    Button btnOperatorSub;
    Button btnOperatorMod;
    Button btnOperatorMulti;
    Button btnOperatorDiv;
    Button btnOpenBracket;
    Button btnCloseBracket;
    Button btnOperatorBoolAnd;
    Button btnOperatorBoolOr;

    Button btnOperatorInequality;
    Button btnOperatorEquality;
    Button btnOperatorLessThan;
    Button btnOperatorLessThanEquals;
    Button btnOperatorMoreThan;
    Button btnOperatorMoreThanEquals;

    Button btnIf;
    Button btnElse;
    Button btnStartIf;
    Button btnEndIf;
    Button btnEndIfCondition;

    Button btnCloseCurly;

    Button btnNewLine;

    Button btnEditReturn;

    Button btnFunctions;
    Button btnExistingFunc;
    Button btnNewFunc;
    Button btnFuncInt;
    Button btnFuncBool;
    Button btnFuncString;
    Button btnFuncVoid;
    Button btnEnterFuncName;
    Button btnEndFuncDec;
    Button btnFuncAddParam;
    Button btnFuncReturn;



    Button btnEnterText;
    Button btnEquals;

    Button btnBoolTrue;
    Button btnBoolFalse;

    Button btnExistingVar;

    Button btnTypeInput;

    Variable newVar;
    Button btnEnterString;
    EditText code;
    TextView output;
    ArrayList<Button> printMenu;
    ArrayList<Button> homeMenu;
    ArrayList<Button> varButtons;
    ArrayList<Button> funcButtons;
  //  ArrayList<Variable> variables;
    ArrayList<ArrayList<ArrayList<Variable>>> variablesArray;
    ArrayList<Function> functionsArray;
    ArrayList<Boolean> openBrackets;
    ArrayList<Boolean> openCurlysIndent;
    ArrayList<String> returnValueStack;

    ArrayList<Boolean> functionDimensions;
    ArrayList<String> errorStack;

    Integer numberOfNewLines;
    String tempString1;
    String s;


    Integer lineJustPressed;



    public void initialise(){
        tree = new Node(Node.Type.ROOT, null);
        varTree = new VarTree(null);
        //tree = tree.addNode(tree, Node.Type.NONE, "right", null);
        tree = tree.addNode(tree, Node.Type.NEWLINE, "right", null);
        tree = tree.moveUpTreeLimit(tree, "ROOT");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnPrint =(Button)findViewById(R.id.btnPrint);
        btnPrintBack = (Button)findViewById(R.id.printBack);
        btnSetEvalTypeInt = (Button) findViewById(R.id.btnSetEvalTypeInt);
        btnSetEvalTypeString = (Button) findViewById(R.id.btnSetEvalTypeString);
        btnSetEvalTypeBool = (Button) findViewById(R.id.btnSetEvalTypeBool);

        btnFunctions = (Button) findViewById(R.id.btnFunctions);
        btnExistingFunc= (Button) findViewById(R.id.btnExistingFunc);
        btnNewFunc = (Button) findViewById(R.id.btnNewFunc);
        btnFuncInt = (Button) findViewById(R.id.btnFuncInt);
        btnFuncString = (Button) findViewById(R.id.btnFuncString);
        btnFuncBool = (Button) findViewById(R.id.btnFuncBool);
        btnFuncVoid = (Button) findViewById(R.id.btnFuncVoid);
        btnEnterFuncName = (Button) findViewById(R.id.btnEnterFuncName);
        btnEndFuncDec = (Button) findViewById(R.id.btnEndFuncDec);
        btnFuncAddParam = (Button) findViewById(R.id.btnFuncAddParam);
        btnFuncReturn = (Button) findViewById(R.id.btnFuncReturn);
        errorStack = new ArrayList<String>();

        btnLoops = (Button)findViewById(R.id.loops);
        btnVar = (Button)findViewById(R.id.var);
        btnNewVar = (Button) findViewById(R.id.varNew);
        btnNewVarInt = (Button) findViewById(R.id.btnVarNewInt);
        btnNewVarString = (Button) findViewById(R.id.btnVarNewString);
        btnNewVarBool = (Button) findViewById(R.id.btnVarNewBool);
        btnPrintVar =  (Button) findViewById(R.id.btnPrintVar);
        btnPrintText =  (Button) findViewById(R.id.btnPrintText);
        variablesArray = new ArrayList<ArrayList<ArrayList<Variable>>>();
        variablesArray.add(new ArrayList<ArrayList<Variable>>());


        functionsArray = new ArrayList<Function>();
        functionDimensions = new ArrayList<Boolean>();

     //   variables = new ArrayList<Variable>();

        btnNewLine = (Button) findViewById(R.id.btnNewLine);

        openBrackets = new ArrayList<Boolean>();
        openCurlysIndent = new ArrayList<Boolean>();

        btnSemicolon =(Button)findViewById(R.id.semicolon);
        btnEnterString = (Button)findViewById(R.id.btnEnterTextString);
        edtEnterString = (EditText) findViewById(R.id.edtEnterTextString);
        btnEnterVarValue = (Button) findViewById(R.id.btnEnterVarValue);
        btnEnterVarName = (Button) findViewById(R.id.btnEnterVarName);

        btnBoolTrue = (Button) findViewById(R.id.btnBoolTrue);
        btnBoolFalse = (Button) findViewById(R.id.btnBoolFalse);

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

        btnOperator = (Button) findViewById(R.id.btnOperator);
        btnOperatorAdd = (Button) findViewById(R.id.btnOperatorAdd);
        btnOperatorSub = (Button) findViewById(R.id.btnOperatorSub);
        btnOperatorMod = (Button) findViewById(R.id.btnOperatorMod);
        btnOperatorMulti = (Button) findViewById(R.id.btnOperatorMulti);
        btnOperatorDiv = (Button) findViewById(R.id.btnOperatorDiv);
        btnOperatorConcat = (Button) findViewById(R.id.btnOperatorConcat);
        btnOpenBracket = (Button) findViewById(R.id.btnOpenBracket);
        btnCloseBracket = (Button) findViewById(R.id.btnCloseBracket);
        btnOperatorBoolAnd = (Button) findViewById(R.id.btnOperatorBoolAnd);
        btnOperatorBoolOr = (Button) findViewById(R.id.btnOperatorBoolOr);
        btnOperatorInequality =(Button) findViewById(R.id.btnOperatorInequality);
        btnOperatorEquality =(Button) findViewById(R.id.btnOperatorEquality);
        btnOperatorLessThan = (Button) findViewById(R.id.btnOperatorLessThan);
        btnOperatorLessThanEquals = (Button) findViewById(R.id.btnOperatorLessThanEqual);
        btnOperatorMoreThan = (Button) findViewById(R.id.btnOperatorMoreThan);
        btnOperatorMoreThanEquals = (Button) findViewById(R.id.btnOperatorMoreThanEquals);

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpLine = (Button) findViewById(R.id.btnUpLine);
        btnDownLine = (Button) findViewById(R.id.btnDownLine);
        btnIf = (Button) findViewById(R.id.btnIf);
        btnStartIf = (Button) findViewById(R.id.btnStartIf);
        btnEndIfCondition = (Button) findViewById(R.id.btnEndIfCondition);
        btnElse = (Button) findViewById(R.id.btnElse);
        btnEndIf = (Button) findViewById(R.id.btnEndIf);

        btnCloseCurly = (Button) findViewById(R.id.btnCloseCurly);

        btnEditReturn = (Button) findViewById(R.id.btnEditReturn);

        lineJustPressed = 0;
        Button btnConditionalIf;
        Button btnConditionalElse;


        btnRun = (Button) findViewById(R.id.run);
        varButtons = new ArrayList<Button>();
        funcButtons = new ArrayList<Button>();
        returnValueStack = new ArrayList<String>();
        btnPrintTextMenu = (Button) findViewById(R.id.btnPrintTextMenu);
        homeMenu = new ArrayList<Button>();
        homeMenu.add(btnPrint);
        homeMenu.add(btnLoops);
        homeMenu.add(btnVar);
        homeMenu.add(btnIf);
        homeMenu.add(btnNewLine);
        homeMenu.add(btnFunctions);
        printMenu = new ArrayList<Button>();
        printMenu.add(btnPrintBack);
        printMenu.add(btnSemicolon);
        printMenu.add(btnEnterString);
        code = (EditText)findViewById(R.id.codeText);
        code.setMovementMethod(new ScrollingMovementMethod());
        code.setClickable(true);
        code.setFocusable(true);
        code.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Node.Type currentNodeType = tree.findCurNode(tree).nodeType;
                    if (!(currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.ROOT || currentNodeType == Node.Type.IF || currentNodeType == Node.Type.ELSE || currentNodeType == Node.Type.NONE || currentNodeType == Node.Type.STARTLOOP)) {
                        showInvalidAlert("Please finish current line before changing line");
                    } else {
                        btnDelete.setVisibility(View.VISIBLE);
                        Layout layout = ((TextView) v).getLayout();
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        if (layout != null) {
                            int line = layout.getLineForVertical(y);
                            int offset = layout.getOffsetForHorizontal(line, x);
                            Log.v("index", "" + offset);
                            lineJustPressed = line;
                            Log.v("line number", "" + lineJustPressed);
                            code.requestFocus();
                            Boolean endOfLine = false;
                            while (offset < code.getText().length() - 1 && endOfLine == false) {
                                String codeChar = code.getText().toString().substring(offset, offset + 1);
                                if (codeChar.equals("\n")) {
                                    endOfLine = true;
                                }
                                offset += 1;
                            }
                            offset--;
                            code.setSelection(offset, offset);
                        }
                        tree = tree.changeCurrentNode(tree, lineJustPressed);
                        doButtonLogic();
                        showElse();


                    }
                }
                    return true;
                }
            });
            numberOfNewLines = 0;
            output = (TextView) findViewById(R.id.runText);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            output.setMovementMethod(new ScrollingMovementMethod());
            btnLogTree = (Button)findViewById(R.id.LogTree);
            tempString1 = "HELLOOO";
            btnFor = (Button) findViewById(R.id.btnFor);
            initialise();


    }

    public void setCursorToEndOfCurrentLine(Integer lineDirection){
        btnElse.setVisibility(View.GONE);
        Integer lineNumber = tree.getLineNumberOfCurrentNode(tree) + lineDirection; //the minus 1 is because we have added a newline after root
        if(lineNumber < 1){
            lineNumber = 0;
        }
        if(lineNumber == 0){
            tree = tree.clearCurrentNode(tree);
            tree.isCurrentNode = true;
            code.setSelection(0);
            lineJustPressed = lineNumber;
        }else {
            lineJustPressed = lineNumber;
            Integer offset = 0;
            Integer numberOfLinesSoFar = 0;
            Boolean endOfLine = false;
            while (offset < code.getText().length() && endOfLine == false) {
                String codeChar = code.getText().toString().substring(offset, offset + 1);
                if (codeChar.equals("\n")) {
                    numberOfLinesSoFar += 1;
                }
                if (numberOfLinesSoFar == lineNumber) {
                    Boolean end = false;
                    while (offset < code.getText().length() - 1 && end == false) {
                        offset += 1;
                        codeChar = code.getText().toString().substring(offset, offset + 1);
                        if (codeChar.equals("\n")) {
                            end = true;
                        }
                    }
                    endOfLine = true;
                }
                offset += 1;
            }
            if (endOfLine) {
                Log.d("Found end of", " line");
            } else {
                Log.d("Didn't find end of ", "line");
            }
            offset -= 1;
            code.setSelection(offset, offset);
            if (lineDirection != 0) {
                tree = tree.changeCurrentNode(tree, lineNumber);
                showElse();
            }else {
                showElse();
            }
        }
        Log.d("Line number = ", lineNumber.toString());
    }
    public Boolean isOutsideAllBrackets(){
        Node node = tree.findCurNode(tree);
        while(node.nodeType != Node.Type.SEQ){
            node = node.parent;
        }
        while(node.nodeType != Node.Type.ROOT){
            if(node.nodeType != Node.Type.SEQ){
                return false;
            }
            node = node.parent;
        }
        return true;
    }




    public void showElse(){
        Node node = tree.findCurNode(tree);
        btnElse.setVisibility(View.GONE);
        /*btnFunctions.setVisibility(View.VISIBLE);
        while(node.nodeType != Node.Type.ROOT){
            if(node.nodeType != Node.Type.SEQ){
                btnFunctions.setVisibility(View.GONE);
            }
            node = node.parent;
        }
        node = tree.findCurNode(tree);*/
        if(node.nodeType == Node.Type.SEQ){
            if(node.left != null) {
                if (node.left.left != null) {
                    if (node.left.left.nodeType == Node.Type.IF) {
                        tree = tree.moveDownDirectionLimit(tree, "left", "CONDITION");
                        tree = tree.moveDownDirectionLimit(tree, "right", "NEWLINE");
                        node = tree.findCurNode(tree);

                       try {
                           if (node.right.right.right.nodeType == Node.Type.ELSE) {

                           }
                       }catch (NullPointerException e){
                           if (((Newline) node).stop == true) {
                               btnElse.setVisibility(View.VISIBLE);
                               //    ((Newline)node).stop = false;
                           }
                       }



                        tree = tree.moveUpTreeLimit(tree, "SEQ");
                    }
                }
            }
        }
    }






    public void hideButtons(ArrayList<Button> b){
        for(int i = 0; i < b.size(); i++ ){
            b.get(i).setVisibility(View.GONE);
        }
    }

    public void showButtons(ArrayList<Button> b){
        btnDelete.setVisibility(View.VISIBLE);
        btnUpLine.setVisibility(View.VISIBLE);
        btnDownLine.setVisibility(View.VISIBLE);
        for(int i = 0; i < b.size(); i++ ){
            b.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void clearVar(){
        /*for(int i = 0; i < variables.size(); i++)
            variables.get(i).value = null;*/
      //  variables = new ArrayList<Variable>();
        variablesArray = new ArrayList<ArrayList<ArrayList<Variable>>>();
    }

    public Boolean checkIfAnyVarsExist(){
        fillVariablesArray();
        for(int j = 0; j < variablesArray.size(); j++){
            if(variablesArray.get(j).size() > 0){
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfAnyFunctionsExist(){
        fillFunctionsArray();
        if(functionsArray.size() > 0){
            return true;
        }
        return false;
    }


    public boolean checkVarExists(String var){
        for(int j = 0; j < variablesArray.get(functionDimensions.size()).size(); j++) {
            ArrayList<Variable> variables = variablesArray.get(functionDimensions.size()).get(j);
            for (int i = 0; i < variables.size(); i++) {
                Variable v = variables.get(i);
                if (v.name.equals(var)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkVarTypeExistence(Variable.Type type){
        fillVariablesArray();
        if(variablesArray != null){
            for(int j = 0; j < variablesArray.get(functionDimensions.size()).size(); j++){
                ArrayList<Variable> variables = variablesArray.get(functionDimensions.size()).get(j);
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).varNodeType == type) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean checkFuncTypeExistence(Function.Type type){
        fillFunctionsArrayUpToCurrentNode();
        if(functionsArray != null){
            for (int i = 0; i < functionsArray.size(); i++) {
                if (functionsArray.get(i).funcType == type) {
                    return true;
                }
            }
        }
        return false;

    }





   public void hideVarButtons(){
        for(int i = 0; i < varButtons.size(); i++){
               varButtons.get(i).setVisibility(View.GONE);
        }
    }


    public void hideFuncButtons(){
        for(int i = 0; i < funcButtons.size(); i++){
            funcButtons.get(i).setVisibility(View.GONE);
        }
    }


    public void updateVariableValue(String value, String name, Variable.Type type){
        for(int j = 0; j < variablesArray.get(functionDimensions.size()).size(); j++) {
            ArrayList<Variable> variables = variablesArray.get(functionDimensions.size()).get(j);
            for (int i = 0; i < variables.size(); i++) {
                Variable v = variables.get(i);
                if (v.name.equals(name) && v.varNodeType == type) {
                    v.value = value;
                }
            }
        }
    }

    public String getVariableValue(String name, Variable.Type type){
        for(int j = 0; j < variablesArray.get(functionDimensions.size()).size(); j++) {
            ArrayList<Variable> variables = variablesArray.get(functionDimensions.size()).get(j);
            for (int i = 0; i < variables.size(); i++) {
                Variable v = variables.get(i);
                if (v.name.equals(name) && v.varNodeType == type) {
                    if (v.value != null) {
                        return v.value;
                    }
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

    public void showInvalidAlert(String msg){
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_dialog);
            Button invalidValue = (Button) dialog.findViewById(R.id.alertInvalidValue);
            invalidValue.setText(msg);
            invalidValue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
    }

    public void addToCode(TextView view, String text, int htmlText, Boolean html){
        if(html) {
            view.append(text);
        }else{
            view.append(Html.fromHtml(getString(htmlText)));
        }
    }

    public void indent(Integer handicap){
       // int loop = openLoopsIndent.size() + openIfsIndent.size();
        int loop = openCurlysIndent.size();
        for(int i = 0; i < loop+handicap; i++){
            code.append("\t\t\t");
        }
    }





    public void visitNode(Node tree){
        Node.Type nodeType = tree.nodeType;
        String text;
        if (nodeType == Node.Type.PRINT){
         //   addToCode(code, null, R.string.print, true);  //TODO
            code.append(Html.fromHtml(getString(R.string.print)));
        }
        else if(nodeType == Node.Type.STRING){
            text = "\"" + ((Str)tree).value + "\"";
         //   addToCode(code, text, 0, false);
            code.append("\"" + ((Str) tree).value + "\"");
        }
        else if(nodeType == Node.Type.VARVAL) {
            Boolean isString = false;
            if(tree.returnEvalVar(tree).evalNodeType == Eval.Type.STRING){
                isString = true;
            }
            //(((Variable)node.parent.parent).value) = value;
          //  Variable.Type type = null;
            if (((VarVal) tree).value != null) {
                if(isString) {
                    code.append("\"");
                }
                code.append(((VarVal) tree).value);
                if(isString) {
                    code.append("\"");
                }
            }
        }
        else if (nodeType == Node.Type.SMCLN){
                Variable.Type type = null;
                code.append(" ;");
            //   if( tree.parent.parent.nodeType == Node.Type.DEC ){
                if(tree.isXbeforeY(tree, Node.Type.DEC, Node.Type.SEQ)){
                    Variable v;// = new Variable(null, null, null, null);
                    if(tree.isXbeforeY(tree, Node.Type.EVAL, Node.Type.SEQ)) {
                        v = tree.returnAssignVar(tree);
                    }else{
                        v = tree.returnDecVar(tree);
                    }
                    type = v.varNodeType;
                    if (!checkVarExists(v.name)) {
                            Variable var = new Variable(null, type, v.name, null);
                            variablesArray.get(functionDimensions.size()).get(openCurlysIndent.size()).add(var);
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
                case BOOL:
                    code.append(Html.fromHtml(getString(R.string.bool)));
                    break;
                default:
                    break;
            }
        }
        else if(nodeType == Node.Type.RETURN){
            code.append(Html.fromHtml(getString(R.string.Return)));
        }
        else if(nodeType == Node.Type.FUNCTION){
            if(((Function)tree).isDec) {
                addFunctionDimension();
                addToVariablesArray();
                if (((Function) tree).funcType != null) {
                    code.append(Html.fromHtml(getString(R.string.function)));
                    switch (((Function) tree).funcType) {
                        case INT:
                            code.append(Html.fromHtml(getString(R.string.integer)));
                            break;

                        case BOOL:
                            code.append(Html.fromHtml(getString(R.string.bool)));
                            break;

                        case STRING:
                            code.append(Html.fromHtml(getString(R.string.string)));
                            break;

                        case VOID:
                            code.append(Html.fromHtml(getString(R.string.Void)));
                            break;

                    }

                }
                if (((Function) tree).name != null) {
                    code.append(((Function) tree).name + "(");
                }
                if (((Function) tree).decFinished) {
                    code.append(" ) {");
                    openCurlysIndent.add(true);

                }

               /* if(!checkVarExists(((Loops) tree).limiter.toString())){
                    String name = ((Loops) tree).limiter.toString();
                    Variable v = new Variable(null, Variable.Type.INT, name, null );
                    variablesArray.get(openCurlysIndent.size()).add(v);
                    //    variables.add(v);
                }*/
            }
        }
        else if(nodeType == Node.Type.FUNCCALL){
            if(((FunctionCall)tree).functionName != null){
                code.append(((FunctionCall)tree).functionName + "(");
            }
            for(int i = 0; i < ((FunctionCall)tree).parameters.size(); i++){
                String value = getValueOfExpressionNode(((FunctionCall) tree).parameters.get(i));
                code.append(value + ", ");
            }
            if(((FunctionCall)tree).paramsFinished) {
                code.append(" )");
            }

        }
        else if(nodeType == Node.Type.FORLOOP){
            switch(((Loops)tree).varNodeType){
                case FOR:
                    code.append(Html.fromHtml(getString(R.string.forLoop)));
                    if(((Loops) tree).limiter != null){
                        openCurlysIndent.add(true);
                        addToVariablesArray();
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(Html.fromHtml(s) + " = ");
                        if(!checkVarExists(((Loops) tree).limiter.toString())){
                            String name = ((Loops) tree).limiter.toString();
                            Variable v = new Variable(null, Variable.Type.INT, name, null );
                            variablesArray.get(functionDimensions.size()).get(openCurlysIndent.size()).add(v);
                        //    variables.add(v);
                        }
                    }
                    if(((Loops) tree).lowerLim != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(((Loops) tree).lowerLim.toString() + "; " + Html.fromHtml(s));
                    }
                    if(((Loops) tree).operator != null){
                        if(((Loops) tree).operator == Operator.Type.LESSTHAN) {
                            code.append(" < ");
                        }else if(((Loops) tree).operator == Operator.Type.MORETHAN) {
                            code.append(" > ");
                        }
                    }
                    if(((Loops) tree).upperLim != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(((Loops) tree).upperLim.toString() + "; " + Html.fromHtml(s));
                    }
                    if(((Loops) tree).plusOrMinus != null){
                        s = "<i>" + ((Loops) tree).limiter.toString() + "<i>";
                        code.append(" " + ((Loops) tree).plusOrMinus.toString() + " ) {");
                    }
                    break;
            }
        }
        else if(nodeType == Node.Type.NEWLINE){
            code.append("\n");
            Boolean isEnd = ((Newline)tree).isEnd;
            if(isEnd == true) {
                indent(-1);
            }else {
                indent(0);
            }
             //   }
           // }
        }
        else if(nodeType == Node.Type.STARTLOOP){
            //openLoopsIndent.add(true);
            //openCurlysIndent.add(true);
            //addToVariablesArray();
        }
        else if(nodeType == Node.Type.END){
            openCurlysIndent.remove(openCurlysIndent.size() - 1);
            if(((Newline)tree.parent).newlineNodeType == Newline.Type.FUNCEND){
                removeFunctionDimension();
            }else {
                // openLoopsIndent.remove(openLoopsIndent.size() - 1);
                variablesArray.get(functionDimensions.size()).remove(variablesArray.get(functionDimensions.size()).size() - 1);
            }
            //indent();
            //String codeText = code.getText().toString();
            //code.setText(codeText.substring(0, codeText.length() - 3));
            code.append("}");
        }
        else if(nodeType == Node.Type.ENDPROGRAM){
            // openLoopsIndent.remove(
            // Indent.size() - 1);
            code.append("\n");
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
        else if(nodeType == Node.Type.BRACKET){
            if(((Bracket)tree).bracketType == Bracket.Type.OPEN){
                code.append("( ");
            }else{
                code.append(" )");
            }
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
            }else if(op.equals("CONCAT")){
                code.append(" + ");
            }else if(op.equals("AND")){
                code.append(" && ");
            }else if(op.equals("OR")){
                code.append(" || ");
            }else if(op.equals("LESSTHAN")){
                code.append(" < ");
            }else if(op.equals("MORETHAN")){
                code.append(" > ");
            }else if(op.equals("LESSTHANEQUALS")){
                code.append(" <= ");
            }else if(op.equals("MORETHANEQUALS")){
                code.append(" >= ");
            }else if(op.equals("EQUALS")){
                code.append(" == ");
            }else if(op.equals("NOTEQUALS")){
                code.append(" != ");
            }else if(op.equals("MOD")){
                code.append(" % ");
            }
        }
        else if(nodeType == Node.Type.IF){
            code.append(Html.fromHtml(getString(R.string.ifString)));
        }
        else if(nodeType == Node.Type.ELSE){
            //String codeText = code.getText().toString();
            //code.setText(codeText.substring(0, codeText.length() - 1));
            code.append(Html.fromHtml(getString(R.string.elseString)));


            openCurlysIndent.add(true);
            addToVariablesArray();
        }
        else if(nodeType == Node.Type.ENDIFCONDITION){
            code.append(Html.fromHtml(getString(R.string.endIfConditionString)));
            //openIfsIndent.add(true);
            openCurlysIndent.add(true);
            addToVariablesArray();
        }

    }

    public String getValueOfExpressionNode(Node node){
            if(node.nodeType == Node.Type.FUNCCALL) {
                Node n = node.getFunctionNodeByName(tree, ((FunctionCall) node).functionName);
                runCode(n);
                String value = returnValueStack.get(returnValueStack.size() - 1);
                returnValueStack.remove(returnValueStack.size() - 1);
                return value;
            }else {
                try {
                    return (((VarVal) node).value);
                } catch (ClassCastException e) {
                    return getVariableValue(((Variable) node).name, ((Variable) node).varNodeType);
                }
            }
    }

    public ArrayList<Node> removeOpFromArrayList(ArrayList<Node> array, Integer i, String value){
        int pos = i;
      //  array.set(pos, new VarVal(array.get(pos).parent.parent, VarVal.Type.STRING, value));
        array.set(pos, new VarVal(null, VarVal.Type.STRING, value));
        array.remove(pos-1);
        array.remove(pos);
        return array;
    }


    public ArrayList<Node> evalDivAndMul(ArrayList<Node> array){
        Node node;
        String value = "";
        int i = 0;
        while(i < array.size()) {
            node = array.get(i);
            if (node.nodeType == Node.Type.OP) {
                if (((Operator) node).opNodeType == Operator.Type.DIV) {
                    value = String.valueOf((Integer.parseInt(getValueOfExpressionNode(array.get(i - 1))) / Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                }else if (((Operator) node).opNodeType == Operator.Type.MOD) {
                    value = String.valueOf((Integer.parseInt(getValueOfExpressionNode(array.get(i - 1))) % Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                } else if (((Operator) node).opNodeType == Operator.Type.MULTI) {
                    value = String.valueOf((Integer.parseInt(getValueOfExpressionNode(array.get(i - 1))) * Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }

        return array;
    }

    public ArrayList<Node> evalAddAndSub(ArrayList<Node> array){
        Node node;
        String value = "";
        int i = 0;
        while(i < array.size()) {
            node = array.get(i);
            if (node.nodeType == Node.Type.OP) {
                if (((Operator) node).opNodeType == Operator.Type.ADD) {
                    value = String.valueOf((Integer.parseInt(getValueOfExpressionNode(array.get(i - 1))) + Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                } else if (((Operator) node).opNodeType == Operator.Type.SUB) {
                    value = String.valueOf((Integer.parseInt(getValueOfExpressionNode(array.get(i - 1))) - Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        return array;
    }

    public ArrayList<Node> evalBool(ArrayList<Node> array){
        Node node;
        String value = "";
        int i = 0;
        while(i < array.size()) {
            node = array.get(i);
            if (node.nodeType == Node.Type.OP) {
                if (((Operator) node).opNodeType == Operator.Type.AND) {
                    value = String.valueOf((Boolean.valueOf(getValueOfExpressionNode(array.get(i - 1))) && Boolean.valueOf(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                } else if (((Operator) node).opNodeType == Operator.Type.OR) {
                    value = String.valueOf((Boolean.valueOf(getValueOfExpressionNode(array.get(i - 1))) || Boolean.valueOf(getValueOfExpressionNode(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        return array;
    }

    public ArrayList<Node> evalConditionalOp(ArrayList<Node> array){
        Node node;
        String value = "";
        int i = 0;
        while(i < array.size()) {
            node = array.get(i);
            if (node.nodeType == Node.Type.OP) {
                String leftValString = String.valueOf(getValueOfExpressionNode(array.get(i - 1)));
                String rightValString = String.valueOf(getValueOfExpressionNode(array.get(i + 1)));
                if (((Operator) node).opNodeType == Operator.Type.EQUALS) {
                    if(leftValString.equals(rightValString)){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.NOTEQUALS) {
                    if(!leftValString.equals(rightValString)){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.LESSTHAN) {
                    Integer leftValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)));
                    if(leftValInt < rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.MORETHAN) {
                    Integer leftValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)));
                    if(leftValInt > rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.LESSTHANEQUALS) {
                    Integer leftValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)));
                    if(leftValInt <= rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.MORETHANEQUALS) {
                    Integer leftValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getValueOfExpressionNode(array.get(i + 1)));
                    if(leftValInt >= rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else{
                    i++;
                }
            }else{
                i++;
            }
        }
        return array;
    }

    public ArrayList<Node> evalString(ArrayList<Node> array){
        Node node;
        String value = "";
        int i = 0;
        while(i < array.size()) {
            node = array.get(i);
            if (node.nodeType == Node.Type.OP) {
                if (((Operator) node).opNodeType == Operator.Type.CONCAT) {
                    value = getValueOfExpressionNode(array.get(i - 1)) + getValueOfExpressionNode(array.get(i + 1));
                    removeOpFromArrayList(array, i, value);
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        return array;
    }

    public boolean areBracketsInArray(ArrayList<Node> array){
        for(int i = 0; i < array.size(); i++){
            if (array.get(i).nodeType == Node.Type.BRACKET){
                return true;
            }
        }
        return false;
    }


    public ArrayList<Node> evaluateBrackets(ArrayList<Node> array){
            Node node;
            int position = 0;
            //TODO
            for(int i = 0; i < array.size(); i++){
                node = array.get(i);
                if(node.nodeType == Node.Type.BRACKET){
                    if(((Bracket)node).bracketType == Bracket.Type.OPEN){
                        position = i;
                    }
                    if(((Bracket)node).bracketType == Bracket.Type.CLOSE){
                        ArrayList<Node> subList = new ArrayList<Node>();
                        int count = 0;
                        int j = position+1;
                       while(count < (i-j)){
                            subList.add(array.get(j));
                            array.remove(j);
                            count++;
                        }
                        array.remove(j);
                        array.set(position, evaluateArray(subList).get(0));
                        return array;
                    }
                }
            }

        return array;
    }

    public ArrayList<Node> evaluateArray(ArrayList<Node> array){
        if(array.size() == 1){
            return array;
        }else {
            if(areBracketsInArray(array)) {
                while(areBracketsInArray(array)) {
                    array = evaluateBrackets(array);
                }
                array = evaluateArray(array);
            }else {
                    array = evalDivAndMul(array);
                    array = evalAddAndSub(array);
                    array = evalString(array);
                    array = evalBool(array);
                    array = evalConditionalOp(array);
            }
            return array;
        }
    }


    public String evaluate(Node tree, Node.Type typeOfEvaluation){
        ArrayList<Node> array = new ArrayList<Node>();
        Node node = tree;
        while(node.nodeType != typeOfEvaluation){
            if(node.left != null){
                if(node.left.nodeType != typeOfEvaluation) {
                    array.add(node.left);
                }
                node = node.left;
            }
            else if(node.right != null){
                if(node.right.nodeType != typeOfEvaluation) {
                    array.add(node.right);
                }
                node = node.right;
            }
        }
        return getValueOfExpressionNode(evaluateArray(array).get(0));
    }

    public void setConditionValue(Node tree, String value){
        while(tree.nodeType != Node.Type.IF){
            tree = tree.parent;
        }
        if(value.equals("true")) {
            ((If) tree).isTrue = true;
        }else{
            ((If)tree).isTrue = false;
        }
    }



    public void visitNodeRun(Node treeNode){
         //  try {
               if (treeNode.nodeType == Node.Type.SMCLN) {
                       if(treeNode.isXbeforeY(treeNode, Node.Type.DEC, Node.Type.SEQ)) {
                           Variable v = treeNode.returnDecVar(treeNode);
                           Variable.Type type = v.varNodeType;
                           String name = v.name;
                           if (!checkVarExists(name)) {
                               Variable var = new Variable(null, type, name, null);
                               variablesArray.get(functionDimensions.size()).get(openCurlysIndent.size()).add(var);
                               //variables.add(var);
                           }
                           //evaluate if user assigns a value while declaring
                           if(treeNode.isXbeforeY(treeNode, Node.Type.EVAL, Node.Type.SEQ)){
                               String value = evaluate(treeNode.returnEvalNode(treeNode), Node.Type.SMCLN);
                               updateVariableValue(value, name, type);
                               Log.d("Value is ", value);
                           }
                       }
                       else if(treeNode.isXbeforeY(treeNode, Node.Type.ASSIGN, Node.Type.SEQ)){
                           Variable v = treeNode.returnAssignVar(treeNode);
                           Variable.Type type = v.varNodeType;
                           String name = v.name;
                           //evaluate
                           String value = evaluate(treeNode.returnEvalNode(treeNode), Node.Type.SMCLN);
                           updateVariableValue(value, name, type);
                        //   Log.d("Value is ", value);
                       }
                      else if(treeNode.isXbeforeY(treeNode, Node.Type.PRINT, Node.Type.SEQ)){
                           String value = evaluate(treeNode.returnEvalNode(treeNode), Node.Type.SMCLN);
                           output.append(value + "\n");
                       }
                       else if(treeNode.isXbeforeY(treeNode, Node.Type.RETURN, Node.Type.SEQ)){
                           Node startFuncNode = treeNode.returnStartFuncNode(treeNode);
                           startFuncNode.left = startFuncNode.setRunForAllChildren(startFuncNode.left, false);
                           String value = evaluate(treeNode.returnEvalNode(treeNode), Node.Type.SMCLN);
                           returnValueStack.add(value);
                       }
               }
               else if (treeNode.nodeType == Node.Type.RESETRETURN) {
                    treeNode.parent = treeNode.setRunForAllChildren(treeNode.parent, true);
               }
               else  if(treeNode.nodeType == Node.Type.FORLOOP){
                 //  openCurlysIndent.add(true);
                 //  addToVariablesArray();
                   String varValue = ((Loops) treeNode).lowerLim.toString();
                   String varName = ((Loops) treeNode).limiter;
                   updateVariableValue(varValue, varName, Variable.Type.INT);
               }else if(treeNode.nodeType == Node.Type.ENDIFCONDITION){
                   openCurlysIndent.add(true);
                   addToVariablesArray();
                   String value = evaluate(treeNode.returnEvalNode(treeNode), Node.Type.ENDIFCONDITION);
                   if(value.equals("true")){
                       setConditionValue(treeNode, "true");
                   }else if(value.equals("false")){
                       setConditionValue(treeNode, "false");
                   }
                   Log.d("STATEMENT IS", value);
               }else if (treeNode.nodeType == Node.Type.ELSE) {
                   openCurlysIndent.add(true);
                   addToVariablesArray();
               } else if (treeNode.nodeType == Node.Type.FUNCTION) {
                   if (((Function) treeNode).isDec) {
                       addFunctionDimension();
                       if (((Function) treeNode).decFinished) {
                           addToVariablesArray();
                           openCurlysIndent.add(true);
                       }
                   }
               }else if (treeNode.nodeType == Node.Type.END) {
                   openCurlysIndent.remove(openCurlysIndent.size() - 1);
                   if(((Newline)treeNode.parent).newlineNodeType == Newline.Type.FUNCEND){
                       removeFunctionDimension();
                   }else {
                       variablesArray.get(functionDimensions.size()).remove(variablesArray.get(functionDimensions.size()).size() - 1);
                   }
               }else if(treeNode.nodeType == Node.Type.FUNCCALL){
                   if(!(tree.isXbeforeY(treeNode, Node.Type.EVAL, Node.Type.SEQ))) {
                       Node n = treeNode.getFunctionNodeByName(tree, ((FunctionCall) treeNode).functionName);
                       runCode(n);
                       if(((FunctionCall)treeNode).type != FunctionCall.Type.VOID) {
                           returnValueStack.remove(returnValueStack.size() - 1);
                       }
                   }
               }
    }


    public void showBracketButtons(Node node){
        btnOpenBracket.setVisibility(View.VISIBLE);
        if(openBrackets.size() > 0){
            btnCloseBracket.setVisibility(View.VISIBLE);
        }else{
            btnCloseBracket.setVisibility(View.GONE);
        }
        if(node.nodeType == Node.Type.BRACKET){
            if(((Bracket)node).bracketType == Bracket.Type.OPEN){
                btnCloseBracket.setVisibility(View.GONE);
            }
        }
        if(node.nodeType == Node.Type.VAR || node.nodeType == Node.Type.VARVAL || node.nodeType == Node.Type.FUNCCALL){
            btnOpenBracket.setVisibility(View.GONE);
        }
        if(node.nodeType == Node.Type.OP){
            btnCloseBracket.setVisibility(View.GONE);
            if (((Operator) node).opNodeType == null){
                btnOpenBracket.setVisibility(View.GONE);
            }
        }

    }

    public void showSemicolonButton(){
        Node n = tree.findCurNode(tree);
        if(openBrackets.size() == 0){
            if(!tree.isXbeforeY(n, Node.Type.IF, Node.Type.NEWLINE)) {
            //    if(n.nodeType == Node.Type.FUNCCALL && n.parent.nodeType != Node.Type.EVAL) {
                    btnSemicolon.setVisibility(View.VISIBLE);
              //  }
            }
        }
    }

    public void endIfCondition(Node node) {
        if (openBrackets.size() == 0) {
            if(tree.hasConditionOperatorBeenUsed(node)){
                btnEndIfCondition.setVisibility(View.VISIBLE);
            }
        }
    }


    public void runCode(Node tree){
        try {
            visitNodeRun(tree);
            if (tree.left != null) {
                if(tree.left.run){
                    if (tree.left.nodeType == Node.Type.FUNCTION) {
                        if (((Function) tree.left).isDec == false) {
                            runCode(tree.left);
                        }
                    } else if (tree.left.nodeType == Node.Type.FORLOOP) {
                        openCurlysIndent.add(true);
                        addToVariablesArray();
                        Integer loopAmount = Math.abs(((Loops) tree.left).upperLim - ((Loops) tree.left).lowerLim);
                        String varValue = ((Loops) tree.left).lowerLim.toString();
                        String varName = ((Loops) tree.left).limiter;
                        if (!checkVarExists(varName)) {
                            variablesArray.get(functionDimensions.size()).get(openCurlysIndent.size()).add(new Variable(null, Variable.Type.INT, varName, varValue));
                        } else {
                            updateVariableValue(varValue, varName, Variable.Type.INT);
                        }
                        ArrayList<Node> condition = new ArrayList<Node>();
                        Variable loopInt = new Variable(null, Variable.Type.INT, varName, getVariableValue(varName, Variable.Type.INT));
                        Operator.Type opType = ((Loops) tree.left).operator;
                        Operator op = new Operator(null, opType);
                        VarVal limit = new VarVal(null, VarVal.Type.INT, ((Loops) tree.left).upperLim.toString());
                        condition.add(loopInt);
                        condition.add(op);
                        condition.add(limit);
                        Integer count = 0;
                        Boolean loopLimitReached = false;
                        while (getValueOfExpressionNode(evaluateArray(condition).get(0)) == "true" && !loopLimitReached) {
                            count++;
                            runCode(tree.left.left);
                            if (((Loops) tree.left).plusOrMinus == "--") {
                                String newValue = String.valueOf(Integer.parseInt(getVariableValue(((Loops) tree.left).limiter, Variable.Type.INT)) - 1);
                                updateVariableValue(newValue, varName, Variable.Type.INT);
                            } else {
                                String newValue = String.valueOf(Integer.parseInt(getVariableValue(((Loops) tree.left).limiter, Variable.Type.INT)) + 1);
                                updateVariableValue(newValue, varName, Variable.Type.INT);
                            }
                            loopInt = new Variable(null, Variable.Type.INT, varName, getVariableValue(varName, Variable.Type.INT));
                            opType = ((Loops) tree.left).operator;
                            op = new Operator(null, opType);
                            limit = new VarVal(null, VarVal.Type.INT, ((Loops) tree.left).upperLim.toString());
                            condition.clear();
                            condition.add(loopInt);
                            condition.add(op);
                            condition.add(limit);
                            if (count > 10000) {
                                loopLimitReached = true;
                                errorStack.add("<ERROR: loop repeated for more than 10,000 iterations>");
                            }
                        }
                        runCode(tree.left.right);

                    } else {
                        runCode(tree.left);
                    }
                }
            }
            if (tree.right != null) {
                if(tree.right.run){

                    if (tree.nodeType == Node.Type.NONE) {
                        //check if if statement condition is true
                        //  if(((If)tree.parent.parent).isTrue){
                        if (tree.parent.nodeType == Node.Type.STARTIF) { //To distinguish from IF and FUNCTIONS
                            if (checkIfTrue(tree)) {
                                runCode(tree.right);
                            }
                        } else if (tree.parent.nodeType == Node.Type.STARTFUNC) {
                            runCode(tree.right);
                        }
                    } else if (tree.nodeType == Node.Type.ELSE) {
                        if (!checkIfTrue(tree)) {
                            runCode(tree.right);
                        }
                    } else {
                        runCode(tree.right);
                    }
                }

            }
        }catch (StackOverflowError e){
            errorStack.add("A recursive function caused an error as it looped forever");
        }
    }

    public Boolean checkIfTrue(Node tree){
        while(tree.nodeType != Node.Type.IF){
            if(tree.nodeType == Node.Type.ROOT){
                Log.e("ERROR", " got to root without finidng if");
                return false;
            }
            tree = tree.parent;
        }
        if(((If)tree).isTrue){
            return true;
        }else {
            return false;
        }
    }


    public void LogTree(Node tree){

        Boolean leftChild = false;
        Boolean rightChild = false;
        if (tree.left != null){
            leftChild = true;
            Log.d("CdTc Going left", tree.left.nodeType.toString());
            if(tree.left.nodeType.equals(Node.Type.VAR)){
                try {
                    Log.d("CdTc type is", ((Variable) tree.left).varNodeType.toString());
                }catch (NullPointerException e){
                    Log.d("CdTc type is", "null");
                }
            }
            if (tree.left.isCurrentNode){
                Log.d("CdTc And IS", "CURRENT " + tree.left.nodeType.toString());
            }else{
           //     Log.e("IS Not ", "CURRENT");
            }
            LogTree(tree.left);

        }
        if (tree.right != null){
            rightChild = true;
            Log.d("CdTc Going right", tree.right.nodeType.toString());
            if(tree.right.nodeType.equals(Node.Type.VAR)){
                Log.d("CdTc type is" , ((Variable)tree.right).varNodeType.toString());
            }
            if (tree.right.isCurrentNode){
                Log.d("CdTc And IS", "CURRENT " + tree.right.nodeType.toString());
            }else{
             //   Log.e("IS Not ", "CURRENT");
            }
            LogTree(tree.right);

        }
        if(!leftChild) {
            Log.d("CdTc no l children for ", tree.nodeType.toString());
        }
        if(!rightChild) {
            Log.d("CdTc No r children for ", tree.nodeType.toString());

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

    public void countNewLines(Node tree){
        if (tree.left != null){
            if(tree.left.nodeType.equals(Node.Type.NEWLINE)){
                Log.d("Newline", " left");
                numberOfNewLines += 1;
            }
            countNewLines(tree.left);

        }
        if (tree.right != null){
            if(tree.right.nodeType.equals(Node.Type.NEWLINE)){
                Log.d("Newline", " right");
                numberOfNewLines += 1;
            }
            countNewLines(tree.right);
        }
    }






    public void clearButtons(){
        LinearLayout col2 = (LinearLayout)findViewById(R.id.buttons);
        for (int i = 0; i < col2.getChildCount(); i++) {
            View a = col2.getChildAt(i);
            a.setVisibility(View.GONE);
        }
    }


    public Node doButtonLogic(Button b, Node curNode, Variable.Type varType, String varTypeString){
        if(tree.isXbeforeY(curNode, Node.Type.PRINT, Node.Type.SEQ) && curNode.nodeType == Node.Type.VAR){
            tree.updateVarType(tree, varType);
            tree.setVarName(tree, b.getText().toString());
        }else {
            if(curNode.nodeType != Node.Type.VAR) {
                tree = tree.addNode(tree, Node.Type.VAR, "left", varTypeString);
                tree.setVarName(tree, b.getText().toString());
                curNode = tree.findCurNode(tree);
            }else {
                tree.updateVarType(tree, varType);
                tree.setVarName(tree, b.getText().toString());
            }
        }
        return curNode;
    }




    public void visitNodeVar(Node tree) {
        Node.Type nodeType = tree.nodeType;
        if (nodeType == Node.Type.SMCLN) {
            Variable.Type type = null;
            if (tree.isXbeforeY(tree, Node.Type.DEC, Node.Type.SEQ)) {
                Variable v;// = new Variable(null, null, null, null);
                if (tree.isXbeforeY(tree, Node.Type.EVAL, Node.Type.SEQ)) {
                    v = tree.returnAssignVar(tree);
                } else {
                    v = tree.returnDecVar(tree);
                }
                type = v.varNodeType;
                if (!checkVarExists(v.name)) {
                    Variable var = new Variable(null, type, v.name, null);
                    variablesArray.get(functionDimensions.size()).get(openCurlysIndent.size()).add(var);
                }
            }

        } else if (nodeType == Node.Type.FORLOOP) {
            switch (((Loops) tree).varNodeType) {
                case FOR:
                    if (((Loops) tree).limiter != null) {
                        openCurlysIndent.add(true);
                        addToVariablesArray();
                        if (!checkVarExists(((Loops) tree).limiter.toString())) {
                            String name = ((Loops) tree).limiter.toString();
                            Variable v = new Variable(null, Variable.Type.INT, name, null);
                            variablesArray.get(functionDimensions.size()).get(openCurlysIndent.size()).add(v);
                        }
                    }
                    break;
            }
        } else if (nodeType == Node.Type.END) {
            openCurlysIndent.remove(openCurlysIndent.size() - 1);
            if(((Newline)tree.parent).newlineNodeType == Newline.Type.FUNCEND){
                removeFunctionDimension();
            }else {
                variablesArray.get(functionDimensions.size()).remove(variablesArray.get(functionDimensions.size()).size() - 1);
            }
        } else if (nodeType == Node.Type.ELSE) {
            openCurlysIndent.add(true);
            addToVariablesArray();
        } else if (nodeType == Node.Type.ENDIFCONDITION) {
            openCurlysIndent.add(true);
            addToVariablesArray();
        } else if (nodeType == Node.Type.FUNCTION) {
            if (((Function) tree).isDec) {
                addFunctionDimension();
                if (((Function) tree).decFinished) {
                    addToVariablesArray();
                    openCurlysIndent.add(true);
                }
            }
        }
    }

    public void addToVariablesArray(){
        try {
            variablesArray.get(functionDimensions.size()).add(new ArrayList<Variable>());
        } catch (IndexOutOfBoundsException e){
            variablesArray.add(new ArrayList<ArrayList<Variable>>());
            variablesArray.get(functionDimensions.size()).add(new ArrayList<Variable>());
        }
    }

    public void addFunctionDimension(){
        functionDimensions.add(true);
        variablesArray.add(new ArrayList<ArrayList<Variable>>());
        ArrayList<Variable> globals = variablesArray.get(0).get(0);
        variablesArray.get(functionDimensions.size()).add(globals);
    }

    public void removeFunctionDimension(){
        functionDimensions.remove(functionDimensions.size() - 1);
        variablesArray.remove(variablesArray.size() - 1);
    }



    public Boolean runFillVar(Node node, Boolean curNodeFound){
        if(node.isCurrentNode == true){
            curNodeFound = true;
        }
        if(!curNodeFound) {
            visitNodeVar(node);
            if (node.left != null) {
                curNodeFound = runFillVar(node.left, curNodeFound);
            }
            if (node.right != null && !curNodeFound) {
                curNodeFound = runFillVar(node.right, curNodeFound);
            }
        }
        return curNodeFound;
    }

    public Boolean runFillFuncUpToCurrentNode(Node node, Boolean curNodeFound){
        if(node.isCurrentNode == true){
            curNodeFound = true;
        }
        if(!curNodeFound) {
            visitNodeFunc(node);
            if (node.left != null) {
                curNodeFound = runFillFuncUpToCurrentNode(node.left, curNodeFound);
            }
            if (node.right != null && !curNodeFound) {
                curNodeFound = runFillFuncUpToCurrentNode(node.right, curNodeFound);
            }
        }
        return curNodeFound;
    }




    public void fillVariablesArray(){
        variablesArray.clear();
        functionDimensions.clear();
        variablesArray = new ArrayList<ArrayList<ArrayList<Variable>>>();
        addToVariablesArray();
        openCurlysIndent.clear();
        runFillVar(tree, false);
    }

    public void visitNodeFunc(Node tree){
        Node.Type nodeType = tree.nodeType;
        if(nodeType == Node.Type.FUNCTION ){
            if(((Function)tree).name != null) {
                functionsArray.add((Function)tree);
            }
        }
    }

    public Boolean runFillFunc(Node node, Boolean curNodeFound){
        visitNodeFunc(node);
        if (node.left != null) {
            curNodeFound = runFillFunc(node.left, curNodeFound);
        }
        if (node.right != null && !curNodeFound) {
            curNodeFound = runFillFunc(node.right, curNodeFound);
        }
        return curNodeFound;
    }

    public void fillFunctionsArray(){
        functionsArray.clear();
        functionsArray = new ArrayList<Function>();
        runFillFunc(tree, false);
    }

    public void fillFunctionsArrayUpToCurrentNode(){
        functionsArray.clear();
        functionsArray = new ArrayList<Function>();
        runFillFuncUpToCurrentNode(tree, false);
    }


    public void showFunctionButtons(Function.Type funcType){
        funcButtons.clear();
        Node.Type nodeType = tree.findCurNode(tree).nodeType;
        LinearLayout ll = (LinearLayout) findViewById(R.id.buttons);
        fillFunctionsArray();
            for (int i = 0; i < functionsArray.size(); i++) {
                if (funcType == null || functionsArray.get(i).funcType == funcType) {
                    final Button b = new Button(this);
                    s = "<b><i>" + functionsArray.get(i).name + "</i></b>";
                    b.setText(Html.fromHtml(s));
                    b.setId(i);
                    b.setContentDescription(functionsArray.get(i).funcType.toString());
                    if (functionsArray.get(i).funcType == Function.Type.STRING) {
                        b.setBackgroundColor(0x9933FF0);
                    } else if (functionsArray.get(i).funcType == Function.Type.INT) {
                        b.setBackgroundColor(0xFFFF0000);
                    } else if (functionsArray.get(i).funcType == Function.Type.BOOL) {
                        b.setBackgroundColor(0x9966FF0);
                    } else if (functionsArray.get(i).funcType == Function.Type.VOID) {
                        b.setBackgroundColor(0x9966FF0);
                    }
                    b.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Node curNode = tree.findCurNode(tree);
                            clearButtons();
                            if (b.getContentDescription().equals(Function.Type.STRING.toString())) {
                                curNode = curNode.setFunctionCallNameAndType(curNode, FunctionCall.Type.STRING, b.getText().toString());
                            } else if (b.getContentDescription().equals(Function.Type.INT.toString())) {
                                curNode = curNode.setFunctionCallNameAndType(curNode, FunctionCall.Type.INT, b.getText().toString());
                            } else if (b.getContentDescription().equals(Function.Type.BOOL.toString())) {
                                curNode = curNode.setFunctionCallNameAndType(curNode, FunctionCall.Type.BOOL, b.getText().toString());
                            }else if (b.getContentDescription().equals(Function.Type.VOID.toString())) {
                                curNode = curNode.setFunctionCallNameAndType(curNode, FunctionCall.Type.VOID, b.getText().toString());
                            }
                            code.setText("");
                            if (tree != null) {
                                //  openLoopsIndent.clear();
                                //  openIfsIndent.clear();
                                variablesArray.clear();
                                functionDimensions.clear();
                                addToVariablesArray();
                                openCurlysIndent.clear();
                                tree = checkNewLineNotDeleted();
                                printTree(tree);
                                setCursorToEndOfCurrentLine(0);
                                doButtonLogic();
                                //code.setSelection(code.getText().length());
                            }
                            funcButtons.add(b);
                            hideFuncButtons();
                        }
                    });
                    ll.addView(b);
                }
            }
    }

    public void hideKeyboard(){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void showVarButtons(Variable.Type varType){
        varButtons.clear();
        Node.Type nodeType = tree.findCurNode(tree).nodeType;
        if((nodeType != Node.Type.PRINT) && (nodeType != Node.Type.OP) && (nodeType != Node.Type.CONDITION) ){
            if(!tree.isXbeforeY(tree.findCurNode(tree), Node.Type.EVAL, Node.Type.SEQ)) {
                btnNewVar.setVisibility(View.VISIBLE);
            }
        }
        LinearLayout ll = (LinearLayout) findViewById(R.id.buttons);
        fillVariablesArray();
        fillFunctionsArray();
        for(int j = 0; j < variablesArray.get(functionDimensions.size()).size(); j ++) {
            ArrayList<Variable> variables = variablesArray.get(functionDimensions.size()).get(j);
            for (int i = 0; i < variables.size(); i++) {
                if (varType == null || variables.get(i).varNodeType == varType) {
                    final Button b = new Button(this);
                    s = "<b><i>" + variables.get(i).name + "</i></b>";
                    b.setText(Html.fromHtml(s));
                    b.setId(i);
                    b.setContentDescription(variables.get(i).varNodeType.toString());
                    if (variables.get(i).varNodeType == Variable.Type.STRING) {
                        b.setBackgroundColor(0x9933FF0);
                    } else if (variables.get(i).varNodeType == Variable.Type.INT) {
                        b.setBackgroundColor(0xFFFF0000);
                    } else if (variables.get(i).varNodeType == Variable.Type.BOOL) {
                        b.setBackgroundColor(0x9966FF0);
                    }
                    b.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            btnDelete.setVisibility(View.GONE);
                            btnUpLine.setVisibility(View.GONE);
                            btnDownLine.setVisibility(View.GONE);
                            Node curNode = tree.findCurNode(tree);
                            clearButtons();
                            if (b.getContentDescription().equals(Variable.Type.STRING.toString())) {
                                curNode = doButtonLogic(b, curNode, Variable.Type.STRING, "String");
                            } else if (b.getContentDescription().equals(Variable.Type.INT.toString())) {
                                curNode = doButtonLogic(b, curNode, Variable.Type.INT, "Int");
                            } else if (b.getContentDescription().equals(Variable.Type.BOOL.toString())) {
                                curNode = doButtonLogic(b, curNode, Variable.Type.BOOL, "Bool");
                            }
                            btnNewVar.setVisibility(View.GONE);
                            if (tree.isXbeforeY(curNode, Node.Type.EVAL, Node.Type.SEQ) || tree.isXbeforeY(curNode, Node.Type.IF, Node.Type.SEQ)) {
                                endIfCondition(curNode);
                                btnOperator.setVisibility(View.VISIBLE);
                                showBracketButtons(curNode);
                            }
                            if (tree.isXbeforeY(curNode, Node.Type.SEQ, Node.Type.EVAL) && tree.isXbeforeY(curNode, Node.Type.SEQ, Node.Type.IF)) {
                                btnEquals.setVisibility(View.VISIBLE);
                            } else {
                                showSemicolonButton();
                            }
                            code.setText("");
                            if (tree != null) {
                                variablesArray.clear();
                                functionDimensions.clear();
                                addToVariablesArray();
                                openCurlysIndent.clear();
                                tree = checkNewLineNotDeleted();
                                printTree(tree);
                                setCursorToEndOfCurrentLine(0);
                            }
                            varButtons.add(b);
                            hideVarButtons();

                        }
                    });
                    ll.addView(b);
                }
            }
        }
    }




    public Function getFunctionFromName(String name){
        for(int i = 0; i < functionsArray.size(); i++){
            if(functionsArray.get(i).name.equals(name)){
                return functionsArray.get(i);
            }
        }
        return null;
    }

    public void doFunctionCallParams(Node currentNode){
        Function f = getFunctionFromName(((FunctionCall)currentNode).functionName);
        if(f.parameters.size() == 0){
            ((FunctionCall)currentNode).paramsFinished = true;
        }
    }

    public Node checkNewLineNotDeleted(){
        Node node = tree;
        while(node.right != null){
            node = node.right;
        }
        if(node.nodeType != Node.Type.NEWLINE){
            node.right = new Newline(node, Newline.Type.NONE);
        }
        return tree;
    }

    public void onBtnClicked(View v) {
        clearButtons();
        btnDelete.setVisibility(View.GONE);
        btnUpLine.setVisibility(View.GONE);
        btnDownLine.setVisibility(View.GONE);
        String text = "";
        Boolean clearScreen = false;
        Integer move = 0;
        switch (v.getId()) {
            case R.id.btnPrint:
                Log.d("DEBUG", "PRESS PRINT");
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", null);
                tree = tree.addNode(tree, Node.Type.PRINT, "left", null);
                tree = tree.addNode(tree, Node.Type.EVAL, "left", null);
                break;


            case R.id.btnExistingFunc:
                tree = tree.addNode(tree, Node.Type.FUNCCALL, "left", null);
                break;


            case R.id.btnFunctions:
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "FUNCTION");

              //  tree = tree.addNode(tree, Node.Type.NEWLINE, "left", null);
                tree = tree.addNode(tree, Node.Type.FUNCTION, "left", null);
                break;

            case R.id.btnFuncInt:
                tree = tree.updateFuncType(tree, Function.Type.INT);
                tree = tree.updateFuncIsDec(tree, true);

                break;

            case R.id.btnFuncBool:
                tree = tree.updateFuncType(tree, Function.Type.BOOL);
                tree = tree.updateFuncIsDec(tree, true);
                break;

            case R.id.btnFuncString:
                tree = tree.updateFuncType(tree, Function.Type.STRING);
                tree = tree.updateFuncIsDec(tree, true);
                break;

            case R.id.btnFuncVoid:
                tree = tree.updateFuncType(tree, Function.Type.VOID);
                tree = tree.updateFuncIsDec(tree, true);
                break;

            case R.id.btnEnterFuncName:
                String name = edtEnterString.getText().toString().trim();
                hideKeyboard();
                Boolean funcNameExists = false;
                for(int i = 0; i < functionsArray.size(); i++){
                    if(functionsArray.get(i).name.equals(name)){
                        funcNameExists = true;
                    }
                }
               if(funcNameExists){
                    showInvalidAlert("Error: A function has already been declared with this name, please choose another name");
                }else if(name.length() == 0) {
                    showInvalidAlert("Error: please enter a name for the function");
                } else {
                   tree = tree.updateFuncName(tree, name);
               }
                break;

            case R.id.btnEndFuncDec:
                Node currentNode = (tree.findCurNode(tree));
                tree = tree.addNode(tree, Node.Type.BLANK, "left", null);
                tree = tree.addNode(tree, Node.Type.RESETRETURN, "right", null);
                tree = tree.moveUpOneStep(tree);
                tree = tree.addNode(tree, Node.Type.STARTFUNC, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "right", "FUNCEND");
                tree = tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpTreeLimit(tree, "STARTFUNC");
                tree = tree.addNode(tree, Node.Type.NONE, "left", null);
                if(((Function)currentNode).funcType != Function.Type.VOID){
                    tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                    tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "NEWLINE");
                    tree = tree.moveUpTreeLimit(tree, "SEQ");
                    tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                    tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "RETURN");
                    tree = tree.addNode(tree, Node.Type.RETURN, "left", "true");
                    if(((Function)currentNode).funcType == Function.Type.BOOL){
                        tree = tree.addNode(tree, Node.Type.EVAL, "left", "BOOL");
                        tree = tree.addNode(tree, Node.Type.VARVAL, "left", "true");
                        tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
                        tree = tree.moveUpTreeLimit(tree, "SEQ");
                    }
                    if(((Function)currentNode).funcType == Function.Type.STRING){
                        tree = tree.addNode(tree, Node.Type.EVAL, "left", "STRING");
                        tree = tree.addNode(tree, Node.Type.VARVAL, "left", "<empty String>");
                        tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
                        tree = tree.moveUpTreeLimit(tree, "SEQ");
                    }
                    if(((Function)currentNode).funcType == Function.Type.INT){
                        tree = tree.addNode(tree, Node.Type.EVAL, "left", "INT");
                        tree = tree.addNode(tree, Node.Type.VARVAL, "left", "0");
                        tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
                        tree = tree.moveUpTreeLimit(tree, "SEQ");
                    }
                    tree = tree.moveUpTreeLimit(tree, "NONE");
                }


                Node functionNode =  tree.findCurNode(tree).parent.parent.parent;
                functionNode = tree.setFuncParamFinished(functionNode, true);
                functionNode = tree.setFuncEndDec(functionNode, true);


                break;

            case R.id.btnEditReturn:
                tree = tree.moveDownDirectionLimit(tree, "left", "EVAL");
                Node n = tree.findCurNode(tree);
                if(n.left != null) {
                    n.left = null;
                }
                if(n.right != null) {
                    n.right = null;
                }
                break;

            case R.id.btnFuncReturn:
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "RETURN");
                tree = tree.addNode(tree, Node.Type.RETURN, "left", "false");
                Function.Type funcType = tree.getCurrentFuncType(tree);
                if(funcType == Function.Type.BOOL) {
                    tree = tree.addNode(tree, Node.Type.EVAL, "left", "BOOL");
                }else if(funcType == Function.Type.STRING) {
                    tree = tree.addNode(tree, Node.Type.EVAL, "left", "STRING");
                }
                else if(funcType == Function.Type.INT) {
                    tree = tree.addNode(tree, Node.Type.EVAL, "left", "INT");
                }
                break;

            case R.id.btnNewLine:
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "NEWLINE");
                tree = tree.moveUpTreeLimit(tree, "SEQ");
                break;

            case R.id.btnDelete:
                Log.d("DEBUG", "PRESS PRINT");
                Node currentN = tree.findCurNode(tree);
                Node.Type currentNodeType = currentN.nodeType;
                Boolean canDelete = true;
                if(currentNodeType == Node.Type.SEQ) {
                    if(currentN.left.nodeType == Node.Type.NEWLINE){
                        if(((Newline)currentN.left).newlineNodeType == Newline.Type.RETURN){
                            if(((Return)currentN.left.left).isInitialReturn){
                                showInvalidAlert("Cannot delete this return, every none void function must return a value");
                                canDelete = false;
                            }
                        }
                    }
                }
                if(canDelete) {
                    tree = tree.delete(tree, lineJustPressed);
                }
                btnDelete.setVisibility(View.VISIBLE);
                btnUpLine.setVisibility(View.VISIBLE);
                btnDownLine.setVisibility(View.VISIBLE);
                showElse();
                break;

            case R.id.btnSetEvalTypeInt:
                tree = tree.updateEval(tree, Eval.Type.INT);
                break;

            case R.id.btnSetEvalTypeString:
                tree = tree.updateEval(tree, Eval.Type.STRING);
                break;

            case R.id.btnSetEvalTypeBool:
                tree = tree.updateEval(tree, Eval.Type.BOOL);
                break;


            case R.id.printBack:
                Log.d("DEBUG", "PRESS PRINT BACK");
                btnPrintBack.setVisibility(View.GONE);
                clearButtons();
                //  showButtons(homeMenu);
                edtEnterString.setVisibility(View.GONE);
                backTree(tree, "SEQ", 1, "right");
                break;

            case R.id.run:
                errorStack = new ArrayList<String>();
                output.setText("");
                tree.renumberNodes(tree);
                variablesArray.clear();
                functionDimensions.clear();
                addToVariablesArray();
                openCurlysIndent.clear();
                runCode(tree);
              //  clearVar();
                if(errorStack.size() > 0 ){
                    output.setText(" ");
                    for(int i = 0; i < errorStack.size(); i++){
                        output.append(errorStack.get(i));
                    }
                }
                break;


            case R.id.loops:
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "FOR");
                break;


            case R.id.btnFor:
                tree = tree.addNode(tree, Node.Type.FORLOOP, "left", "For");
                break;

            case R.id.btnForNewVar:
                clearButtons();
                break;

            case R.id.btnForNewVarEnter:
                String varName = edtEnterString.getText().toString().trim();
                hideKeyboard();
                clearButtons();
                variablesArray.clear();
                functionDimensions.clear();
                addToVariablesArray();
                openCurlysIndent.clear();
                runFillVar(tree, false);
                if(checkVarExists(varName)){
                    showInvalidAlert("Error: A variable has already been declared with this name");
                }else if(varName.length() == 0) {
                    showInvalidAlert("Error: please enter a name for the variable");

                } else {
                    ((Loops) tree.findCurNode(tree)).limiter = edtEnterString.getText().toString().trim();
                }
                //      edtEnterString.setVisibility(View.VISIBLE);
                //     btnForNewVarValueEnter.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForNewVarValueEnter:
                text = edtEnterString.getText().toString().trim();
                hideKeyboard();
                try {
                    int num = Integer.parseInt(text);
                    clearButtons();
                    ((Loops) tree.findCurNode(tree)).lowerLim = Integer.parseInt(text);
                    //        btnForLess.setVisibility(View.VISIBLE);
                    //      btnForGreater.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    showInvalidAlert("Please enter a valid value");
                }
                break;

            case R.id.btnForLess:
                //     clearButtons();
                ((Loops) tree.findCurNode(tree)).operator = Operator.Type.LESSTHAN;
                //    edtEnterString.setVisibility(View.VISIBLE);
                //  btnForNewVarValueUpperEnter.setVisibility(View.VISIBLE);
                break;

            case R.id.btnForGreater:
                //  clearButtons();
                ((Loops) tree.findCurNode(tree)).operator = Operator.Type.MORETHAN;
                //     edtEnterString.setVisibility(View.VISIBLE);
                //   btnForNewVarValueUpperEnter.setVisibility(View.VISIBLE);
                break;


            case R.id.btnForNewVarValueUpperEnter:
                text = edtEnterString.getText().toString().trim();
                hideKeyboard();
                try {
                    int num = Integer.parseInt(text);
                    clearButtons();
                    ((Loops) tree.findCurNode(tree)).upperLim = Integer.parseInt(text);
                    //      btnForPlus.setVisibility(View.VISIBLE);
                    //    btnForMinus.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    showInvalidAlert("Please enter a valid value");
                }
                break;

            case R.id.btnForPlus:
                //   clearButtons();
                ((Loops) tree.findCurNode(tree)).plusOrMinus = "++";
                tree.addNode(tree, Node.Type.NEWLINE, "right", "FOREND");
                tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpTreeLimit(tree, "FORLOOP");
                tree.addNode(tree, Node.Type.STARTLOOP, "left", null);
          //      tree.addNode(tree, Node.Type.NEWLINE, "right", "FOREND");
           //     tree.addNode(tree, Node.Type.END, "right", null);
            //    tree = tree.moveUpTreeLimit(tree, "STARTLOOP");
                // showButtons(homeMenu);
                break;

            case R.id.btnForMinus:
                //   clearButtons();
                ((Loops) tree.findCurNode(tree)).plusOrMinus = "--";
                tree.addNode(tree, Node.Type.NEWLINE, "right", "FOREND");
                tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpTreeLimit(tree, "FORLOOP");
                tree.addNode(tree, Node.Type.STARTLOOP, "left", null);
            //    tree.addNode(tree, Node.Type.NEWLINE, "right", "FOREND");
            //    tree.addNode(tree, Node.Type.END, "right", null);
             //   tree = tree.moveUpTreeLimit(tree, "STARTLOOP");
                //   showButtons(homeMenu);
                break;




            case R.id.clear:
                initialise();
                clearButtons();
                //  openLoops.clear();
                // openCurlys.clear();
                openBrackets.clear();
                output.setText("");
                //   variables.clear();
                variablesArray.clear();
                functionDimensions.clear();
                addToVariablesArray();
                showButtons(homeMenu);
                break;

            case R.id.LogTree:
                LogTree(tree);
                numberOfNewLines = 0;
                countNewLines(tree);
                Log.d("Number of lines = ", numberOfNewLines.toString());
                break;


            case R.id.semicolon:
                Log.d("DEBUG", "PRESS ;");
                if(tree.isXbeforeY(tree.findCurNode(tree), Node.Type.RETURN, Node.Type.SEQ)) {
                    tree = tree.addNode(tree, Node.Type.SMCLN, "right", "RETURN");
                }else{
                    tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
                }
                tree = tree.moveUpTreeLimit(tree, "SEQ");
                clearButtons();
                // showButtons(homeMenu);
                break;



            case R.id.var:
                    clearButtons();
                Node curNode = tree.findCurNode(tree);
                if ((curNode.nodeType == Node.Type.SEQ) || curNode.nodeType == Node.Type.NONE || (curNode.nodeType == Node.Type.ROOT) || (curNode.nodeType == Node.Type.STARTLOOP) || (curNode.nodeType == Node.Type.STARTIF) || (curNode.nodeType == Node.Type.ELSE)) { //TODO: make this more efficient by making isValidResting property of Node
                    tree = tree.addNode(tree, Node.Type.SEQ, "right", "none");
                    tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "none");
                    //   tree.addNode(tree, Node.Type.VAR, "left", null);
                } else if ((curNode.nodeType == Node.Type.EVAL) || curNode.nodeType == Node.Type.OP) {
                    //    if(tree.isXbeforeY(curNode, Node.Type.PRINT, Node.Type.SEQ)){
                    tree.addNode(tree, Node.Type.VAR, "left", null);
                    //   }
                /*    else if (tree.returnEvalVar(tree.findCurNode(tree)).evalNodeType == Eval.Type.STRING) {
                        tree.addNode(tree, Node.Type.VAR, "left", "String");
                    }else if (tree.returnEvalVar(tree.findCurNode(tree)).evalNodeType == Eval.Type.INT) {
                        tree.addNode(tree, Node.Type.VAR, "left", "Int");
                    }else if (tree.returnEvalVar(tree.findCurNode(tree)).evalNodeType == Eval.Type.BOOL) {
                        tree.addNode(tree, Node.Type.VAR, "left", "Bool");
                    }*/
                }
                showVarButtons(null);
                break;

            case R.id.varNew:
                //   clearButtons();
                tree = tree.addNode(tree, Node.Type.DEC, "left", "none");
                break;

            case R.id.btnVarNewString:
                tree = tree.updateDec(tree, Dec.Type.STRING);
                break;

            case R.id.btnVarNewInt:
                tree = tree.updateDec(tree, Dec.Type.INT);
                break;

            case R.id.btnVarNewBool:
                tree = tree.updateDec(tree, Dec.Type.BOOL);
                break;


            case R.id.btnEnterVarName:

                String vName = edtEnterString.getText().toString().trim();
                hideKeyboard();

                variablesArray.clear();
                addToVariablesArray();
                runFillVar(tree, false);
                if(checkVarExists(vName)){
                    showInvalidAlert("Error: A variable has already been declared with this name in this scope");
                }else if(vName.length() == 0) {
                    showInvalidAlert("Error: please enter a name for the variable");
                } else {
                    if (((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.STRING) {
                        tree = tree.addNode(tree, Node.Type.VAR, "left", "String");
                    } else if (((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.INT) {
                        tree = tree.addNode(tree, Node.Type.VAR, "left", "Int");
                    } else if (((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.BOOL) {
                        tree = tree.addNode(tree, Node.Type.VAR, "left", "Bool");
                    }
                    tree.setVarName(tree, vName);
                }
                break;


            case R.id.btnEquals:
                tree = tree.addNode(tree, Node.Type.ASSIGN, "right", null);
                tree = tree.addNode(tree, Node.Type.EVAL, "left", null);
                Variable.Type type = tree.getVarType(tree.findCurNode(tree));
                if (type == Variable.Type.INT) {
                    tree = tree.updateEval(tree, Eval.Type.INT);
                } else if (type == Variable.Type.STRING) {
                    tree = tree.updateEval(tree, Eval.Type.STRING);
                } else if (type == Variable.Type.BOOL) {
                    tree = tree.updateEval(tree, Eval.Type.BOOL);
                }
                break;

            case R.id.btnTypeInput:
                tree = tree.addNode(tree, Node.Type.VARVAL, "left", null);
                break;

            case R.id.btnBoolTrue:
                tree = tree.addNode(tree, Node.Type.VARVAL, "left", "true");
                break;

            case R.id.btnBoolFalse:
                tree = tree.addNode(tree, Node.Type.VARVAL, "left", "false");
                break;


            case R.id.btnEnterVarValue:
                hideKeyboard();
                if ((tree.returnEvalNode(tree.findCurNode(tree)).evalNodeType == Eval.Type.INT)) {
                    text = edtEnterString.getText().toString();
                    try {
                        int num = Integer.parseInt(text);
                        tree = tree.updateVarVal(tree, edtEnterString.getText().toString());
                    } catch (NumberFormatException e) {
                        showInvalidAlert("Please enter a valid value");
                    }
                } else {
                    tree = tree.updateVarVal(tree, edtEnterString.getText().toString());
                }
                break;


            case R.id.btnEnterTextString:
                hideKeyboard();
                if (tree.isXbeforeY(tree.findCurNode(tree), Node.Type.VARVAL, Node.Type.SEQ)) {
                    tree = tree.updateVarVal(tree, edtEnterString.getText().toString());
                } else {
                    tree = tree.addNode(tree, Node.Type.VARVAL, "left", edtEnterString.getText().toString());
                }
                break;

            case R.id.btnOperator:
                tree = tree.addNode(tree, Node.Type.OP, "right", null);
                break;

            case R.id.btnOperatorAdd:
                tree = tree.updateOp(tree, Operator.Type.ADD);
                break;

            case R.id.btnOperatorConcat:
                tree = tree.updateOp(tree, Operator.Type.CONCAT);
                break;

            case R.id.btnOperatorSub:
                tree = tree.updateOp(tree, Operator.Type.SUB);
                break;

            case R.id.btnOperatorMod:
                tree = tree.updateOp(tree, Operator.Type.MOD);
                break;

            case R.id.btnOperatorMulti:
                tree = tree.updateOp(tree, Operator.Type.MULTI);
                break;

            case R.id.btnOperatorDiv:
                tree = tree.updateOp(tree, Operator.Type.DIV);
                break;

            case R.id.btnOpenBracket:
                tree = tree.addNode(tree, Node.Type.BRACKET, "left", "Open");
                openBrackets.add(true);
                break;

            case R.id.btnCloseBracket:
                tree = tree.addNode(tree, Node.Type.BRACKET, "left", "Close");
                openBrackets.remove(openBrackets.size() - 1);

                break;

            case R.id.btnOperatorBoolAnd:
                tree = tree.updateOp(tree, Operator.Type.AND);
                break;

            case R.id.btnOperatorBoolOr:
                tree = tree.updateOp(tree, Operator.Type.OR);
                break;

            case R.id.btnOperatorLessThan:
                tree = tree.updateOp(tree, Operator.Type.LESSTHAN);
                //  tree.addNode(tree, Node.Type.EVAL, "left", "none");

                break;

            case R.id.btnOperatorLessThanEqual:
                tree = tree.updateOp(tree, Operator.Type.LESSTHANEQUALS);
                // tree.addNode(tree, Node.Type.EVAL, "left", "none");

                break;

            case R.id.btnOperatorMoreThan:
                tree = tree.updateOp(tree, Operator.Type.MORETHAN);
                //    tree.addNode(tree, Node.Type.EVAL, "left", "none");

                break;

            case R.id.btnOperatorMoreThanEquals:
                tree = tree.updateOp(tree, Operator.Type.MORETHANEQUALS);
                //    tree.addNode(tree, Node.Type.EVAL, "left", "none");
                break;

            case R.id.btnOperatorEquality:
                tree = tree.updateOp(tree, Operator.Type.EQUALS);
                //     tree.addNode(tree, Node.Type.EVAL, "left", "none");

                break;

            case R.id.btnOperatorInequality:
                tree = tree.updateOp(tree, Operator.Type.NOTEQUALS);
                //     tree.addNode(tree, Node.Type.EVAL, "left", "none");
                break;

            case R.id.btnIf:
                tree = tree.addNode(tree, Node.Type.SEQ, "right", "none");
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "IF");
                tree = tree.addNode(tree, Node.Type.IF, "left", "none");
                tree = tree.addNode(tree, Node.Type.CONDITION, "left", "none");
                tree = tree.addNode(tree, Node.Type.EVAL, "left", "none");
                break;

            case R.id.btnElse:
                //  tree = tree.moveDownOneStep(tree, "left");
                // tree = tree.moveDownOneStep(tree, "left");
                tree = tree.moveDownDirectionLimit(tree, "left", "CONDITION");
                tree = tree.moveDownDirectionLimit(tree, "right", "END");
                tree = tree.addNode(tree, Node.Type.NEWLINE, "right", "ELSE");
                tree = tree.addNode(tree, Node.Type.ELSE, "right", "none");
                tree.addNode(tree, Node.Type.NEWLINE, "right", "ELSEEND");
                tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpTreeLimit(tree, "ELSE");

                //  addOpenCurly();
                //openCurlys.add(true);
                break;

            case R.id.btnEndIfCondition:
                tree = tree.addNode(tree, Node.Type.ENDIFCONDITION, "left", "none");
                Node node = tree.findCurNode(tree);
                tree = tree.moveUpTreeLimit(tree, "CONDITION");
                tree = tree.addNode(tree, Node.Type.NEWLINE, "right", "IFEND");
                tree = tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpTreeLimit(tree, "CONDITION");
                //  openIfs.add(true);
                //  addOpenCurly();
                //openCurlys.add(true);
                tree.addNode(tree, Node.Type.STARTIF, "right", "none");
                tree.addNode(tree, Node.Type.NONE, "left", "none");
                break;

            case R.id.btnUpLine:
                btnDelete.setVisibility(View.VISIBLE);
                btnUpLine.setVisibility(View.VISIBLE);
                btnDownLine.setVisibility(View.VISIBLE);
                move = -1;
                break;

            case R.id.btnDownLine:
                btnDelete.setVisibility(View.VISIBLE);
                btnUpLine.setVisibility(View.VISIBLE);
                btnDownLine.setVisibility(View.VISIBLE);
                move = 1;
                break;
        }


        edtEnterString.setText("");
        code.setText("");
        if (tree != null) {
            openCurlysIndent.clear();
            functionDimensions.clear();
            variablesArray.clear();
            addToVariablesArray();
            tree = checkNewLineNotDeleted();
            printTree(tree);
            setCursorToEndOfCurrentLine(move);
            doButtonLogic();
        }
    }

        public void doButtonLogic(){
        Node currentNode = tree.findCurNode(tree);
        Node.Type currentNodeType = currentNode.nodeType;

        if (currentNodeType == Node.Type.SEQ ||/*currentNodeType == Node.Type.NEWLINE ||*/ currentNodeType == Node.Type.ROOT || (currentNodeType == Node.Type.STARTLOOP)) {
            showButtons(homeMenu);
        }
        if (currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.IF || currentNodeType == Node.Type.ELSE || currentNodeType == Node.Type.NONE) {
            if (openCurlysIndent.size() == 0) {
                btnRun.setVisibility(View.VISIBLE);
            } else {
                btnRun.setVisibility(View.GONE);
            }
        } else {
            btnRun.setVisibility(View.GONE);
        }


        if (currentNodeType == Node.Type.OP && ((Operator) currentNode).opNodeType == null) {
            Eval.Type evalType = tree.returnEvalVar(currentNode).evalNodeType;
            if (evalType == Eval.Type.INT) {
                btnOperatorAdd.setVisibility(View.VISIBLE);
                btnOperatorSub.setVisibility(View.VISIBLE);
                btnOperatorMod.setVisibility(View.VISIBLE);
                btnOperatorMulti.setVisibility(View.VISIBLE);
                btnOperatorDiv.setVisibility(View.VISIBLE);
            } else if (evalType == Eval.Type.STRING) {
                btnOperatorConcat.setVisibility(View.VISIBLE);
            } else if (evalType == Eval.Type.BOOL) {
                btnOperatorBoolAnd.setVisibility(View.VISIBLE);
                btnOperatorBoolOr.setVisibility(View.VISIBLE);
            }
            //for if statements
            if (tree.isXbeforeY(currentNode, Node.Type.CONDITION, Node.Type.SEQ)) {
                showBracketButtons(currentNode);
                if (tree.hasConditionOperatorBeenUsed(currentNode) == false && openBrackets.size() == 0) {
                    if (evalType == Eval.Type.INT) {
                        btnOperatorLessThan.setVisibility(View.VISIBLE);
                        btnOperatorMoreThan.setVisibility(View.VISIBLE);
                        btnOperatorMoreThanEquals.setVisibility(View.VISIBLE);
                        btnOperatorLessThanEquals.setVisibility(View.VISIBLE);
                    }
                    btnOperatorEquality.setVisibility(View.VISIBLE);
                    btnOperatorInequality.setVisibility(View.VISIBLE);
                }
            }
        } else if (currentNodeType == Node.Type.OP && ((Operator) currentNode).opNodeType != null) {
            showTypeInput(currentNode);
        } else if (currentNodeType == Node.Type.DEC) {
            if (((Dec) currentNode).varNodeType == Dec.Type.NONE) {
                btnNewVar.setVisibility(View.GONE);
                btnNewVarInt.setVisibility(View.VISIBLE);
                btnNewVarString.setVisibility(View.VISIBLE);
                btnNewVarBool.setVisibility(View.VISIBLE);
            } else {
                edtEnterString.setVisibility(View.VISIBLE);
                btnEnterVarName.setVisibility(View.VISIBLE);
            }
        } else if (currentNodeType == Node.Type.VAR) {
            if (tree.isXbeforeY(currentNode, Node.Type.EVAL, Node.Type.SEQ)) {
                clearButtons();
                Eval.Type type = tree.returnEvalVar(currentNode).evalNodeType;
                if (type == Eval.Type.STRING) {
                    showVarButtons(null);
                } else if (type == Eval.Type.INT) {
                    showVarButtons(Variable.Type.INT);
                } else if (type == Eval.Type.BOOL) {
                    showVarButtons(Variable.Type.BOOL);
                } else if (type == Eval.Type.NONE) {
                    showVarButtons(Variable.Type.INT);
                }
            } else {
                edtEnterString.setText("");
                btnEquals.setVisibility(View.VISIBLE);
                showSemicolonButton();
            }
        } else if (currentNodeType == Node.Type.PRINT) {
            btnPrintBack.setVisibility(View.VISIBLE);
            showSemicolonButton();
        } else if (currentNodeType == Node.Type.VARVAL) {
            Node varVal = currentNode;
            if (((VarVal) varVal).value == null) {
                edtEnterString.setVisibility(View.VISIBLE);
                btnEnterVarValue.setVisibility(View.VISIBLE);
                //for Booleans
            } else {
                showSemicolonButton();
                btnOperator.setVisibility(View.VISIBLE);
                showBracketButtons(currentNode);
                endIfCondition(currentNode); //TODO
            }

        } else if (currentNodeType == Node.Type.FORLOOP) {
            if (((Loops) currentNode).limiter == null) {
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarEnter.setVisibility(View.VISIBLE);
            } else if (((Loops) currentNode).lowerLim == null) {
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarValueEnter.setVisibility(View.VISIBLE);
            } else if (((Loops) currentNode).operator == null) {
                btnForLess.setVisibility(View.VISIBLE);
                btnForGreater.setVisibility(View.VISIBLE);
            } else if (((Loops) currentNode).upperLim == null) {
                edtEnterString.setVisibility(View.VISIBLE);
                btnForNewVarValueUpperEnter.setVisibility(View.VISIBLE);
            } else if (((Loops) currentNode).plusOrMinus == null) {
                btnForPlus.setVisibility(View.VISIBLE);
                btnForMinus.setVisibility(View.VISIBLE);
            }

        } else if (currentNodeType == Node.Type.STRING) {
            showSemicolonButton();
            btnOperator.setVisibility(View.VISIBLE);
        } else if (currentNodeType == Node.Type.BRACKET) {
            showBracketButtons(currentNode);
            if (((Bracket) currentNode).bracketType == Bracket.Type.CLOSE) {
                btnOperator.setVisibility(View.VISIBLE);
                btnOpenBracket.setVisibility(View.GONE);
                showSemicolonButton();
                endIfCondition(currentNode); //TODO
            }else{
               showTypeInput(currentNode);
            }
        }else if(currentNodeType == Node.Type.FUNCCALL) {
            if(((FunctionCall)currentNode).type == FunctionCall.Type.NONE){
                if(!checkIfAnyFunctionsExist()){
                    showInvalidAlert("No functions to call");
                    tree = tree.moveUpTreeLimit(tree, "SEQ");
                    Node node = tree.findCurNode(tree);
                    node.left = null;
                    node.parent.isCurrentNode = true;
                    node.parent.right = node.right;
                    code.setText("");
                    printTree(tree);
                    doButtonLogic();
                }else{
                   showFunctionButtons(null);
                }
            }else {
                //situation where function call is in expression
                if (tree.isXbeforeY(currentNode, Node.Type.EVAL, Node.Type.SEQ)) {
                    //if(((FunctionCall)currentNode).type == FunctionCall.Type.INT){
                    if(((FunctionCall)currentNode).functionName == null) {
                        Eval.Type evalType = tree.returnEvalVar(currentNode).evalNodeType;
                        if (evalType == Eval.Type.STRING) {
                            showFunctionButtons(null);
                        } else if (evalType == Eval.Type.INT) {
                            showFunctionButtons(Function.Type.INT);
                        } else if (evalType == Eval.Type.BOOL) {
                            showFunctionButtons(Function.Type.BOOL);
                        }
                    }else if (!((FunctionCall) currentNode).paramsFinished) {
                        doFunctionCallParams(currentNode);
                        if (((FunctionCall) currentNode).paramsFinished) {
                            btnOperator.setVisibility(View.VISIBLE);
                            showBracketButtons(currentNode);
                            showSemicolonButton();
                        }
                    }
                } else {

                    if (!((FunctionCall) currentNode).paramsFinished) {
                        doFunctionCallParams(currentNode);
                    }
                    if (((FunctionCall) currentNode).paramsFinished) {
                        showSemicolonButton();
                    }

                }
                code.setText("");
                printTree(tree);
            }
        }
        else if (currentNodeType == Node.Type.FUNCTION) {
            if(!isOutsideAllBrackets()){
                if(!checkIfAnyFunctionsExist()){
                    showInvalidAlert("No functions to call, functions must be delcared outside any open curly brackets");
                    tree = tree.moveUpTreeLimit(tree, "SEQ");
                    Node node = tree.findCurNode(tree);
                    node.left = null;
                    node.parent.isCurrentNode = true;
                    node.parent.right = node.right;
                    code.setText("");
                    printTree(tree);
                    doButtonLogic();
                }else{
                    btnExistingFunc.setVisibility(View.VISIBLE);
                }
            }
            else if(((Function)currentNode).funcType == null){
                if(checkIfAnyFunctionsExist()){
                    btnExistingFunc.setVisibility(View.VISIBLE);
                }
                btnFuncInt.setVisibility(View.VISIBLE);
                btnFuncBool.setVisibility(View.VISIBLE);
                btnFuncString.setVisibility(View.VISIBLE);
                btnFuncVoid.setVisibility(View.VISIBLE);

            }else if(((Function)currentNode).name == null){
                edtEnterString.setVisibility(View.VISIBLE);
                btnEnterFuncName.setVisibility(View.VISIBLE);
            }else if(((Function)currentNode).paramsFinished == false){
                btnEndFuncDec.setVisibility(View.VISIBLE);
                btnFuncAddParam.setVisibility(View.VISIBLE);
            }
        }
        else if (currentNodeType == Node.Type.NONE) {
            showButtons(homeMenu);
        }
        else if (currentNodeType == Node.Type.NEWLINE) {
            if (((Newline) currentNode).newlineNodeType == Newline.Type.FOR) {
                clearButtons();
                btnFor.setVisibility(View.VISIBLE);
            }
        }
        else if (currentNodeType == Node.Type.ELSE) {
            showButtons(homeMenu);
        }
        else if (currentNodeType == Node.Type.EVAL) {
            if ((tree.returnEvalNode(currentNode)).evalNodeType == Eval.Type.NONE) {
                if (tree.isXbeforeY(currentNode, Node.Type.PRINT, Node.Type.SEQ) || tree.isXbeforeY(currentNode, Node.Type.CONDITION, Node.Type.SEQ)) {
                    btnSetEvalTypeInt.setVisibility(View.VISIBLE);
                    btnSetEvalTypeString.setVisibility(View.VISIBLE);
                    btnSetEvalTypeBool.setVisibility(View.VISIBLE);
                }
            } else {
                showTypeInput(currentNode);
            }
        }

        if ((currentNodeType != Node.Type.VARVAL) && (currentNodeType != Node.Type.STRING) && (currentNodeType != Node.Type.FUNCCALL)&& (currentNodeType != Node.Type.VAR) && (currentNodeType != Node.Type.BRACKET)) {
            btnOperator.setVisibility(View.GONE);
        }

        if(tree.isInFunction(tree)) {
            if ((currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.ROOT || currentNodeType == Node.Type.IF || currentNodeType == Node.Type.ELSE || currentNodeType == Node.Type.NONE || currentNodeType == Node.Type.STARTLOOP)) {
               if(tree.getCurrentFuncType(tree) != Function.Type.VOID) {
                   btnFuncReturn.setVisibility(View.VISIBLE);
               }
            }
        }
        if(currentNodeType == Node.Type.SEQ) {
            btnEditReturn.setVisibility(View.GONE);
            if(currentNode.left.nodeType == Node.Type.NEWLINE){
                if(((Newline)currentNode.left).newlineNodeType == Newline.Type.RETURN){
                    if(((Return)currentNode.left.left).isInitialReturn) {
                        clearButtons();
                    }
                    btnEditReturn.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void showTypeInput(Node currentNode){
        Eval.Type evalType = tree.returnEvalVar(currentNode).evalNodeType;
        if (evalType == Eval.Type.STRING) {
            btnTypeInput.setVisibility(View.VISIBLE);
            if (checkIfAnyVarsExist()) {
                btnVar.setVisibility(View.VISIBLE);
            }
            if (checkFuncTypeExistence(Function.Type.STRING)) {
                btnExistingFunc.setVisibility(View.VISIBLE);
            }
        } else if (evalType == Eval.Type.INT) {
            btnTypeInput.setVisibility(View.VISIBLE);
            if (checkVarTypeExistence(Variable.Type.INT)) {
                btnVar.setVisibility(View.VISIBLE);
            }
            if (checkFuncTypeExistence(Function.Type.INT)) {
                btnExistingFunc.setVisibility(View.VISIBLE);
            }

        } else if (evalType == Eval.Type.BOOL) {
            btnBoolTrue.setVisibility(View.VISIBLE);
            btnBoolFalse.setVisibility(View.VISIBLE);
            if (checkVarTypeExistence(Variable.Type.BOOL)) {
                btnVar.setVisibility(View.VISIBLE);
            }
            if (checkFuncTypeExistence(Function.Type.BOOL)) {
                btnExistingFunc.setVisibility(View.VISIBLE);
            }
        } else if (evalType == Eval.Type.NONE) {
            btnTypeInput.setVisibility(View.VISIBLE);
            if (checkVarTypeExistence(Variable.Type.INT)) {
                btnVar.setVisibility(View.VISIBLE);
            }
        }
        showBracketButtons(currentNode);
    }
}




//Tuesday 18th August
//ToDO: make loops work properly (with ++ -- etc) -- DONE
//TODO: implement return functionality -- DONE

//TODO: editReturn button still shows when you press on another line -- DONE

//TODO: FIX VARIABLE SCOPE

//TODO: having problems with for loops within functions


//TODO: have better error reporting, so basically if there is an error, add the error message to an array list, at the end if there are any errors, output them instead of code




//TODO: warning when you delete function declaration or variable that is used later
//TODO: don't allow var or func names with spaces etc
//TODO: make it so you can't declare a var with same name (only works if var is decalred outside all loops)

//TODO: finish editing

//TODO: implement arrays



//TODO: its a bit fucky when you go to top line, you can add in new stuff but if fucks up if you delete anything (ie you cant move down past 2nd line)



//TODO: Request focus when edt box comes up
//TODO: make it possible to save variable as null
//TODO: make it so when you select a line, all the code that will be deleted is highlighted
//TODO: editing

//TODO: idea: give conditional operators a type eg Int string or bool

//TODO: add option to add condition when you have choice to end condition






//TODO: optimize multiple calls to findCurNode
//TODO: Implement Back functionality
//TODO: Make it editable
//TODO: deal with overflows with ints, deal with dividing by 0 and using null variables
//TODO: when writing up, talk about hwo you have only done ++ with for loops, not += 2 for example. Say it's further development
//TODO: Idea - when modifying, to see if you can delete a line, run the code up to the end of that scope (i.e while opencurlies is >= to what it is for that line
// and check that that variable is not used anywhere else in the scope. if it is, make them delete that line first


//TODO: when writing up, talk about how you initially thought it would be better to not have duplicate buttons (Ie var) but this actually
//made things more confusing and if you were starting again you would have unique buttons more
//TODO: When writing up, justify why you have used binary tree and long branches







//FRIDAY 30th MAY
//TODO: put in SEQ after for loop agian --DONE
//TODO: int dec doesnt work in loop -- DONE
//TODO: Fix printing input text without op -- DONE
//TODO: Make print type, then make it so you have to choose whether to print an int or string -- DONE
//TODO: Print Text makes 2 varvals -- DONE
//TODO: Fix printing input text with op -- DONE
//TODO: Remove printy things -- DONE
//TODO: Change checkAssignVar to check Eval -- DONE
//TODO: check out why int j = then press Var doesn't show j but does with string (Wasn't an issue) -- DONE
//TODO: vars appear adfter varval eg j = x BUT PRESSING LOGTREE FIXES IT??? -- DONE
//TODO: vars still appear when in loop, then declare int without val, then on new line try and assign val. only = should appear -- DONE
//TODO: vars still appear when in loop, then NOT DEC int without val, then on new line try and assign val. only = should appear -- DONE
//TODO: when you print a var, it adds a none node to tree -- DONE
//TODO: stop double var adding after print caused by adding var when var button pressed as well as b pressed -- DONE
//TODO: make assignment work again with vars -- DONE
//TODO: stop double var on assign -- DONE
//TODO: make sure you can't use a var in it's declaration i.e. String i = k + "hi" + i. seems to happen after you input text -- DONE


//MONDAY 1st JUNE

//TODO: make declarations without ops work on run -- DONE
//TODO: make declarations with ops work on run -- DONE
//TODO: make ops run with ints -- DONE
//TODO: make ops run with strings -- DONE
//TODO: implement BODMAS for run -- DONE
//TODO: Make run work for assignments without dec -- DONE
//TODO: Make run work for print -- DONE



//Tuesday 2nd May
//TODO: fix broken var before assign: doesn't show/work -- (was a problem with optimising curNode) -- DONE
//TODO: Concatenate ints in string dec doesn't work, nor does assigning int to string (Whether int is initialized or not) -- DONE

//Wed 3rd May
//TODO: Bool make assingment work -- DONE
//TODO: make print bool work -- DONE
//TODO: Bool make bool operators -- DONE
//TODO: Booleans -- DONEISH


//Thursday 4th June

//TODO: code indentation -- BASCIALLY atm i need to get loops button showing properly (maybe by sorting out showhomemenu) and also put in Newline before end of loop -- DONE
//TODO: don't show semicolon unless brackets are closed -- DONE
//TODO: implement brackets -- DONE
//TODO: implement brackets in run -- DONE

//Sat + Sunday 7th June

//TODO: Conditionals
//TODO: generalise curly brackets -- DONE

//TODO: get end of IFs working in the code view (at the moment it deletes the code in the brackets -- DONE


//Sat 4th July

//TODO: fix endifcondition button not showing -- DONE
//TODO: Boolean assignment with operators doesnt work - fix it -- DONE
//TODO: Variables button doesn't work when pressed at start of IF statement block -- DONE
//TODO: open bracket shouldnt be an option here: if ( 9  -- DONE
//TODO: make conditional operator buttons only show at appropriate times -- DONE

//Wed 8th July
//TODO: make conditional operators only appear when brackets are closed -- DONE
//TODO: make current node be the right node when you end if statement -- DONE
//TODO: if user doesn't press else, make current node go up to seq -- DONE with justFinishedIfStatement
//TODO: be able to print true or false when printing bool -- DONE
//TODO: make it so run is only visible when there are no open brackets or open curlys -- DONE
//TODO: make sure condition isTrue value resets incase of function calls or loops etc -- DONE
//TODO: make if conditional logic work when running -- DONE
//TODO: make else work -- DONE
//TODO: cannot declare variable immediatly after ELSE -- DONE
//TODO: VARIABLE SCOPE -- DONE
//TODO: make for loop variable only valid for that for loop -- DONE

//Wed 15th July


//TODO: make else button not appear after else has already been used ie don't let if; else; else; -- DONE
//TODO: make sure run only shows in appropriate place with else -- DONE

//TODO: make new line count incorporate close curlys -- DONE

//TODO: make else appear on new line so that deleting the else part is doable -- DONE

//TODO: idea: if child of newline to be deleted is END, look up tree for previous newline DO THIS NEXT -- DONE


//Thurs 16th July


//TODO: make it so when you select a line, the cursor moves to the end -- DONE (sort of)
//TODO: make it so that delete button only appears when you touch code area -- DONE
//TODO: add nodetype to newline nodes then change how findnewlines works -- DONE
//TODO: make setting the focus change the current node correctly so that you can add in new lines of code -- DONE
//TODO: find way of selecting one line of code. Can get it to highlight up to certain index, use this combined with line number -- DONE
//TODO: idea - modify : give every newline a linenumber, when user clicks on line it highlights, they can delete line -- DONE
//TODO: idea - clear line : go up to new line, go up to seq, delete child -- DONE


//Friday 17th July
//TODO: try changing it so that newline nodes make a new line rather than the way im doing it atm -- DONE
//TODO: make it so that you can add a line at the top ( currently crashes) -- DONE
//TODO: make it so when you do insert new line into first line of for loop the line goes in the loop, not after -- DONE
//TODO: make it so when you do insert new line into first line of if the line goes in the loop, not after -- DONE
//TODO: fix indentation for close curlys -- DONE (this also fixed bold text not showing) -- DONE


//Sunday 19th July
//TODO: make the cursor appear in the right place when you go back and edit code -- getting there -- DONE
//TODO: cant delete for loop from open curly (it crashes) -- DONE
//TODO: cant insert into first lien of if -- DONE
//TODO: make variables be selectable when editing in an existing curly (at the moment it doesn't) -- DONE

//MONDAY 20th July Wed 22nd
//TODO: fix indentation when you insert a forloop into a if statement -- DONE
//TODO: get move up and move down buttons working -- DONE
//TODO : done for if (had to add stop property for newline) -- DONE
//TODO: done for for -- DONE
//almost done, need to get it working perfectly for FOR and IF
//TODO: can't delcare new var on first line in curly brackets - fix it -- DONE
//TODO: make it so that you can only select a line if you have finished the current line -- DONE
//TODO: justendedifstatement is a bit dodgy because what if you press logtree or some future button. Try and find solution that uses tree -- DONE
//TODO when you move up using buttons to close if when there is an else close bracket shouldnt appear -- DONE


//Thursday 23rd July
//TODO: check assigns in loops -- Need to implement scope -- DONE
//TODO: checknewlinenotdeleted doesnt always work (do 1 if statement then delete it) -- DONE
//TODO: checknewlinenotdeleted doesnt always work (do 1 if statement then delete it) -- DONE
//TODO: be able to add else condition afterwards -- DONE
//TODO: when you delete an if statement in a for loop, the close bracket for the for loop gets deleted too -- DONE
//TODO: at the moemnt when you delete it just deletes from the Newline, need to delete the seq aswell -- DONE
//TODO: when you go back into a loop and delclare a var, you can assing it a new value but you can't print it -- DONE
//TODO: make it so you cannot declare a variable of the same name within the same scope -- DONE
//TODO: can't use move up buttons to get to first line -- DONE

//Thursday 30th July

//TODO: deleting else from bottom close bracket crashes -- DONE

//TODO: else doesnt show when you delete an else -- DONE for deleting frop top brakcet, cant get bottom one to work

//Wed 5th August
//TODO: implement modulo operator -- DONE
//TODO: make funcitons button appear at right time -- DONE




//Friday 14th August & Sunday
//TODO: add newline button --DONE
//TODO: can't delete for within an IF without it crashing -- DONE
//TODO: make it so you can add a return value -- DONE
//TODO: do new function button workflow -- DONE
//TODO: make it so you can't delete return if its the default one -- DONE
//TODO: make button logic work when you press line -- DONE
//TODO: make it so that you can't write any code after the initial return -- DONE
//TODO: make it so that you can edit return value -- DONE
//TODO: fix menu when you press variables -- DONE by taking out NEWLINE in opetions to show home menu
//TODO: get openCurylsIndent and correct variables working when you run -- DONE
//TODO: fix for loops so that they run properly -- DONE

//Monday 17th August

//TODO: functions: might have to make varaibles array 3d? -- MADE IT 3D, NOW TO MAKE IT ADD MORE DIMENSIONS WHEN NEW FUNCTION OPENED
//
//TODO: function calls -- DONE for no parameters and no return