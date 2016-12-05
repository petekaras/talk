package talk.response;

/**
 * Created by peter on 12/5/16.
 */
public class Result {
    private float confidence;
    private String sentiment;


    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }



    @Override
    public String toString() {
        return "Result{" +
                "confidence='" + confidence + '\'' +
                ", sentiment='" + sentiment + '\'' +
                '}';
    }
}
