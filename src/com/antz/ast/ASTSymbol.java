package com.antz.ast;

import java.util.Iterator;
import java.util.List;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-17:58
 * @use ���ڷ��Žڵ�
 */

public class ASTSymbol extends ASTree {

    protected List<ASTree> children;

    public ASTSymbol(List<ASTree> t){
        children = t ;
    }

    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Iterator<ASTree> children() {
        return children.iterator();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(')');
        String sep = "";
        for (ASTree t : children) {
            builder.append(sep);
            sep = " ";
            builder.append(t.toString());
        }
        return builder.append(')').toString();
    }

    @Override
    public String location() {
        for(ASTree t : children) {
            String s = t.location();
            if (s != null)
                return s;
        }
        return null;
    }

}
