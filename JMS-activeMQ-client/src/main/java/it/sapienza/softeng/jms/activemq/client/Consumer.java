package it.sapienza.softeng.jms.activemq.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer implements Runnable {

    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String subject = "my_queue";

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Consumer());
            t.start();
        }
    }

    @Override
    public void run() {
        Session session = null;
        Connection connection = null;
        Message message = null;

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(subject);
            MessageConsumer consumer = session.createConsumer(destination);
             
            System.out.println("Consumer [" + Thread.currentThread().getName() + "] started...");

            while (true) {
                message = consumer.receive();
                TextMessage textMessage = (TextMessage) message;
                System.out.println("[" + Thread.currentThread().getName() + "]Received message : " + textMessage.getText());
                System.out.flush();
                Thread.sleep(1000);
            }

        } catch (JMSException ex) {
            try {
                // Clean up
                session.close();
                connection.close();
            } catch (JMSException ex1) {
                ex.printStackTrace();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
