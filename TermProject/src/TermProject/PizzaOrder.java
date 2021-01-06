package TermProject; //본인 환경에 맞는 package 넣기 

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
     // 프레임 생성
        f.setTitle("피자 주문 프로그램");                             
        f.setSize(615,1020);
        
        // 프레임 레이아웃 설정
        f.setLayout(null);
        
        // 버튼 생성
        JButton premium_pizza= new JButton("프리미엄 피자");        
        JButton classic_pizza = new JButton("클래식 피자");        
        JButton side_menu = new JButton("사이드 메뉴");
        JButton reset = new JButton("주문 초기화");
        f.add(premium_pizza);
        f.add(classic_pizza);
        f.add(side_menu);
        f.add(reset);
        
        // 메뉴판 보여주는 창        
        TextArea menuArea = new TextArea("원하시는 메뉴를 선택해 주세요.",0,0,TextArea.SCROLLBARS_NONE);        
        f.add(menuArea);
        
        //매장 식사 or 포장       
        CheckboxGroup chkGroup = new CheckboxGroup(); 
        Checkbox here = new Checkbox("매장에서 식사", chkGroup, false) ;
        Checkbox takeOut = new Checkbox("Take out", chkGroup, false) ;
        f.add(here) ;
        f.add(takeOut) ;
        
        //보유 쿠폰 유무에 달라지는 할인율  
        Label lbl = new Label("보유 쿠폰") ;
            
        CheckboxGroup chkGroup2 = new CheckboxGroup(); //보유 쿠폰 
        Checkbox cupon1 = new Checkbox("10%", chkGroup2, false);       
        Checkbox cupon2 = new Checkbox("20%", chkGroup2, false);     
        Checkbox cupon3 = new Checkbox("30%", chkGroup2, false);
        f.add(lbl);
        f.add(cupon1);
        f.add(cupon2);
        f.add(cupon3); 
        
        //최종 주문내역
        Label ordermenu = new Label("       상품명                                                 단가                      수량                      합계");
        TextArea totalOrder1 = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
        JButton totalPrice = new JButton("전체 금액");
        TextArea totalOrder2 = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
        JButton order = new JButton("결제"); 
        f.add(ordermenu);
        f.add(totalOrder1);
        f.add(totalPrice);
        f.add(totalOrder2);
        f.add(order); 
        
        //컴포넌트 위치, 크기 설정
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
        
        // 프리미엄 피자 카테고리 선택 버튼
        premium_pizza.addActionListener(new ActionListener() {       	
        	@Override
        	public void actionPerformed(ActionEvent e) {        		
        		f.remove(menuArea);
        		
        		String menu[] = { "30 치즈&뉴욕 스트립 스테이크", "더블크러스트 이베리코", "문어밤 슈림프", "미트 미트 미트", "베스트 콰트로", "블랙앵거스 스테이크", "시리얼 칠리크랩", "치즈케이크 블랙타이거" };
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
        		
        		// 카테고리 재선택 버튼
        		JButton clear = new JButton("카테고리 재선택");
        		clear.setBounds(25,930,150,30);
        		f.add(clear);
        		
        		// 주문 버튼 왼쪽으로 마우스를 갖다대면 버튼 보임
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
        			//피자 버튼
        			bt[i] = new JButton(menu[i]);
        			if(i<4) {
        				bt[i].setBounds(25+i*150, 80, 100, 100);
        			}
        			else {
        				bt[i].setBounds(25+(i-4)*150, 330, 100, 100);
        			}
        			icon[i] = new ImageIcon("images/프리미엄 피자/"+menu[i]+".jpg");
        			bt[i].setIcon(icon[i]);
        			
        			// 수량 text 부분
        			Lnumber[i] = new TextField("(L) 0");
        			Lnumber[i].setBackground(Color.white);
        			Lnumber[i].setEditable(false);
        			Lnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
        			Mnumber[i] = new TextField("(M) 0");
        			Mnumber[i].setBackground(Color.white);
        			Mnumber[i].setEditable(false);
        			Mnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 160, 40, 20);
        			
        			// "-" 버튼
        			Lminus[i] = new Button("-");
        			Lminus[i].setBounds(bt[i].getX(), Lnumber[i].getY(), 20, 20);
        			Lminus[i].setEnabled(false);
        			Mminus[i] = new Button("-");
        			Mminus[i].setBounds(bt[i].getX(), Mnumber[i].getY(), 20, 20);
        			Mminus[i].setEnabled(false);
        			
        			// "+" 버튼
        			Lplus[i] = new Button("+");
        			Lplus[i].setBounds(bt[i].getX()+(100-20), Lnumber[i].getY(), 20, 20);
        			Lplus[i].setEnabled(false);
        			Mplus[i] = new Button("+");
        			Mplus[i].setBounds(bt[i].getX()+(100-20), Mnumber[i].getY(), 20, 20);
        			Mplus[i].setEnabled(false);
        			
        			// 가격
        			l[i] = new Label("L:"+Lprice[i]+"원 M:"+Mprice[i]+"원");
        			l[i].setBounds(bt[i].getX()-10, Lnumber[i].getY()-25, 120, 20);
        			
        			// 확인 버튼
        			ok[i] = new JButton("확인");
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
        					
        			// 피자 버튼 이벤트
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
        			
        			//"-" 버튼 이벤트
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
        			
        			// "+" 버튼 이벤트        			
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
        			
        			
        			
        			// 확인 버튼 이벤트
        			ok[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					
        					show = bt[j].getActionCommand();
        					     					
                			
        					
            				if(j==0) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)     "+Lprice[j]+"    	   "+Lcount+"     		"+Lprice[j]*Lcount+"원\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)    "+Mprice[j]+"    	   "+Mcount+"     		"+Mprice[j]*Mcount+"원\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j == 1) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)       	  "+Lprice[j]+"	    	   "+Lcount+"     		"+Lprice[j]*Lcount+"원\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)      	  "+Mprice[j]+" 	   	   "+Mcount+"     		"+Mprice[j]*Mcount+"원\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j >= 2 && j <= 4 || j == 6) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)       	  	  "+Lprice[j]+"		   "+Lcount+"     		"+Lprice[j]*Lcount+"원\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)      	  	  "+Mprice[j]+"		   "+Mcount+"     		"+Mprice[j]*Mcount+"원\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j == 5 || j == 7) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)       	  "+Lprice[j]+"		   "+Lcount+"     		"+Lprice[j]*Lcount+"원\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)      	  "+Mprice[j]+"		   "+Mcount+"     		"+Mprice[j]*Mcount+"원\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}            				
           				    if(Lcount == 0 && Mcount == 0) {
           				    	JOptionPane.showMessageDialog(null, "선택된 수량이 없습니다.");
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
        
        // 클래식 피자 카테고리 선택 버튼
        classic_pizza.addActionListener(new ActionListener() {       	
        	@Override
        	public void actionPerformed(ActionEvent e) {   
        		f.remove(menuArea);
        		        		
        		String menu[] = { "리얼불고기", "베이컨체더치즈", "슈퍼디럭스", "슈퍼슈프림", "우리고구마", "치즈가든", "포테이토", "핫치킨" };
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
        		
        		// 카테고리 재선택 버튼
        		JButton clear = new JButton("카테고리 재선택");
        		clear.setBounds(25,930,150,30);
        		f.add(clear);
        		
        		// 주문 버튼 왼쪽으로 마우스를 갖다대면 버튼 보임
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
        			//피자 버튼
        			bt[i] = new JButton(menu[i]);
        			if(i<4) {
        				bt[i].setBounds(25+i*150, 80, 100, 100);
        			}
        			else {
        				bt[i].setBounds(25+(i-4)*150, 330, 100, 100);
        			}
        			icon[i] = new ImageIcon("images/클래식 피자/"+menu[i]+".jpg");
        			bt[i].setIcon(icon[i]);
        			
        			// 수량 text 부분
        			Lnumber[i] = new TextField("(L) 0");
        			Lnumber[i].setBackground(Color.white);
        			Lnumber[i].setEditable(false);
        			Lnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
        			Mnumber[i] = new TextField("(M) 0");
        			Mnumber[i].setBackground(Color.white);
        			Mnumber[i].setEditable(false);
        			Mnumber[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 160, 40, 20);
        			
        			// "-" 버튼
        			Lminus[i] = new Button("-");
        			Lminus[i].setBounds(bt[i].getX(), Lnumber[i].getY(), 20, 20);
        			Lminus[i].setEnabled(false);
        			Mminus[i] = new Button("-");
        			Mminus[i].setBounds(bt[i].getX(), Mnumber[i].getY(), 20, 20);
        			Mminus[i].setEnabled(false);
        			
        			// "+" 버튼
        			Lplus[i] = new Button("+");
        			Lplus[i].setBounds(bt[i].getX()+(100-20), Lnumber[i].getY(), 20, 20);
        			Lplus[i].setEnabled(false);
        			Mplus[i] = new Button("+");
        			Mplus[i].setBounds(bt[i].getX()+(100-20), Mnumber[i].getY(), 20, 20);
        			Mplus[i].setEnabled(false);
        			
        			// 가격
        			l[i] = new Label("L:"+Lprice[i]+"원 M:"+Mprice[i]+"원");
        			l[i].setBounds(bt[i].getX()-10, Lnumber[i].getY()-25, 120, 20);
        			
        			// 확인 버튼
        			ok[i] = new JButton("확인");
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
        					
        			// 피자 버튼 이벤트
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
        			
        			//"-" 버튼 이벤트
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
        			
        			// "+" 버튼 이벤트        			
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
        			
        			// 확인 버튼 이벤트
        			ok[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					show = bt[j].getActionCommand();
        					

            				if(j>=0 && j<=4) {
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)     		  "+Lprice[j]+"    	   "+Lcount+"    	 	"+Lprice[j]*Lcount+"원\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)    		  "+Mprice[j]+"    	   "+Mcount+"     		"+Mprice[j]*Mcount+"원\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				else if(j>4)
            				{
            					if(Lcount > 0) {
                					totalOrder1.append(show+"(L)     			  "+Lprice[j]+"    	   "+Lcount+"    	 	"+Lprice[j]*Lcount+"원\n");
                					TotalPrice += Lprice[j]*Lcount;
                				}
                				if(Mcount > 0) {
                					totalOrder1.append(show+"(M)    			  "+Mprice[j]+"    	   "+Mcount+"     		"+Mprice[j]*Mcount+"원\n");
                					TotalPrice += Mprice[j]*Mcount;
                				}
            				}
            				          				
           				    if(Lcount == 0 && Mcount == 0) {
           				    	JOptionPane.showMessageDialog(null, "선택된 수량이 없습니다.");
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
        
        // 사이드 메뉴 카테고리 선택 버튼
        side_menu.addActionListener(new ActionListener() {       	
        	@Override
        	public void actionPerformed(ActionEvent e) {     
        		f.remove(menuArea);
        		
        		String menu[] = { "샐러드 가든", "슈퍼곡물 치킨(10조각)", "스프라이트 1.5L", "코카콜라 1.25L", "크리스피 핫 순살 치킨(8조각)", "트러플 리조또", "펜네 파스타", "한돈 빠에야" };
        		int price[] = { 6800, 7800, 2100, 2000, 4800, 8800, 8800, 8800};    	
        		JButton bt[] = new JButton[menu.length];
        		TextField number[] = new TextField[menu.length];
        		Button minus[] = new Button[menu.length];
        		Button plus[] = new Button[menu.length];
        		JButton ok[] = new JButton[menu.length];
        		Label l[] = new Label[menu.length];        		
        		ImageIcon icon[] = new ImageIcon[menu.length];
        		
        		// 카테고리 재선택 버튼
        		JButton clear = new JButton("카테고리 재선택");
        		clear.setBounds(25,930,150,30);
        		f.add(clear);
        		
        		// 주문 버튼 왼쪽으로 마우스를 갖다대면 버튼 보임
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
        			//피자 버튼
        			bt[i] = new JButton(menu[i]);
        			if(i<4) {
        				bt[i].setBounds(25+i*150, 80, 100, 100);
        			}
        			else {
        				bt[i].setBounds(25+(i-4)*150, 330, 100, 100);
        			}
        			icon[i] = new ImageIcon("images/사이드디시/"+menu[i]+".jpg");
        			bt[i].setIcon(icon[i]);
        			
        			// 수량 text 부분
        			number[i] = new TextField("0");
        			number[i].setBackground(Color.white);
        			number[i].setEditable(false);
        			number[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);        			
        			
        			// "-" 버튼
        			minus[i] = new Button("-");
        			minus[i].setBounds(bt[i].getX(), number[i].getY(), 20, 20);
        			minus[i].setEnabled(false);        			
        			
        			// "+" 버튼
        			plus[i] = new Button("+");
        			plus[i].setBounds(bt[i].getX()+(100-20), number[i].getY(), 20, 20);
        			plus[i].setEnabled(false);        			
        			
        			// 가격
        			l[i] = new Label(price[i]+"원");
        			l[i].setBounds(bt[i].getX()+30, number[i].getY()-25, 120, 20);
        			
        			// 확인 버튼
        			ok[i] = new JButton("확인");
        			ok[i].setBounds(bt[i].getX(), number[i].getY()+30, 100, 20);
        			ok[i].setEnabled(false);
        			
        			f.add(bt[i]);
        			f.add(number[i]);;
        			f.add(minus[i]);
        			f.add(plus[i]);
        			f.add(l[i]);
        			f.add(ok[i]);
        			
        			int j = i;
        					
        			// 사이드 메뉴 버튼 이벤트
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
        			
        			//"-" 버튼 이벤트
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
        			
        			// "+" 버튼 이벤트        			
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
        			
        			// 확인 버튼 이벤트
        			ok[i].addActionListener(new ActionListener() {
        				@Override
        				public void actionPerformed(ActionEvent e) {
        					show = bt[j].getActionCommand();
        					
        					if(j == 0) {
        						if(count > 0) {
                					totalOrder1.append(show+"     			  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"원\n");
                					TotalPrice += price[j]*count;
                				}
        					}      					
        					else if(j>=1 && j<=3) {
            					if(count > 0) {
                					totalOrder1.append(show+"     		  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"원\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					else if(j == 4) {
            					if(count > 0) {
                					totalOrder1.append(show+"     	  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"원\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					else if(j == 5) {
            					if(count > 0) {
                					totalOrder1.append(show+"     	  	  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"원\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					else if(j >= 6) {
            					if(count > 0) {
                					totalOrder1.append(show+"     	  	  	  "+price[j]+"    	   "+count+"    	 	"+price[j]*count+"원\n");
                					TotalPrice += price[j]*count;
                				}
            				}
        					
        					
           				    if(count == 0) {
           				    	JOptionPane.showMessageDialog(null, "선택된 수량이 없습니다.");
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
        
        // 최종 결제 금액 확인 버튼
		totalPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(cupon1.getState()) TotalPrice *= 0.9;
				if(cupon2.getState()) TotalPrice *= 0.8;
    			if(cupon3.getState()) TotalPrice *= 0.7;
    			if(takeOut.getState()) TotalPrice -= 1000;
    			
		    	totalOrder2.append("      " + TotalPrice + "원");
		    }
		});
		
		// 결제 버튼
        order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "결제를 진행하시겠습니까?", "결제창", JOptionPane.WARNING_MESSAGE);
				
				if(result == 0) {
					JOptionPane.showMessageDialog(null, "주문이 완료되었습니다", "주문완료창", JOptionPane.WARNING_MESSAGE);
					f.setVisible(false);
				}
			}
		});
        
        reset.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		totalOrder1.setText("");
        		TotalPrice = 0;  
        		JOptionPane.showMessageDialog(null, "주문이 초기화되었습니다.");
        	}
        });
    }      
   
           
 
    // 메인
    public static void main(String[] args) {
        new PizzaOrder();
    }
 
}