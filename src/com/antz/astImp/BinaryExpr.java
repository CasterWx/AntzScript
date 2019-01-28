package com.antz.astImp;

import com.antz.ast.ASTMark;
import com.antz.ast.ASTSymbol;
import com.antz.ast.ASTree;

import java.util.List;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-19:10
 */
public class BinaryExpr extends ASTSymbol {
    public BinaryExpr(List<ASTree> t){
        super(t);
    }

    public ASTree left(){
        return child(0) ;
    }

    public String operator(){
        return ((ASTMark)child(1)).token().getLexeme();
    }

    public ASTree right(){
        return child(2) ;
    }
}