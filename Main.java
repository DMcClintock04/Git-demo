package com.company;


public class Main {
    int size = 10;
    int[][] Board = new int[size][size];
    double vo;
    String Path;
    int fin = 1000;

    public void pathVal(int x, int y, String z, int f){
        if(f>fin){
            vo = 0;
        }else if(String.valueOf(z).length() > (size * 1.5)){
            vo = 0;
        } else {
            if(x == (size - 1) && y == (size - 1)){
                    if (fin > f) {
                        fin = f;
                        Path = z;
                    }
            } else {
                if (x != (size - 1) && y != (size - 1)) { //down right
                    char add = 'c';
                    pathVal(x + 1, y + 1, z + add, f + Board[x][y]);
                }
                if (x != (size - 1)) { //right
                    char add = 'b';
                    pathVal(x + 1, y, z + add, f + Board[x][y]);
                }
                if (y != (size - 1)) { //down
                    char add = 'a';
                    pathVal(x, y + 1, z + add, f + Board[x][y]);
                }
                if (y != (size - 1) && x != 0) { //left down
                    char add = 'd';
                    pathVal(x - 1, y + 1, z + add, f + Board[x][y]);
                }
                if (y != 0 && x != (size - 1)) { //right up
                    char add = 'e';
                    pathVal(x + 1, y - 1, z + add, f + Board[x][y]);
                }
                if (x != 0) { //left
                    char add = 'h';
                    pathVal(x - 1, y, z + add, f + Board[x][y]);
                }
                if (y != 0 && x != 0) { //left up
                    char add = 'f';
                    pathVal(x - 1, y - 1, z + add, f + Board[x][y]);
                }
                if (y != 0) { //up
                    char add = 'g';
                    pathVal(x, y - 1, z + add, f + Board[x][y]);
                }
            }
        }
    }


    public void pathfindStr(int x, int y, String s, int m){
        int length = String.valueOf(s).length();
        if(m != length) {
            if(s.charAt(m) == 'e'){
                System.out.print(" (" + (x+1) + "," + (y-1) + ")");
                pathfindStr(x+1, y-1, s, m+1);
            } else if(s.charAt(m) == 'g'){
                System.out.print(" (" + (x) + "," + (y-1) + ")");
                pathfindStr(x, y-1, s, m+1);
            } else if(s.charAt(m) == 'f'){
                System.out.print(" (" + (x-1) + "," + (y-1) + ")");
                pathfindStr(x-1, y-1, s, m+1);
            } else if(s.charAt(m) == 'h'){
                System.out.print(" (" + (x-1) + "," + (y) + ")");
                pathfindStr(x-1, y, s, m+1);
            } else if(s.charAt(m) == 'd'){
                System.out.print(" (" + (x-1) + "," + (y+1) + ")");
                pathfindStr(x-1, y+1, s, m+1);
            }else if (s.charAt(m) == 'c') {
                System.out.print(" (" + (x + 1) + "," + (y + 1) + ")");
                pathfindStr(x + 1, y + 1, s, m + 1);
            } else if (s.charAt(m) == 'b') {
                System.out.print(" (" + (x + 1) + "," + (y) + ")");
                pathfindStr(x + 1, y, s, m + 1);
            } else if (s.charAt(m) == 'a') {
                System.out.print(" (" + (x) + "," + (y + 1) + ")");
                pathfindStr(x, y + 1, s, m + 1);
            }
        } else {
            System.out.print(" done");
        }
    }


    public Main(){
        for (int i = 0; i < size; i++){
            for (int f = 0; f < size; f++){
                Board[i][f] = (int)Math.floor(Math.random()*(101)+0);
            }
        }


        pathVal(0,0, "z", 0);
        System.out.print(fin + ", (0,0)");
        pathfindStr(0,0,Path,1);
    }



    public static void main(String[] args) {
        Main m = new Main();
    }


}
