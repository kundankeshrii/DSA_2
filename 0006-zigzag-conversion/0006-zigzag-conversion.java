class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 ||s.length()<=numRows) return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i]=new StringBuilder();
        }
        int curr=0;
        boolean goDown=true;
        for(char ch:s.toCharArray()){
            sb[curr].append(ch);
            if(curr==0) goDown=true;
            else if(curr==numRows-1) goDown=false;

            if(goDown){
                curr+=1;
            }else{
                curr-=1;
            }
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder row:sb){
            res.append(row);
        }
        return res.toString();
    }
}