package com.rnd.aws;

import com.rnd.aws.sns.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class AwsApplication implements CommandLineRunner {

  @Autowired SnsService snsService;

  public static void main(String[] args) {
    SpringApplication.run(AwsApplication.class, args);
  }

  @Override
  public void run(String... args) {
    String ARN = snsService.createSNSTopic("TEST-TOPIC");
    snsService.listSNSTopics();
    snsService.subEmail(ARN, "test@gmail.com");
    snsService.pubTopic("TEST MESSAGE", ARN);
  }
}
