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
        kindMap.put("(","������");
        kindMap.put(")","������");
        kindMap.put("{","������");
        kindMap.put("}","�һ�����");
        kindMap.put(">","����");
        kindMap.put("==","����");
        kindMap.put("=","��ֵ");
        kindMap.put("<","С��");
        kindMap.put("<=","С�ڵ���");
        kindMap.put(">=","���ڵ���");
        kindMap.put("*","�˺�");
        kindMap.put("/","����");
        kindMap.put("-","����");
        kindMap.put("+","�Ӻ�");
        kindMap.put(";","�ֺ�");
        kindMap.put("int","INT");
        kindMap.put("float","FLOAT");
        kindMap.put("double","DOUBLE");
        kindMap.put("String","STRING");
        kindMap.put("char","CHAR");
    }
}
