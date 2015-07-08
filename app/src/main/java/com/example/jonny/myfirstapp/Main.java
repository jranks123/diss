package com.example.jonny.myfirstapp;

/**
 * Created by Jonny on 19/03/2015.
 */

import android.app.Dialog;
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


    Button btnEnterText;
    Button btnEquals;

    Button btnBoolTrue;
    Button btnBoolFalse;

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
    ArrayList<Boolean> openLoopsIndent;
    ArrayList<Boolean> openBrackets;
    ArrayList<Boolean> openIfs;
    ArrayList<Boolean> openIfsIndent;
    ArrayList<Boolean> openCurlys;
    ArrayList<Boolean> openCurlysIndent;

    String tempString1;
    String s;

    Boolean justEndedIfStatement;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tree = new Node(Node.Type.ROOT, null);
        btnPrint =(Button)findViewById(R.id.btnPrint);
        btnPrintBack = (Button)findViewById(R.id.printBack);
        btnSetEvalTypeInt = (Button) findViewById(R.id.btnSetEvalTypeInt);
        btnSetEvalTypeString = (Button) findViewById(R.id.btnSetEvalTypeString);
        btnSetEvalTypeBool = (Button) findViewById(R.id.btnSetEvalTypeBool);


        btnLoops = (Button)findViewById(R.id.loops);
        btnVar = (Button)findViewById(R.id.var);
        btnNewVar = (Button) findViewById(R.id.varNew);
        btnNewVarInt = (Button) findViewById(R.id.btnVarNewInt);
        btnNewVarString = (Button) findViewById(R.id.btnVarNewString);
        btnNewVarBool = (Button) findViewById(R.id.btnVarNewBool);
        btnPrintVar =  (Button) findViewById(R.id.btnPrintVar);
        btnPrintText =  (Button) findViewById(R.id.btnPrintText);
        variables = new ArrayList<Variable>();
        openLoops = new ArrayList<Boolean>();
        openLoopsIndent = new ArrayList<Boolean>();
        openBrackets = new ArrayList<Boolean>();
        openIfs = new ArrayList<Boolean>();
        openIfsIndent = new ArrayList<Boolean>();
        openCurlys = new ArrayList<Boolean>();
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

        btnIf = (Button) findViewById(R.id.btnIf);
        btnStartIf = (Button) findViewById(R.id.btnStartIf);
        btnEndIfCondition = (Button) findViewById(R.id.btnEndIfCondition);
        btnElse = (Button) findViewById(R.id.btnElse);
        btnEndIf = (Button) findViewById(R.id.btnEndIf);

        btnCloseCurly = (Button) findViewById(R.id.btnCloseCurly);

        justEndedIfStatement = false;

        Button btnConditionalIf;
        Button btnConditionalElse;


        btnRun = (Button) findViewById(R.id.run);
        varButtons = new ArrayList<Button>();
        btnPrintTextMenu = (Button) findViewById(R.id.btnPrintTextMenu);
        homeMenu = new ArrayList<Button>();
        homeMenu.add(btnPrint);
        homeMenu.add(btnLoops);
        homeMenu.add(btnVar);
        homeMenu.add(btnIf);
        printMenu = new ArrayList<Button>();
        printMenu.add(btnPrintBack);
        printMenu.add(btnSemicolon);
        printMenu.add(btnEnterString);
        code = (TextView)findViewById(R.id.codeText);
        code.setMovementMethod(new ScrollingMovementMethod());
        output = (TextView) findViewById(R.id.runText);
        output.setMovementMethod(new ScrollingMovementMethod());
        btnLogTree = (Button)findViewById(R.id.LogTree);
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


    public boolean checkVarTypeExistence(Variable.Type type){
        if(variables != null){
            for(int i = 0; i < variables.size(); i++){
                if(variables.get(i).varNodeType == type){
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

    public void showInvalidAlert(){
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.custom_dialog);
            Button invalidValue =(Button)dialog.findViewById(R.id.alertInvalidValue);
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

    public void indent(){
       // int loop = openLoopsIndent.size() + openIfsIndent.size();
        int loop = openCurlysIndent.size();
        for(int i = 0; i < loop; i++){
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
                code.append(" ;\n");
            //   if( tree.parent.parent.nodeType == Node.Type.DEC ){
                if(tree.isXbeforeY(tree, Node.Type.DEC, Node.Type.SEQ)){
                    Variable v;// = new Variable(null, null, null, null);
                    if(tree.isXbeforeY(tree, Node.Type.EVAL, Node.Type.SEQ)) {
                        v = tree.returnAssignVar(tree);
                    }else{
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
                case BOOL:
                    code.append(Html.fromHtml(getString(R.string.bool)));
                    break;
                default:
                    break;
            }
        }
        else if(nodeType == Node.Type.FORLOOP){
            switch(((Loops)tree).varNodeType){
                case FOR:
                    code.append(Html.fromHtml(getString(R.string.forLoop)));
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
        else if(nodeType == Node.Type.NEWLINE){
                indent();
        }
        else if(nodeType == Node.Type.STARTLOOP){
            //openLoopsIndent.add(true);
            openCurlysIndent.add(true);
        }
        else if(nodeType == Node.Type.END){
           // openLoopsIndent.remove(openLoopsIndent.size() - 1);
            openCurlysIndent.remove(openCurlysIndent.size() - 1);

            indent();
            code.append("}\n");
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
            }
        }
        else if(nodeType == Node.Type.IF){
            code.append(Html.fromHtml(getString(R.string.ifString)));
        }
        else if(nodeType == Node.Type.ELSE){
            String codeText = code.getText().toString();
            code.append(Html.fromHtml(getString(R.string.elseString)));


            openCurlysIndent.add(true);
        }
        else if(nodeType == Node.Type.ENDIFCONDITION){
            code.append(Html.fromHtml(getString(R.string.endIfConditionString)) + "\n");
            //openIfsIndent.add(true);
            openCurlysIndent.add(true);
        }
        else if(nodeType == Node.Type.ENDIF){
            //openIfsIndent.remove(openIfsIndent.size() - 1);
            openCurlysIndent.remove(openCurlysIndent.size() - 1);
            indent();
            code.append(Html.fromHtml(getString(R.string.endIfString)) + "\n");
        }

    }

    public String getVarOrVarValValue(Node node){
         try {
                return (((VarVal) node).value);
            }catch (ClassCastException e){
                return getVariableValue(((Variable) node).name, ((Variable) node).varNodeType);
            }
    }

    public ArrayList<Node> removeOpFromArrayList(ArrayList<Node> array, Integer i, String value){
        int pos = i;
        array.set(pos, new VarVal(array.get(pos).parent.parent, VarVal.Type.STRING, value));
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
                    value = String.valueOf((Integer.parseInt(getVarOrVarValValue(array.get(i - 1))) / Integer.parseInt(getVarOrVarValValue(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                } else if (((Operator) node).opNodeType == Operator.Type.MULTI) {
                    value = String.valueOf((Integer.parseInt(getVarOrVarValValue(array.get(i - 1))) * Integer.parseInt(getVarOrVarValValue(array.get(i + 1)))));
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
                    value = String.valueOf((Integer.parseInt(getVarOrVarValValue(array.get(i - 1))) + Integer.parseInt(getVarOrVarValValue(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                } else if (((Operator) node).opNodeType == Operator.Type.SUB) {
                    value = String.valueOf((Integer.parseInt(getVarOrVarValValue(array.get(i - 1))) - Integer.parseInt(getVarOrVarValValue(array.get(i + 1)))));
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
                    value = String.valueOf((Boolean.valueOf(getVarOrVarValValue(array.get(i - 1))) && Boolean.valueOf(getVarOrVarValValue(array.get(i + 1)))));
                    removeOpFromArrayList(array, i, value);
                } else if (((Operator) node).opNodeType == Operator.Type.OR) {
                    value = String.valueOf((Boolean.valueOf(getVarOrVarValValue(array.get(i - 1))) || Boolean.valueOf(getVarOrVarValValue(array.get(i + 1)))));
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
                String leftValString = String.valueOf(getVarOrVarValValue(array.get(i - 1)));
                String rightValString = String.valueOf(getVarOrVarValValue(array.get(i + 1)));
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
                    Integer leftValInt = Integer.parseInt(getVarOrVarValValue(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getVarOrVarValValue(array.get(i + 1)));
                    if(leftValInt < rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.MORETHAN) {
                    Integer leftValInt = Integer.parseInt(getVarOrVarValValue(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getVarOrVarValValue(array.get(i + 1)));
                    if(leftValInt > rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.LESSTHANEQUALS) {
                    Integer leftValInt = Integer.parseInt(getVarOrVarValValue(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getVarOrVarValValue(array.get(i + 1)));
                    if(leftValInt <= rightValInt){
                        value = "true";
                    }else{
                        value = "false";
                    }
                    removeOpFromArrayList(array, i, value);
                }
                else if (((Operator) node).opNodeType == Operator.Type.MORETHANEQUALS) {
                    Integer leftValInt = Integer.parseInt(getVarOrVarValValue(array.get(i - 1)));
                    Integer rightValInt = Integer.parseInt(getVarOrVarValValue(array.get(i + 1)));
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
                    value = getVarOrVarValValue(array.get(i - 1)) + getVarOrVarValValue(array.get(i + 1));
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
        return getVarOrVarValValue(evaluateArray(array).get(0));
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



    public void visitNodeRun(Node tree){
         //  try {
               if (tree.nodeType == Node.Type.SMCLN) {
                       if(tree.isXbeforeY(tree, Node.Type.DEC, Node.Type.SEQ)) {
                           Variable v = tree.returnDecVar(tree);
                           Variable.Type type = v.varNodeType;
                           String name = v.name;
                           if (!checkVarExists(name, type)) {
                               Variable var = new Variable(null, type, name, null);
                               variables.add(var);
                           }
                           //evaluate if user assigns a value while declaring
                           if(tree.isXbeforeY(tree, Node.Type.EVAL, Node.Type.SEQ)){
                               String value = evaluate(tree.returnEvalNode(tree), Node.Type.SMCLN);
                               updateVariableValue(value, name, type);
                               Log.d("Value is ", value);
                           }
                       }
                       else if(tree.isXbeforeY(tree, Node.Type.ASSIGN, Node.Type.SEQ)){
                           Variable v = tree.returnAssignVar(tree);
                           Variable.Type type = v.varNodeType;
                           String name = v.name;
                           //evaluate
                           String value = evaluate(tree.returnEvalNode(tree), Node.Type.SMCLN);
                           updateVariableValue(value, name, type);
                           Log.d("Value is ", value);
                       }
                      else if(tree.isXbeforeY(tree, Node.Type.PRINT, Node.Type.SEQ)){
                           String value = evaluate(tree.returnEvalNode(tree), Node.Type.SMCLN);
                           output.append(value + "\n");
                     }
               }
               else  if(tree.nodeType == Node.Type.FORLOOP){
                   String varValue = ((Loops) tree).lowerLim.toString();
                   String varName = ((Loops) tree).limiter;
                   updateVariableValue(varValue, varName, Variable.Type.INT);
               }else if(tree.nodeType == Node.Type.ENDIFCONDITION){
                   String value = evaluate(tree.returnEvalNode(tree), Node.Type.ENDIFCONDITION);
                   if(value.equals("true")){
                       setConditionValue(tree, "true");
                   }else if(value.equals("false")){
                       setConditionValue(tree, "false");
                   }
                   Log.d("STATEMENT IS", value);
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
        if(node.nodeType == Node.Type.VAR || node.nodeType == Node.Type.VARVAL){
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

        if(openBrackets.size() == 0){
            if(!tree.isXbeforeY(tree.findCurNode(tree), Node.Type.IF, Node.Type.NEWLINE)) {
                btnSemicolon.setVisibility(View.VISIBLE);
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
                    runCode(tree.left.left.right); //TODO:clear this up
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
            if(tree.nodeType == Node.Type.STARTIF){
                //check if if statement condition is true
                if(((If)tree.parent.parent).isTrue){
                    runCode(tree.right);
                }
            }else if(tree.nodeType == Node.Type.ELSE) {
                if(!((If)tree.parent).isTrue){
                    runCode(tree.right);
                }
            }
            else{
                runCode(tree.right);
            }
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
        if(!rightChild){
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

    public void showVarButtons(Variable.Type varType){
        varButtons.clear();
        Node.Type nodeType = tree.findCurNode(tree).nodeType;
        if((nodeType != Node.Type.PRINT) && (nodeType != Node.Type.OP) && (nodeType != Node.Type.CONDITION) ){
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
                if (variables.get(i).varNodeType == Variable.Type.STRING) {
                    b.setBackgroundColor(0x9933FF0);
                }
                else if (variables.get(i).varNodeType == Variable.Type.INT) {
                    b.setBackgroundColor(0xFFFF0000);
                }else if (variables.get(i).varNodeType == Variable.Type.BOOL) {
                    b.setBackgroundColor(0x9966FF0);
                }
                if(true){

                }else{

                }
                b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Node curNode = tree.findCurNode(tree);
                        clearButtons();
                        if (b.getContentDescription().equals(Variable.Type.STRING.toString())) {
                            curNode = doButtonLogic(b, curNode, Variable.Type.STRING, "String");
                        }
                        else if (b.getContentDescription().equals(Variable.Type.INT.toString())) {
                            curNode = doButtonLogic(b, curNode, Variable.Type.INT, "Int");
                        }
                        else if (b.getContentDescription().equals(Variable.Type.BOOL.toString())) {
                            curNode = doButtonLogic(b, curNode, Variable.Type.BOOL, "Bool");
                        }
                        btnNewVar.setVisibility(View.GONE);
                        if(tree.isXbeforeY(curNode, Node.Type.EVAL, Node.Type.SEQ) || tree.isXbeforeY(curNode, Node.Type.IF, Node.Type.SEQ)){
                            endIfCondition(curNode);
                            btnOperator.setVisibility(View.VISIBLE);
                            showBracketButtons(curNode);
                        }
                        if(tree.isXbeforeY(curNode, Node.Type.SEQ, Node.Type.EVAL) && tree.isXbeforeY(curNode, Node.Type.SEQ, Node.Type.IF) ){
                            btnEquals.setVisibility(View.VISIBLE);
                        } else {
                            showSemicolonButton();
                        }
                        code.setText("");
                        if (tree != null) {
                          //  openLoopsIndent.clear();
                          //  openIfsIndent.clear();
                            openCurlysIndent.clear();
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
        String text = "";
        Boolean clearScreen = false;
       // if((v.getId() != R.id.semicolon) && (v.getId() != R.id.run)){
       //     btnRun.setVisibility(View.GONE);
      //  }

        if(justEndedIfStatement){
            if(v.getId() != R.id.btnElse){
                tree = tree.moveUpTreeLimit(tree, "SEQ");
            }
            justEndedIfStatement = false;
        }
        switch(v.getId()){
            case R.id.btnPrint:
                Log.d("DEBUG", "PRESS PRINT");
                tree = tree.addNode(tree, Node.Type.SEQ, "right", null);
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", null);
                tree = tree.addNode(tree, Node.Type.PRINT, "left", null);
                tree = tree.addNode(tree, Node.Type.EVAL, "left", null);
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
              //  openLoops.add(true);
                openCurlys.add(true);
                clearButtons();
                tree = tree.addNode(tree, Node.Type.FORLOOP, "left", "For");
                //LogTree(tree);
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
                text = edtEnterString.getText().toString().trim();
                try {
                    int num = Integer.parseInt(text);
                    clearButtons();
                    ((Loops) tree.findCurNode(tree)).lowerLim = Integer.parseInt(text);
                    btnForLess.setVisibility(View.VISIBLE);
                    btnForGreater.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    showInvalidAlert();
                }
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
                text = edtEnterString.getText().toString().trim();
                try {
                    int num = Integer.parseInt(text);
                    clearButtons();
                    ((Loops) tree.findCurNode(tree)).upperLim = Integer.parseInt(text);
                    btnForPlus.setVisibility(View.VISIBLE);
                    btnForMinus.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    showInvalidAlert();
                }
                break;

            case R.id.btnForPlus:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).plusOrMinus = "++";
                tree.addNode(tree, Node.Type.STARTLOOP, "left", null);
                showButtons(homeMenu);
                break;

            case R.id.btnForMinus:
                clearButtons();
                ((Loops) tree.findCurNode(tree)).plusOrMinus = "--";
                tree.addNode(tree, Node.Type.STARTLOOP, "left", null);
                showButtons(homeMenu);
                break;

            case R.id.btnForEndLoop:
                clearButtons();
                //openLoops.remove(openLoops.size() - 1);
                //openLoops.remove(openLoops.size() - 1);
                openCurlys.remove(openCurlys.size() - 1);  //TODO: THIS COULD BE FOR LOOP BRACKET PROBLEM, WHY TWICE?
               // tree.addNode(tree, Node.Type.NEWLINE, "right", null); TODO:Check this
                tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpToStartOfForLoop(tree);
                tree = tree.moveUpOneStep(tree);
                tree = tree.moveUpOneStep(tree);
                //  btnRun.setVisibility(View.VISIBLE);
                showButtons(homeMenu);
                break;

            case R.id.btnCloseCurly:
                openCurlys.remove(openCurlys.size() - 1);  //TODO: THIS COULD BE FOR LOOP BRACKET PROBLEM, WHY TWICE?
                tree.addNode(tree, Node.Type.END, "right", null);
                if(tree.isXbeforeY(tree.findCurNode(tree), Node.Type.FORLOOP, Node.Type.NEWLINE)){
                    tree = tree.moveUpTreeLimit(tree, "FORLOOP");
                    tree = tree.moveUpTreeLimit(tree, "SEQ");
                }else if(tree.isXbeforeY(tree.findCurNode(tree), Node.Type.IF, Node.Type.NEWLINE)){
                    tree = tree.moveUpTreeLimit(tree, "IF");
                    justEndedIfStatement = true;
                }

                break;



        /*    case R.id.btnEndIf:
                openIfs.remove(openIfs.size() - 1);
                tree = tree.moveUpTreeLimit(tree, "SEQ");
                tree.addNode(tree, Node.Type.ENDIF, "right", null);
                tree = tree.moveUpTreeLimit(tree, "IF");
                break;
        }*/


            case R.id.clear:
                tree = new Node(Node.Type.ROOT, null);
                clearButtons();
              //  openLoops.clear();
                openBrackets.clear();
                openCurlys.clear();
                output.setText("");
                variables.clear();
                justEndedIfStatement = false;
                showButtons(homeMenu);
                break;

            case R.id.LogTree:
                LogTree(tree);
                break;



            case R.id.semicolon:
                Log.d("DEBUG", "PRESS ;");
                tree = tree.addNode(tree, Node.Type.SMCLN, "right", null);
                tree = tree.moveUpTreeLimit(tree, "SEQ");
                clearButtons();
                showButtons(homeMenu);
                break;

            case R.id.var:
                clearButtons();
                Node curNode = tree.findCurNode(tree);
                if((curNode.nodeType == Node.Type.SEQ) || (curNode.nodeType == Node.Type.ROOT) || (curNode.nodeType == Node.Type.STARTLOOP) ||  (curNode.nodeType == Node.Type.STARTIF)){
                    tree = tree.addNode(tree, Node.Type.SEQ, "right", "none");
                    tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "none");
                    //   tree.addNode(tree, Node.Type.VAR, "left", null);
                }else if((curNode.nodeType == Node.Type.EVAL)|| curNode.nodeType == Node.Type.OP){
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
                clearButtons();
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
                if(((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.STRING ){
                    tree = tree.addNode(tree, Node.Type.VAR, "left", "String");
                }else if(((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.INT ){
                    tree = tree.addNode(tree, Node.Type.VAR, "left", "Int");
                }else if(((Dec) tree.findCurNode(tree)).varNodeType == Dec.Type.BOOL ){
                    tree = tree.addNode(tree, Node.Type.VAR, "left", "Bool");
                }
                tree.setVarName(tree, edtEnterString.getText().toString().trim());
                clearButtons();
                break;



            case R.id.btnEquals:
                clearButtons();
                tree = tree.addNode(tree, Node.Type.ASSIGN, "right", null);
                tree = tree.addNode(tree, Node.Type.EVAL, "left", null);
                Variable.Type type = tree.getVarType(tree.findCurNode(tree));
                if(type == Variable.Type.INT) {
                    tree = tree.updateEval(tree, Eval.Type.INT);
                }else if(type == Variable.Type.STRING){
                    tree = tree.updateEval(tree, Eval.Type.STRING);
                }else if(type == Variable.Type.BOOL){
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
                if((tree.returnEvalNode(tree.findCurNode(tree)).evalNodeType == Eval.Type.INT)){
                    text = edtEnterString.getText().toString();
                    try {
                        int num = Integer.parseInt(text);
                        tree = tree.updateVarVal(tree, edtEnterString.getText().toString());
                    } catch (NumberFormatException e) {
                        showInvalidAlert();
                    }
                }else {
                    tree = tree.updateVarVal(tree, edtEnterString.getText().toString());
                }
             //   tree = tree.addNode(tree, Node.Type.VARVAL, "right", edtEnterString.getText().toString().trim()); //FIX FOR TWO VAR VALS
                break;


            case R.id.btnEnterTextString:
                if(tree.isXbeforeY(tree.findCurNode(tree), Node.Type.VARVAL, Node.Type.SEQ)) {
                    tree = tree.updateVarVal(tree, edtEnterString.getText().toString());
                }else{
                    tree = tree.addNode(tree, Node.Type.VARVAL, "left", edtEnterString.getText().toString());
                }
                clearButtons();
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
                tree = tree.addNode(tree, Node.Type.NEWLINE, "left", "none");
                tree = tree.addNode(tree, Node.Type.IF, "left", "none");
                tree = tree.addNode(tree, Node.Type.CONDITION, "left", "none");
                tree = tree.addNode(tree, Node.Type.EVAL, "left", "none");
                break;

            case R.id.btnElse:
                tree = tree.addNode(tree, Node.Type.ELSE, "right", "none");
                openCurlys.add(true);
                break;

            case R.id.btnEndIfCondition:
                tree = tree.addNode(tree, Node.Type.ENDIFCONDITION, "left", "none");
                Node node = tree.findCurNode(tree);
                tree = tree.moveUpTreeLimit(tree, "CONDITION");
              //  openIfs.add(true);
                openCurlys.add(true);
                tree.addNode(tree, Node.Type.STARTIF, "right", "none");
                break;

         /*   case R.id.btnEndIf:
              //  openIfs.remove(openIfs.size() - 1);
                openCurlys.remove(openCurlys.size() - 1);
                tree.addNode(tree, Node.Type.END, "right", null);
                tree = tree.moveUpTreeLimit(tree, "IF");
                break;*/
            }


        edtEnterString.setText("");
        code.setText("");
        if(tree != null) {
            Node currentNode = tree.findCurNode(tree);
            Node.Type currentNodeType = currentNode.nodeType;
           // openLoopsIndent.clear();
           // openIfsIndent.clear();
            openCurlysIndent.clear();
            printTree(tree);

            if (openCurlys.size() > 0) {
                if (currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.STARTLOOP) {
                    btnCloseCurly.setVisibility(View.VISIBLE);
                }
            }else{
                btnCloseCurly.setVisibility(View.GONE);
            }

          //  int openLoopsSize = openLoops.size();
          //  int openIfsSize = openIfs.size();

      /*      if(openLoopsSize > 0) {
                if (currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.STARTLOOP) {
                    btnForEndLoop.setVisibility(View.VISIBLE);
                }
            }
            if(openLoopsSize == 0){
                btnForEndLoop.setVisibility(View.GONE);
            }

            if(openIfsSize > 0){
                if (currentNodeType == Node.Type.SEQ) {
                    btnEndIf.setVisibility(View.VISIBLE);
                }
            }

            if(openIfsSize == 0){
                btnEndIf.setVisibility(View.GONE);
            }*/

          //  if((v.getId() == R.id.semicolon) || (v.getId() == R.id.btnForPlus)  || (v.getId() == R.id.btnForMinus || (v.getId() == R.id.run) || (v.getId() == R.id.clear))){
           if(currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.ROOT || (currentNodeType == Node.Type.STARTLOOP )){
               /*if((currentNodeType == Node.Type.FORLOOP )){
                   if(((Loops) currentNode).plusOrMinus != null ){
                       btnLoops.setVisibility(View.VISIBLE);
                   }
               }else {
                   btnLoops.setVisibility(View.VISIBLE);
               }
            }else{*/
                btnLoops.setVisibility(View.VISIBLE);
            }
            if(currentNodeType == Node.Type.SEQ || currentNodeType == Node.Type.IF) {
                if (openLoops.size() == 0 && openCurlys.size() == 0) {
                    btnRun.setVisibility(View.VISIBLE);
                } else {
                    btnRun.setVisibility(View.GONE);
                }
            }
            if(currentNodeType == Node.Type.OP && ((Operator) currentNode).opNodeType == null){
                clearButtons();
                Eval.Type evalType = tree.returnEvalVar(currentNode).evalNodeType;
                if(evalType == Eval.Type.INT){
                    btnOperatorAdd.setVisibility(View.VISIBLE);
                    btnOperatorSub.setVisibility(View.VISIBLE);
                    btnOperatorMulti.setVisibility(View.VISIBLE);
                    btnOperatorDiv.setVisibility(View.VISIBLE);
                }else if (evalType == Eval.Type.STRING){
                    btnOperatorConcat.setVisibility(View.VISIBLE);
                }
                else if (evalType == Eval.Type.BOOL){
                    btnOperatorBoolAnd.setVisibility(View.VISIBLE);
                    btnOperatorBoolOr.setVisibility(View.VISIBLE);
                }
                //for if statements
                if(tree.isXbeforeY(currentNode, Node.Type.CONDITION, Node.Type.SEQ)) {
                    showBracketButtons(currentNode);
                    if(tree.hasConditionOperatorBeenUsed(currentNode) == false && openBrackets.size() == 0) {
                        if (evalType == Eval.Type.INT) {
                            btnOperatorLessThan.setVisibility(View.VISIBLE);
                            btnOperatorMoreThan.setVisibility(View.VISIBLE);
                            btnOperatorMoreThanEquals.setVisibility(View.VISIBLE);
                            btnOperatorLessThanEquals.setVisibility(View.VISIBLE);
                        }
                        btnOperatorEquality.setVisibility(View.VISIBLE);
                        btnOperatorInequality.setVisibility(View.VISIBLE);
                      /*  btnOperatorAdd.setVisibility(View.VISIBLE);
                        btnOperatorSub.setVisibility(View.VISIBLE);
                        btnOperatorMulti.setVisibility(View.VISIBLE);
                        btnOperatorDiv.setVisibility(View.VISIBLE);*/
                    }
                }
            }else if(currentNodeType == Node.Type.OP && ((Operator) currentNode).opNodeType != null){
                Eval.Type evalType = tree.returnEvalVar(currentNode).evalNodeType;
                clearButtons();
                if (evalType == Eval.Type.STRING) {
                    btnTypeInput.setVisibility(View.VISIBLE);
                    if (variables.size() > 0) {
                        btnVar.setVisibility(View.VISIBLE);
                    }
                }
                else if (evalType == Eval.Type.INT) {
                    btnTypeInput.setVisibility(View.VISIBLE);
                    if(checkVarTypeExistence(Variable.Type.INT)){
                        btnVar.setVisibility(View.VISIBLE);
                    }

                }else if (evalType == Eval.Type.BOOL) {
                    btnBoolTrue.setVisibility(View.VISIBLE);
                    btnBoolFalse.setVisibility(View.VISIBLE);
                    if(checkVarTypeExistence(Variable.Type.BOOL)){
                        btnVar.setVisibility(View.VISIBLE);
                    }
                }else if(evalType == Eval.Type.NONE){
                    btnTypeInput.setVisibility(View.VISIBLE);
                    if(checkVarTypeExistence(Variable.Type.INT)){
                        btnVar.setVisibility(View.VISIBLE);
                    }
                }
                showBracketButtons(currentNode);
               /* Variable.Type varType = tree.returnAssignVar(tree.findCurNode(tree)).varNodeType;
                if(varType == Variable.Type.STRING) {
                    showVarButtons(null);
                }else if (varType == Variable.Type.INT){
                    showVarButtons(varType);
                }*/
            }
            else if(currentNodeType == Node.Type.DEC){
                clearButtons();
                if( ((Dec)currentNode).varNodeType == Dec.Type.NONE) {
                    btnNewVar.setVisibility(View.GONE);
                    btnNewVarInt.setVisibility(View.VISIBLE);
                    btnNewVarString.setVisibility(View.VISIBLE);
                    btnNewVarBool.setVisibility(View.VISIBLE);

                }else {
                    edtEnterString.setVisibility(View.VISIBLE);
                    btnEnterVarName.setVisibility(View.VISIBLE);
                }
            }
            else if(currentNodeType == Node.Type.VAR){
                clearButtons();
                //Node node = tree.findCurNode(tree);
                if(tree.isXbeforeY(currentNode, Node.Type.EVAL, Node.Type.SEQ)){
                //    Variable.Type varType = tree.returnAssignVar(tree.findCurNode(tree)).varNodeType;
                    Eval.Type type = tree.returnEvalVar(currentNode).evalNodeType;
                    if(type == Eval.Type.STRING) {
                        showVarButtons(null);
                    }else if (type == Eval.Type.INT){
                        showVarButtons(Variable.Type.INT);
                    }else if (type == Eval.Type.BOOL){
                        showVarButtons(Variable.Type.BOOL);
                    }else if(type == Eval.Type.NONE){
                        showVarButtons(Variable.Type.INT);
                    }
                }else {
                    edtEnterString.setText("");
                    btnEquals.setVisibility(View.VISIBLE);
                    showSemicolonButton();
                    //btnSemicolon.setVisibility(View.VISIBLE);
                }
            }

            else if(currentNodeType == Node.Type.PRINT){
                btnPrintBack.setVisibility(View.VISIBLE);
                showSemicolonButton();
                //btnSemicolon.setVisibility(View.VISIBLE);

            }
            else if(currentNodeType == Node.Type.VARVAL){
                clearButtons();
                Node varVal = currentNode;
                if(((VarVal)varVal).value == null){
                    edtEnterString.setVisibility(View.VISIBLE);
                    btnEnterVarValue.setVisibility(View.VISIBLE);
                //for Booleans
                }else {
                    showSemicolonButton();
                    //btnSemicolon.setVisibility(View.VISIBLE);
                    btnOperator.setVisibility(View.VISIBLE);
                    showBracketButtons(currentNode);
                    endIfCondition(currentNode); //TODO
                }

            }
            else if(currentNodeType == Node.Type.STRING){
                clearButtons();
                showSemicolonButton();
                //btnSemicolon.setVisibility(View.VISIBLE);
                btnOperator.setVisibility(View.VISIBLE);
            }
            else if(currentNodeType == Node.Type.BRACKET){
                showBracketButtons(currentNode);
                if(((Bracket)currentNode).bracketType == Bracket.Type.CLOSE){
                    btnOperator.setVisibility(View.VISIBLE);
                    btnOpenBracket.setVisibility(View.GONE);
                    showSemicolonButton();
                    endIfCondition(currentNode); //TODO
                }
            }
            else if(currentNodeType == Node.Type.CONDITION){
               // clearButtons();
               // btnEndIf.setVisibility(View.VISIBLE);
               // showButtons(homeMenu);
            }
            else if(currentNodeType == Node.Type.STARTIF){
                clearButtons();
                //btnEndIf.setVisibility(View.VISIBLE);
                btnCloseCurly.setVisibility(View.VISIBLE);
                showButtons(homeMenu);
            }
            else if(currentNodeType == Node.Type.ENDIFCONDITION){
           //     tree = tree.moveUpTreeLimit(currentNode, "CONDITION");
            }
            else if(currentNodeType == Node.Type.IF){
                btnElse.setVisibility(View.VISIBLE);
            }else if(currentNodeType == Node.Type.ELSE){
                clearButtons();
                btnCloseCurly.setVisibility(View.VISIBLE);
                showButtons(homeMenu);
            }
            else if(currentNodeType == Node.Type.EVAL) {
                clearButtons();
                if ((tree.returnEvalNode(currentNode)).evalNodeType == Eval.Type.NONE) {
                    if (tree.isXbeforeY(currentNode, Node.Type.PRINT, Node.Type.SEQ) || tree.isXbeforeY(currentNode, Node.Type.CONDITION, Node.Type.SEQ)) {
                        btnSetEvalTypeInt.setVisibility(View.VISIBLE);
                        btnSetEvalTypeString.setVisibility(View.VISIBLE);
                        btnSetEvalTypeBool.setVisibility(View.VISIBLE);
                    }
                  /* else if(tree.isXbeforeY(currentNode, Node.Type.CONDITION, Node.Type.SEQ)){
                        showBracketButtons(currentNode);
                        btnTypeInput.setVisibility(View.VISIBLE);
                        showVarButtons(null);
                    }*/
                }
                else{
                    showBracketButtons(currentNode);
                    if ((tree.returnEvalNode(currentNode)).evalNodeType == Eval.Type.STRING) {
                        btnTypeInput.setVisibility(View.VISIBLE);
                        if (variables.size() > 0) {
                            btnVar.setVisibility(View.VISIBLE);
                        }
                    }
                    else if ((tree.returnEvalNode(currentNode)).evalNodeType == Eval.Type.INT) {
                        btnTypeInput.setVisibility(View.VISIBLE);
                        if(checkVarTypeExistence(Variable.Type.INT)){
                            btnVar.setVisibility(View.VISIBLE);
                        }
                    }else if ((tree.returnEvalNode(currentNode)).evalNodeType == Eval.Type.BOOL) {
                    //    if(tree.isXbeforeY(currentNode, Node.Type.PRINT, Node.Type.SEQ )){
                            btnBoolTrue.setVisibility(View.VISIBLE);
                            btnBoolFalse.setVisibility(View.VISIBLE);
                    //    }
                        if(checkVarTypeExistence(Variable.Type.BOOL)){
                            btnVar.setVisibility(View.VISIBLE);
                        }
                    }
                }

            }
            if ((currentNodeType != Node.Type.VARVAL) && (currentNodeType != Node.Type.STRING) && (currentNodeType != Node.Type.VAR) && (currentNodeType != Node.Type.BRACKET) ){
                btnOperator.setVisibility(View.GONE);
            }
        }
    }
}










//Wed 8th July
//TODO: make conditional operators only appear when brackets are closed -- DONE
//TODO: make current node be the right node when you end if statement -- DONE
//TODO: if user doesn't press else, make current node go up to seq -- DONE with justFinishedIfStatement
//TODO: be able to print true or false when printing bool -- DONE
//TODO: make it so run is only visible when there are no open brackets or open curlys -- DONE
//TODO: make sure condition isTrue value resets incase of function calls or loops etc -- DONE
//TODO: make if conditional logic work when running -- DONE
//TODO: make else work -- DONE

//TODO: VARIABLE SCOPE

//TODO: idea - clear line : go up to new line, go up to seq, delete child
//TODO: idea - modify : give every newline a linenumber, when user clicks on line it highlights, they can delete line


//TODO: idea: give conditional operators a type eg Int string or bool

//TODO: add option to add condition when you have choice to end condition


//TODO: Functions

//TODO: check assigns in loops -- Need to implement scope
//TODO: Implement variable scope
//Will do this by creating new ArrayList<Varaible> every time new loop is open, then deleting it once the loops is
//closed. Eg if 2 { are open there will be 2 additional lists, any declarations will be valid only inside those brackets
//TODO: remove "" for ints and bools

//TODO: implement modulo operator
//ToDO: make loops work properly (with ++ -- etc)
//TODO: optimize multiple calls to findCurNode
//TODO: Implement Back functionality
//TODO: Make it editable
//TODO: deal with overflows with ints
//TODO: Check that loops work properly
//TODO: when writing up, talk about hwo you have only done ++ with for loops, not += 2 for example. Say it's further development







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
//TODO: stop double var adding after print caused by adding var when var btton pressed as well as b pressed -- DONE
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

