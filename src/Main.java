import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main implements ActionListener {
    File file = new File("");
    public Main() {
        JFrame frame = new JFrame("Текстовый редактор");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton buttonOpen = new JButton("Открыть");
        buttonOpen.setLocation(10, 10);
        buttonOpen.setSize(110, 50);

        JButton buttonSave = new JButton("Сохранить");
        buttonSave.setLocation(130, 10);
        buttonSave.setSize(110, 50);

        JButton buttonNew = new JButton("Новый файл");
        buttonNew.setLocation(250, 10);
        buttonNew.setSize(110, 50);

        JTextArea area = new JTextArea(100, 200);

        JPanel panel = (JPanel)frame.getContentPane();

        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setSize(760, 475);
        scroll.setLocation(10,70);
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(FileWork.readFile(frame));
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWork.writeFile(area.getText());
            }
        });
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWork.newFile();
            }
        });
        frame.add(buttonOpen);
        frame.add(buttonSave);
        frame.add(buttonNew);
        panel.add(scroll);
        frame.add(new JLabel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
