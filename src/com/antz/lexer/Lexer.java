package com.antz.lexer;

import com.antz.token.Token;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-27-4:46
 */
public class Lexer {
    private static String regexPat =
            "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")" +
                    "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";

    private ArrayList<Token> tokens = new ArrayList<>();

    public ArrayList<Token> getTokens(){
        return this.tokens;
    }

    public void add(String source){
        Pattern pattern = Pattern.compile(regexPat);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()){
            String tokenStr = matcher.group();
            Token token = new Token(tokenStr);
            if(!token.getK().equals("»Ø³µ")){
                tokens.add(token);
            }
        }
    }
}
