package Challenges;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverse("aidan leblanc is awesome"));
    }


    public static String reverse(String text) {
        String[] words = text.split(" ");

        String[] reversedWords = reverseArray(words);

        return String.join(" ", reversedWords);
    }

    public static String[] reverseArray(String[] words) {
        String[] reversedWords = new String[words.length];
        for(int i=0; i<words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }
        return reversedWords;
    }

    public static String reverseWord(String str) {
        String reversedString = "";
        
        for(int i = str.length() - 1; i > -1; i--) {
            reversedString += str.substring(i, i + 1);
        }

        return reversedString;
    }
}
