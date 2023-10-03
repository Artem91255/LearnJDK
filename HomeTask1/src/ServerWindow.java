import javax.swing.*; //импортируем фреймворк swing для возможности работы с окнами
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ServerWindow extends JFrame{ //создаем класс и наследуем его от JFrame для того, что бы можно было выводить в окно содержимое класса

    private static final int WIDTH = 555; // задаем ширину окна
    private static final int HEIGHT = 507; // задаем высоту окна
    private static final String THE_FILE = "D:\\GeekBrains\\Java Development Kit\\text.txt";
    JTextArea textArea = new JTextArea();



    JButton btnStart, btnStop;
    boolean isStart = false;
    boolean isStop = true;

    ServerWindow(){
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаем операцию, которая произойдет, когда пользователь нажмет на X(крестик).
       setSize(WIDTH, HEIGHT); //Задаем размер окна
       setLocationRelativeTo(null); //центруем окно
        setTitle("Chat client");
        setResizable(true); //включаем возможность изменять размер окна
        //setVisible(true); //делаем наше окно видимым

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(THE_FILE);
                String inner = "";
                if (isStart == false)
                {
                    textArea.append("Start server");
                    textArea.append("\n");
                    //System.out.println("Start server");
                    isStop = false;
                    isStart = true;

                }
                else{
                    textArea.append("Server already running");
                    textArea.append("\n");
                    //System.out.println("Server already running");
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStop == false){
                    textArea.append("Stop the server");
                    textArea.append("\n");
                    //System.out.println("Stop the server");
                    isStop = true;
                    isStart = false;
                }
                else{
                    textArea.append("Server is already stop");
                    textArea.append("\n");
                    //System.out.println("Server is already stop");
                }
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);

        add(panBottom, BorderLayout.SOUTH);
        add(textArea);
        textArea.setPreferredSize(new Dimension(200, 20));
        textArea.setEnabled(false);
        textArea.setLineWrap(true);
        textArea.setSelectedTextColor(Color.BLACK);
        setFont(new Font("Dialog", Font.PLAIN, 14));
        setVisible(true);
    }

}
