package com.antz.GrammarParser;

import com.antz.astImp.BinaryExpr;
import com.antz.astImp.NameImp;
import com.antz.token.Token;

import java.util.ArrayList;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-02-12-14:48
 */
public class Parser {
    public Parser(ArrayList<Token> tokens){
        int flag = 0 ;
        ArrayList<Token> tokenArrayList = new ArrayList<>();
        for (Token t :
                tokens) {
            if(t.getLexeme().equals("{")){
                tokenArrayList.add(t);
                flag ++ ;
            }else if (t.getLexeme().equals("}")) {
                tokenArrayList.add(t);
                flag--;
                if (0==flag){
                    printArrayList(tokenArrayList);
                    tokenArrayList.clear();
                }
            }else if (t.getLexeme().equals(";")) {
                tokenArrayList.add(t) ;
                if(0==flag){
                    printArrayList(tokenArrayList);
                    tokenArrayList.clear();
                }
            }else {
                tokenArrayList.add(t);
            }
        }
    }

    public void printArrayList(ArrayList<Token> tokens){
        for (Token t:
             tokens) {
                System.out.print(t.getLexeme()+" ");
        }
        System.out.println();
    }
}
