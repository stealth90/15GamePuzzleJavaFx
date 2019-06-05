package sample;

import java.util.*;

public class Grid {
    public int[][] gridOfGame;
    public Integer[] randomNumbers;
    public int[] emptyCell;


    public void shuffleGrid(){
        this.gridOfGame=new int[4][4];
        Random rand = new Random();
        randomNumbers= new Integer[16];
        int counter=0;
        int numberControl=1;
        int position=0;
        for(int r=0;r<randomNumbers.length; ){
            int randomNumber=rand.nextInt(16);
            if(r==0) {
                randomNumbers[r]=randomNumber;
                r++;
            }
            else{
                for(int j=0;j<numberControl;j++){
                    if(randomNumber!=randomNumbers[j]){
                        ++counter;
                    }
                }
                if(counter==numberControl){
                    randomNumbers[r]=randomNumber;
                    r++;
                    ++numberControl;
                }
            }
            counter=0;
        }
        for(int i =0;i<gridOfGame.length;i++){
            for(int j=0; j<gridOfGame[i].length;j++){
                gridOfGame[i][j]=randomNumbers[position];
                ++position;
            }
        }
        getEmptyCell();
    }

    public Grid() { shuffleGrid();}

    public int[] getEmptyCell(){
        emptyCell = new int[2];
        for( int i=0; i< 4 ; i++){
            for(int j=0; j<4 ; j++)
                if(this.gridOfGame[i][j]==0){
                    emptyCell[0]=i;
                    emptyCell[1]=j;
                }
        }
        return emptyCell;
    }

    public void swipe(int direction){
        int[]emptyCell= getEmptyCell();
        if(direction == 6) {
            if (emptyCell[1] == 3) {
                System.out.println("CAN'T DO THIS MOVE TO THE RIGHT");
                return ;
            }
            else {
                int temp = gridOfGame[emptyCell[0]][emptyCell[1] + 1];
                gridOfGame[emptyCell[0]][emptyCell[1] + 1] = 0;
                gridOfGame[emptyCell[0]][emptyCell[1]] = temp;
            }
        }
        else if(direction==4){
            if (emptyCell[1] == 0){
                System.out.println("CAN'T DO THIS MOVE TO THE LEFT");
                return;
            }
            else {
                int temp = gridOfGame[emptyCell[0]][emptyCell[1] - 1];
                gridOfGame[emptyCell[0]][emptyCell[1] - 1] = 0;
                gridOfGame[emptyCell[0]][emptyCell[1]] = temp;
            }
        }
        else if(direction==2){
            if (emptyCell[0] == 3) {
                System.out.println("CAN'T DO THIS MOVE TO DOWN");
                return;
            }
            else {
                int temp = gridOfGame[emptyCell[0] + 1][emptyCell[1]];
                gridOfGame[emptyCell[0] + 1][emptyCell[1]] = 0;
                gridOfGame[emptyCell[0]][emptyCell[1]] = temp;
            }
        }
        else if(direction==8){
            if (emptyCell[0] == 0){
                System.out.println("CAN'T DO THIS MOVE TO UP");
                return;
            }
            else {
                int temp = gridOfGame[emptyCell[0] - 1][emptyCell[1]];
                gridOfGame[emptyCell[0] - 1][emptyCell[1]] = 0;
                gridOfGame[emptyCell[0]][emptyCell[1]] = temp;
                win();
            }
        }
    }


    public boolean win(){
        int [][] gridCompare= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        int counter=0;
        for(int i=0;i<gridCompare.length;i++){
            for(int j=0;j<gridCompare[i].length;j++){
                if(gridOfGame[i][j]!=gridCompare[i][j]) return false;
                ++counter;
                if(counter==16)return true;
            }
        }
        return false;
    }


}