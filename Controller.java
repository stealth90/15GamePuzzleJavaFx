package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class Controller{

    private Grid gridGames;
    private Label zeroLabel;
    private boolean win=true;

    @FXML
    private GridPane gridPane;



    @FXML
    void newGame(ActionEvent event) {
        gridGames = new Grid();
        getZeroLabel();
        addLabel();
    }

    @FXML
    void test(){
        int counter=1;
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                gridGames.gridOfGame[i][j]=counter++;
            }
        }
        counter=1;
        for(Node i: gridPane.getChildren()){
            if( i instanceof Label) ((Label) i).setText(String.valueOf(counter++));
        }

        win();
    }


    @FXML
    void swapCell(KeyEvent event) {
        getZeroLabel();
        if(event.getCode()== KeyCode.UP){
            if (gridGames.emptyCell[0] == 0){
                System.out.println("CAN'T DO THIS MOVE TO UP");
            }
            else {
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]-1))).setText("");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]-1))).getStyleClass().add("one");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]-1))).getStyleClass().remove("cellNumber");
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).setText((String.valueOf(gridGames.gridOfGame[gridGames.emptyCell[0]-1][gridGames.emptyCell[1]])));
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().remove("one");
                int temp = gridGames.gridOfGame[gridGames.emptyCell[0] - 1][gridGames.emptyCell[1]];
                gridGames.gridOfGame[gridGames.emptyCell[0]-1][gridGames.emptyCell[1]]=0;
                gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]] = temp;
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().add("cellNumber");
                gridGames.emptyCell[0] = gridGames.emptyCell[0]-1;
                win();
            }
        }
        else if(event.getCode()== KeyCode.RIGHT){
            if (gridGames.emptyCell[1] == 3) {
                System.out.println("CAN'T DO THIS MOVE TO THE RIGHT");
            }
            else {
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1]+1,gridGames.emptyCell[0]))).setText("");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1]+1,gridGames.emptyCell[0]))).getStyleClass().add("one");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1]+1,gridGames.emptyCell[0]))).getStyleClass().remove("cellNumber");
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).setText((String.valueOf(gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]+1])));
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().remove("one");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().add("cellNumber");
                int temp = gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]+1];
                gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]+1]=0;
                gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]] = temp;
                gridGames.emptyCell[1] = gridGames.emptyCell[1]+1;
                win();
            }
        }
        else if(event.getCode()== KeyCode.DOWN){
            if (gridGames.emptyCell[0] == 3) {
                System.out.println("CAN'T DO THIS MOVE TO DOWN");
            }
            else {
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]+1))).setText("");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]+1))).getStyleClass().add("one");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]+1))).getStyleClass().remove("cellNumber");
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).setText((String.valueOf(gridGames.gridOfGame[gridGames.emptyCell[0]+1][gridGames.emptyCell[1]])));
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().remove("one");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().add("cellNumber");
                int temp = gridGames.gridOfGame[gridGames.emptyCell[0] + 1][gridGames.emptyCell[1]];
                gridGames.gridOfGame[gridGames.emptyCell[0]+1][gridGames.emptyCell[1]]=0;
                gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]] = temp;
                gridGames.emptyCell[0] = gridGames.emptyCell[0]+1;
                win();
            }
        }
        else if(event.getCode()== KeyCode.LEFT){
            if (gridGames.emptyCell[1] == 0){
                System.out.println("CAN'T DO THIS MOVE TO THE LEFT");
            }
            else {
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1]-1,gridGames.emptyCell[0]))).setText("");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1]-1,gridGames.emptyCell[0]))).getStyleClass().add("one");
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1]-1,gridGames.emptyCell[0]))).getStyleClass().remove("cellNumber");
                ((Label) gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).setText((String.valueOf(gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]-1])));
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().remove("one");
                int temp = gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]-1];
                gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]-1]=0;
                gridGames.gridOfGame[gridGames.emptyCell[0]][gridGames.emptyCell[1]] = temp;
                (gridPane.getChildren().get(getIndex(gridGames.emptyCell[1],gridGames.emptyCell[0]))).getStyleClass().add("cellNumber");
                gridGames.emptyCell[1] = gridGames.emptyCell[1]-1;
                win();
            }
        }
    }

    private void addLabel(){
        int counter=0;
        zeroLabel.getStyleClass().remove("one");
        zeroLabel.getStyleClass().add("cellNumber");
        for (Node i:gridPane.getChildren())
            {   if(i instanceof Label){
                 if (gridGames.randomNumbers[counter].toString().equals("0")){
                     ((Label) i).setText("");
                     i.getStyleClass().remove("cellNumber");
                     i.getStyleClass().add("one");
                     counter++;
                 }
                 else{
                     ((Label) i).setText(gridGames.randomNumbers[counter++].toString());
                     ((Label) i).getStyleClass().remove("cellNumber");
                     ((Label) i).getStyleClass().add("cellNumber");
                 }
                }
        }
    }
    public void getZeroLabel() {
        for (Node i : gridPane.getChildren()) {
            if (i instanceof Label) {
                if (((Label) i).getText().equals("")){
                    zeroLabel = (Label) i;
                    zeroLabel.setFocusTraversable(true);
                    break;
                }
            }
        }
    }


    public int getIndex(int column, int row){
        return row*4+column;
    }

    public void win(){
        int [][] gridCompare= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int counter=0;
        for(int i=0;i<gridCompare.length;i++){
            for(int j=0;j<gridCompare[i].length;j++){
                if(gridGames.gridOfGame[i][j]!=gridCompare[i][j]) return;
                ++counter;
                if(counter==16){
                    String wordVictory="You Won !       ";
                    int position=0;
                    for(Node node: gridPane.getChildren()){
                        if(node instanceof Label){
                            ((Label) node).setText(wordVictory.substring(position,++position));
                        }
                    }
                }
            }
        }
    }
}
