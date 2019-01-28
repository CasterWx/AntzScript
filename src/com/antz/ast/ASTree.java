package com.antz.ast;

import java.util.Iterator;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-17:51
 */

public abstract class ASTree implements Iterable<ASTree> {
    // ASTLeaf child(int i)	���ص�i���ӽڵ�
    public abstract ASTree child(int i);

    // int numChildren()	�����ӽڵ�ĸ�����û�з���0��
    public abstract int numChildren();

    // Iterator children()	����һ�����ڱ����ӽڵ��iterator
    public abstract Iterator<ASTree> children();

    // String location()  ������һ�����ڱ�ʾ�����﷨���ڵ��ڳ���������λ�õ��ַ�����
    public abstract String location();

    // iterator������children����������ͬ������һ����������
    // �ڽ�ASTree��תΪIterable����ʱ�����õ��÷���
    public Iterator<ASTree> iterator() {
        return children();
    }
}