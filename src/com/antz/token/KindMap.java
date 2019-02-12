package com.antz.token;

import java.util.HashMap;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-27-5:44
 */
public class KindMap {
    public static HashMap<String,String> kindMap = new HashMap<>();
    public static void init(){
        kindMap.put("while","WHILE");
        kindMap.put("if","IF");
        kindMap.put("else","ELSE");
        kindMap.put("elif","ELIF");
        kindMap.put("for","FOR");
        kindMap.put("(","左括号");
        kindMap.put(")","右括号");
        kindMap.put("{","左花括号");
        kindMap.put("}","右花括号");
        kindMap.put(">","大于");
        kindMap.put("==","等于");
        kindMap.put("=","赋值");
        kindMap.put("<","小于");
        kindMap.put("<=","小于等于");
        kindMap.put(">=","大于等于");
        kindMap.put("*","乘号");
        kindMap.put("/","除号");
        kindMap.put("-","减号");
        kindMap.put("+","加号");
        kindMap.put(";","分号");
        kindMap.put("int","INT");
        kindMap.put("float","FLOAT");
        kindMap.put("double","DOUBLE");
        kindMap.put("String","STRING");
        kindMap.put("char","CHAR");
    }
}
