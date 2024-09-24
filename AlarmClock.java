import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmClock extends JFrame {
    private JLabel timeLabel;
    private JTextField alarmTimeField;
    private JButton setAlarmButton;
    private String alarmTime;

    public AlarmClock() {
        setTitle("Alarm Clock");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 48));
        add(timeLabel);

        alarmTimeField = new JTextField(5);
        add(alarmTimeField);

        setAlarmButton = new JButton("Set Alarm");
        setAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alarmTime = alarmTimeField.getText();
            }
        });
        add(setAlarmButton);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                timeLabel.setText(currentTime);
                if (currentTime.equals(alarmTime)) {
                    JOptionPane.showMessageDialog(null, "Alarm! Time to wake up!");
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AlarmClock().setVisible(true);
            }
        });
    }
}
