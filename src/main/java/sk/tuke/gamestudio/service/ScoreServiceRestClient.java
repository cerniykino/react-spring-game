package sk.tuke.gamestudio.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Score;

import java.util.Arrays;
import java.util.List;
@Service
public class ScoreServiceRestClient implements ScoreService {

    private final String url = "http://localhost:8080/api/score";


    @Autowired
    private RestTemplate restTemplate; //= new RestTemplate();

//    @PostConstruct
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
    @Override
    public void addScore(Score score) {
        restTemplate.postForEntity(url, score, Score.class);
    }

    @Override
    public Score getScore(String player, String game) throws ScoreException {
        return null;
    }

    @Override
    public List<Score> getTopScores(String gameName) {
        return Arrays.asList(restTemplate.getForEntity(url + "/" + gameName, Score[].class).getBody());
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web service");
    }
}