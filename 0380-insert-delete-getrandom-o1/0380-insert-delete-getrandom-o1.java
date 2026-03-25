import java.util.*;
class RandomizedSet {
     HashMap<Integer,Integer>mpp;
     ArrayList<Integer>list; 
     Random rand;

    public RandomizedSet() {
        list=new ArrayList<>();
        mpp=new HashMap<>();
        rand=new Random();

    }
    public boolean insert(int val) {
        if(mpp.containsKey(val)){
           return false;
        }else{
            list.add(val);
           mpp.put(val,list.size()-1);
           return true;
        }
    }
    
    public boolean remove(int val) {
        if(mpp.containsKey(val)){
            int idx=mpp.get(val);//index mil gaya 
            int last=list.get(list.size()-1); //last index mil gaya 
            //aab swap kar lo 
            //in java you cannot swap directly
            list.set(idx,last);
            mpp.put(last,idx);
            list.remove(list.size()-1);
            mpp.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int randIdx=rand.nextInt(list.size());
        int val=list.get(randIdx);
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */