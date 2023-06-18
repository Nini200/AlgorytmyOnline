package Lists;

import java.util.ArrayList;

public class ListTranspose implements IList{
    ArrayList<Integer> list = new ArrayList<>();
    public int access(int number) {
        for (int i = 0 ; i<list.size(); i++){
            if(list.get(i) == number){
                if(i>0){
                    list.remove(i);
                    list.add(i-1, number);
                }
                return i+1;
            }
        }
        list.add(number);
        return list.size()-1;
    }

    @Override
    public void clear() {
        list.clear();
    }

    public void print(){
        System.out.print(list);
    }
}
