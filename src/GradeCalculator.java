import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Grade Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel labelM1 = new JLabel("Milestone 1 (Max 25):");
        labelM1.setBounds(10, 20, 160, 25);
        panel.add(labelM1);

        JTextField textM1 = new JTextField(20);
        textM1.setBounds(180, 20, 50, 25);
        panel.add(textM1);

        JLabel labelM2 = new JLabel("Milestone 2 (Max 40):");
        labelM2.setBounds(10, 50, 160, 25);
        panel.add(labelM2);

        JTextField textM2 = new JTextField(20);
        textM2.setBounds(180, 50, 50, 25);
        panel.add(textM2);

        JLabel labelTA = new JLabel("Terminal Assessment (Max 35):");
        labelTA.setBounds(10, 80, 180, 25);
        panel.add(labelTA);

        JTextField textTA = new JTextField(20);
        textTA.setBounds(180, 80, 50, 25);
        panel.add(textTA);

        JButton calculateButton = new JButton("Calculate Grade");
        calculateButton.setBounds(70, 120, 150, 25);
        panel.add(calculateButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 150, 250, 25);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double m1 = Double.parseDouble(textM1.getText());
                    double m2 = Double.parseDouble(textM2.getText());
                    double ta = Double.parseDouble(textTA.getText());

                    if (m1 < 0 || m1 > 25 || m2 < 0 || m2 > 40 || ta < 0 || ta > 35) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid grades within the allowed range.");
                    } else {
                        double totalGrade = m1 + m2 + ta;
                        resultLabel.setText("Total Grade: " + totalGrade);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
                }
            }
        });
    }
}
