public class Array2 {
/*
* https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
* */
public static boolean canWin(int leap, int[] game) {

    return canJump(leap, game, 0);
}

    public static boolean canJump (int leap, int[] game, int index){
        //end of the array, auto win
        if(index >= game.length)
            return true;
        if (index <0 || game[index]==1) //negative index or value equal to one
            return false;
        //reach this point this cell is visited
        game[index] = 1;
        //iterate recursively for each possible scenario
        return canJump(leap, game,index+leap) ||
                canJump(leap, game, index+1)||
                canJump(leap, game, index-1);
    }


}
