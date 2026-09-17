import java.util.List;

public class WordCounter {

    private static int totalWords = 0;

    public static void main(String[] args) {
        List<String> sentences = List.of("Hello world", "Java is fun", "Compact source files");
        for (String sentence : sentences) {
            countWords(sentence);
        }
        System.out.println("Total words: " + totalWords);
    }

    private static void countWords(String sentence) {
        totalWords += sentence.split(" ").length;
    }
}
