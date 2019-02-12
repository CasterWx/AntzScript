package com.antz.token;

import com.antz.ast.ASTree;
import com.antz.astImp.NumberImp;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-27-4:55
 */

public class Token {
    private String k;
    private String type ;
    private String lexeme ;
    private static HashMap<String ,String> kindMap = null ;

    public Token(String lexeme){
        if (kindMap==null){
            KindMap.init();
            kindMap = KindMap.kindMap ;
        }
        String lexmeStr = lexeme.trim() ;
        this.k = kindMap.get(lexmeStr);
        if (k==null&&isNumber(lexmeStr)){
            this.k = "����" ;
            this.type = "number" ;
        }else if (k==null&&isVariable(lexmeStr)){
            this.k = "����" ;
            this.type = "name" ;
        }else if (k==null&&isString(lexmeStr)){
            this.k = "�ַ���" ;
            this.type = "name" ;
        }else if(k==null&&lexeme.length()==0){
            this.k = "�س�" ;
        }
        this.lexeme = lexmeStr ;
    }

    private static boolean isVariable(String lexeme){
        Pattern pattern = Pattern.compile("^[A-Z_a-z][A-Z_a-z0-9]*$");
        Matcher matcher = pattern.matcher(lexeme);
        if (matcher.find()){
            return true ;
        }
        return false ;
    }

    private static boolean isNumber(String lexeme){
        Pattern pattern = Pattern.compile("^([0-9]+)$");
        Matcher matcher = pattern.matcher(lexeme);
        if (matcher.find()){
            return true ;
        }
        return false ;
    }

    private static boolean isString(String lexeme){
        Pattern pattern = Pattern.compile("^(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")$");
        Matcher matcher = pattern.matcher(lexeme);
        if (matcher.find()){
            return true ;
        }
        return false ;

    }

    public String printToken(){
        return "Token { " +
                "kind = \"" + k +
                "\",lexeme = \"" + lexeme +
                "\",type = " + type +
                " }";
    }

    public String getK() {
        return k;
    }

    public String getLexeme() {
        return lexeme;
    }
}