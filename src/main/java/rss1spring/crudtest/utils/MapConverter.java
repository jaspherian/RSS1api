package rss1spring.crudtest.utils;

import java.util.Map;

public class MapConverter {

    public static class Utils{

        public static String getString(Map<String,Object> body,String key,String other){
            String str = body.get(key)==null?(other!=null?other:""):body.get(key).toString();
            return str;
        }

        public static String getString(Map<String,Object> body,String key){
            return getString(body,key,null);
        }

        public static String getStringNoEmpty(Map<String,Object> body,String key,String other){
            String str = getString(body,key,other);
            return str!=null && str.isEmpty()?null:str;
        }

        public static String getStringNoEmpty(Map<String,Object> body,String key){
            return getStringNoEmpty(body,key,null);
        }

        public static int getInt(Map<String,Object> body,String key,Integer other){
            return body.get(key)==null?(other!=null?other.intValue():0):Integer.parseInt(body.get(key).toString());
        }

        public static int getInt(Map<String,Object> body,String key){
            return getInt(body,key,null);
        }


    }
}
