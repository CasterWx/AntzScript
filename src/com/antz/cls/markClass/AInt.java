package com.antz.cls.markClass;

import com.antz.cls.baseClass.AObject;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-30-12:51
 */
public class AInt extends AObject {
    private Integer integer ;
    public AInt(){}
    public AInt(Integer integer){
        this.integer = integer ;
    }
    public String getType(){
        return "[Integer]";
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Integer value(){
        return integer ;
    }

    public Integer add(Integer integer){
        return this.integer + integer ;
    }
}
