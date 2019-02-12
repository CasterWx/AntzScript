package com.antz.load;

import com.antz.lexer.Lexer;
import com.antz.token.Token;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-27-7:05
 */
public class LoadCode {
    private Lexer lexer = new Lexer();
    private ArrayList<Token> tokens =  new ArrayList<>();

    public LoadCode(String fileName){
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String source = "";
            while ((source = br.readLine()) != null) {
                lexer.add(source);
            }
            tokens = lexer.getTokens() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Token> getTokens(){
        return tokens ;
    }
}