package assignment1;
import java.io.*;


public class fileIssueCount {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\abimg\\OneDrive\\Documents");
        int[] qty = countJavaFileAndIssue(folder);

        System.out.println("Number of Java Files = " + qty[0]);
        System.out.println("Number of Issues = " + qty[1]);
    }

    public static int[] countJavaFileAndIssue(File folder) {
        int fileCount = 0;
        int issueCount = 0;

        File[] files = folder.listFiles();
        if (files == null) {
            System.out.println("Directory is empty or not accessible.");
            return new int[]{0, 0};
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                fileCount++;

                if (containsSolvedComment(file)) {
                    issueCount++;
                }
            }
        }

        return new int[]{fileCount, issueCount};
    }

    public static boolean containsSolvedComment(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().trim().contains("// solved")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }

        return false;
    }
}
