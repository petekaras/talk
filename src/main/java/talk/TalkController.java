package talk;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import talk.response.Sentiment;

@RestController
public class TalkController {

    private final String MASHAPE_KEY = "xxxx";

    @RequestMapping(value="/talk", method= RequestMethod.POST)
    public Sentiment talk(@RequestParam(value="text", defaultValue="great") String text) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.set("X-Mashape-Key",MASHAPE_KEY);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("txt", text);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Sentiment> response = restTemplate.postForEntity("https://community-sentiment.p.mashape.com/text/",request, Sentiment.class);
        return response.getBody();
    }

}