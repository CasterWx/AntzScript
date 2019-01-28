package com.antz.ast;

import java.util.Iterator;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-17:51
 */

public abstract class ASTree implements Iterable<ASTree> {
    // ASTLeaf child(int i)	返回第i个子节点
    public abstract ASTree child(int i);

    // int numChildren()	返回子节点的个数（没有返回0）
    public abstract int numChildren();

    // Iterator children()	返回一个用于遍历子节点的iterator
    public abstract Iterator<ASTree> children();

    // String location()  将返回一个用于表示抽象语法树节点在程序内所处位置的字符串。
    public abstract String location();

    // iterator方法与children方法功能相同，它是一个适配器，
    // 在将ASTree类转为Iterable类型时将会用到该方法
    public Iterator<ASTree> iterator() {
        return children();
    }
}