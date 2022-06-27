package Challenges;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverse("aidan leblanc is awesome"));
    }

    public static String reverse(String text) {
        String[] words = text.split(" ");

        String reversedSentence = "";

        for(int i=words.length-1; i>-1; i--) {
            reversedSentence += words[i] + " ";
        }

        return reversedSentence;
    }
}
