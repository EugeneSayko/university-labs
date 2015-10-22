package deleteComment;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sayko on 07.10.2015.
 */
public class DeleteCommentFile {
    private String text;
    private FileRead file;
    private StringBuilder textEdited;

    public DeleteCommentFile() throws FileNotFoundException {
        file = new FileRead();
        textEdited = new StringBuilder("");
    }

    public void readText() throws IOException {
        text = new String(file.readText());
    }

    public void deleteCommentText() throws IllegalStateException{

        text = deleteCommentsLine("(?<=[^(\\\".*)(//\\w)])(//.*)(?=[^\\\"])", text);

        text = deleteCommentsLine("(?<=[^\\\".*?(//\\*)\\w])(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|[\\t\\r\\n]@i(?=[^\\\"])", text);

        textEdited.append(text);

    }

    private String deleteCommentsLine(String regex, String text){
        String[] lineComments = text.split(regex);
        text = "";
        for(String item : lineComments){
            text = text + item;
        }
        return text;
    }


    public void printTextToFile(){
        file.writeTextInFile(textEdited);
    }

    public void printText(){
        System.out.println(text);
    }

    public void printEditedText(){
        System.out.println(textEdited);
    }
}
