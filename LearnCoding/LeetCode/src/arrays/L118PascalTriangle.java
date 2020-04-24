package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L118PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            if(i == 0){
                temp.add(1);
                continue;
            }
            List<Integer> last = result.get(i-1);
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(last.get(j)+last.get(j-1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}
