import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        //System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        int wordCount = 0;
        char[] inputArray = urlToString("https://www.bls.gov/tus/charts/chart9.txt").toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == ' ' || inputArray[i] == '\n') {
                wordCount += 1;
            }
        }
        System.out.println(wordCount);
    }
}
