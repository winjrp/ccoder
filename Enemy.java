import java.awt.Graphics;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Random;

class Enemy {
    private ImageIcon[] images;
    private int scale, direction, pointer;
    private Random random;
    public int[] selfPosition = { 0, 0 };
    private int[] tmpPosition = { 0, 0 };
    private Map map;
    private String state, type;
    private boolean walking;
    private int[] dirs = { 3, 3, 3, 4, 4, 4 };

    public Enemy(Map map, int scale, int mapRow, int mapColumn, String type) {
        this.images = new ImageIcon[6];
        this.type = type;
        if (this.type.equals("zombie")) {
            this.images[0] = new ImageIcon("src/enemy/a/stand/1.png");
            this.images[1] = new ImageIcon("src/enemy/a/stand/2.png");
            this.images[2] = new ImageIcon("src/enemy/a/stand/3.png");
            this.images[3] = new ImageIcon("src/enemy/a/stand/4.png");
            this.images[4] = new ImageIcon("src/enemy/a/stand/5.png");
            this.images[5] = new ImageIcon("src/enemy/a/stand/6.png");
        } else if (this.type.equals("snow_man")) {
            this.images[0] = new ImageIcon("src/enemy/b/stand/1.png");
            this.images[1] = new ImageIcon("src/enemy/b/stand/2.png");
            this.images[2] = new ImageIcon("src/enemy/b/stand/3.png");
            this.images[3] = new ImageIcon("src/enemy/b/stand/4.png");
            this.images[4] = new ImageIcon("src/enemy/b/stand/5.png");
            this.images[5] = new ImageIcon("src/enemy/b/stand/6.png");
        }
        this.random = new Random();
        this.map = map;
        this.scale = scale;
        this.selfPosition[0] = mapRow;
        this.selfPosition[1] = mapColumn;
        this.state = "live";
        this.walking = false;
        this.pointer = 0;
    }

    public void draw(Graphics g, int dir, int locationX, int locationY, int padX, int padY) {
        g.drawImage(this.images[dir].getImage(),
                (this.selfPosition[1] * this.scale) + locationX + (padX * this.selfPosition[0]),
                (this.selfPosition[0] * this.scale) + locationY - (padY * this.selfPosition[0]) - 143 + 50, null);
    }

    public void walk() {
        if (!this.walking && !this.state.equals("dead")) {
            // int dir = random.nextInt(5 - 1) + 1; // random 1-4
            // int dir = getRandom(this.dirs);
            int dir = this.dirs[this.pointer];
            this.pointer++;
            if (this.pointer > this.dirs.length - 1) {
                this.pointer = 0;
            }
            // int dir = 1;
            this.direction = dir;
            this.walking = true;
            Coder.frameC = 0;
            this.tmpPosition[0] = this.selfPosition[0];
            this.tmpPosition[1] = this.selfPosition[1];
            if (dir == 1 && collision(dir)) {
                this.tmpPosition[1]--;
            } else if (dir == 2 && collision(dir)) {
                this.tmpPosition[1]++;
            } else if (dir == 3 && collision(dir)) {
                this.tmpPosition[0]--;
            } else if (dir == 4 && collision(dir)) {
                this.tmpPosition[0]++;
            } else {
                // System.out.println("*** Sysntax error ***");
            }
            if (!this.state.equals("dead")) {
                this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
                this.map.setMap(this.selfPosition[0], this.selfPosition[1], '0');
            } else {
                this.map.setMap(this.tmpPosition[0], this.tmpPosition[1], '0');
            }
        } else {
            System.err.println("Enemy are dead");
        }
    }

    public void update() {
        this.map.setMap(this.selfPosition[0], this.selfPosition[1], '0');
        if (this.type.equals("zombie")) {
            this.selfPosition[0] = this.tmpPosition[0];
            this.selfPosition[1] = this.tmpPosition[1];
            this.map.setMap(this.selfPosition[0], this.selfPosition[1], '2');
        } else if (this.type.equals("snow_man")) {
            this.map.setMap(this.selfPosition[0], this.selfPosition[1], 'S');
        }
    }

    public boolean collision(int dir) {
        boolean bool = true;
        if (dir == 1) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] - 1) != '0') {
                bool = false;
            }
        } else if (dir == 2) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] + 1) != '0') {
                bool = false;
            }
        } else if (dir == 3) {
            if (this.map.checkMap(this.selfPosition[0] - 1, this.selfPosition[1]) != '0') {
                bool = false;
            }
        } else if (dir == 4) {
            if (this.map.checkMap(this.selfPosition[0] + 1, this.selfPosition[1]) != '0') {
                bool = false;
            }
        }
        return bool;
    }

    public boolean checkNextStep(int dir, char a) {
        boolean bool = false;
        if (dir == 1) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] - 1) == a) {
                bool = true;
            }
        } else if (dir == 2) {
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] + 1) == a) {
                bool = true;
            }
        } else if (dir == 3) {
            if (this.map.checkMap(this.selfPosition[0] - 1, this.selfPosition[1]) == a) {
                bool = true;
            }
        } else if (dir == 4) {
            if (this.map.checkMap(this.selfPosition[0] + 1, this.selfPosition[1]) == a) {
                bool = true;
            }
        }
        return bool;
    }

    public void attack(Player player) {
        if (this.type.equals("snow_man")) {
            System.out.println("Shoryuken!");
            if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] - 1) == '9') {
                this.map.setMap(this.selfPosition[0], this.selfPosition[1] - 1, '0');
                player.setState("dead");
                Coder.soundMedia.playSoundSingle("media/fire.wav");
                Coder.soundMedia.playSoundSingle("media/hit.wav");
            } else if (this.map.checkMap(this.selfPosition[0], this.selfPosition[1] - 1) != '0') {
                System.out.println("Have something front.");
            } else {
                this.map.setMap(this.selfPosition[0], this.selfPosition[1] - 1, 'F');
                Coder.soundMedia.playSoundSingle("media/fire.wav");
            }
        } else if (Coder.attackingEnemy) {
            System.out.println("Enemy are attacking");
        } else {
            System.out.println("Enemy are not Snow man");
        }
    }

    public void disable() {
        this.map.setMap(this.selfPosition[0], this.selfPosition[1], '0');
        this.selfPosition[0] = -99;
        this.state = "dead";
    }

    public void setEnemyDir(int[] a) {
        this.dirs = a;
    }

    public static int getRandom(int[] a) {
        int b = new Random().nextInt(a.length);
        return a[b];
    }

    public String getState() {
        return this.state;
    }

    public int getSelfRow() {
        return this.selfPosition[0];
    }

    public int getSelfColumn() {
        return this.selfPosition[1];
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int a) {
        this.direction = a;
    }

    public boolean getWalking() {
        return this.walking;
    }

    public void setWalking(boolean a) {
        this.walking = a;
    }

    public int[] getDirs() {
        return this.dirs;
    }

    public void setDirs(int[] a) {
        this.dirs = null;
        this.dirs = a;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String a) {
        this.type = a;
    }
}