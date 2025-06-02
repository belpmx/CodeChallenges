package problemSolving;

public class CommonChild {
    class Result {

        /*
         * Complete the 'commonChild' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING s1
         *  2. STRING s2
         */

        public static int commonChild(String s1, String s2) {
            //Solved by dynamic programing
            //extra space is base scenarios at
            int  [][] table = new int[s1.length()+1][s2.length()+1];
            for (int i =0; i<= s1.length();i++){
                for(int j=0; j<=s2.length(); j++){
                    //fill  diagonal for base scenario
                    if(i==0||j==0){
                        table[i][j] =0;
                    }
                    else if(s1.charAt(i-1)==s2.charAt(j-1)){
                        //fill the diagonal plus one
                        table[i][j] = table[i-1][j-1]+1;
                    }
                    else {
                        //take max value from cell above table[i-1][j]
                        //or cell on left table[i][j-1]
                        table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                    }
                }//end for j
            }//end for i
            //return the last value of the diagonal
            return table[s1.length()][s2.length()];
        }

    }


}
