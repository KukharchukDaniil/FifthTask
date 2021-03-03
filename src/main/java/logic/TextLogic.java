package logic;

import entities.Component;
import entities.Composite;
import entities.Leaf;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class TextLogic {
        public String rebuildText(Composite text){
            StringJoiner resultText = new StringJoiner(" ");
            List<Component> paragraphs = text.getChildNodes();
            for (Component paragraph : paragraphs) {
                List<Component> sentences = ((Composite)paragraph).getChildNodes();
                sentences.stream().forEach(component -> {
                    Composite sentence = (Composite) component;
                    sentence.getChildNodes().stream().forEach(word -> {
                        resultText.add(((Leaf)(word)).getValue());
                    });
                    resultText.add(". ");
                });
                resultText.add("\t");
            }
            return String.valueOf(resultText);
        }
        public Composite sortParagraphsBySentencesAmount(Composite text){
            List<Component> paragraphs = text.getChildNodes();
            Composite result = new Composite(paragraphs.stream().sorted(new Comparator<Component>() {
                @Override
                public int compare(Component firstComponent, Component secondComponent) {
                    List<Component> sentencesFirst = ((Composite)(firstComponent)).getChildNodes();
                    List<Component> sentencesSecond = ((Composite)(firstComponent)).getChildNodes();
                    return sentencesFirst.size() - sentencesSecond.size();
            }}).collect(Collectors.toList()));
           return result;
        }
        private Composite sentenceSortingProcess(Component paragraph){
            List<Component> sentences = ((Composite) paragraph).getChildNodes();
            Composite resultParagraph = new Composite();
            for (Component sentence : sentences) {
                Composite resultSentence;
                List<Component> words = ((Composite)sentence).getChildNodes();
                List<Component> sortedWords = words.stream().sorted(new Comparator<Component>() {
                    @Override
                    public int compare(Component firstComponent, Component secondComponent) {
                        String firstValue = ((Leaf) (firstComponent)).getValue();
                        String secondValue = ((Leaf) (secondComponent)).getValue();
                        return Integer.compare(firstValue.length(), secondValue.length());
                    }
                }).collect(Collectors.toList());
                resultSentence= new Composite(sortedWords);
                resultParagraph.add(resultSentence);
            }
            return resultParagraph;
        }
        public Composite sortSentenceByWordLength(Component text){
            Composite resultText = new Composite();
            List<Component> paragraphs = ((Composite) text).getChildNodes();
            for (Component paragraph : paragraphs) {
                resultText.add(sentenceSortingProcess(paragraph));
            }
            return resultText;
        }

}
