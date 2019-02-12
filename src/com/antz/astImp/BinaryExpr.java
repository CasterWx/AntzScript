package com.antz.astImp;

import com.antz.ast.ASTree;
import com.antz.token.Token;

import java.util.ArrayList;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-19:10
 */
public class BinaryExpr extends ASTree {
    private ArrayList<ASTree> asTrees ;

    public BinaryExpr(Token token){
        asTrees = new ArrayList<>() ;
    }

    public void add(ASTree asTree){
        asTrees.add(asTree) ;
    }
}
