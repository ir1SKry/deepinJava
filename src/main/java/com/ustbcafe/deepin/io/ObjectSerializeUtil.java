package com.ustbcafe.deepin.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Rudy Steiner on 2017/5/4.
 */
public class ObjectSerializeUtil {

    public static void serializeObject(ObjectOutputStream oos,DefaultMessage df) throws IOException{
        oos.writeObject(df);
    }
    public static DefaultMessage deSerialize(ObjectInputStream ois) throws IOException,ClassNotFoundException{
         DefaultMessage df;
        df=(DefaultMessage) ois.readObject();
        return df;
    }
}
