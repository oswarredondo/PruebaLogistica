/* * $id$
 * Nombre del archivo: Files.java
 * Responsable: David Gutiérrez Carrillo
 * Descripcion: manwejo de archivos de la aplicacions
 * $Log: $
 *
 */
package com.innovargia.utils;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


/**
 *
 * @author  amorales
 */
public class Files {
    

    
    /** Creates a new instance of Files */
    public Files() {
    }
    
   
    
    private static String checaNull(String str){
        //Verifica si es null
        if (str==null){
            return "";
        }
        
        //reemplaza los caracters de enter por espacios
        return quitoSignos(str);
    }
     
    
    private static String quitoSignos(String s){
        s = s.replace('\t',' ');
        s = s.replace('\r',' ');
        s = s.replace('\n',' ');
        s = s.replace('ñ','n');
        s = s.replace('|',' ');
        s = s.replace('&',' ');
        //s = s.replace('/',' ');
        s = s.replace('Á','A');
        s = s.replace('É','E');
        s = s.replace('Í','I');
        s = s.replace('Ó','O');
        s = s.replace('Ú','U');
        s = s.replace('á','a');
        s = s.replace('é','e');
        s = s.replace('í','i');
        s = s.replace('ó','o');
        s = s.replace('ú','u');
        
        return s;
        
    }
    
    /**Devuelve un arreglo de bytes de un archivo**/
    public static byte[] getBytesFromFile(File file) throws IOException {
    	
   	
        InputStream is = new FileInputStream(file);
    
        // Get the size of the file
        long length = file.length();
    
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
    
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];
    
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
    
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
    
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    private static HashMap mime = new HashMap();
    static{
    	mime.put(".3dm","x-world/x-3dmf");
    	mime.put(".3dmf","x-world/x-3dmf");
    	mime.put(".a","application/octet-stream");
    	mime.put(".aab","application/x-authorware-bin");
    	mime.put(".aam","application/x-authorware-map");
    	mime.put(".aas","application/x-authorware-seg");
    	mime.put(".abc","text/vnd.abc");
    	mime.put(".acgi","text/html");
    	mime.put(".afl","video/animaflex");
    	mime.put(".ai","application/postscript");
    	mime.put(".aif","audio/aiff");
    	mime.put(".aif","audio/x-aiff");
    	mime.put(".aifc","audio/aiff");
    	mime.put(".aifc","audio/x-aiff");
    	mime.put(".aiff","audio/aiff");
    	mime.put(".aiff","audio/x-aiff");
    	mime.put(".aim","application/x-aim");
    	mime.put(".aip","text/x-audiosoft-intra");
    	mime.put(".ani","application/x-navi-animation");
    	mime.put(".aos","application/x-nokia-9000-communicator-add-on-software");
    	mime.put(".aps","application/mime");
    	mime.put(".arc","application/octet-stream");
    	mime.put(".arj","application/arj");
    	mime.put(".arj","application/octet-stream");
    	mime.put(".art","image/x-jg");
    	mime.put(".asf","video/x-ms-asf");
    	mime.put(".asm","text/x-asm");
    	mime.put(".asp","text/asp");
    	mime.put(".asx","application/x-mplayer2");
    	mime.put(".asx","video/x-ms-asf");
    	mime.put(".asx","video/x-ms-asf-plugin");
    	mime.put(".au","audio/basic");
    	mime.put(".au","audio/x-au");
    	mime.put(".avi","application/x-troff-msvideo");
    	mime.put(".avi","video/avi");
    	mime.put(".avi","video/msvideo");
    	mime.put(".avi","video/x-msvideo");
    	mime.put(".avs","video/avs-video");
    	mime.put(".bcpio","application/x-bcpio");
    	mime.put(".bin","application/mac-binary");
    	mime.put(".bin","application/macbinary");
    	mime.put(".bin","application/octet-stream");
    	mime.put(".bin","application/x-binary");
    	mime.put(".bin","application/x-macbinary");
    	mime.put(".bm","image/bmp");
    	mime.put(".bmp","image/bmp");
    	mime.put(".bmp","image/x-windows-bmp");
    	mime.put(".boo","application/book");
    	mime.put(".book","application/book");
    	mime.put(".boz","application/x-bzip2");
    	mime.put(".bsh","application/x-bsh");
    	mime.put(".bz","application/x-bzip");
    	mime.put(".bz2","application/x-bzip2");
    	mime.put(".c","text/plain");
    	mime.put(".c","text/x-c");
    	mime.put(".c++","text/plain");
    	mime.put(".cat","application/vnd.ms-pki.seccat");
    	mime.put(".cc","text/plain");
    	mime.put(".cc","text/x-c");
    	mime.put(".ccad","application/clariscad");
    	mime.put(".cco","application/x-cocoa");
    	mime.put(".cdf","application/cdf");
    	mime.put(".cdf","application/x-cdf");
    	mime.put(".cdf","application/x-netcdf");
    	mime.put(".cer","application/pkix-cert");
    	mime.put(".cer","application/x-x509-ca-cert");
    	mime.put(".cha","application/x-chat");
    	mime.put(".chat","application/x-chat");
    	mime.put(".class","application/java");
    	mime.put(".class","application/java-byte-code");
    	mime.put(".class","application/x-java-class");
    	mime.put(".com","application/octet-stream");
    	mime.put(".com","text/plain");
    	mime.put(".conf","text/plain");
    	mime.put(".cpio","application/x-cpio");
    	mime.put(".cpp","text/x-c");
    	mime.put(".cpt","application/mac-compactpro");
    	mime.put(".cpt","application/x-compactpro");
    	mime.put(".cpt","application/x-cpt");
    	mime.put(".crl","application/pkcs-crl");
    	mime.put(".crl","application/pkix-crl");
    	mime.put(".crt","application/pkix-cert");
    	mime.put(".crt","application/x-x509-ca-cert");
    	mime.put(".crt","application/x-x509-user-cert");
    	mime.put(".csh","application/x-csh");
    	mime.put(".csh","text/x-script.csh");
    	mime.put(".css","application/x-pointplus");
    	mime.put(".css","text/css");
    	mime.put(".cxx","text/plain");
    	mime.put(".dcr","application/x-director");
    	mime.put(".deepv","application/x-deepv");
    	mime.put(".def","text/plain");
    	mime.put(".der","application/x-x509-ca-cert");
    	mime.put(".dif","video/x-dv");
    	mime.put(".dir","application/x-director");
    	mime.put(".dl","video/dl");
    	mime.put(".dl","video/x-dl");
    	mime.put(".doc","application/msword");
    	mime.put(".dot","application/msword");
    	mime.put(".dp","application/commonground");
    	mime.put(".drw","application/drafting");
    	mime.put(".dump","application/octet-stream");
    	mime.put(".dv","video/x-dv");
    	mime.put(".dvi","application/x-dvi");
    	mime.put(".dwf","drawing/x-dwf (old)");
    	mime.put(".dwf","model/vnd.dwf");
    	mime.put(".dwg","application/acad");
    	mime.put(".dwg","image/vnd.dwg");
    	mime.put(".dwg","image/x-dwg");
    	mime.put(".dxf","application/dxf");
    	mime.put(".dxf","image/vnd.dwg");
    	mime.put(".dxf","image/x-dwg");
    	mime.put(".dxr","application/x-director");
    	mime.put(".el","text/x-script.elisp");
    	mime.put(".elc","application/x-bytecode.elisp (compiled elisp)");
    	mime.put(".elc","application/x-elc");
    	mime.put(".env","application/x-envoy");
    	mime.put(".eps","application/postscript");
    	mime.put(".es","application/x-esrehber");
    	mime.put(".etx","text/x-setext");
    	mime.put(".evy","application/envoy");
    	mime.put(".evy","application/x-envoy");
    	mime.put(".exe","application/octet-stream");
    	mime.put(".f","text/plain");
    	mime.put(".f","text/x-fortran");
    	mime.put(".f77","text/x-fortran");
    	mime.put(".f90","text/plain");
    	mime.put(".f90","text/x-fortran");
    	mime.put(".fdf","application/vnd.fdf");
    	mime.put(".fif","application/fractals");
    	mime.put(".fif","image/fif");
    	mime.put(".fli","video/fli");
    	mime.put(".fli","video/x-fli");
    	mime.put(".flo","image/florian");
    	mime.put(".flx","text/vnd.fmi.flexstor");
    	mime.put(".fmf","video/x-atomic3d-feature");
    	mime.put(".for","text/plain");
    	mime.put(".for","text/x-fortran");
    	mime.put(".fpx","image/vnd.fpx");
    	mime.put(".fpx","image/vnd.net-fpx");
    	mime.put(".frl","application/freeloader");
    	mime.put(".funk","audio/make");
    	mime.put(".g","text/plain");
    	mime.put(".g3","image/g3fax");
    	mime.put(".gif","image/gif");
    	mime.put(".gl","video/gl");
    	mime.put(".gl","video/x-gl");
    	mime.put(".gsd","audio/x-gsm");
    	mime.put(".gsm","audio/x-gsm");
    	mime.put(".gsp","application/x-gsp");
    	mime.put(".gss","application/x-gss");
    	mime.put(".gtar","application/x-gtar");
    	mime.put(".gz","application/x-compressed");
    	mime.put(".gz","application/x-gzip");
    	mime.put(".gzip","application/x-gzip");
    	mime.put(".gzip","multipart/x-gzip");
    	mime.put(".h","text/plain");
    	mime.put(".h","text/x-h");
    	mime.put(".hdf","application/x-hdf");
    	mime.put(".help","application/x-helpfile");
    	mime.put(".hgl","application/vnd.hp-hpgl");
    	mime.put(".hh","text/plain");
    	mime.put(".hh","text/x-h");
    	mime.put(".hlb","text/x-script");
    	mime.put(".hlp","application/hlp");
    	mime.put(".hlp","application/x-helpfile");
    	mime.put(".hlp","application/x-winhelp");
    	mime.put(".hpg","application/vnd.hp-hpgl");
    	mime.put(".hpgl","application/vnd.hp-hpgl");
    	mime.put(".hqx","application/binhex");
    	mime.put(".hqx","application/binhex4");
    	mime.put(".hqx","application/mac-binhex");
    	mime.put(".hqx","application/mac-binhex40");
    	mime.put(".hqx","application/x-binhex40");
    	mime.put(".hqx","application/x-mac-binhex40");
    	mime.put(".hta","application/hta");
    	mime.put(".htc","text/x-component");
    	mime.put(".htm","text/html");
    	mime.put(".html","text/html");
    	mime.put(".htmls","text/html");
    	mime.put(".htt","text/webviewhtml");
    	mime.put(".htx","text/html");
    	mime.put(".ice","x-conference/x-cooltalk");
    	mime.put(".ico","image/x-icon");
    	mime.put(".idc","text/plain");
    	mime.put(".ief","image/ief");
    	mime.put(".iefs","image/ief");
    	mime.put(".iges","application/iges");
    	mime.put(".iges","model/iges");
    	mime.put(".igs","application/iges");
    	mime.put(".igs","model/iges");
    	mime.put(".ima","application/x-ima");
    	mime.put(".imap","application/x-httpd-imap");
    	mime.put(".inf","application/inf");
    	mime.put(".ins","application/x-internett-signup");
    	mime.put(".ip","application/x-ip2");
    	mime.put(".isu","video/x-isvideo");
    	mime.put(".it","audio/it");
    	mime.put(".iv","application/x-inventor");
    	mime.put(".ivr","i-world/i-vrml");
    	mime.put(".ivy","application/x-livescreen");
    	mime.put(".jam","audio/x-jam");
    	mime.put(".jav","text/plain");
    	mime.put(".jav","text/x-java-source");
    	mime.put(".java","text/plain");
    	mime.put(".java","text/x-java-source");
    	mime.put(".jcm","application/x-java-commerce");
    	mime.put(".jfif","image/jpeg");
    	mime.put(".jfif","image/pjpeg");
    	mime.put(".jfif-tbnl","image/jpeg");
    	mime.put(".jpe","image/jpeg");
    	mime.put(".jpe","image/pjpeg");
    	mime.put(".jpeg","image/jpeg");
    	mime.put(".jpeg","image/pjpeg");
    	mime.put(".jpg","image/jpeg");
    	mime.put(".jpg","image/pjpeg");
    	mime.put(".jps","image/x-jps");
    	mime.put(".js","application/x-javascript");
    	mime.put(".jut","image/jutvision");
    	mime.put(".kar","audio/midi");
    	mime.put(".kar","music/x-karaoke");
    	mime.put(".ksh","application/x-ksh");
    	mime.put(".ksh","text/x-script.ksh");
    	mime.put(".la","audio/nspaudio");
    	mime.put(".la","audio/x-nspaudio");
    	mime.put(".lam","audio/x-liveaudio");
    	mime.put(".latex","application/x-latex");
    	mime.put(".lha","application/lha");
    	mime.put(".lha","application/octet-stream");
    	mime.put(".lha","application/x-lha");
    	mime.put(".lhx","application/octet-stream");
    	mime.put(".list","text/plain");
    	mime.put(".lma","audio/nspaudio");
    	mime.put(".lma","audio/x-nspaudio");
    	mime.put(".log","text/plain");
    	mime.put(".lsp","application/x-lisp");
    	mime.put(".lsp","text/x-script.lisp");
    	mime.put(".lst","text/plain");
    	mime.put(".lsx","text/x-la-asf");
    	mime.put(".ltx","application/x-latex");
    	mime.put(".lzh","application/octet-stream");
    	mime.put(".lzh","application/x-lzh");
    	mime.put(".lzx","application/lzx");
    	mime.put(".lzx","application/octet-stream");
    	mime.put(".lzx","application/x-lzx");
    	mime.put(".m","text/plain");
    	mime.put(".m","text/x-m");
    	mime.put(".m1v","video/mpeg");
    	mime.put(".m2a","audio/mpeg");
    	mime.put(".m2v","video/mpeg");
    	mime.put(".m3u","audio/x-mpequrl");
    	mime.put(".man","application/x-troff-man");
    	mime.put(".map","application/x-navimap");
    	mime.put(".mar","text/plain");
    	mime.put(".mbd","application/mbedlet");
    	mime.put(".mc$","application/x-magic-cap-package-1.0");
    	mime.put(".mcd","application/mcad");
    	mime.put(".mcd","application/x-mathcad");
    	mime.put(".mcf","image/vasa");
    	mime.put(".mcf","text/mcf");
    	mime.put(".mcp","application/netmc");
    	mime.put(".me","application/x-troff-me");
    	mime.put(".mht","message/rfc822");
    	mime.put(".mhtml","message/rfc822");
    	mime.put(".mid","application/x-midi");
    	mime.put(".mid","audio/midi");
    	mime.put(".mid","audio/x-mid");
    	mime.put(".mid","audio/x-midi");
    	mime.put(".mid","music/crescendo");
    	mime.put(".mid","x-music/x-midi");
    	mime.put(".midi","application/x-midi");
    	mime.put(".midi","audio/midi");
    	mime.put(".midi","audio/x-mid");
    	mime.put(".midi","audio/x-midi");
    	mime.put(".midi","music/crescendo");
    	mime.put(".midi","x-music/x-midi");
    	mime.put(".mif","application/x-frame");
    	mime.put(".mif","application/x-mif");
    	mime.put(".mime","message/rfc822");
    	mime.put(".mime","www/mime");
    	mime.put(".mjf","audio/x-vnd.audioexplosion.mjuicemediafile");
    	mime.put(".mjpg","video/x-motion-jpeg");
    	mime.put(".mm","application/base64");
    	mime.put(".mm","application/x-meme");
    	mime.put(".mme","application/base64");
    	mime.put(".mod","audio/mod");
    	mime.put(".mod","audio/x-mod");
    	mime.put(".moov","video/quicktime");
    	mime.put(".mov","video/quicktime");
    	mime.put(".movie","video/x-sgi-movie");
    	mime.put(".mp2","audio/mpeg");
    	mime.put(".mp2","audio/x-mpeg");
    	mime.put(".mp2","video/mpeg");
    	mime.put(".mp2","video/x-mpeg");
    	mime.put(".mp2","video/x-mpeq2a");
    	mime.put(".mp3","audio/mpeg3");
    	mime.put(".mp3","audio/x-mpeg-3");
    	mime.put(".mp3","video/mpeg");
    	mime.put(".mp3","video/x-mpeg");
    	mime.put(".mpa","audio/mpeg");
    	mime.put(".mpa","video/mpeg");
    	mime.put(".mpc","application/x-project");
    	mime.put(".mpe","video/mpeg");
    	mime.put(".mpeg","video/mpeg");
    	mime.put(".mpg","audio/mpeg");
    	mime.put(".mpg","video/mpeg");
    	mime.put(".mpga","audio/mpeg");
    	mime.put(".mpp","application/vnd.ms-project");
    	mime.put(".mpt","application/x-project");
    	mime.put(".mpv","application/x-project");
    	mime.put(".mpx","application/x-project");
    	mime.put(".mrc","application/marc");
    	mime.put(".ms","application/x-troff-ms");
    	mime.put(".mv","video/x-sgi-movie");
    	mime.put(".my","audio/make");
    	mime.put(".mzz","application/x-vnd.audioexplosion.mzz");
    	mime.put(".nap","image/naplps");
    	mime.put(".naplps","image/naplps");
    	mime.put(".nc","application/x-netcdf");
    	mime.put(".ncm","application/vnd.nokia.configuration-message");
    	mime.put(".nif","image/x-niff");
    	mime.put(".niff","image/x-niff");
    	mime.put(".nix","application/x-mix-transfer");
    	mime.put(".nsc","application/x-conference");
    	mime.put(".nvd","application/x-navidoc");
    	mime.put(".o","application/octet-stream");
    	mime.put(".oda","application/oda");
    	mime.put(".omc","application/x-omc");
    	mime.put(".omcd","application/x-omcdatamaker");
    	mime.put(".omcr","application/x-omcregerator");
    	mime.put(".p","text/x-pascal");
    	mime.put(".p10","application/pkcs10");
    	mime.put(".p10","application/x-pkcs10");
    	mime.put(".p12","application/pkcs-12");
    	mime.put(".p12","application/x-pkcs12");
    	mime.put(".p7a","application/x-pkcs7-signature");
    	mime.put(".p7c","application/pkcs7-mime");
    	mime.put(".p7c","application/x-pkcs7-mime");
    	mime.put(".p7m","application/pkcs7-mime");
    	mime.put(".p7m","application/x-pkcs7-mime");
    	mime.put(".p7r","application/x-pkcs7-certreqresp");
    	mime.put(".p7s","application/pkcs7-signature");
    	mime.put(".part","application/pro_eng");
    	mime.put(".pas","text/pascal");
    	mime.put(".pbm","image/x-portable-bitmap");
    	mime.put(".pcl","application/vnd.hp-pcl");
    	mime.put(".pcl","application/x-pcl");
    	mime.put(".pct","image/x-pict");
    	mime.put(".pcx","image/x-pcx");
    	mime.put(".pdb","chemical/x-pdb");
    	mime.put(".pdf","application/pdf");
    	mime.put(".pfunk","audio/make");
    	mime.put(".pfunk","audio/make.my.funk");
    	mime.put(".pgm","image/x-portable-graymap");
    	mime.put(".pgm","image/x-portable-greymap");
    	mime.put(".pic","image/pict");
    	mime.put(".pict","image/pict");
    	mime.put(".pkg","application/x-newton-compatible-pkg");
    	mime.put(".pko","application/vnd.ms-pki.pko");
    	mime.put(".pl","text/plain");
    	mime.put(".pl","text/x-script.perl");
    	mime.put(".plx","application/x-pixclscript");
    	mime.put(".pm","image/x-xpixmap");
    	mime.put(".pm","text/x-script.perl-module");
    	mime.put(".pm4","application/x-pagemaker");
    	mime.put(".pm5","application/x-pagemaker");
    	mime.put(".png","image/png");
    	mime.put(".pnm","application/x-portable-anymap");
    	mime.put(".pnm","image/x-portable-anymap");
    	mime.put(".pot","application/mspowerpoint");
    	mime.put(".pot","application/vnd.ms-powerpoint");
    	mime.put(".pov","model/x-pov");
    	mime.put(".ppa","application/vnd.ms-powerpoint");
    	mime.put(".ppm","image/x-portable-pixmap");
    	mime.put(".pps","application/mspowerpoint");
    	mime.put(".pps","application/vnd.ms-powerpoint");
    	mime.put(".ppt","application/mspowerpoint");
    	mime.put(".ppt","application/powerpoint");
    	mime.put(".ppt","application/vnd.ms-powerpoint");
    	mime.put(".ppt","application/x-mspowerpoint");
    	mime.put(".ppz","application/mspowerpoint");
    	mime.put(".pre","application/x-freelance");
    	mime.put(".prt","application/pro_eng");
    	mime.put(".ps","application/postscript");
    	mime.put(".psd","application/octet-stream");
    	mime.put(".pvu","paleovu/x-pv");
    	mime.put(".pwz","application/vnd.ms-powerpoint");
    	mime.put(".py","text/x-script.phyton");
    	mime.put(".pyc","applicaiton/x-bytecode.python");
    	mime.put(".qcp","audio/vnd.qcelp");
    	mime.put(".qd3","x-world/x-3dmf");
    	mime.put(".qd3d","x-world/x-3dmf");
    	mime.put(".qif","image/x-quicktime");
    	mime.put(".qt","video/quicktime");
    	mime.put(".qtc","video/x-qtc");
    	mime.put(".qti","image/x-quicktime");
    	mime.put(".qtif","image/x-quicktime");
    	mime.put(".ra","audio/x-pn-realaudio");
    	mime.put(".ra","audio/x-pn-realaudio-plugin");
    	mime.put(".ra","audio/x-realaudio");
    	mime.put(".ram","audio/x-pn-realaudio");
    	mime.put(".ras","application/x-cmu-raster");
    	mime.put(".ras","image/cmu-raster");
    	mime.put(".ras","image/x-cmu-raster");
    	mime.put(".rast","image/cmu-raster");
    	mime.put(".rexx","text/x-script.rexx");
    	mime.put(".rf","image/vnd.rn-realflash");
    	mime.put(".rgb","image/x-rgb");
    	mime.put(".rm","application/vnd.rn-realmedia");
    	mime.put(".rm","audio/x-pn-realaudio");
    	mime.put(".rmi","audio/mid");
    	mime.put(".rmm","audio/x-pn-realaudio");
    	mime.put(".rmp","audio/x-pn-realaudio");
    	mime.put(".rmp","audio/x-pn-realaudio-plugin");
    	mime.put(".rng","application/ringing-tones");
    	mime.put(".rng","application/vnd.nokia.ringing-tone");
    	mime.put(".rnx","application/vnd.rn-realplayer");
    	mime.put(".roff","application/x-troff");
    	mime.put(".rp","image/vnd.rn-realpix");
    	mime.put(".rpm","audio/x-pn-realaudio-plugin");
    	mime.put(".rt","text/richtext");
    	mime.put(".rt","text/vnd.rn-realtext");
    	mime.put(".rtf","application/rtf");
    	mime.put(".rtf","application/x-rtf");
    	mime.put(".rtf","text/richtext");
    	mime.put(".rtx","application/rtf");
    	mime.put(".rtx","text/richtext");
    	mime.put(".rv","video/vnd.rn-realvideo");
    	mime.put(".s","text/x-asm");
    	mime.put(".s3m","audio/s3m");
    	mime.put(".saveme","application/octet-stream");
    	mime.put(".sbk","application/x-tbook");
    	mime.put(".scm","application/x-lotusscreencam");
    	mime.put(".scm","text/x-script.guile");
    	mime.put(".scm","text/x-script.scheme");
    	mime.put(".scm","video/x-scm");
    	mime.put(".sdml","text/plain");
    	mime.put(".sdp","application/sdp");
    	mime.put(".sdp","application/x-sdp");
    	mime.put(".sdr","application/sounder");
    	mime.put(".sea","application/sea");
    	mime.put(".sea","application/x-sea");
    	mime.put(".set","application/set");
    	mime.put(".sgm","text/sgml");
    	mime.put(".sgm","text/x-sgml");
    	mime.put(".sgml","text/sgml");
    	mime.put(".sgml","text/x-sgml");
    	mime.put(".sh","application/x-bsh");
    	mime.put(".sh","application/x-sh");
    	mime.put(".sh","application/x-shar");
    	mime.put(".sh","text/x-script.sh");
    	mime.put(".shar","application/x-bsh");
    	mime.put(".shar","application/x-shar");
    	mime.put(".shtml","text/html");
    	mime.put(".shtml","text/x-server-parsed-html");
    	mime.put(".sid","audio/x-psid");
    	mime.put(".sit","application/x-sit");
    	mime.put(".sit","application/x-stuffit");
    	mime.put(".skd","application/x-koan");
    	mime.put(".skm","application/x-koan");
    	mime.put(".skp","application/x-koan");
    	mime.put(".skt","application/x-koan");
    	mime.put(".sl","application/x-seelogo");
    	mime.put(".smi","application/smil");
    	mime.put(".smil","application/smil");
    	mime.put(".snd","audio/basic");
    	mime.put(".snd","audio/x-adpcm");
    	mime.put(".sol","application/solids");
    	mime.put(".spc","application/x-pkcs7-certificates");
    	mime.put(".spc","text/x-speech");
    	mime.put(".spl","application/futuresplash");
    	mime.put(".spr","application/x-sprite");
    	mime.put(".sprite","application/x-sprite");
    	mime.put(".src","application/x-wais-source");
    	mime.put(".ssi","text/x-server-parsed-html");
    	mime.put(".ssm","application/streamingmedia");
    	mime.put(".sst","application/vnd.ms-pki.certstore");
    	mime.put(".step","application/step");
    	mime.put(".stl","application/sla");
    	mime.put(".stl","application/vnd.ms-pki.stl");
    	mime.put(".stl","application/x-navistyle");
    	mime.put(".stp","application/step");
    	mime.put(".sv4cpio","application/x-sv4cpio");
    	mime.put(".sv4crc","application/x-sv4crc");
    	mime.put(".svf","image/vnd.dwg");
    	mime.put(".svf","image/x-dwg");
    	mime.put(".svr","application/x-world");
    	mime.put(".svr","x-world/x-svr");
    	mime.put(".swf","application/x-shockwave-flash");
    	mime.put(".t","application/x-troff");
    	mime.put(".talk","text/x-speech");
    	mime.put(".tar","application/x-tar");
    	mime.put(".tbk","application/toolbook");
    	mime.put(".tbk","application/x-tbook");
    	mime.put(".tcl","application/x-tcl");
    	mime.put(".tcl","text/x-script.tcl");
    	mime.put(".tcsh","text/x-script.tcsh");
    	mime.put(".tex","application/x-tex");
    	mime.put(".texi","application/x-texinfo");
    	mime.put(".texinfo","application/x-texinfo");
    	mime.put(".text","application/plain");
    	mime.put(".text","text/plain");
    	mime.put(".tgz","application/gnutar");
    	mime.put(".tgz","application/x-compressed");
    	mime.put(".tif","image/tiff");
    	mime.put(".tif","image/x-tiff");
    	mime.put(".tiff","image/tiff");
    	mime.put(".tiff","image/x-tiff");
    	mime.put(".tr","application/x-troff");
    	mime.put(".tsi","audio/tsp-audio");
    	mime.put(".tsp","application/dsptype");
    	mime.put(".tsp","audio/tsplayer");
    	mime.put(".tsv","text/tab-separated-values");
    	mime.put(".turbot","image/florian");
    	mime.put(".txt","text/plain");
    	mime.put(".uil","text/x-uil");
    	mime.put(".uni","text/uri-list");
    	mime.put(".unis","text/uri-list");
    	mime.put(".unv","application/i-deas");
    	mime.put(".uri","text/uri-list");
    	mime.put(".uris","text/uri-list");
    	mime.put(".ustar","application/x-ustar");
    	mime.put(".ustar","multipart/x-ustar");
    	mime.put(".uu","application/octet-stream");
    	mime.put(".uu","text/x-uuencode");
    	mime.put(".uue","text/x-uuencode");
    	mime.put(".vcd","application/x-cdlink");
    	mime.put(".vcs","text/x-vcalendar");
    	mime.put(".vda","application/vda");
    	mime.put(".vdo","video/vdo");
    	mime.put(".vew","application/groupwise");
    	mime.put(".viv","video/vivo");
    	mime.put(".viv","video/vnd.vivo");
    	mime.put(".vivo","video/vivo");
    	mime.put(".vivo","video/vnd.vivo");
    	mime.put(".vmd","application/vocaltec-media-desc");
    	mime.put(".vmf","application/vocaltec-media-file");
    	mime.put(".voc","audio/voc");
    	mime.put(".voc","audio/x-voc");
    	mime.put(".vos","video/vosaic");
    	mime.put(".vox","audio/voxware");
    	mime.put(".vqe","audio/x-twinvq-plugin");
    	mime.put(".vqf","audio/x-twinvq");
    	mime.put(".vql","audio/x-twinvq-plugin");
    	mime.put(".vrml","application/x-vrml");
    	mime.put(".vrml","model/vrml");
    	mime.put(".vrml","x-world/x-vrml");
    	mime.put(".vrt","x-world/x-vrt");
    	mime.put(".vsd","application/x-visio");
    	mime.put(".vst","application/x-visio");
    	mime.put(".vsw","application/x-visio");
    	mime.put(".w60","application/wordperfect6.0");
    	mime.put(".w61","application/wordperfect6.1");
    	mime.put(".w6w","application/msword");
    	mime.put(".wav","audio/wav");
    	mime.put(".wav","audio/x-wav");
    	mime.put(".wb1","application/x-qpro");
    	mime.put(".wbmp","image/vnd.wap.wbmp");
    	mime.put(".web","application/vnd.xara");
    	mime.put(".wiz","application/msword");
    	mime.put(".wk1","application/x-123");
    	mime.put(".wmf","windows/metafile");
    	mime.put(".wml","text/vnd.wap.wml");
    	mime.put(".wmlc","application/vnd.wap.wmlc");
    	mime.put(".wmls","text/vnd.wap.wmlscript");
    	mime.put(".wmlsc","application/vnd.wap.wmlscriptc");
    	mime.put(".word","application/msword");
    	mime.put(".wp","application/wordperfect");
    	mime.put(".wp5","application/wordperfect");
    	mime.put(".wp5","application/wordperfect6.0");
    	mime.put(".wp6","application/wordperfect");
    	mime.put(".wpd","application/wordperfect");
    	mime.put(".wpd","application/x-wpwin");
    	mime.put(".wq1","application/x-lotus");
    	mime.put(".wri","application/mswrite");
    	mime.put(".wri","application/x-wri");
    	mime.put(".wrl","application/x-world");
    	mime.put(".wrl","model/vrml");
    	mime.put(".wrl","x-world/x-vrml");
    	mime.put(".wrz","model/vrml");
    	mime.put(".wrz","x-world/x-vrml");
    	mime.put(".wsc","text/scriplet");
    	mime.put(".wsrc","application/x-wais-source");
    	mime.put(".wtk","application/x-wintalk");
    	mime.put(".xbm","image/x-xbitmap");
    	mime.put(".xbm","image/x-xbm");
    	mime.put(".xbm","image/xbm");
    	mime.put(".xdr","video/x-amt-demorun");
    	mime.put(".xgz","xgl/drawing");
    	mime.put(".xif","image/vnd.xiff");
    	mime.put(".xl","application/excel");
    	mime.put(".xla","application/excel");
    	mime.put(".xla","application/x-excel");
    	mime.put(".xla","application/x-msexcel");
    	mime.put(".xlb","application/excel");
    	mime.put(".xlb","application/vnd.ms-excel");
    	mime.put(".xlb","application/x-excel");
    	mime.put(".xlc","application/excel");
    	mime.put(".xlc","application/vnd.ms-excel");
    	mime.put(".xlc","application/x-excel");
    	mime.put(".xld","application/excel");
    	mime.put(".xld","application/x-excel");
    	mime.put(".xlk","application/excel");
    	mime.put(".xlk","application/x-excel");
    	mime.put(".xll","application/excel");
    	mime.put(".xll","application/vnd.ms-excel");
    	mime.put(".xll","application/x-excel");
    	mime.put(".xlm","application/excel");
    	mime.put(".xlm","application/vnd.ms-excel");
    	mime.put(".xlm","application/x-excel");
    	mime.put(".xls","application/excel");
    	mime.put(".xls","application/vnd.ms-excel");
    	mime.put(".xls","application/x-excel");
    	mime.put(".xls","application/x-msexcel");
    	mime.put(".xlt","application/excel");
    	mime.put(".xlt","application/x-excel");
    	mime.put(".xlv","application/excel");
    	mime.put(".xlv","application/x-excel");
    	mime.put(".xlw","application/excel");
    	mime.put(".xlw","application/vnd.ms-excel");
    	mime.put(".xlw","application/x-excel");
    	mime.put(".xlw","application/x-msexcel");
    	mime.put(".xm","audio/xm");
    	mime.put(".xml","application/xml");
    	mime.put(".xml","text/xml");
    	mime.put(".xmz","xgl/movie");
    	mime.put(".xpix","application/x-vnd.ls-xpix");
    	mime.put(".xpm","image/x-xpixmap");
    	mime.put(".xpm","image/xpm");
    	mime.put(".x-png","image/png");
    	mime.put(".xsr","video/x-amt-showrun");
    	mime.put(".xwd","image/x-xwd");
    	mime.put(".xwd","image/x-xwindowdump");
    	mime.put(".xyz","chemical/x-pdb");
    	mime.put(".z","application/x-compress");
    	mime.put(".z","application/x-compressed");
    	mime.put(".zip","application/x-compressed");
    	mime.put(".zip","application/x-zip-compressed");
    	mime.put(".zip","application/zip");
    	mime.put(".zip","multipart/x-zip");
    	mime.put(".zoo","application/octet-stream");
    	mime.put(".zsh","text/x-script.zsh");
    	
    	mime.put(".xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    	mime.put(".xltx","application/vnd.openxmlformats-officedocument.spreadsheetml.template");
    	mime.put(".potx","application/vnd.openxmlformats-officedocument.presentationml.template");
    	mime.put(".ppsx","application/vnd.openxmlformats-officedocument.presentationml.slideshow");
    	mime.put(".pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation");
    	mime.put(".sldx","application/vnd.openxmlformats-officedocument.presentationml.slide");
    	mime.put(".docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    	mime.put(".dotx","application/vnd.openxmlformats-officedocument.wordprocessingml.template");
    	mime.put(".xlam","application/vnd.ms-excel.addin.macroEnabled.12");
    	mime.put(".xlsb","application/vnd.ms-excel.sheet.binary.macroEnabled.12");

    }
    public static String getMimeType(String fileName){
    	//System.out.println("getMimeType del archvivo->" + fileName);
    	if (fileName==null) return "application/octet-stream";
    	
    	//System.out.println("getMimeType del archvivo NO NULL->" + fileName);
    	String[] ext =fileName.split("\\.");
    	for (int i=0;i<ext.length;i++){
    		//System.out.println("Parte del archivo->" + ext[i]);	
    	}
    	if (ext.length>1){
    		//System.out.println("Busco datos->" + mime.containsKey("." + ext[1]));
    		if (mime.containsKey("." + ext[ext.length-1])){
    			//System.out.println("lo encontre->" + mime.get("." + ext[1]));
    			return (String) mime.get("." + ext[ext.length-1]);
    		}
    	}
    	return "application/octet-stream";
    }
    
    public static String getMimeTypeFile(File file){
    	//System.out.println("getMimeTypeFile->" + file);
    	if (file==null){
    		//System.out.println("File es NULL->");
    		return getMimeType(null);
    	}
    	//System.out.println("file.getName()->" + file.getName());
    	return getMimeType(file.getName());
    }
    
    
   

}//fin de Files
