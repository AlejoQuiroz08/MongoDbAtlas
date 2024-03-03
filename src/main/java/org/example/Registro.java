package org.example;




import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    private JButton ingresarDatosButton;
    private JTextField nombrefield;
    private JTextField pasatiempofield;
    private JTextField descripcionfield;
    public JPanel Registro;
    private JButton volverButton;


    public Registro() {
        ingresarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String connectionString = "mongodb+srv://esfot:esfot2024@cluster0.xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
                MongoClient mongoClient = MongoClients.create(connectionString);

                MongoDatabase database = mongoClient.getDatabase("RegistroPasatiempos");
                MongoCollection<Document> collection = database.getCollection("Registros");

                Document document = new Document("Nombre", nombrefield.getText())
                        .append("Pasatiempo", pasatiempofield.getText())
                        .append("Descripción", descripcionfield.getText());

                collection.insertOne(document);
                System.out.println("Documento Insertado");

                JOptionPane.showMessageDialog(null, "Se ha ingresado correctamente el registro");
                nombrefield.setText("");
                pasatiempofield.setText("");
                descripcionfield.setText("");

                // Cerrar el cliente de MongoDB
                mongoClient.close();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Frame1 = new JFrame("Menu");
                Frame1.setContentPane(new Menu().menu);
                Frame1.setSize(400,400);
                Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Frame1.setVisible(true);
                Frame1.setLocationRelativeTo(null);
                JFrame cerrar = (JFrame) SwingUtilities.getWindowAncestor(Registro);
                cerrar.dispose();
            }
        });
    }
}
