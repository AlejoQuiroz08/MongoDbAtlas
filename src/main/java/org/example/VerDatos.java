package org.example;




import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerDatos {
    private JButton Buscardatos;
    private JTextField nombrefield;
    private JTextField pasatiempofield;
    private JTextField descripcionfield;
    public JPanel VerDatos;
    private JButton volverButton;


    public VerDatos() {
        Buscardatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String connectionString = "mongodb+srv://esfot:esfot2024@cluster0.xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
                MongoClient mongoClient = MongoClients.create(connectionString);

                MongoDatabase database = mongoClient.getDatabase("RegistroPasatiempos");
                MongoCollection<Document> collection = database.getCollection("Registros");

                String nombreABuscar = nombrefield.getText();

                Document query = new Document("Nombre", nombreABuscar);
                MongoCursor<Document> cursor = collection.find(query).iterator();

                if (cursor.hasNext()) {
                    Document doc = cursor.next();
                    nombrefield.setText(doc.getString("Nombre"));
                    pasatiempofield.setText(doc.getString("Pasatiempo"));
                    descripcionfield.setText(doc.getString("Descripción"));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados para el nombre proporcionado.");
                }

                // Cerrar el cursor y el cliente de MongoDB
                cursor.close();
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
                JFrame cerrar = (JFrame) SwingUtilities.getWindowAncestor(VerDatos);
                cerrar.dispose();
            }
        });
    }
}
