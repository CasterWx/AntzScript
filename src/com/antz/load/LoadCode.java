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
    public LoadCode(String fileName){
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)
        ) {
            Lexer lexer = new Lexer();
            String source = "";
            while ((source = br.readLine()) != null) {
                lexer.add(source);
            }
            ArrayList<Token> tokens =  lexer.getTokens();
            for (int i=0;i<tokens.size();i++){
                System.out.print(tokens.get(i).getK()+"("+tokens.get(i).getLexeme()+") ");
                if (tokens.get(i).getLexeme().length()==0){
                    System.out.println();
                }

//                System.out.println(tokens.get(i).printToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
