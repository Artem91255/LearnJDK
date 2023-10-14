package server.server.rep;

import java.io.FileReader;
import java.io.FileWriter;

public class Storage implements Repository {

    //private String THE_FILE = "src\\server\\server\\rep\\log.txt";
    private final String THE_FILE ;

    public Storage(String THE_FILE) {
        this.THE_FILE = THE_FILE;
    }
    @Override
    public String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(THE_FILE);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void saveInLog(String text){
        try (FileWriter writer = new FileWriter(THE_FILE, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

