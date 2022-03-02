package Week8to11;

import javax.swing.*;
import java.awt.*;

class Select {
    Select() {
        JFrame f = new JFrame("SELECT ONE");
        JButton addroute, showroute, addConnection, showConnection;
        JLabel titleLabel;

        titleLabel = new JLabel("CHOOSE ONE");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        f.add(titleLabel);
        titleLabel.setBounds(150, 30, 3000, 100);

        addroute = new JButton("Add route");
        f.add(addroute);
        addroute.setBounds(0, 150, 200, 100);


        showroute = new JButton("View route");
        f.add(showroute);
        showroute.setBounds(210, 150, 200, 100);

        addConnection = new JButton("Add Connection");
        f.add(addConnection);
        addConnection.setBounds(0, 350, 200, 100);

        showConnection = new JButton("Show Connection");
        f.add(showConnection);
        showConnection.setBounds(210, 350, 200, 100);

        addroute.addActionListener(e -> {
            f.dispose();
            new AddrouteFrame();
        });

        showroute.addActionListener(e -> {
            f.dispose();
            new Viewroute();
        });

        addConnection.addActionListener(e -> {
            f.dispose();
            new AddConnectionFrame();
        });

        showConnection.addActionListener(e -> {
            f.dispose();
            new ViewConnection();
        });


        f.setLayout(null);
        f.setBounds(300, 50, 600, 450);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);


        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(100, 50, 600, 600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}