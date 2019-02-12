package com.antz.astImp;

import com.antz.ast.ASTree;
import com.antz.token.Token;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-19:10
 */
public class NumberImp extends ASTree {
    private Token token ;

    public NumberImp(Token token){
        this.token = token ;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
