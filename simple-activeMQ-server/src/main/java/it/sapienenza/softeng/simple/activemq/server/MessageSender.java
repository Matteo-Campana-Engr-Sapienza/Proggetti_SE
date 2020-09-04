package it.sapienenza.softeng.simple.activemq.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

    //URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // default broker URL is : tcp://localhost:61616"
    private static String subject = "MY_QUEUE"; // Queue Name.You can create any/many queue names as per your requirement. 

    public static void main(String[] args) {
        // Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection;
        try {
            connection = (Connection) connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
            //The queue will be created automatically on the server.
            Destination destination = session.createQueue(subject);

            // MessageProducer is used for sending messages to the queue.
            MessageProducer producer = session.createProducer(destination);

            // We will send a small text message saying 'Hello World!!!' 
            TextMessage message = session.createTextMessage("Hello !!! Welcome to the world of ActiveMQ.");

            // Here we are sending our message!
            producer.send(message);

            System.out.println("MY_QUEUE printing@@ '" + message.getText() + "'");
            connection.close();

        } catch (JMSException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
        }

    }
}
