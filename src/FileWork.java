import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWork {
    private static final long FILE_MAX_LENGTH = 1073741824;//1 Gb
    static File file;
    public static String readFile(JFrame frame){
        file = chooseFile(frame);
        char [] buf = new char [(int) file.length()];
        try(FileReader reader = new FileReader(file)){
            System.out.println(file.length() + " bytes");
            if(file.length() < FILE_MAX_LENGTH) {
                reader.read(buf);
            }
            else{
                System.out.println("Error! This file is larger than 1 GB");
            }

        }catch (Exception e3){
            e3.printStackTrace();
        }
        return String.valueOf(buf);
    }
    private static File chooseFile(JFrame frame){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(frame);
        chooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        return chooser.getSelectedFile();
    }
    public static void writeFile(String text){
        try(FileWriter writer = new FileWriter(file)){
            writer.write(text);
            writer.flush();

        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public static void newFile(){
        JFileChooser chooser = new JFileChooser();
        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            file = new File(chooser.getSelectedFile() + ".txt");
            FileWork.writeFile("");
        }
    }
}
