import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClientGUI extends JFrame {

    private static final int WIDTH = 555; // задаем ширину окна
    private static final int HEIGHT = 507; // задаем высоту окна
    private static final String THE_FILE = "D:\\GeekBrains\\Java Development Kit\\text.txt";
    JTextField TFipAddress = new JTextField("127.0.0.1");

    JTextField TFPort = new JTextField(("5050"));
    JTextField TFLogin = new JTextField("login");
    JPasswordField TFPassword = new JPasswordField();
    JTextField TFMessage = new JTextField();
    JTextArea TAMessageArea = new JTextArea();

    JButton btnLogin, btnSend, btnEmpty;

    ClientGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаем операцию, которая произойдет, когда пользователь нажмет на X(крестик).
        setSize(WIDTH, HEIGHT); //Задаем размер окна
        setLocationRelativeTo(null); //центруем окно
        setTitle("Chat client");
        setResizable(true); //включаем возможность изменять размер окна
        setVisible(true); //делаем наше окно видимым

        btnLogin = new JButton("login");
        btnSend = new JButton("send");
        btnEmpty = new JButton();

        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();

        btnLogin.addActionListener(new ActionListener() {
            File file = new File(THE_FILE);
            String inner = "";

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader fr = new BufferedReader(new FileReader(file)); //чтение файла

                    int c;

                    while((c = fr.read()) != -1) {
                        inner += (char)c;
                    }
                    fr.close();
                } catch (IOException exc) {
                    exc.getMessage();
                }
                TAMessageArea.append(inner); //установка текста

//                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { //true нужно для того, чтобы файл дозаписывался
//                    writer.write(date + ": User "+TFLogin.getText()+ " connected to chat");
//                    writer.write("\n");
//                    writer.close();
//                }
//                catch (IOException er) {
//                    er.printStackTrace();
//                }
//
            }
        });

        btnSend.addActionListener(new ActionListener() {
            File file = new File(THE_FILE);
            String inner = "";

            @Override
            public void actionPerformed(ActionEvent e) {
                TAMessageArea.append("\n");
                TAMessageArea.append(TFLogin.getText() + " : " + TFMessage.getText());

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { //true нужно для того, чтобы файл дозаписывался
                    writer.write(date + ": User "+TFLogin.getText()+ " send: " + TFMessage.getText());
                    writer.write("\n");
                    writer.close();
                }
                catch (IOException er) {
                    er.printStackTrace();
                }

            }
        });



        JPanel panTop1 = new JPanel(new GridLayout(2, 3));

        JPanel panBottom1 = new JPanel(new BorderLayout());

        btnEmpty.setEnabled(false);
        panTop1.add(TFipAddress);
        panTop1.add(TFPort);
        panTop1.add(btnEmpty);
        panTop1.add(TFLogin);
        panTop1.add(TFPassword);
        panTop1.add(btnLogin);
        add(panTop1, BorderLayout.NORTH);

        TAMessageArea.setEnabled(false);
        TAMessageArea.setLineWrap(true);
        TAMessageArea.setWrapStyleWord(true);
        TAMessageArea.setSelectedTextColor(Color.BLACK);
        setFont(new Font("Dialog", Font.PLAIN, 14));
        add(TAMessageArea,BorderLayout.CENTER);

        panBottom1.add(TFMessage);
        panBottom1.add(btnSend, BorderLayout.EAST);
        add(panBottom1, BorderLayout.SOUTH);
        
        setVisible(true);

    }
}
