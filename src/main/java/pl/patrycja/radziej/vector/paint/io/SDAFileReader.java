package pl.patrycja.radziej.vector.paint.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SDAFileReader {

    private File file;

    public SDAFileReader(File file) {
        this.file = file;
    }

    public List<String> readFile() {
        List<String> finalList= new LinkedList<>();
        BufferedReader br = null;
        try {
            System.out.println(file.getAbsolutePath());
            java.io.FileReader fileReader = new java.io.FileReader(file);
            br = new BufferedReader(fileReader);

            String nextLine = br.readLine();
            while (nextLine != null) {
 //               System.out.println(nextLine);
                finalList.add(nextLine);
                nextLine = br.readLine();
            }
            System.out.println("Koniec pliku");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(finalList);
        return finalList;
    }
}
