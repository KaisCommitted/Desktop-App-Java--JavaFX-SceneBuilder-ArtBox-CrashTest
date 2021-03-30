package SentimentAnalysis;
import java.util.List;

public class Document{
    public String id;
    public String sentiment;
    public ConfidenceScores confidenceScores;
    public List<Sentence> sentences;
    public List<Object> warnings;
}