package exam;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {
        WriteFile wf = new WriteFile();
        wf.start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("please input a file name");
            String fileName = in.nextLine();
            if (!checkFileExists(fileName)) continue;
            if (writeFile(fileName, "Yes,I have created a file")) break;
        }
    }


    public boolean writeFile(String path, String content) {
        if (content.isEmpty()
                || path.isEmpty()) return true;
        try {
            FileWriter fileWriter = new FileWriter(path, false);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkFileExists(String path) {
        if (path.isEmpty()) return false;
        return new File(path).exists();
    }
}
