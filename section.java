package ATP;

import java.awt.Color;

import javax.swing.JPanel;
// 섹션 만들기
class section extends JPanel {
   int x;
   int y;
   static Subject s1 = new Subject(83,720,ali.Icon5,null,null);
   static Subject s2 = new Subject(163,780,ali.Icon6,null,null);
   static Subject s3 = new Subject(83,840,ali.Icon7,null,null);
   static Subject s4 = new Subject(0,780,ali.Icon8,null,null);
   static Subject s5 = new Subject(0,720,ali.Icon9,null,null);

   section(int x , int y, Color a){
      this.x=x;
      this.y=y;
      setLayout(null);
      setBounds(x,y,300,900);
      setBackground(a);
      setOpaque(true);
      this.add(s1);
      this.add(s2);
      this.add(s3);
      this.add(s4);
      this.add(s5);
      s1.setVisible(true);
      s2.setVisible(true);
      s3.setVisible(true);
      s4.setVisible(true);
      s5.setVisible(true);
   }
}