package com.antz.cls.markClass;

import com.antz.cls.baseClass.AObject;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-30-12:35
 */
public class AString extends AObject {
    private String value ;
    public AString(){
    }
    public AString(String value){
        this.value = value  ;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public String getType(){
        return "[AString]";
    }
    public String value(){
        return value ;
    }
    public String append(String str){
        return this.value+str ;
    }
    public String replace(String str1,String str2){
        return this.value.replace(str1,str2);
    }
    public String[] split(String str){
        return this.value.split(str);
    }
}
