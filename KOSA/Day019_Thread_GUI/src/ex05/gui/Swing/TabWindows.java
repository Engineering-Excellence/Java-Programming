package ex05.gui.Swing;

import java.awt.Color;

import javax.swing.*;
import javax.swing.event.*;

public class TabWindows extends JFrame implements ChangeListener {
	JTabbedPane pane;
	JLabel  lbl;
	
	public TabWindows(String str){
		super(str);
		JPanel  one, two, three;
		pane = new JTabbedPane();
		lbl = new JLabel("              ");
		
		one = new JPanel();
		one.add(new JLabel("ù��° ���Դϴ�"));
		one.add(new JTextField("���ڸ� �Է��ϼ���"));
		one.setBackground(Color.pink);
		pane.addTab("One", one);
		
		two = new JPanel();
		two.add(new JLabel("�ι�° ���Դϴ�"));
		two.add(new JTextField("���ڸ� �Է��ϼ���"));
		two.setBackground(Color.yellow);
		pane.addTab("Two", two);
		
		three = new JPanel();
		three.add(new JLabel("����° ���Դϴ�"));
		three.add(new JTextField("���ڸ� �Է��ϼ���"));
		three.setBackground(Color.cyan);
		pane.addTab("Three", three);
		
		pane.setSelectedIndex(0);
		pane.addChangeListener(this);
		this.getContentPane().add("North", new JLabel("���� ����� ��"));
		this.getContentPane().add("Center", pane);
		this.getContentPane().add("South", lbl);
		
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end

	@Override
	public void stateChanged(ChangeEvent e) {
		int index = pane.getSelectedIndex();//�������� ��ȣ�� �����´�
		String msg = pane.getTitleAt(index); //index ���� �� ���ڿ��� ������
		msg += "���� ���õǾ����ϴ�";
		lbl.setText(msg);
		pane.setSelectedIndex(index); //���� ������ ������ ȭ�� ��� ����
	}
	
	
	public static void main(String[] args) {
		new TabWindows("�� ����");
	}
}
