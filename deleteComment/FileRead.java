package deleteComment;

import java.io.*;

/**
 * Created by Sayko on 07.10.2015.
 */
public class FileRead {

    private static final String FILE_NAME_INPUT = "src/deleteComment/Main.java";
    private static final String FILE_NAME_OUTPUT = "src/deleteComment/output.txt";

    private BufferedReader reader;
    private StringBuilder textFile;
    private File file;

    public FileRead() throws FileNotFoundException {
        file = new File(FILE_NAME_INPUT);
        reader = new BufferedReader(new FileReader(file));
        textFile = new StringBuilder("");
    }

    public StringBuilder readText() throws IOException {
        String line;
        while((line = reader.readLine()) != null){
            textFile.append(line + "\n");
        }
        return textFile;
    }

    public void writeTextInFile(StringBuilder str){
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            fileOutputStream = new FileOutputStream(FILE_NAME_OUTPUT);
            printStream = new PrintStream(fileOutputStream);
            printStream.print(str);
        }catch (FileNotFoundException e){
            System.out.println("не удалось записать текст в файл!");
        }finally {
            try {
                fileOutputStream.close();
                printStream.close();
            } catch (IOException e) {
                System.out.println("ошибка при закрытии файла!");
            }
        }


    }

}
