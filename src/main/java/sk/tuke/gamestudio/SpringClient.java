package sk.tuke.gamestudio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;;
import org.springframework.context.annotation.FilterType;
import sk.tuke.gamestudio.level.BaseLevel;
import sk.tuke.gamestudio.level.Level1;
import sk.tuke.gamestudio.service.*;
import sk.tuke.gamestudio.ui.ConsoleUI;

@SpringBootApplication

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tuke.gamestudio.server.*"))

public class SpringClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
        //SpringApplication.run(SpringClient.class, args);
    }

    @Bean
    public CommandLineRunner runner(ConsoleUI ui) {
        return args -> ui.gameLoop();
    }

    @Bean
    public ConsoleUI consoleUI(Level1 field) {
        return new ConsoleUI(field);
    }

    @Bean
    public Level1 field() {
        return new Level1();
    }

    @Bean
    public ScoreService scoreService() {
        //return new ScoreServiceJPA();
        return new ScoreServiceRestClient();
    }

    @Bean
    public RatingService ratingService(){
        //return new RatingServiceJPA();
        return new RatingServiceRestClient();
    }

    @Bean
    public CommentService commentService(){
        //return new CommentServiceJPA();
        return new CommentServiceRestClient();
    }
}