package com.antz.cls.baseClass;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-30-12:31
 */
public class AObject {

    private Object object ;

    public AObject(){
    }
    public AObject(Object object){
        this.object = object ;
    }
    public Object value(){
        return object ;
    }

    public String getType(){
        return "[Object]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
