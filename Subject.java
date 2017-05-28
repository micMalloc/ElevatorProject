package ATP;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigInteger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//써큘러 엘리베이터 용
class Subject extends JPanel implements Runnable {
   int x;
   int y;
   int d_x;
   int d_y;
   client c;
   HashMap<Integer, ArrayList<Integer>> path;
   ImageIcon icon;

   public Subject(int x, int y, ImageIcon a, client c, HashMap<Integer, ArrayList<Integer>> path) {
      icon = a;
      setOpaque(false);
      setBounds(x, y, 83, 60);
      setVisible(true);
      this.x = x;
      this.y = y;
      this.c = c;
      this.path = path;
   }

   public void f_convert(int floor) {
      if (floor == 1) {
         d_y = 720;
      } else if (floor == 2) {
         d_y = 540;
      } else if (floor == 3) {
         d_y = 360;
      } else if (floor == 4) {
         d_y = 180;
      } else if (floor == 5) {
         d_y = 0;
      }
   }

   public void s_convert(int sec) {

      if (sec == 0) {
         d_x = 0;
      } else if (sec == 1) {
         d_x = 83;
      } else if (sec == 2) {
         d_x = 163;
      } else if (sec == 3) {
         d_x = 163;
         d_y = d_y + 60;
      } else if (sec == 4) {
         d_x = 163;
         d_y = d_y + 120;
      } else if (sec == 5) {
         d_x = 83;
         d_y = d_y + 120;
      } else if (sec == 6) {
         d_x = 0;
         d_y = d_y + 120;
      } else if (sec == 7) {
         d_x = 0;
         d_y = d_y + 60;
      }
   }

   public void run() {
      // int start, mid, end;
      for (int k : path.keySet()) {
         ArrayList<Integer> tmp = new ArrayList<Integer>();
         System.out.println("Floor : " + k);
         System.out.print("Section : ");
         tmp = path.get(k);
         for (int i = 0; i < tmp.size(); ++i) {
            System.out.print(tmp.get(i) + " ");
         }
         System.out.println("");
      }
      int prev = 0;
      for (int floor : path.keySet()) {
         ArrayList<Integer> tmp = new ArrayList<Integer>();
         tmp = path.get(floor);
         int current;
         f_convert(floor);
         for (int i = 0; i < tmp.size(); ++i) {
            current = tmp.get(i);
            s_convert(current);
            if (tmp.size() == 1) {
               u_cir(x, y);
               // System.out.println("확인"+ x + " " + y + " " + d_x + " " +
               // d_y);
               try {
                  Thread.sleep(10);
               } catch (Exception ex) {
               }
               System.out.println("Prev " + prev);
               if (prev != 0) {
                  Center.floor[prev].section[tmp.get(0)] = 0;
               }
            }

            if (Center.elevator[c.assign].currentSec == current) {
               u_cir(x, d_y);
               y = d_y;
               try {
                  Thread.sleep(500);
               } catch (Exception ex) {
               }
            } else {
               if (y < d_y) {
                  while (y < d_y) {
                     System.out.println(x + " " + y + " " + d_x + " " + d_y);
                     y++;
                     u_cir(x, y);
                     try {
                        Thread.sleep(10);
                     } catch (Exception ex) {
                     }
                  }
                  int p = Center.elevator[c.assign].currentSec;
                  Center.floor[floor].section[p] = 0;
                  Center.elevator[c.assign].currentSec = current;
               } else if (y > d_y) {
                  while (y > d_y) {
                     System.out.println(x + " " + y + " " + d_x + " " + d_y);
                     y--;
                     u_cir(x, y);
                     try {
                        Thread.sleep(10);
                     } catch (Exception ex) {
                     }
                  }
                  int p = Center.elevator[c.assign].currentSec;
                  Center.floor[floor].section[p] = 0;
                  Center.elevator[c.assign].currentSec = current;
               } else {
                  if (x > d_x) {
                     while (x > d_x) {
                        System.out.println(x + " " + y + " " + d_x + " " + d_y);
                        x--;
                        u_cir(x, y);
                        try {
                           Thread.sleep(10);
                        } catch (Exception ex) {
                        }
                     }
                     int p = Center.elevator[c.assign].currentSec;
                     Center.floor[floor].section[p] = 0;
                     Center.elevator[c.assign].currentSec = current;
                  } else if (x < d_x) {
                     while (x < d_x) {
                        System.out.println(x + " " + y + " " + d_x + " " + d_y);
                        x++;
                        u_cir(x, y);
                        try {
                           Thread.sleep(10);
                        } catch (Exception ex) {
                        }
                     }
                     int p = Center.elevator[c.assign].currentSec;
                     Center.floor[floor].section[p] = 0;
                     Center.elevator[c.assign].currentSec = current;
                  }
               }
            }

         }
         Center.elevator[c.assign].currentFloor = floor;
         prev = floor;
      }
   }

   public void u_cir(int a, int b) {
      setVisible(false);
      setBounds(a, b, 83, 60);
      setVisible(true);
   }

   public void paintComponent(Graphics g) {
      g.drawImage(icon.getImage(), 0, 0, null);
      super.paintComponent(g);
   }
}