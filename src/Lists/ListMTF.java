package Lists;

import java.util.ArrayList;

public class ListMTF implements IList{
    ArrayList<Integer> list = new ArrayList<>();

    public int access(int number) {
        for (int i = 0 ; i<list.size(); i++){
            if(list.get(i) == number){
                list.remove(i);
                list.add(0, number);
                return i+1;
            }
        }
        list.add(0, number);
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
