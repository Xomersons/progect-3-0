package user.igor.progect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String poem = "У Лукоморья дуб зелёный"; // строка стихотворения

    private TextView manyMonthOut; // поле вывода результатов анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manyMonthOut = findViewById(R.id.manyMonthOut); // поле вывода результатов анализа строки

        int charCount = countCharacters(poem);
        int wordCount = countWords(poem);
        int letterLCount = countLetterL(poem);
        String fiveLetterWords = findFiveLetterWords(poem);
        String wordsStartingWithA = findWordsStartingWithA(poem);

        String result = "Character count: " + charCount + "\n" +
                "Word count: " + wordCount + "\n" +
                "Letter 'л' count: " + letterLCount + "\n" +
                "Five letter words: " + fiveLetterWords + "\n" +
                "Words starting with 'a': " + wordsStartingWithA;

        manyMonthOut.setText(result);
    }

    public int countCharacters(String poem) {
        return poem.length();
    }

    public int countWords(String poem) {
        String[] words = poem.split(" ");
        return words.length;
    }

    public int countLetterL(String poem) {
        int count = 0;
        for (int i = 0; i < poem.length(); i++) {
            if (poem.charAt(i) == 'л') {
                count++;
            }
        }
        return count;
    }

    public String findFiveLetterWords(String poem) {
        String[] words = poem.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() == 5) {
                result.append(word).append(" ");
            }
        }
        return result.toString();
    }

    public String findWordsStartingWithA(String poem) {
        String[] words = poem.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("а") || word.startsWith("А")) {
                result.append(word).append(" ");
            }
        }
        return result.toString();
    }
}
