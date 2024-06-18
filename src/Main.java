import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static String operator = String.valueOf(' ');
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel first_number = new JLabel("Fist Number: ");
        first_number.setBounds(70,50,100,40);

        JLabel second_number = new JLabel("Second Number: ");
        second_number.setBounds(70,130,150,40);

        JLabel result_number = new JLabel("Result: ");
        result_number.setBounds(70,210,100,40);

        JTextField txtfirst_number = new JTextField();
        txtfirst_number.setBounds(190,50,230,50);

        JTextField txtsecond_number = new JTextField();
        txtsecond_number.setBounds(190,130,230,50);

        JTextField txtresult_number = new JTextField();
        txtresult_number.setBounds(190,210,230,50);
        txtresult_number.setEditable(false);

        JButton btn_add = new JButton("+");
        btn_add.setBounds(70,280,50,50);

        JButton btn_sub = new JButton("-");
        btn_sub.setBounds(120,280,50,50);

        JButton btn_mul = new JButton("*");
        btn_mul.setBounds(170,280,50,50);

        JButton btn_dev = new JButton("/");
        btn_dev.setBounds(220,280,50,50);

        JButton btn_equal = new JButton("=");
        btn_equal.setBounds(270,280,50,50);

        JButton btn_clear = new JButton("Clear");
        btn_clear.setBounds(320,280,100,50);

        frame.add(first_number);
        frame.add(second_number);
        frame.add(result_number);

        frame.add(txtfirst_number);
        frame.add(txtsecond_number);
        frame.add(txtresult_number);

        frame.add(btn_add);
        frame.add(btn_sub);
        frame.add(btn_mul);
        frame.add(btn_dev);
        frame.add(btn_equal);
        frame.add(btn_clear);

        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);

        ActionListener actionListener_clear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtfirst_number.setText("");
                txtsecond_number.setText("");
                txtresult_number.setText("");
            }
        };
        btn_clear.addActionListener(actionListener_clear);

        btn_add.addActionListener(e -> operator = "+");
        btn_sub.addActionListener(e -> operator = "-");
        btn_mul.addActionListener(e -> operator = "*");
        btn_dev.addActionListener(e -> operator = "/");

        btn_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float FirstNumber = Float.parseFloat(txtfirst_number.getText());
                float SecondNumber = Float.parseFloat(txtsecond_number.getText());
                float result = calculate(FirstNumber,SecondNumber,operator);
                txtresult_number.setText(String.valueOf(result));
            }
        });
    }
    static float calculate(float firstnumber,float secondnumber,String operator){
        switch (operator){
            case "+":
                return firstnumber + secondnumber;
            case "-":
                return firstnumber - secondnumber;
            case "*":
                return firstnumber * secondnumber;
            case "/":
                if(secondnumber==0){
                    JOptionPane.showMessageDialog(null,"Cannot divide by zero");
                }else{
                    return firstnumber / secondnumber;
                }
        }
        return 0;
    }
}