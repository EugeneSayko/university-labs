package FileWork;

import java.io.*;

/**
 * Created by Sayko on 05.12.2015.
 */
public class FileBytes {

    private FileInputStream fis;
    private FileOutputStream fos;

    public boolean openInputFile(String filename){
        try {
            fis = new FileInputStream(new File(filename));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean openOutputFile(String filename){
        try {
            fos = new FileOutputStream(new File(filename));
            return true;
        }catch (FileNotFoundException e){
            return false;
        }
    }

    public void closeInputFile() throws IOException {
        if(fis != null){
            fis.close();
        }
    }

    public void closeOutputFile() throws IOException{
        if(fos != null){
            fos.close();
        }
    }

    public boolean canReadFile() throws IOException {
        if(fis.available() != 0){
            return true;
        }
        return false;
    }

    public byte[] readAllFile() throws IOException{
        byte[] b = new byte[fis.available()];
        fis.read(b);
        return b;
    }

    public void writeBytesFile(byte[] b) throws IOException {
        fos.write(b);
    }

    public byte[] readButBytes(int but) throws IOException{
        byte[] b;
        if(fis.available() < but){
            b = new byte[fis.available()];
        }else{
            b = new byte[but];
        }
        fis.read(b);
        return b;
    }
}
