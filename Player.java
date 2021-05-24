// Version 0.0.1

// import javax.swing.*;
// import java.awt.*;
import java.awt.Graphics;
// import java.awt.event.*;
// import java.applet.*;
// import java.util.*;
// import java.util.ArrayList;
// import java.util.StringTokenizer;
// import java.io.*;
// import java.awt.Graphics;
import javax.swing.ImageIcon;

class Player {
    private ImageIcon[] images;
    private int scale, treasure;
    public int[] selfPosition = { 0, 0 };
    private int[] tmpPosition = { 0, 0 };
    private int[] nextPosition = { 0, 0 };
    private Map map, mapTmp;
    private String state, stateTmp, mushroom, direction;
    private boolean walking, deading;

    public Player(Map map, Map mapTmp, int scale) {
        int i = 0;
        this.images = new ImageIcon[108];
        this.images[i] = new ImageIcon("src/hero/a/stand/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/stand/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/stand/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/stand/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/stand/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/stand/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/left/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/left/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/left/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/left/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/left/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/left/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/right/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/right/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/right/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/right/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/right/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/right/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/up/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/up/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/up/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/up/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/up/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/up/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/down/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/down/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/down/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/down/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/down/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/down/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/dead/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/dead/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/dead/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/dead/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/dead/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/a/dead/6.png");
        i++;

        this.images[i] = new ImageIcon("src/hero/b/stand/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/stand/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/stand/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/stand/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/stand/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/stand/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/left/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/left/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/left/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/left/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/left/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/left/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/right/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/right/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/right/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/right/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/right/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/right/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/up/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/up/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/up/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/up/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/up/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/up/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/down/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/down/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/down/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/down/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/down/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/down/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/dead/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/dead/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/dead/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/dead/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/dead/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/b/dead/6.png");
        i++;

        this.images[i] = new ImageIcon("src/hero/c/stand/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/stand/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/stand/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/stand/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/stand/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/stand/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/left/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/left/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/left/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/left/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/left/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/left/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/right/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/right/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/right/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/right/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/right/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/right/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/up/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/up/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/up/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/up/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/up/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/up/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/down/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/down/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/down/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/down/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/down/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/down/6.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/dead/1.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/dead/2.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/dead/3.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/dead/4.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/dead/5.png");
        i++;
        this.images[i] = new ImageIcon("src/hero/c/dead/6.png");

        this.map = map;
        this.mapTmp = mapTmp;
        this.scale = scale;
        this.treasure = 0;
        this.state = "live";
        this.stateTmp = "live";
        this.mushroom = "ryu";
        this.selfPosition[0] = this.map.findMap('9')[0];
        this.selfPosition[1] = this.map.findMap('9')[1];
        this.walking = false;
        this.deading = false;
    }

    public void draw(Graphics g, int dir, int locationX, int locationY, int padX, int padY) {
        g.drawImage(this.images[dir].getImage(),
                (this.selfPosition[1] * this.scale) + locationX + (padX * this.selfPosition[0]),
                (this.selfPosition[0] * this.scale) + locationY - (padY * this.selfPosition[0]) - 143 + 50, null);
    }

    public void walk(String dir) {
        if (!this.walking && !this.state.equals("dead")) {
            this.direction = dir;
            this.walking = true;
            Coder.frameA = 0;
            if (!this.state.equals("dead")) {
                this.tmpPosition[0] = this.selfPosition[0];
                this.tmpPosition[1] = this.selfPosition[1];
                this.nextPosition[0] = this.selfPosition[0];
                this.nextPosition[1] = this.selfPosition[1];
                if (dir.equals("left") && collision(dir)) {
                    this.tmpPosition[1]--;
                } else if (dir.equals("right") && collision(dir)) {
                    this.tmpPosition[1]++;
                } else if (dir.equals("up") && collision(dir)) {
                    this.tmpPosition[0]--;
                } else if (dir.equals("down") && collision(dir)) {
                    this.tmpPosition[0]++;
                } else {
                    System.out.println("*** Sysntax error ***");
                    if (checkNextStep(dir, '3')) {
                        if (this.mushroom.equals("mushroom_red")) {
                            this.map.setMap(this.nextPosition[0], this.nextPosition[1], '0');
                            this.map.setCountBomb(this.map.getCountBomb() - 1);
                        } else {
                            this.stateTmp = "dead";
                            this.deading = true;
                        }
                    } else if (checkNextStep(dir, 'Q') || checkNextStep(dir, '2') || checkNextStep(dir, 'S')) {
                        this.stateTmp = "dead";
                        this.deading = true;
                    }
                }
            } else {
                this.stateTmp = "dead";
                this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
                Coder.soundMedia.playSoundSingle("media/dead.wav");
                System.out.println("You are dead");
            }
        }
        Coder.direction = 0;
    }

    public void update() {
        this.map.setMap(this.selfPosition[0], this.selfPosition[1], '0');
        this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '9');
        this.selfPosition[0] = this.tmpPosition[0];
        this.selfPosition[1] = this.tmpPosition[1];
        this.state = this.stateTmp;
    }

    public boolean collision(String dir) {
        boolean bool = true;

        if (dir.equals("left")) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] - 1) != '0') {
                bool = false;
            }
            this.nextPosition[1]--;
        } else if (dir.equals("right")) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] + 1) != '0') {
                bool = false;
            }
            this.nextPosition[1]++;
        } else if (dir.equals("up")) {
            if (this.map.checkMap(this.selfPosition[0] - 1, this.selfPosition[1]) != '0') {
                bool = false;
            }
            this.nextPosition[0]--;
        } else if (dir.equals("down")) {
            if (this.map.checkMap(this.selfPosition[0] + 1, this.selfPosition[1]) != '0') {
                bool = false;
            }
            this.nextPosition[0]++;
        }
        checkStep(dir);
        return bool;
    }

    public String CheckErrorDir(String dir) {
        String checkerror = "error";
        if (dir.equals("left")) {
            checkerror = "no error";
            return checkerror;
        }

        else if (dir.equals("right")) {
            checkerror = "no error";
            return checkerror;

        }

        else if (dir.equals("up")) {
            checkerror = "no error";
            return checkerror;

        }

        else if (dir.equals("down")) {
            checkerror = "no error";
            return checkerror;
        }

        else {
            return checkerror;
        }
    }

    public void checkStep(String dir) {
        if (checkNextStep(dir, '8')) {
            this.stateTmp = "next";
            Coder.soundMedia.playSoundSingle("media/next.wav");
        } else if (checkNextStep(dir, '7')) {
            this.map.setMap(this.nextPosition[0], this.nextPosition[1], '0');
            this.nextPosition[0] = this.map.findMap('6')[0];
            this.nextPosition[1] = this.map.findMap('6')[1];
            this.tmpPosition[0] = this.nextPosition[0];
            this.tmpPosition[1] = this.nextPosition[1];
            this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
            this.map.setMap(this.selfPosition[0], this.selfPosition[1], '9');
            Coder.soundMedia.playSoundSingle("media/portal.wav");
        } else if (checkNextStep(dir, '6')) {
            this.map.setMap(this.nextPosition[0], this.nextPosition[1], '0');
            this.nextPosition[0] = this.map.findMap('7')[0];
            this.nextPosition[1] = this.map.findMap('7')[1];
            this.tmpPosition[0] = this.nextPosition[0];
            this.tmpPosition[1] = this.nextPosition[1];
            this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
            this.map.setMap(this.selfPosition[0], this.selfPosition[1], '9');
            Coder.soundMedia.playSoundSingle("media/portal.wav");
        } else if (checkNextStep(dir, '5')) {
            this.tmpPosition[0] = this.nextPosition[0];
            this.tmpPosition[1] = this.nextPosition[1];
            // this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
            // this.map.setMap(this.selfPosition[0], this.selfPosition[1], '9');
            Coder.soundMedia.playSoundSingle("media/mushroom.wav");
            this.mushroom = "mushroom_yellow";
        } else if (checkNextStep(dir, 'A')) {
            this.tmpPosition[0] = this.nextPosition[0];
            this.tmpPosition[1] = this.nextPosition[1];
            this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
            this.map.setMap(this.selfPosition[0], this.selfPosition[1], '9');
            Coder.soundMedia.playSoundSingle("media/mushroom.wav");
            this.mushroom = "mushroom_red";
        } else if (checkNextStep(dir, 'T')) {
            for (int i = 0; i < Coder.treasures.size(); i++) {
                if (Coder.treasures.get(i).checkNextStep(invDir(dir), '9')) {
                    this.tmpPosition[0] = this.nextPosition[0];
                    this.tmpPosition[1] = this.nextPosition[1];
                    this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
                    this.map.setMap(this.selfPosition[0], this.selfPosition[1], '9');
                    Coder.soundMedia.playSoundSingle("media/treasure.wav");
                    this.treasure += 50;
                    Coder.treasures.remove(i);
                }
            }
        }
    }

    public String invDir(String dir) {
        String invDir = "";
        if (dir.equals("left")) {
            invDir = "right";
        } else if (dir.equals("right")) {
            invDir = "left";
        } else if (dir.equals("up")) {
            invDir = "down";
        } else if (dir.equals("down")) {
            invDir = "up";
        }
        return invDir;
    }

    public boolean checkNextStep(String dir, char a) {
        boolean bool = false;
        if (dir.equals("left")) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] - 1) == a) {
                bool = true;
            }
        } else if (dir.equals("right")) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] + 1) == a) {
                bool = true;
            }
        } else if (dir.equals("up")) {
            if (this.map.checkMap(this.selfPosition[0] - 1, this.selfPosition[1]) == a) {
                bool = true;
            }
        } else if (dir.equals("down")) {
            if (this.map.checkMap(this.selfPosition[0] + 1, this.selfPosition[1]) == a) {
                bool = true;
            }
        }
        return bool;
    }

    public void attack() {
        if (this.mushroom.equals("mushroom_yellow") && !Coder.attacking) {
            System.out.println("Hadouken!");
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] + 1) == '2') {
                this.map.setMap(this.selfPosition[0], this.selfPosition[1] + 1, '0');
                for (int i = 0; i < Coder.enemys.size(); i++) {
                    if (Coder.enemys.get(i).checkNextStep(1, '9')) {
                        Coder.enemys.get(i).disable();
                        Coder.enemys.remove(i);
                    }
                }
                Coder.soundMedia.playSoundSingle("media/fire.wav");
                Coder.soundMedia.playSoundSingle("media/hit.wav");
            } else if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] + 1) != '0') {
                System.out.println("Have something front.");
            } else {
                this.map.setMap(this.selfPosition[0], this.selfPosition[1] + 1, '4');
                Coder.soundMedia.playSoundSingle("media/fire.wav");
            }
        } else if (Coder.attacking) {
            System.out.println("You are attacking");
        } else {
            System.out.println("You are not Ken");
        }
    }

    public void search(String dir) {
        Coder.creating = true;
        if (checkNextStep(dir, 'Q')) {
            System.out.println(dir);
            if (dir.equals("left")) {
                this.map.setMap(this.selfPosition[0], this.selfPosition[1] - 1, 'T');
            } else if (dir.equals("right")) {
                this.map.setMap(this.selfPosition[0], this.selfPosition[1] + 1, 'T');
            } else if (dir.equals("up")) {
                this.map.setMap(this.selfPosition[0] - 1, this.selfPosition[1], 'T');
            } else if (dir.equals("down")) {
                this.map.setMap(this.selfPosition[0] + 1, this.selfPosition[1], 'T');
            }
        } else {
            System.out.println("Not treasure right there");
        }
    }

    public void build(int x, int y) {
        this.map.setMap(x, y, '3');
        this.mapTmp.setMap(x, y, '3');
        Coder.firstMake = true;
    }

    public int getMushroomNumber() {
        if (this.mushroom.equals("mushroom_yellow")) {
            return 1;
        } else if (this.mushroom.equals("mushroom_red")) {
            return 2;
        } else {
            return 0;
        }
    }

    public String getState() {
        return this.state;
    }

    public void setState(String a) {
        this.state = a;
    }

    public String getStateTmp() {
        return this.stateTmp;
    }

    public void setStateTmp(String a) {
        this.stateTmp = a;
    }

    public String getMushroom() {
        return this.mushroom;
    }

    public void setMushroom(String a) {
        this.mushroom = a;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String a) {
        this.direction = a;
    }

    public int getTreasure() {
        return this.treasure;
    }

    public void setTreasure(int a) {
        this.treasure = a;
    }

    public boolean getWalking() {
        return this.walking;
    }

    public void setWalking(boolean a) {
        this.walking = a;
    }

    public boolean getDeading() {
        return this.deading;
    }

    public void setDeading(boolean a) {
        this.deading = a;
    }
}