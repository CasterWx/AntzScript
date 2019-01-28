package com.antz.ast;

import com.antz.token.Token;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-17:58
 * @use 用于标志/数值节点
 */
public class ASTMark extends ASTree {
    private static ArrayList<ASTree> empty = new ArrayList<ASTree>();
    protected Token token;

    public ASTMark(Token token){
        this.token = token ;
    }
    @Override
    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    public String location() {
        return  "at line ";
    }

    public Token token() {
        return token;
    }
}
