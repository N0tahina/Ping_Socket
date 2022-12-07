package Graph;


import javax.swing.*;

import Mouvement.Moov;



public class Fenetre extends JFrame{
    Circle pan = new Circle();
    int x; int y;
    int xrec; int yrec;
    int xrec2; int yrec2;
    int xplus; int yplus;
    boolean backX = true;
    boolean backY = true;
    boolean mahi = false;

    public void setMahi(boolean b){
      this.mahi = b;
    }

    public void setBackX(boolean b){
      this.backX = b;
    }

    public void setBackY(boolean b){
      this.backY = b;
    }

    public int getXplus(){
      return this.xplus ;
    }

    public int getYplus(){
      return this.yplus ;
    }

    public void setXplus(int x){
      this.xplus = x;
    }

    public void setYplus(int x){
      this.yplus = x;
    }

    public int getXrec(){
      return this.xrec ;
    }

    public int getYrec(){
      return this.yrec ;
    }

    public int getXrec2(){
      return this.xrec2 ;
    }

    public int getYrec2(){
      return this.yrec2 ;
    }    

    public void setXrec(int x){
      this.xrec = x;
    }

    public void setYrec(int y){
      this.yrec = y;
    }

    public void setXrec2(int x){
      this.xrec2 = x;
    }

    public void setYrec2(int y){
      this.yrec2 = y;
    }

    public Fenetre(){
        this.xplus = 1; this.yplus = 1;
        this.setTitle("Ping");
        this.setSize(400, 600);
        this.x = (this.getWidth()/2)-10; this.y= (this.getHeight()/2)-10;
        this.xrec = (this.getWidth()/2)-40; this.yrec =this.getHeight()-50; 
        this.xrec2 = (this.getWidth()/2)-40; this.yrec2 =0; 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pan);
        this.setVisible(true);
        go();
    }

    public void go(){
        int points1 = 0; int points2 = 0;

        while(true){

            pan.setXrec1(this.xrec);
            pan.setYrec1(this.yrec);

            pan.setXrec2(this.xrec2);
            pan.setYrec2(this.yrec2);

            if(this.x < 1)
            this.backX = true;

            if(this.x > pan.getWidth()-20)
            this.backX = false;

            if(this.y < 1)
            this.backY = true;
            this.mahi = false;

            if(this.y > pan.getHeight()-20)
            this.backY = false;

            if(this.mahi == true){
              
              pan.setYo1(this.y);
            }


            if(!this.backX){
            this.x = this.x - this.xplus;
            pan.setXo1(this.x);
            }else{
            this.x = this.x + this.xplus; 
            pan.setXo1(this.x);
            }

            if(!this.backY){
            this.y = this.y - this.yplus;
            pan.setYo1(this.y);
            }else{
            this.y = this.y + this.yplus;  
            pan.setYo1(this.y);
            }
            

            if(this.xrec>this.x+10 && this.y+20 == this.yrec || this.x+10>this.xrec+80 && this.y+20 == this.yrec){
              points1 = points1+1;
              this.x=this.xrec+40; this.y = this.yrec-20;
              this.xplus = 0; this.yplus = 0;
            }else if(this.xrec2>this.x+10 && this.y == this.yrec2+10 || this.x+10>this.xrec2+80 && this.y == this.yrec2+10){
              points2 = points2+1;
              this.x=this.xrec2+40; this.y = this.yrec2+10;
              this.xplus = 0; this.yplus = 0;
            }


            pan.repaint();
              try {
                Thread.sleep(5);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }

        } 
    }    



}
