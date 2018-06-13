/*
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

*/
/**
 * Created by admin on 2018-05-29.
 *//*

public class Test{
    public static void main(String arg[]){
        DefaultMQProducer producer = new DefaultMQProducer("Producer");

        producer.setNamesrvAddr("127.0.0.1:9876");
        try {

            producer.start();

            for(int i = 0 ; i < 120 ; i++){
                Message msg = new Message("TopicTest" */
/* Topic *//*
,
                        "TagA" */
/* Tag *//*
,
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) */
/* Message body *//*

                );
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            }


        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }

}
*/
