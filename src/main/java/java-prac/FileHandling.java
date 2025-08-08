import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {
        String fileName = "sample.txt";
        File file = new File(fileName);

        // File inspection methods
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent: " + file.getParent());
        System.out.println("Exists: " + file.exists());
        System.out.println("Can read: " + file.canRead());
        System.out.println("Can write: " + file.canWrite());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());

        try {
            // Create the file if it doesn't exist
            if (file.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }

            // Write content to the file (overwrite mode)
            FileWriter writer = new FileWriter(file);
            writer.write("This is a sample content.\n");
            writer.write("Writing to file in Java made simple!");
            writer.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred." + e);
        }
    }
}