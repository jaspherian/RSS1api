package rss1spring.crudtest.utils;

import java.util.Map;

public class Utilities {

    public static class Util {

        public static int Int(Integer v,int other){
            return v!=null?v.intValue():other;
        }

        public static String String(String v,String other){
            return v!=null?v:other;
        }

        public static String StringEmpty(String v,String other){
            return v!=null?(v.isEmpty()?other:v):other;
        }

    }
}
