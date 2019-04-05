package sources;

public class PhraseOMatic {
    public static String makePhrase() {
        String[] wordListOne = {"24/7", "multi-tier", "30,000 foot", "B-to-B", "win-win"};
        String[] wordListTwo = {"empowered", "sticky", "valued-added", "oriented", "centric"};
        String[] wordListThree = {"process", "tipping point", "solution", "architecture"};

        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        return new StringBuilder()
            .append("What We need is a: ")
            .append(wordListOne[rand1] + " ")
            .append(wordListTwo[rand2] + " ")
            .append(wordListThree[rand3] + " ")
            .toString();
    }
}