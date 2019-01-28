package com.antz.astImp;

import com.antz.ast.ASTMark;
import com.antz.token.Token;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-28-19:10
 */
public class NameImp extends ASTMark {
    public NameImp(Token token) {
        super(token);
    }

    public String name(){
        return token.getLexeme();
    }
}
