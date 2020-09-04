package it.sapienza.softeng.jms.activemq.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String destination_queue = "my_queue";

    public static void main(String[] args) {

        Session session = null;
        Connection connection = null;

        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(destination_queue);

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            
            
            int count = 0;
            String text = null;

            while (true) {
                // Create a messages
                text = "Hello world number : " + count;
                count++;
                TextMessage message = session.createTextMessage(text);

                // Tell the producer to send the message
                System.out.println("\n\n[Producer] Sent message: " + message);
                producer.send(message);
                Thread.sleep(3000);
            }

            // Clean up
            /*
            session.close();
            connection.close();
            */
        } catch (JMSException ex) {
            try {
                //Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                // Clean up
                session.close();
                connection.close();
            } catch (JMSException ex1) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
