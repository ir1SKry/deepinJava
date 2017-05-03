package com.ustbcafe.deepin.io;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Rudy Steiner on 2017/2/20.
 */
public class IOHelper {

    public static String getUserDir(){
        return System.getProperty("user.dir");
    }
    public static String getSeperator(){
        return  File.separator;
    }
    public static InputStream getResourceRootPath(){
        return  IOHelper.class.getResourceAsStream("/");
    }
    public static InputStream getResourceRelativePath(){
        return  IOHelper.class.getResourceAsStream("");
    }
    public static InputStream read(String path){


        return null;
    }

}
