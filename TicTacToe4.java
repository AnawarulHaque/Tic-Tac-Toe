package TicTacToe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe4 {
	JFrame fr=new JFrame("Tic Tac Toe");
	JLabel img=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
	JPanel [] pa=new JPanel[3];
	JLabel msg=new JLabel("First player turn...");
	JButton reset=new JButton("RESET");
	JButton [] bt=new JButton[9];
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int user=1,count=0;
	boolean winnerFound=false;
	public TicTacToe4()
	{
		fr.setSize(500,600);
		fr.setDefaultCloseOperation(3);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.add(img);
		addPanels();
		fr.setVisible(true);
	}
	private void addPanels()
	{
		img.setLayout(null);
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			img.add(pa[i]);
		}
		pa[0].setBounds(50,20,400,40);
		pa[1].setBounds(50,90,400,370);
		pa[2].setBounds(50,490,400,40);
		addInfo();
	}
	private void addInfo()
	{
		pa[0].add(msg);
		msg.setFont(new Font("elephant",0,25));
		msg.setForeground(Color.blue);
		pa[0].setBackground(Color.cyan);
		pa[2].add(reset);
		reset.setFont(new Font("arial",0,20));
		pa[2].setOpaque(false);
		addButtons();
		reset.addActionListener(new ResetListener());
		reset.setEnabled(false);
	}
	private void addButtons()
	{
		pa[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.yellow);
			pa[1].add(bt[i]);
		}
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(user==1)
			{
				bb.setIcon(icon1);
				msg.setText("Second player turn...");
				pa[0].setBackground(Color.blue);
				msg.setForeground(Color.white);
				user=2;
			}
			else if(user==2)
			{
				bb.setIcon(icon2);
				msg.setText("First player turn...");
				pa[0].setBackground(Color.cyan);
				msg.setForeground(Color.blue);
				user=1;
			}
			bb.setEnabled(false);
			findWinner();
			count++;
			if(count==9 && !winnerFound)
			{
				reset.setEnabled(true);
				msg.setText("Match draw");
				msg.setForeground(Color.red);
				JOptionPane.showMessageDialog(fr,"No one is winner");
			}
		}
		private void findWinner()
		{
			//For first player
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
				announceWinner(0,1,2);
			if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
				announceWinner(3,4,5);
			if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(6,7,8);
			if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(0,3,6);
			if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
				announceWinner(1,4,7);
			if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(2,5,8);
			if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(0,4,8);
			if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(2,4,6);
			//For second player
			if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
				announceWinner(0,1,2);
			if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
				announceWinner(3,4,5);
			if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(6,7,8);
			if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(0,3,6);
			if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
				announceWinner(1,4,7);
			if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(2,5,8);
			if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(0,4,8);
			if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(2,4,6);
		}
		private void announceWinner(int i,int j,int k)
		{
			reset.setEnabled(true);
			winnerFound=true;
			bt[i].setBackground(Color.green);
			bt[j].setBackground(Color.green);
			bt[k].setBackground(Color.green);
			msg.setText("Game over");
			msg.setForeground(Color.red);
			for(int c=0;c<9;c++)
				bt[c].setEnabled(false);
			if(user==2)
				JOptionPane.showMessageDialog(fr,"First player is winner");
			else
				JOptionPane.showMessageDialog(fr,"Second player is winner");
		}
	}
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			reset.setEnabled(false);
			msg.setText("First player turn...");
			msg.setForeground(Color.blue);
			pa[0].setBackground(Color.cyan);
			for(int c=0;c<9;c++)
			{
				bt[c].setBackground(Color.yellow);
				bt[c].setIcon(null);
				bt[c].setEnabled(true);
			}
			user=1;
			winnerFound=false;
			count=0;
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe4();
	}
}
