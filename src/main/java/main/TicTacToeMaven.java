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
        public void addChar(int num0, int num1, Players A){
            if (this.field[num0][num1] == Players.emp){
                this.field[num0][num1] = A;
            }
        }
        public Players cleaner(int num0, int num1){
            this.field[num0][num1] = Players.emp;
            return this.field[num0][num1];
        }

        public Players getState(int num0, int num1){
            return this.field[num0][num1];
        }
        public int maxDiag(Players P){
            int counterD1 = 0;
            int counterD2 = 0;
            int max_lenght = 0;
            int kol = fieldSize;
            for (int count = 0; count < fieldSize; count++) {
                if (this.field[count][count] != null && this.field[count][count] == P){
                    ++counterD1;
                    max_lenght = Math.max(counterD1, max_lenght);
                }
                if (this.field[--kol][count] != null && this.field[kol][count] == P){
                    ++counterD2;
                    max_lenght = Math.max(counterD2, max_lenght);
                }
            }
            return max_lenght;
        }
        public int maxLenght(Players P){
            int max_lenght = 0;
            int counterH = 0;
            int counterV = 0;
            for (int row = 0; row < fieldSize; row++) {
                for (int col = 0; col < fieldSize; col++) {
                    if (this.field[row][col] != Players.emp && this.field[row][col] == P){
                        counterH++;
                        max_lenght = Math.max(counterH, max_lenght);
                    }
                    else counterH = 0;
                    if (this.field[col][row] != Players.emp && this.field[col][row] == P){
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
