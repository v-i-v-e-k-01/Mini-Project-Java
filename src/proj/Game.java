/* The Sliding Tile Puzzle  */
package proj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Game extends javax.swing.JFrame implements ActionListener{


    public Game() {
        initComponents();
        gamePanelJP.setVisible(false);
    }



    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        startStopJB = new javax.swing.JButton();
        playPauseJB = new javax.swing.JButton();
        shuffleJB = new javax.swing.JButton();
        loadJB = new javax.swing.JButton();
        gamePanelJP = new javax.swing.JPanel();
        timerPanel = new javax.swing.JPanel();
        closeJL = new javax.swing.JLabel();
        timeJL = new javax.swing.JTextField();
        helpJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(150, 50, 255));
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.BorderLayout());

        controlPanel.setBackground(new java.awt.Color(204, 204, 255));
        controlPanel.setFocusable(false);
        controlPanel.setOpaque(false);
        controlPanel.setPreferredSize(new java.awt.Dimension(300, 40));
        controlPanel.setLayout(new java.awt.GridLayout(1, 3));

        startStopJB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        startStopJB.setForeground(new java.awt.Color(0, 153, 153));
        startStopJB.setText("START");
        startStopJB.setToolTipText("Start or Stop");
        startStopJB.setBorder(null);
        startStopJB.setBorderPainted(false);
        startStopJB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startStopJB.setFocusable(false);
        startStopJB.setMaximumSize(new java.awt.Dimension(85, 31));
        startStopJB.setMinimumSize(new java.awt.Dimension(85, 31));
        startStopJB.setPreferredSize(new java.awt.Dimension(85, 31));
        startStopJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopJBActionPerformed(evt);
            }
        });
        controlPanel.add(startStopJB);

        playPauseJB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        playPauseJB.setForeground(new java.awt.Color(0, 153, 153));
        playPauseJB.setText("PLAY");
        playPauseJB.setToolTipText("Play or Pause");
        playPauseJB.setBorder(null);
        playPauseJB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playPauseJB.setFocusable(false);
        playPauseJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseJBActionPerformed(evt);
            }
        });
        controlPanel.add(playPauseJB);

        shuffleJB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        shuffleJB.setForeground(new java.awt.Color(0, 153, 153));
        shuffleJB.setText("SHUFFLE");
        shuffleJB.setToolTipText("Shuffle Tiles");
        shuffleJB.setBorder(null);
        shuffleJB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shuffleJB.setFocusable(false);
        shuffleJB.setOpaque(false);
        shuffleJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleJBActionPerformed(evt);
            }
        });
        controlPanel.add(shuffleJB);

        loadJB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loadJB.setForeground(new java.awt.Color(0, 153, 153));
        loadJB.setText("LOAD");
        loadJB.setToolTipText("Load Image");
        loadJB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadJB.setFocusable(false);
        loadJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadJBActionPerformed(evt);
            }
        });
        controlPanel.add(loadJB);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        gamePanelJP.setBackground(new java.awt.Color(204, 204, 255));
        gamePanelJP.setFocusable(false);
        gamePanelJP.setMaximumSize(new java.awt.Dimension(240, 200));
        gamePanelJP.setMinimumSize(new java.awt.Dimension(240, 200));
        gamePanelJP.setPreferredSize(new java.awt.Dimension(240, 200));
        gamePanelJP.setRequestFocusEnabled(false);
        gamePanelJP.setLayout(new java.awt.GridLayout(4, 4));
        getContentPane().add(gamePanelJP, java.awt.BorderLayout.CENTER);

        timerPanel.setBackground(new java.awt.Color(204, 204, 255));
        timerPanel.setFocusCycleRoot(true);
        timerPanel.setPreferredSize(new java.awt.Dimension(300, 25));
        timerPanel.setLayout(new java.awt.BorderLayout());

        closeJL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closeJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeJL.setText("X");
        closeJL.setToolTipText("Close");
        closeJL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeJL.setFocusable(false);
        closeJL.setMaximumSize(new java.awt.Dimension(10, 10));
        closeJL.setMinimumSize(new java.awt.Dimension(20, 20));
        closeJL.setPreferredSize(new java.awt.Dimension(25, 25));
        closeJL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeJLMouseClicked(evt);
            }
        });
        timerPanel.add(closeJL, java.awt.BorderLayout.EAST);

        timeJL.setEditable(false);
        timeJL.setBackground(new java.awt.Color(0, 102, 102));
        timeJL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        timeJL.setForeground(new java.awt.Color(255, 255, 255));
        timeJL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timeJL.setText("0:0");
        timeJL.setToolTipText("");
        timeJL.setBorder(null);
        timeJL.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        timeJL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                timeJLMouseDragged(evt);
            }
        });
        timeJL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeJLKeyPressed(evt);
            }
        });
        timerPanel.add(timeJL, java.awt.BorderLayout.CENTER);

        helpJL.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        helpJL.setForeground(new java.awt.Color(0, 153, 153));
        helpJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpJL.setText("*");
        helpJL.setToolTipText("Left Click to see Image and Right Click to Hide Controls");
        helpJL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        helpJL.setFocusable(false);
        helpJL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpJL.setPreferredSize(new java.awt.Dimension(25, 25));
        helpJL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpJLMouseClicked(evt);
            }
        });
        timerPanel.add(helpJL, java.awt.BorderLayout.LINE_START);

        getContentPane().add(timerPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }

    private void initGame(){
        buttons=new JButton[15];
        img=new ImageIcon(getClass().getResource("/img/16.jpg")).getImage();
        icon=splitImage(img);
        for(int i=0;i<buttons.length;i++){
                buttons[i]=new JButton();
                buttons[i].setFocusable(false);
                buttons[i].setSize(60, 50);
                buttons[i].addActionListener(this);
                buttons[i].setIcon(icon[i]);
                gamePanelJP.add(buttons[i]);
        }
        swapB=new JButton();
        swapB.setIcon(new ImageIcon(getClass().getResource("/img/blank.png")));
        gamePanelJP.add(swapB);
        gamePanelJP.setVisible(true);
        gamePanelJP.updateUI();
        
    }
    
    private void changeImage() {
        gamePanelJP.removeAll();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setIcon(icon[i]);
            gamePanelJP.add(buttons[i]);
        }
        swapB = new JButton();
        swapB.setIcon(new ImageIcon(getClass().getResource("/img/blank.png")));
        gamePanelJP.add(swapB);
        gamePanelJP.updateUI();
        
    }
    
    private void shuffleJBActionPerformed(java.awt.event.ActionEvent evt) {
        shuffle();
    }

    private void closeJLMouseClicked(java.awt.event.MouseEvent evt) {
     if(evt.getButton()==MouseEvent.BUTTON1){
        this.dispose();
        System.exit(1);
     }
    }

    private void timeJLKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            this.setLocation(this.getLocation().x-10, this.getLocation().y);
        }
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
            this.setLocation(this.getLocation().x+10, this.getLocation().y);
        }
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            this.setLocation(this.getLocation().x, this.getLocation().y-10);
        }
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            this.setLocation(this.getLocation().x, this.getLocation().y+10);
        }
    }

    private void loadJBActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser filechooser=new JFileChooser();
        int response=filechooser.showOpenDialog(startStopJB);
        if(response==JFileChooser.APPROVE_OPTION){
            img=new ImageIcon(filechooser.getSelectedFile().toString()).getImage();
            icon=splitImage(img);
            changeImage();
        }
    }

    private void startStopJBActionPerformed(java.awt.event.ActionEvent evt) {
      if(startStopJB.getText().equals("START")){
       timer=new Timer(timeJL);
       timer.start();
       playPauseJB.setText("PAUSE");
       startStopJB.setText("STOP");
       gamePanelJP.removeAll();
       initGame();
      }else{
          timer.stopT();
          startStopJB.setText("START");
          playPauseJB.setText("PLAY");
          timeJL.setText("0:0");
          gamePanelJP.setVisible(false);
      }
       //shuffle();
    }

    private void playPauseJBActionPerformed(java.awt.event.ActionEvent evt) {
        if (playPauseJB.getText().equals("PAUSE")) {
            playPauseJB.setText("PLAY");
            timer.pauseT();
        } else {
            playPauseJB.setText("PAUSE");
            timer.resumeT();
        }

    }

    private void helpJLMouseClicked(java.awt.event.MouseEvent evt) {
       if(evt.getButton()==MouseEvent.BUTTON1){
           new Help(img,this.getX()+this.getWidth(),this.getY()).setVisible(true);
       }
       if(evt.getButton()==MouseEvent.BUTTON3){
           if(controlPanel.isVisible()){
           this.setSize(this.getWidth(), this.getHeight()-40);
           controlPanel.setVisible(false);
           }else{
              this.setSize(this.getWidth(), this.getHeight()+40); 
              controlPanel.setVisible(true);
           }
       }
    }

    private void timeJLMouseDragged(java.awt.event.MouseEvent evt) {
       setLocation(evt.getXOnScreen()-175,evt.getYOnScreen());
    }


    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game().setVisible(true);
            }
        });
    }
    
    public void shuffle(){
        gamePanelJP.removeAll();
         for(int i=0;i<100;i++){
            int x=(int)(Math.random()*15);
            gamePanelJP.add(buttons[x]);
        }
         gamePanelJP.add(swapB);
         gamePanelJP.updateUI();
    }

    public void check() {
        boolean won = false;
        for (int i = 0; i < 15; i++) {
            if (buttons[i] == gamePanelJP.getComponent(i)) {
                won = true;
            } else {
                won = false;
                break;
            }
        }
        if (won) {
            timer.stopT();
            swapB.setIcon(icon[15]);
            JOptionPane.showMessageDialog(gamePanelJP,"You Won! "+timeJL.getText()); 
            startStopJB.setText("START");
            playPauseJB.setText("PLAY");
        }
    }
    
    public void move(JButton btn){
        if(swapB==gamePanelJP.getComponentAt(btn.getX()+btn.getWidth(),btn.getY())){
            int swapIndex=gamePanelJP.getComponentZOrder(swapB);
            int btnIndex=gamePanelJP.getComponentZOrder(btn);
            gamePanelJP.add(btn,swapIndex);
            gamePanelJP.add(swapB,btnIndex);
            gamePanelJP.updateUI();
        }
        if(swapB==gamePanelJP.getComponentAt(btn.getX()-btn.getWidth(),btn.getY())){
            int swapIndex=gamePanelJP.getComponentZOrder(swapB);
            int btnIndex=gamePanelJP.getComponentZOrder(btn);
            gamePanelJP.add(btn,swapIndex);
            gamePanelJP.add(swapB,btnIndex);
            gamePanelJP.updateUI();
        }
        if(swapB==gamePanelJP.getComponentAt(btn.getX(),btn.getY()+btn.getHeight())){
           int swapIndex=gamePanelJP.getComponentZOrder(swapB);
            int btnIndex=gamePanelJP.getComponentZOrder(btn);
            gamePanelJP.add(btn,swapIndex);
            gamePanelJP.add(swapB,btnIndex);
            gamePanelJP.updateUI();
            
        }
        if(swapB==gamePanelJP.getComponentAt(btn.getX(),btn.getY()-btn.getHeight())){
            int swapIndex=gamePanelJP.getComponentZOrder(swapB);
            int btnIndex=gamePanelJP.getComponentZOrder(btn);
            gamePanelJP.add(btn,swapIndex);
            gamePanelJP.add(swapB,btnIndex);
            gamePanelJP.updateUI();
            
        }

        
        
   }
       
    public ImageIcon[] splitImage(Image img){
        ImageIcon[] splittedIcons = new ImageIcon[16];
            BufferedImage bi=new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g=bi.createGraphics();
            g.drawImage(img, 0, 0, null);
            int width = bi.getWidth();
            int height = bi.getHeight();
            int pos = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    img = bi.getSubimage(j * (width / 4), i * (height / 4), width / 4, height / 4).getScaledInstance(85, 55, 2);
                    splittedIcons[pos] = new ImageIcon();
                    splittedIcons[pos].setImage(img);
                    pos++;
                }
            }

        return splittedIcons;
    }
    
    private javax.swing.JButton swapB;
    private javax.swing.JButton[] buttons;
    private javax.swing.ImageIcon[] icon;
    private java.awt.Image img;
    private Timer timer;

    private javax.swing.JLabel closeJL;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel gamePanelJP;
    private javax.swing.JLabel helpJL;
    private javax.swing.JButton loadJB;
    private javax.swing.JButton playPauseJB;
    private javax.swing.JButton shuffleJB;
    private javax.swing.JButton startStopJB;
    private javax.swing.JTextField timeJL;
    private javax.swing.JPanel timerPanel;


    @Override
    public void actionPerformed(ActionEvent e) {
        move((JButton)e.getSource());
        check();
    }
}

