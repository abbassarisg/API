package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {


    private  static org.codehaus.jackson.map.ObjectMapper mapper;

    static {
        mapper=new ObjectMapper();
    }

    public  static <T> T convertJsonToJava(String json, Class<T> cls){ //Generic method

    T javaResult=null;
        try {
           javaResult= mapper.readValue(json,cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return javaResult;
    }
}
