package leetcode.biweekly.contest68;

class MaximumNumberOfWordsFoundInSentences {
    public static void main(String[] args) {
        MaximumNumberOfWordsFoundInSentences obj = new MaximumNumberOfWordsFoundInSentences();
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(obj.mostWordsFound(sentences));
    }

    public int mostWordsFound(String[] sentences) {
        int count = Integer.MIN_VALUE;

        for (int i = 0; i < sentences.length; ++i) {
            String[] wordsInSentences = sentences[i].split(" ");
            int sentencesSize = wordsInSentences.length;
            count = Math.max(count, sentencesSize);
        }

        return count;
    }
}