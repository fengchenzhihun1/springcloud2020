package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Classname ConsumController
 * @Description TODO
 * @Date 2020/3/9 23:42
 * @Created by  wrsChen
 */
@Component
@EnableBinding(Sink.class)
public class ConsumController {
  @Value("${server.port}")
  private String serport;
  @StreamListener(Sink.INPUT)
  public void input(Message<String>message){
      System.out.println("接受到的消息"+message.getPayload() +"\t port" + serport );
  }
}
