
package SentimentAnalysis;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;



public class SentimentAPI{

    private static HttpURLConnection con;

    public static String GetSentiment(String text) throws IOException {

        String url = "https://adamr.cognitiveservices.azure.com/text/analytics/v3.1-preview.3/sentiment?opinionMining=true/";
        String urlParameters = "{ documents: [{ id: \"1\", text: \"" + text + "\"}]}";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Ocp-Apim-Subscription-Key", "c0bfc3ef5e114befbfcba3c123b86819");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {

                wr.write(postData);
            }

            StringBuilder content;

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();

            Root response = objectMapper.readValue(content.toString(), Root.class);
            System.out.println(response.documents.get(0).sentiment);
            return response.documents.get(0).sentiment;
            

            //System.out.println(content.toString());
            

        } finally {

            con.disconnect();
        }
    }
}
