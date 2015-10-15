package deleteComment;

import java.io.IOException;

/**
 * Created by Sayko on 07.10.2015.
 */
public class MainDeleteComment {
    public static void main(String[] args){
        try {
            DeleteCommentFile comment = new DeleteCommentFile();
            comment.readText();
            comment.deleteCommentText();
            comment.printTextToFile();
            comment.printEditedText();
        }catch (IOException e){
            System.out.println("error io exception");
        }catch (IllegalStateException e){
            System.out.println("error match not found");
        }

    }
}
