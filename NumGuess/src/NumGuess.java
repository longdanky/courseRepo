import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;

public class NumGuess {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new GameProcessTableFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}
class GameProcessTableFrame extends JFrame
{
    public GameProcessTableFrame()
    {
        setLayout(new GridBagLayout());
        setTitle("Game");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        lable = new JLabel("请输入四位数字：");
        textField = new JTextField();
        textField.setEnabled(false);

        confirmButton = new JButton("确  定");
        confirmButton.setEnabled(false);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(!inputCheck())
                     return;
                 confirmButton.setEnabled(false);
                 model.changeModel(new GameData(textField.getText(),gameLogical.getResult(textField.getText())));
                 textField.setText("");
                if(!gameover)
                    confirmButton.setEnabled(true);
            }
        });

        startButton = new JButton("开  始");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clearData();
                gameover=false;
                startButton.setEnabled(false);
                confirmButton.setEnabled(true);
                textField.setEnabled(true);
                gameLogical = new GameLogical(GameProcessTableFrame.this);
            }
        });
        model = new GameProcessTableModel();
        JTable table = new JTable(model);
        table.setRowHeight(35);
        table.setShowGrid(false);

        add(lable,new GBC(0,0,1,1).setFill(GBC.HORIZONTAL));
        add(textField,new GBC(1,0,1,1).setFill(GBC.HORIZONTAL));
        add(confirmButton, new GBC(1, 1, 1, 1));
        add(startButton, new GBC(0, 1, 1, 1));
        add(new JScrollPane(table),new GBC(0,2,2,6).setFill(GBC.BOTH).setWeight(100, 100));
    }

    private boolean inputCheck()
    {
         Matcher matcher = pattern.matcher(textField.getText());
        if(!matcher.matches())
        {
            JOptionPane.showMessageDialog(null,"必须输入4位数字！",null,JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return  true;
    }
    public void success()
    {
        JOptionPane.showMessageDialog(null,"成功！",null,JOptionPane.INFORMATION_MESSAGE);
        startButton.setEnabled(true);
        confirmButton.setEnabled(false);
        textField.setEnabled(false);
        gameover=true;
    }
    public void fail(String str)
    {
        JOptionPane.showMessageDialog(null,"失败！正确的结果是"+str,null,JOptionPane.INFORMATION_MESSAGE);
        startButton.setEnabled(true);
        confirmButton.setEnabled(false);
        textField.setEnabled(false);
        gameover=true;
    }
    private Pattern pattern = Pattern.compile("\\d{4}");
    private GameLogical gameLogical;
    private GameProcessTableModel model;
    private JLabel lable;
    private JTextField textField;
    private boolean gameover=false;
    private JButton startButton,confirmButton;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 315;
}

