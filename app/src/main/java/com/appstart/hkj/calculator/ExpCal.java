package com.appstart.hkj.calculator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HKJ on 2016/7/7.
 */
public class ExpCal {
    private String exp = new String();
    public ExpCal(String exp1){
        exp = exp1;
    }
    public ArrayList<String> CreateReversePolish(String e){
        ArrayList<String> rp = new ArrayList<String>();
        Stack<String> op = new Stack<String>();

        Pattern pat = Pattern.compile("[^\\.0-9]");
        String []data = pat.split(e);

        pat = Pattern.compile("[^\\.0-9]");
        Matcher op1 = pat.matcher(e);
        rp.add(data[0]);
        int i = 1;
        while(i<data.length && op1.find()){
            String str = op1.group();
            if(op.empty()){
                op.push(str);
            }
            else if(str.equals("+") || str.equals("-")){
                rp.add(op.pop());
                op.push(str);
            }
            else{
                op.push(str);
            }
            rp.add(data[i]);
            i++;
        }
        while(!op.empty()){
            rp.add(op.pop());
        }
        return rp;
    }
    public Double ExpResult(){
        Double result = new Double(0.0);
        ArrayList<String> str = new ArrayList<String>(CreateReversePolish(exp));
        Stack<Double> da = new Stack<Double>();
        for(int i=0;i<str.size();i++){
            if(str.get(i).equals("+") || str.get(i).equals("-") || str.get(i).equals("*") ||str.get(i).equals("/")){
                double d2 = da.pop();
                double d1 = da.pop();
                switch(str.get(i)){
                    case "+": result = d1 + d2;break;
                    case "-": result = d1 - d2;break;
                    case "*": result = d1 * d2;break;
                    case "/": result = d1 / d2;break;
                };
                da.push(result);
            }
            else{
                da.push(Double.parseDouble(str.get(i)));
            }
        }
        return result;
    }
}
