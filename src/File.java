import java.io.*;

public class File {

    public void createFile () {

        try {
            FileWriter fw = new FileWriter("C:\\Users\\nikam\\IdeaProjects\\JavaHomework9\\src/info.txt");
            fw.write("help \n" +
                    "create file dslfvjdfsv \n" +
                    "---- \n");

            fw.write("date \n" +
                    "f2398y329823 \n" +
                    "---- \n");

            fw.write("name \n" +
                    "nikoloz \n" +
                    "---- \n");

            fw.write("error \n" +
                    "Compile error \n" +
                    "----");

            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readFile () {

        try {

            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\nikam\\IdeaProjects\\JavaHomework9\\src/info.txt"));

            String line = bf.readLine();

            while (line != null){
                System.out.println(line);
                line = bf.readLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
