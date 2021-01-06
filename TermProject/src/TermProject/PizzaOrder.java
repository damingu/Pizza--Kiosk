package TermProject; //���� ȯ�濡 �´� package �ֱ� 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PizzaOrder {
 
	private static JFrame f = new JFrame();
	static int Lcount = 0;
	static int Mcount = 0;
	static int count = 0;
	static String show = "";
	static int TotalPrice = 0;
	
    public PizzaOrder() {
     // ������ ����
        f.setTitle("���� �ֹ� ���α׷�");                             
        f.setSize(615,1020);
        
        // ������ ���̾ƿ� ����
        f.setLayout(null);
        
        // ��ư ����
        JButton premium_pizza= new JButton("�����̾� ����");        
        JButton classic_pizza = new JButton("Ŭ���� ����");        
        JButton side_menu = new JButton("���̵� �޴�");
        JButton reset = new JButton("�ֹ� �ʱ�ȭ");
        f.add(premium_pizza);
        f.add(classic_pizza);
        f.add(side_menu);
        f.add(reset);
        
        // �޴��� �����ִ� â        
        TextArea menuArea = new TextArea("���Ͻô� �޴��� ������ �ּ���.",0,0,TextArea.SCROLLBARS_NONE);        
        f.add(menuArea);
        
        //���� �Ļ� or ����       
        CheckboxGroup chkGroup = new CheckboxGroup(); 
        Checkbox here = new Checkbox("���忡�� �Ļ�", chkGroup, false) ;
        Checkbox takeOut = new Checkbox("Take out", chkGroup, false) ;
        f.add(here) ;
        f.add(takeOut) ;
        
        //���� ���� ������ �޶����� ������  
        Label lbl = new Label("���� ����") ;
            
        CheckboxGroup chkGroup2 = new CheckboxGroup(); //���� ���� 
        Checkbox cupon1 = new Checkbox("10%", chkGroup2, false);       
        Checkbox cupon2 = new Checkbox("20%", chkGroup2, false);     
        Checkbox cupon3 = new Checkbox("30%", chkGroup2, false);
        f.add(lbl);
        f.add(cupon1);
        f.add(cupon2);
        f.add(cupon3); 
        
        //���� �ֹ�����
        Label ordermenu = new Label("       ��ǰ��                                                 �ܰ�                      ����                      �հ�");
        TextArea totalOrder1 = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
        JButton totalPrice = new JButton("��ü �ݾ�");
        TextArea totalOrder2 = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
        JButton order = new JButton("����"); 
        f.add(ordermenu);
        f.add(totalOrder1);
        f.add(totalPrice);
        f.add(totalOrder2);
        f.add(order); 
        
        //������Ʈ ��ġ, ũ�� ����
        premium_pizza.setBounds(50, 30, 120, 30);
        classic_pizza.setBounds(220, 30, 120, 30);
        side_menu.setBounds(390, 30, 120, 30);
        menuArea.setBounds(50, 80, 460, 460);       
        here.setBounds(280, 550, 100, 30);
        takeOut.setBounds(420, 550, 100, 30);
        lbl.setBounds(180, 580, 80, 50);
        cupon1.setBounds(290, 580, 50, 50);
        cupon2.setBounds(360, 580, 50, 50);
        cupon3.setBounds(430, 580, 50, 50);
        ordermenu.setBounds(50, 640, 440, 20);
        totalOrder1.setBounds(50, 660, 475, 200);
        totalPrice.setBounds(140, 870, 100, 30);
        totalOrder2.setBounds(250, 875, 100, 20);
        order.setBounds(415, 930, 120, 30);
        reset.setBounds(230, 930, 120, 30);
        
        f.setVisible(true);
        
        // �����̾� ���� ī�װ� ���� ��ư
        premium_pizza.addActionListener(new ActionListener() {       	
        	@Override
        	public void actionPerformed(ActionEvent e) {        		
        		f.remove(menuArea);
        		
        		String menu[] = { "30 ġ��&���� ��Ʈ�� ������ũ", "����ũ����Ʈ �̺�����", "����� ������", "��Ʈ ��Ʈ ��Ʈ", "����Ʈ ��Ʈ��", "���ްŽ� ������ũ", "�ø��� ĥ��ũ��", "ġ������ũ ��Ÿ�̰�" };
        		int Lprice[] = { 34900, 34900, 34900, 33900, 34900, 34900, 34900, 35900};
        		int Mprice[] = { 29000, 29000, 29000, 28000, 29000, 29000, 29000, 29000};
        		JButton bt[] = new JButton[menu.length];
        		TextField Lnumber[] = new TextField[menu.length];
        		TextField Mnumber[] = new TextField[menu.length];
        		Button Lminus[] = new Button[menu.length];
        		Button Mminus[] = new Button[menu.length];
        		Button Lplus[] = new Button[menu.length];
        		Button Mplus[] = new Button[menu.length];
        		JButton ok[] = new JButton[menu.length];
        		Label l[] = new Label[menu.length];        		
        		ImageIcon icon[] = new ImageIcon[menu.length];
        		
        		// ī�װ� �缱�� ��ư
        		JButton clear = new JButton("ī�װ� �缱��");
        		clear.setBounds(25,930,150,30);
        		f.add(clear);
        		
        		// �ֹ� ��ư �������� ���콺�� ���ٴ�� ��ư ����
        		clear.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				for(int i = 0; i<menu.length; i++) {
        					f.remove(bt[i]);
                			f.remove(Lnumber[i]);
                			f.remove(Mnumber[i]);
                			f.remove(Lminus[i]);
                			f.remove(Mminus[i]);
                			f.remove(Lplus[i]);
                			f.remove(Mplus[i]);
                			f.remove(l[i]);
                			f.remove(ok[i]);
                			f.remove(clear);
                			f.add(menuArea);
        				}
        			}
        		});
        		
        		for(int i = 0; i < menu.length; i++) {
        			//���� ��ư
        			bt[i] = new JButton(menu[i]);
        			if(i<4) {
        				bt[i].setBounds(25+i*150, 80, 100, 100);
        			}
        			else {
        				bt[i].setBounds(25+(i-4)*150, 330, 100, 100);
        			}
        			icon[i] = new ImageIcon("images/�����̾� ����/"+menu[i]+".jpg");
        			bt[i].setIcon(icon[i]);
        			
        			// ���� text �κ�
        			Lnumber[i] = new TextField("(L) 0");
        			Lnumber[i].setBackground(Color.white);
        			Lnumber[i].setEditable(false);
        			Lnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
        			Mnumber[i] = new TextField("(M) 0");
        			Mnumber[i].setBackground(Color.white);
        			Mnumber[i].setEditable(false);
        			Mnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 160, 40, 20);
        			
        			// "-" ��ư
        			Lminus[i] = new Button("-");
        			Lminus[i].setBounds(bt[i].getX(), Lnumber[i].getY(), 20, 20);
        			Lminus[i].setEnabled(false);
        			Mminus[i] = new Button("-");
        			Mminus[i].setBounds(bt[i].getX(), Mnumber[i].getY(), 20, 20);
        			Mminus[i].setEnabled(false);
        			
        			// "+" ��ư
        			Lplus[i] = new Button("+");
        			Lplus[i].setBounds(bt[i].getX()+(100-20), Lnumber[i].getY(), 20, 20);
        			Lplus[i].setEnabled(false);
        			Mplus[i] = new Button("+");
        			Mplus[i].setBounds(bt[i].getX()+(100-20), Mnumber[i].getY(), 20, 20);
        			Mplus[i].setEnabled(false);
        			
        			// ����
        			l[i] = new Label("L:"+Lprice[i]+"�� M:"+Mprice[i]+"��");
        			l[i].setBounds(bt[i].getX()-10, Lnumber[i].getY()-25, 120, 20);
        			
        			// Ȯ�� ��ư
        			ok[i] = new JButton("Ȯ��");
        			ok[i].setBounds(bt[i].getX(), Mnumber[i].getY()+30, 100, 20);
        			ok[i].setEnabled(false);
        			
        			f.add(bt[i]);
        			f.add(Lnumber[i]);
        			f.add(Mnumber[i]);
        			f.add(Lminus[i]);
        			f.add(Mminus[i]);
        			f.add(Lplus[i]);
        			f.add(Mplus[i]);
        			f.add(l[i]);
        			f.add(ok[i]);
        			
        			int j = i;
        					
        			// ���� ��ư �̺�Ʈ
        			bt[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					Lminus[j].setEnabled(true);
        					Mminus[j].setEnabled(true);
        					Lplus[j].setEnabled(true);
        					Mplus[j].setEnabled(true);
        					bt[j].setEnabled(false);
        					ok[j].setEnabled(true);
        					
        					Lcount=0;
        					Mcount=0;
        				}
        			});
        			
        			//"-" ��ư �̺�Ʈ
        			Lminus[j].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					if(Lcount>0) {
        						Lcount = Lcount - 1;
        						Lnumber[j].setText("(L) "+Lcount);
        						ok[j].setEnabled(true);
        					}
        					else {
        						Lminus[j].setEnabled(false);       						
        					}
        				}
        			});
        			Mminus[j].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					if(Mcount>0) {
        						Mcount = Mcount - 1;
        						Mnumber[j].setText("(M) "+Mcount);
        						ok[j].setEnabled(true);
        					}
        					else {
        						Mminus[j].setEnabled(false);       						
        					}       					
        				}
        			});
        			
        			// "+" ��ư �̺�Ʈ        			
        			Lplus[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					Lcount = Lcount + 1;
        					Lnumber[j].setText("(L) "+Lcount);
        					ok[j].setEnabled(true);
        					if(Lcount>0) {
        						Lminus[j].setEnabled(true);
        					}
        				}
        			});
        			Mplus[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					Mcount = Mcount + 1;
        					Mnumber[j].setText("(M) "+Mcount);
        					ok[j].setEnabled(true);
        					if(Mcount>0) {
        						Mminus[j].setEnabled(true);
        					}
        				}
        			});
        			
        			
        			
        			// Ȯ�� ��ư �̺�Ʈ
        			ok[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					
        					show = bt[j].getActionCommand();
        					     					
                			
        					
            				if(j==0) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)     "+Lprice[j]+"    	   "+Lcount+"     		"+Lprice[j]*Lcount+"��\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)    "+Mprice[j]+"    	   "+Mcount+"     		"+Mprice[j]*Mcount+"��\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j == 1) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)       	  "+Lprice[j]+"	    	   "+Lcount+"     		"+Lprice[j]*Lcount+"��\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)      	  "+Mprice[j]+" 	   	   "+Mcount+"     		"+Mprice[j]*Mcount+"��\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j >= 2 && j <= 4 || j == 6) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)       	  	  "+Lprice[j]+"		   "+Lcount+"     		"+Lprice[j]*Lcount+"��\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)      	  	  "+Mprice[j]+"		   "+Mcount+"     		"+Mprice[j]*Mcount+"��\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j == 5 || j == 7) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)       	  "+Lprice[j]+"		   "+Lcount+"     		"+Lprice[j]*Lcount+"��\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)      	  "+Mprice[j]+"		   "+Mcount+"     		"+Mprice[j]*Mcount+"��\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}            				
           				    if(Lcount == 0 && Mcount == 0) {
           				    	JOptionPane.showMessageDialog(null, "���õ� ������ �����ϴ�.");
           				    	bt[j].setEnabled(true);
           				    }
           				                   			
            				Lcount = 0;
            				Mcount = 0;
            				
            				Lnumber[j].setText("(L) 0");
            				Mnumber[j].setText("(M) 0");
            				
            				ok[j].setEnabled(false);
            				bt[j].setEnabled(true);
        				}        				
        			});
        		}       		
        	}
        });
        
        // Ŭ���� ���� ī�װ� ���� ��ư
        classic_pizza.addActionListener(new ActionListener() {       	
        	@Override
        	public void actionPerformed(ActionEvent e) {   
        		f.remove(menuArea);
        		        		
        		String menu[] = { "����Ұ��", "������ü��ġ��", "���۵𷰽�", "���۽�����", "�츮����", "ġ���", "��������", "��ġŲ" };
        		int Lprice[] = { 27900, 25900, 25900, 25900, 29900, 27900, 25900, 27900};
        		int Mprice[] = { 21000, 19000, 19000, 19000, 23000, 21000, 19000, 21000};
        		JButton bt[] = new JButton[menu.length];
        		TextField Lnumber[] = new TextField[menu.length];
        		TextField Mnumber[] = new TextField[menu.length];
        		Button Lminus[] = new Button[menu.length];
        		Button Mminus[] = new Button[menu.length];
        		Button Lplus[] = new Button[menu.length];
        		Button Mplus[] = new Button[menu.length];
        		JButton ok[] = new JButton[menu.length];
        		Label l[] = new Label[menu.length];        		
        		ImageIcon icon[] = new ImageIcon[menu.length];
        		
        		// ī�װ� �缱�� ��ư
        		JButton clear = new JButton("ī�װ� �缱��");
        		clear.setBounds(25,930,150,30);
        		f.add(clear);
        		
        		// �ֹ� ��ư �������� ���콺�� ���ٴ�� ��ư ����
        		clear.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				for(int i = 0; i<menu.length; i++) {
        					f.remove(bt[i]);
                			f.remove(Lnumber[i]);
                			f.remove(Mnumber[i]);
                			f.remove(Lminus[i]);
                			f.remove(Mminus[i]);
                			f.remove(Lplus[i]);
                			f.remove(Mplus[i]);
                			f.remove(l[i]);
                			f.remove(ok[i]);
                			f.remove(clear);
                			f.add(menuArea);
        				}
        			}
        		});
        		
        		for(int i = 0; i < menu.length; i++) {
        			//���� ��ư
        			bt[i] = new JButton(menu[i]);
        			if(i<4) {
        				bt[i].setBounds(25+i*150, 80, 100, 100);
        			}
        			else {
        				bt[i].setBounds(25+(i-4)*150, 330, 100, 100);
        			}
        			icon[i] = new ImageIcon("images/Ŭ���� ����/"+menu[i]+".jpg");
        			bt[i].setIcon(icon[i]);
        			
        			// ���� text �κ�
        			Lnumber[i] = new TextField("(L) 0");
        			Lnumber[i].setBackground(Color.white);
        			Lnumber[i].setEditable(false);
        			Lnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
        			Mnumber[i] = new TextField("(M) 0");
        			Mnumber[i].setBackground(Color.white);
        			Mnumber[i].setEditable(false);
        			Mnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 160, 40, 20);
        			
        			// "-" ��ư
        			Lminus[i] = new Button("-");
        			Lminus[i].setBounds(bt[i].getX(), Lnumber[i].getY(), 20, 20);
        			Lminus[i].setEnabled(false);
        			Mminus[i] = new Button("-");
        			Mminus[i].setBounds(bt[i].getX(), Mnumber[i].getY(), 20, 20);
        			Mminus[i].setEnabled(false);
        			
        			// "+" ��ư
        			Lplus[i] = new Button("+");
        			Lplus[i].setBounds(bt[i].getX()+(100-20), Lnumber[i].getY(), 20, 20);
        			Lplus[i].setEnabled(false);
        			Mplus[i] = new Button("+");
        			Mplus[i].setBounds(bt[i].getX()+(100-20), Mnumber[i].getY(), 20, 20);
        			Mplus[i].setEnabled(false);
        			
        			// ����
        			l[i] = new Label("L:"+Lprice[i]+"�� M:"+Mprice[i]+"��");
        			l[i].setBounds(bt[i].getX()-10, Lnumber[i].getY()-25, 120, 20);
        			
        			// Ȯ�� ��ư
        			ok[i] = new JButton("Ȯ��");
        			ok[i].setBounds(bt[i].getX(), Mnumber[i].getY()+30, 100, 20);
        			ok[i].setEnabled(false);        			
        			
        			f.add(bt[i]);
        			f.add(Lnumber[i]);
        			f.add(Mnumber[i]);
        			f.add(Lminus[i]);
        			f.add(Mminus[i]);
        			f.add(Lplus[i]);
        			f.add(Mplus[i]);
        			f.add(l[i]);
        			f.add(ok[i]);
        			
        			int j = i;
        					
        			// ���� ��ư �̺�Ʈ
        			bt[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					Lminus[j].setEnabled(true);
        					Mminus[j].setEnabled(true);
        					Lplus[j].setEnabled(true);
        					Mplus[j].setEnabled(true);
        					bt[j].setEnabled(false);
        					ok[j].setEnabled(true);
        					
        					Lcount=0;
        					Mcount=0;
        				}
        			});
        			
        			//"-" ��ư �̺�Ʈ
        			Lminus[j].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					if(Lcount>0) {
        						Lcount = Lcount - 1;
        						Lnumber[j].setText("(L) "+Lcount);
        						ok[j].setEnabled(true);
        					}
        					else {
        						Lminus[j].setEnabled(false);       						
        					}
        				}
        			});
        			Mminus[j].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					if(Mcount>0) {
        						Mcount = Mcount - 1;
        						Mnumber[j].setText("(M) "+Mcount);
        						ok[j].setEnabled(true);
        					}
        					else {
        						Mminus[j].setEnabled(false);       						
        					}       					
        				}
        			});
        			
        			// "+" ��ư �̺�Ʈ        			
        			Lplus[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					Lcount = Lcount + 1;
        					Lnumber[j].setText("(L) "+Lcount);
        					ok[j].setEnabled(true);
        					if(Lcount>0) {
        						Lminus[j].setEnabled(true);
        					}
        				}
        			});
        			Mplus[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					Mcount = Mcount + 1;
        					Mnumber[j].setText("(M) "+Mcount);
        					ok[j].setEnabled(true);
        					if(Mcount>0) {
        						Mminus[j].setEnabled(true);
        					}
        				}
        			});
        			
        			// Ȯ�� ��ư �̺�Ʈ
        			ok[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					show = bt[j].getActionCommand();
        					

            				if(j>=0 && j<=4) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)     		  "+Lprice[j]+"    	   "+Lcount+"    	 	"+Lprice[j]*Lcount+"��\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)    		  "+Mprice[j]+"    	   "+Mcount+"     		"+Mprice[j]*Mcount+"��\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j>4)
            				{
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)     			  "+Lprice[j]+"    	   "+Lcount+"    	 	"+Lprice[j]*Lcount+"��\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)    			  "+Mprice[j]+"    	   "+Mcount+"     		"+Mprice[j]*Mcount+"��\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				          				
           				    if(Lcount == 0 && Mcount == 0) {
           				    	JOptionPane.showMessageDialog(null, "���õ� ������ �����ϴ�.");
           				    	bt[j].setEnabled(true);
           				    }
           				                 			
            				Lcount = 0;
            				Mcount = 0;
            				
            				Lnumber[j].setText("(L) 0");
            				Mnumber[j].setText("(M) 0");
            				
            				ok[j].setEnabled(false);
            				bt[j].setEnabled(true);
        				}        				
        			});
        		}
        	}
        });
        
        // ���̵� �޴� ī�װ� ���� ��ư
        side_menu.addActionListener(new ActionListener() {       	
        	@Override
        	public void actionPerformed(ActionEvent e) {     
        		f.remove(menuArea);
        		
        		String menu[] = { "������ ����", "���۰ ġŲ(10����)", "��������Ʈ 1.5L", "��ī�ݶ� 1.25L", "ũ������ �� ���� ġŲ(8����)", "Ʈ���� ������", "��� �Ľ�Ÿ", "�ѵ� ������" };
        		int price[] = { 6800, 7800, 2100, 2000, 4800, 8800, 8800, 8800};    	
        		JButton bt[] = new JButton[menu.length];
        		TextField number[] = new TextField[menu.length];
        		Button minus[] = new Button[menu.length];
        		Button plus[] = new Button[menu.length];
        		JButton ok[] = new JButton[menu.length];
        		Label l[] = new Label[menu.length];        		
        		ImageIcon icon[] = new ImageIcon[menu.length];
        		
        		// ī�װ� �缱�� ��ư
        		JButton clear = new JButton("ī�װ� �缱��");
        		clear.setBounds(25,930,150,30);
        		f.add(clear);
        		
        		// �ֹ� ��ư �������� ���콺�� ���ٴ�� ��ư ����
        		clear.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				for(int i = 0; i<menu.length; i++) {
        					f.remove(bt[i]);
                			f.remove(number[i]);
                			f.remove(minus[i]);
                			f.remove(plus[i]);
                			f.remove(l[i]);
                			f.remove(ok[i]);
                			f.remove(clear);
                			f.add(menuArea);
        				}
        			}
        		});
        		
        		for(int i = 0; i < menu.length; i++) {
        			//���� ��ư
        			bt[i] = new JButton(menu[i]);
        			if(i<4) {
        				bt[i].setBounds(25+i*150, 80, 100, 100);
        			}
        			else {
        				bt[i].setBounds(25+(i-4)*150, 330, 100, 100);
        			}
        			icon[i] = new ImageIcon("images/���̵���/"+menu[i]+".jpg");
        			bt[i].setIcon(icon[i]);
        			
        			// ���� text �κ�
        			number[i] = new TextField("0");
        			number[i].setBackground(Color.white);
        			number[i].setEditable(false);
        			number[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);        			
        			
        			// "-" ��ư
        			minus[i] = new Button("-");
        			minus[i].setBounds(bt[i].getX(), number[i].getY(), 20, 20);
        			minus[i].setEnabled(false);        			
        			
        			// "+" ��ư
        			plus[i] = new Button("+");
        			plus[i].setBounds(bt[i].getX()+(100-20), number[i].getY(), 20, 20);
        			plus[i].setEnabled(false);        			
        			
        			// ����
        			l[i] = new Label(price[i]+"��");
        			l[i].setBounds(bt[i].getX()+30, number[i].getY()-25, 120, 20);
        			
        			// Ȯ�� ��ư
        			ok[i] = new JButton("Ȯ��");
        			ok[i].setBounds(bt[i].getX(), number[i].getY()+30, 100, 20);
        			ok[i].setEnabled(false);
        			
        			f.add(bt[i]);
        			f.add(number[i]);;
        			f.add(minus[i]);
        			f.add(plus[i]);
        			f.add(l[i]);
        			f.add(ok[i]);
        			
        			int j = i;
        					
        			// ���̵� �޴� ��ư �̺�Ʈ
        			bt[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					minus[j].setEnabled(true);
        					plus[j].setEnabled(true);
        					bt[j].setEnabled(false);
        					ok[j].setEnabled(true);
        					
        					count=0;
        				}
        			});
        			
        			//"-" ��ư �̺�Ʈ
        			minus[j].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					if(count>0) {
        						count = count - 1;
        						number[j].setText(count+"");
        						ok[j].setEnabled(true);
        					}
        					else {
        						minus[j].setEnabled(false);       						
        					}
        				}
        			});
        			
        			// "+" ��ư �̺�Ʈ        			
        			plus[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					count = count + 1;
        					number[j].setText(count+"");
        					ok[j].setEnabled(true);
        					if(count>0) {
        						minus[j].setEnabled(true);
        					}
        				}
        			});        			
        			
        			// Ȯ�� ��ư �̺�Ʈ
        			ok[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					show = bt[j].getActionCommand();
        					
        					if(j == 0) {
        						if(count > 0) {
                					totalOrder1.append(show+"     			  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"��\n");
                					TotalPrice += price[j]*count;
                				}
        					}      					
        					else if(j>=1 && j<=3) {
            					if(count > 0) {
                					totalOrder1.append(show+"     		  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"��\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					else if(j == 4) {
            					if(count > 0) {
                					totalOrder1.append(show+"     	  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"��\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					else if(j == 5) {
            					if(count > 0) {
                					totalOrder1.append(show+"     	  	  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"��\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					else if(j >= 6) {
            					if(count > 0) {
                					totalOrder1.append(show+"     	  	  	  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"��\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					
        					
           				    if(count == 0) {
           				    	JOptionPane.showMessageDialog(null, "���õ� ������ �����ϴ�.");
           				    	bt[j].setEnabled(true);
           				    }
           				    

            				count = 0;  
            				
            				number[j].setText("0");
            				
            				ok[j].setEnabled(false);
            				bt[j].setEnabled(true);
            				}        				        				
        			});        			
        		}
        	}
        });
        
        // ���� ���� �ݾ� Ȯ�� ��ư
		totalPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(cupon1.getState()) TotalPrice *= 0.9;
				if(cupon2.getState()) TotalPrice *= 0.8;
    			if(cupon3.getState()) TotalPrice *= 0.7;
    			if(takeOut.getState()) TotalPrice -= 1000;
    			
		    	totalOrder2.append("      " + TotalPrice + "��");
		    }
		});
		
		// ���� ��ư
        order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?", "����â", JOptionPane.WARNING_MESSAGE);
				
				if(result == 0) {
					JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ�Ǿ����ϴ�", "�ֹ��Ϸ�â", JOptionPane.WARNING_MESSAGE);
					f.setVisible(false);
				}
			}
		});
        
        reset.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		totalOrder1.setText("");
        		TotalPrice = 0;  
        		JOptionPane.showMessageDialog(null, "�ֹ��� �ʱ�ȭ�Ǿ����ϴ�.");
        	}
        });
    }      
   
           
 
    // ����
    public static void main(String[] args) {
        new PizzaOrder();
    }
 
}