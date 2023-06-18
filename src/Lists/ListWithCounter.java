package Lists;

import java.util.ArrayList;
import java.util.Comparator;

public class ListWithCounter implements IList{
    private class IntWithCount{
        int number;
        int count;

        IntWithCount(int number){
            this.number = number;
            this.count = 0;
        }

        void update(){
            this.count ++;
        }
    }
    ArrayList<IntWithCount> list = new ArrayList<>();

    public int access(int number) {
        for (int i = 0 ; i<list.size(); i++){
            if(list.get(i).number == number){
                list.get(i).update();
                list.sort((o1, o2) -> - Integer.compare(o1.count, o2.count));
                return i+1;
            }
        }
        list.add(new IntWithCount(number));
        return list.size()-1;
    }

    @Override
    public void clear() {
        list.clear();
    }

    public void print(){
        for (IntWithCount ic : list) {
            System.out.print("("+ic.number + "," + ic.count + "), ");
        }
    }
}
