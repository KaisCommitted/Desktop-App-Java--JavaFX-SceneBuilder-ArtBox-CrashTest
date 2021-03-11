/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtHub.RestAPI;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.ai.textanalytics.models.*;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.TextAnalyticsClient;

/**
 *
 * @author Kais
 */
public class SentimentAnalysis {

    private static String KEY = "b03caeec01f042f3bf1be7db300c0cd5";
    private static String ENDPOINT = "https://yassine-ta.cognitiveservices.azure.com/";

    public void getSent(String text) {
        TextAnalyticsClient client = authenticateClient(KEY, ENDPOINT);

        sentimentAnalysisExample(client, text);
    }

    static TextAnalyticsClient authenticateClient(String key, String endpoint) {
        return new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();
    }

    static void sentimentAnalysisExample(TextAnalyticsClient client, String text) {
        // The text that need be analyzed.
        
        DocumentSentiment documentSentiment = client.analyzeSentiment(text);
        /*System.out.printf(
                "Recognized document sentiment: %s, positive score: %s, neutral score: %s, negative score: %s.%n",
                documentSentiment.getSentiment(),
                documentSentiment.getConfidenceScores().getPositive(),
                documentSentiment.getConfidenceScores().getNeutral(),
                documentSentiment.getConfidenceScores().getNegative());

        for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
            System.out.printf(
                    "Recognized sentence sentiment: %s, positive score: %s, neutral score: %s, negative score: %s.%n",
                    sentenceSentiment.getSentiment(),
                    sentenceSentiment.getConfidenceScores().getPositive(),
                    sentenceSentiment.getConfidenceScores().getNeutral(),
                    sentenceSentiment.getConfidenceScores().getNegative());
        }*/
    }
}

