package ch;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class fuli  extends JFrame
{
private JLabel a1;
private JLabel a2;
private JLabel a3;
private JLabel a4;
private JTextField b1;
private JTextField b2;
private JTextField b3;
private JTextField b4;
private JButton c1;
private JButton c2;
private JButton c3;
private JTextArea text;
private JPanel leftpanel = new JPanel();
private AbstractButton leftpanelr= new JRadioButtonMenuItem("每年添加一定的本金");

public double[] a = new double[100];
public double[] b = new double[100];
int input = 0;
public fuli()
{
creatComponents()    ;
layoutComponents();
registerHandlers();
setTitle("复利存款计算器");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pack();
}

 

private void  creatComponents()    
{
a1=new JLabel("本  金 ");
a1.setFont(new Font("宋体",Font.BOLD,18));
a2=new JLabel("年利率 ");
a2.setFont(new Font("宋体",Font.BOLD,18));
a3=new JLabel("年  数 ");
a3.setFont(new Font("宋体",Font.BOLD,18));
a4=new JLabel("期望值 ");
a4.setFont(new Font("宋体",Font.BOLD,18));
b1=new JTextField(10);
b2=new JTextField(10);
b3=new JTextField(10);
b4=new JTextField(10);
c1=new JButton("计算");
c1.setFont(new Font("宋体",Font.BOLD,15));
c2=new JButton("清除");
c2.setFont(new Font("宋体",Font.BOLD,15));
c3=new JButton("投资记录");
c3.setFont(new Font("宋体",Font.BOLD,15));


text=new JTextArea();
}
private void layoutComponents()
{ 
setLayout(new FlowLayout());
JPanel panel1=new JPanel();
panel1.add(a1);
panel1.add(b1);
JPanel panel2=new JPanel();
panel2.add(a2);
panel2.add(b2);
JPanel panel3=new JPanel();
panel3.add(a3);
panel3.add(b3);
JPanel panel6=new JPanel();
panel6.add(a4);
panel6.add(b4);
JPanel panel4=new JPanel();
panel4.add(c1);
panel4.add(c2);
panel4.add(c3);

JPanel  leftpanel=new JPanel(new GridLayout(5,2));
leftpanel.add(panel1);
leftpanel.add(panel2);
leftpanel.add(panel3);
leftpanel.add(panel6);
leftpanel.add(panel4);
JScrollPane panel5=new JScrollPane(text);
panel5.setPreferredSize(new Dimension(300,200));
add(leftpanel);
add(panel5);
}

private void registerHandlers() {
    c1ActionEventHander hander1 = new c1ActionEventHander();
    c1.addActionListener(hander1);
    c2ActionEventHander hander2 = new c2ActionEventHander();
    c2.addActionListener(hander2);
    c3ActionEventHander hander4 = new c3ActionEventHander();
    c3.addActionListener(hander4);
}


private class c1ActionEventHander implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        double principal = 0;
        double amount = 0;
        double rate = 0;
        int n = 0;
        NumberFormat currencyformatter = NumberFormat.getCurrencyInstance(); // 字符串转化为数字
        String output = "年" + "/" + "复利存款";
        int year = 1;
        int result;

        if (b1.getText().equals("") && b2.getText() != null
                && b3.getText() != null && b4.getText() != null) { // 计算本金

            try {
                rate = Double.parseDouble(b2.getText());
                n = Integer.parseInt(b3.getText());
                amount = Double.parseDouble(b4.getText());
            
            principal = 0;
            while (year <= n) {
                principal = amount / (Math.pow(1 + rate, year));
                year = year + 1;
            }

            output = "本金" + currencyformatter.format(principal) + "\n";
            text.setText(output);
            }
            catch (Exception e2) {
                // TODO: handle exception
            }
        }

        else if (b2.getText().equals("") && b1.getText() != null
                && b3.getText() != null && b4.getText() != null) // 求利率
        {
            try {
                principal = Double.parseDouble(b1.getText()); // b1本金
                n = Integer.parseInt(b3.getText()); // b3年份
                amount = Double.parseDouble(b4.getText()); // b4期望值
            } catch (Exception e2) {
                // TODO: handle exception
            }
            rate = java.lang.StrictMath.pow(amount / principal, 1.0 / n) - 1;
            output = "利率" + rate + "\n";
            text.setText(output);
        }

        else if (b3.getText().equals("") && b1.getText() != null
                && b2.getText() != null && b4.getText() != null) // 求年份
        {
            try {
                principal = Double.parseDouble(b1.getText()); // b1本金
                amount = Double.parseDouble(b4.getText()); // b4期望值
                rate = Double.parseDouble(b2.getText());
            } catch (Exception e2) {
                // TODO: handle exception
            }

            double year2 = Math.log(amount / principal) / Math.log(1 + rate);
            output = "至少年数" + year2 + "\n";
            text.setText(output);
        }

        else if (b4.getText().equals("") && b1.getText() != null
                && b3.getText() != null && b2.getText() != null) // 求期望值
        {
            try {
                rate = Double.parseDouble(b2.getText());
                n = Integer.parseInt(b3.getText());
                principal = Double.parseDouble(b1.getText()); // b1本金
            } catch (Exception e2) {
                // TODO: handle exception
            }

            double tempprincipal = principal;
            result = JOptionPane.showConfirmDialog(null, "是否每年进行投资？");
            if (result == JOptionPane.YES_OPTION) {
                amount=CalculateA(year,n,principal,rate,tempprincipal);
                System.out.println("CalculateA(year,n,principal,rate,tempprincipal)"+year+n+principal+rate+tempprincipal);
                output += String.valueOf(year) + "\t\t\t"
                        + currencyformatter.format(amount) + "\n";
            } else {
                while (year <= n) {
                    amount = principal * Math.pow(1 + rate, year);
                    output += String.valueOf(year) + "\t\t\t"
                            + currencyformatter.format(amount) + "\n";
                    year = year + 1;
                }
            }

            text.setText(output);
            int Isinfo = JOptionPane.showConfirmDialog(null, "是否投资？");
            if (Isinfo == JOptionPane.YES_OPTION) {
                a[input] = principal;

                b[input] = amount;
                input += 1;
            }
        } else if (b1.getText() != null && b4.getText() != null
                && b3.getText() != null && b2.getText() != null) {
            JOptionPane.showMessageDialog(null, "请删除一个数据");
        } else {
            JOptionPane.showMessageDialog(null, "请增加数据");
        }
    }
    
    
    public double CalculateA(int years2,int n2,double principal2,double rate2,double tempprincipal2){
        double amount2 = 0;
        while (years2 <= n2) {
            amount2 = principal2 * Math.pow(1 + rate2, years2)
                    + tempprincipal2;
            
            years2 = years2 + 1;
        }
        return amount2;
    }
    }

public double CalculateA1(int years2,int n2,double principal2,double rate2,double tempprincipal2){
    double amount2 = 0;
    while (years2 <= n2) {
        amount2 = principal2 * Math.pow(1 + rate2, years2)
                + tempprincipal2;
        years2 = years2 + 1;
    }
    return amount2;
}

private double CalculateA(int year, int n, double principal, double rate,
        double tempprincipal) {
    // TODO 自动生成的方法存根
    return 0;
}

private class c2ActionEventHander implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        text.setText("");
    }
}

public static void main(String[] args)
{
    fuli frame=new fuli();
    frame.setVisible(true);
     int Windowswidth = 500;
     int Windowsheight = 400;
     int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     int height = Toolkit.getDefaultToolkit().getScreenSize().height;
  frame.setResizable(false);
  frame.setLocation((width - Windowswidth) / 2,
          (height - Windowsheight) / 2); // 窗口居中
}
private class c3ActionEventHander implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String output = "交易记录：存入的本金/获得的收益";
        int i = 0;
        while (a[i] != 0) {
            output = output + "\t\t" + a[i] + "/" + b[i] + "\n";
            i += 1;
        }
        text.setText(output);
    }
}
}