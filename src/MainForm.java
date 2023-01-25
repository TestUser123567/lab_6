import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainForm extends JFrame{

    private ArrayList<Manager> managersList;
    private ArrayList<Employee> employeesList;
    private JPanel mainPanel;
    private JButton serialization_1;
    private JButton deserialization_1;
    private JButton readFile_1;
    private JButton serialization_2;
    private JButton deserialization_2;
    private JButton readFile_2;
    private JList list1;
    private JList list2;

    public MainForm() {
        setContentPane(mainPanel);
        setTitle("My first program");
        setSize(1024, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        readFile_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    managersList = Connector.setManager();
                    list1.setListData(managersList.toArray());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        serialization_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.serialization("Manager.txt", null, managersList);
                    JOptionPane.showMessageDialog(null, "Serialization managers done success!!!");
                    list1.setListData(new String[0]);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        deserialization_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.deserialization("Manager.txt", null, managersList);
                    JOptionPane.showMessageDialog(null, "Deserialization managers done success!!!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        readFile_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(managersList == null)){
                    try {
                        employeesList = Connector.setEmployee(managersList);
                        list2.setListData(employeesList.toArray());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty managers list!!!");
                }
            }
        });
        serialization_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(managersList == null)) {
                    try {
                        Connector.serialization("Employee.txt", employeesList, null);
                        JOptionPane.showMessageDialog(null, "Serialization employee done success!!!");
                        list2.setListData(new String[0]);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty managers list!!!");
                }
            }
        });
        deserialization_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(managersList == null)) {
                    try {
                        Connector.deserialization("Employee.txt", employeesList, null);
                        JOptionPane.showMessageDialog(null, "Deserialization employee done success!!!");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty managers list!!!");
                }
            }
        });
    };
}
