import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithoutStringGui {
    private JPanel rootPanel;
    private JLabel helloLabel;
    private JButton helloButton;
    private JTextField baseTextField;
    private JTextField removeTextField;
    private JLabel removeLabel;
    private JLabel baseLabel;

    public WithoutStringGui() {
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String baseInputText = baseTextField.getText();
                String removeInputText = removeTextField.getText();
                helloLabel.setText(WithoutString.WithoutString(baseInputText, removeInputText));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("WithoutStringGui");
        frame.setContentPane(new WithoutStringGui().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
