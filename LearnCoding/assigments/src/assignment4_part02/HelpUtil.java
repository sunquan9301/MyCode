package assignment4_part02;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

//a util to offer some method for file
public class HelpUtil {
    public static boolean writeFile(String path, String content) {
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

    public static String read(final BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[8192];
        try {
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                sb.append(buffer, 0, read);
            }
        } catch (IOException e) {
        } finally {
            close(reader);
        }
        return sb.toString();
    }

    public static void close(Closeable c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
