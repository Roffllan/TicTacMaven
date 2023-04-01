package main;
public class TicTacToeMaven {
    public static class GameXO {
        private final int fieldSize;
        private final Players[][] field;
        public enum Players{
            X , O, emp
        }


        public GameXO(int fieldSize){
            this.fieldSize =fieldSize;
            this.field = new Players[fieldSize][fieldSize];
            for (int i = 0; i < fieldSize; i++){
                for(int j = 0; j < fieldSize; j++){
                    this.field[i][j] = Players.emp;
                }
            }

        }
        public void addCharX(int num0, int num1){
            if (this.field[num0][num1] == Players.emp){
                this.field[num0][num1] = Players.X;
            }
        }
        public void addCharO(int num0, int num1){
            if (this.field[num0][num1] == Players.emp){
                this.field[num0][num1] = Players.O;
            }
        }
        public Players cleaner(int num0, int num1){
            this.field[num0][num1] = Players.emp;
            return this.field[num0][num1];
        }

        public Players getState(int num0, int num1){
            return this.field[num0][num1];
        }
        public int maxXDiag(){
            int max_lenght = 0;
            int counterD1 = 0;
            int counterD2 = 0;
            int kol = fieldSize;
            for (int count = 0; count < fieldSize; count++) {
                if (this.field[count][count] != Players.emp && this.field[count][count] == Players.X){
                    ++counterD1;
                    max_lenght = Math.max(counterD1, max_lenght);
                }
                if (this.field[--kol][count] != Players.emp && this.field[kol][count] == Players.X){
                    ++counterD2;
                    max_lenght = Math.max(counterD2, max_lenght);
                }
            }
            return max_lenght;
        }
        public int maxODiag(){
            int counterD1 = 0;
            int counterD2 = 0;
            int max_lenght = 0;
            int kol = fieldSize;
            for (int count = 0; count < fieldSize; count++) {
                if (this.field[count][count] != null && this.field[count][count] == Players.O){
                    ++counterD1;
                    max_lenght = Math.max(counterD1, max_lenght);
                }
                if (this.field[--kol][count] != null && this.field[kol][count] == Players.O){
                    ++counterD2;
                    max_lenght = Math.max(counterD2, max_lenght);
                }
            }
            return max_lenght;
        }
        public int maxX(){
            int max_lenght = 0;
            int counterH = 0;
            int counterV = 0;
            for (int row = 0; row < fieldSize; row++) {
                for (int col = 0; col < fieldSize; col++) {
                    if (this.field[row][col] != Players.emp && this.field[row][col] == Players.X){
                        counterH++;
                        max_lenght = Math.max(counterH, max_lenght);
                    }
                    else counterH = 0;
                    if (this.field[col][row] != Players.emp && this.field[col][row] == Players.X){
                        counterV++;
                        max_lenght = Math.max(counterV, max_lenght);
                    }
                    else counterV = 0;
                }
            }
            return max_lenght;
        }
        public int maxO(){
            int max_lenght = 0;
            int counterH = 0;
            int counterV = 0;
            for (int row = 0; row < fieldSize; row++) {
                for (int col = 0; col < fieldSize; col++) {
                    if (this.field[row][col] != Players.emp && this.field[row][col]== Players.O){
                        counterH++;
                        max_lenght = Math.max(counterH, max_lenght);
                    }
                    else counterH = 0;
                    if (this.field[col][row] != Players.emp && this.field[col][row] == Players.O){
                        counterV++;
                        max_lenght = Math.max(counterV, max_lenght);
                    }
                    else counterV = 0;
                }
            }
            return max_lenght;

        }
    }

}
