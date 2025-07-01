
/*=> same code (FileHandling2.java) but with numerical sorting instead of lexicographical sorting of Arrays.sort()
*/
import java.io.*;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class FileHandling3 {

  public static void main(String[] args) throws IOException {
    // create instance of directory
    File dir = new File("Javacode-main");

    // create object of PrintWriter for output file
    PrintWriter pw = new PrintWriter("merged_output.txt");

    // Get list of all the files in form of String Array
    String[] fileNames = dir.list();

    if (fileNames == null) {
      System.out.println("Directory not found or is empty");
      pw.close();
      return;
    }

    // Sort the file names using a custom comparator
    java.util.Arrays.sort(fileNames, new Comparator<String>() {
      public int compare(String a, String b) {
        return extractSortKey(a).compareTo(extractSortKey(b));
      }

      private String extractSortKey(String name) {
        // Pad numeric parts so that "2.10" becomes "002.010", etc.
        String[] parts = name.split(" ")[0].split("\\.");
        StringBuilder key = new StringBuilder();
        for (String part : parts) {
          try {
            int num = Integer.parseInt(part);
            key.append(String.format("%03d", num));
          } catch (NumberFormatException e) {
            key.append(part);
          }
        }
        return key.toString();
      }
    });

    // loop for reading the contents of all the files
    // in the directory
    for (String fileName : fileNames) {
      // Only process .java files
      if (fileName.endsWith(".java")) {
        System.out.println("Reading from " + fileName);

        // create instance of file from Name of
        // the file stored in string Array
        File f = new File(dir, fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
          pw.println("// ========================================");
          pw.println("// Contents of file: " + fileName);
          pw.println("// ========================================");

          // Read from current file
          String line = br.readLine();
          while (line != null) {
            // write to the output file
            pw.println(line);
            line = br.readLine();
          }
          pw.println(); // Add blank line between files
        } catch (IOException e) {
          System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }
      }
    }

    pw.close();
    System.out.println("Reading from all .java files in directory " +
        dir.getName() + " completed. Output written to merged_output.txt");
  }
}
