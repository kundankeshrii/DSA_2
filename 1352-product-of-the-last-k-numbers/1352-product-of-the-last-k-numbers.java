class ProductOfNumbers {
    List<Integer>list;
    int idx;

    public ProductOfNumbers() {
        list=new ArrayList<>();
        idx=0;
    }
    
    public void add(int num) {
        list.add(num);
        idx++;
        
    }
    
    public int getProduct(int k) {
        int prod=1;
        for(int i=idx-1;i>=idx-k;i--){
            prod=prod*list.get(i);
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */