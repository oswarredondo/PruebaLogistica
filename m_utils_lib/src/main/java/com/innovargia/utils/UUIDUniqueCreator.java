package com.innovargia.utils;

import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
//import org.apache.commons.id.uuid.VersionFourGenerator;


/**
 *
 * @author  AMorales
 */
public class UUIDUniqueCreator {
    
   public UUIDUniqueCreator () {    }

    public static long generateUUID(String s) throws IOException {
        
        CRC32 cs = new CRC32();
        byte[] str_bytes =s.getBytes();
        
        for (int bb = 0; bb<str_bytes.length;bb++) {
            cs.update(str_bytes[bb]);
        }
        
        
        return cs.getValue();
    }
    
    /***
     * Genera un UUID de 
     * @return
     * @throws IOException
     */
    public static String generateUUID() throws IOException {
    	return UUID.randomUUID().toString();
    }
}
