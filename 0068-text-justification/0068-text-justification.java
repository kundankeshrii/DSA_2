class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        List<String>list=new ArrayList<>();
        int i=0;
        while(i<n){
            int k=i;
            int currWidth=0;
            while(k<n && currWidth+words[k].length()+(k-i)<=maxWidth ){
                currWidth+=words[k++].length();
            }
            int gaps=k-i-1;
            StringBuilder sb=new StringBuilder();
            if(gaps==0 || k==n){
                for(int j=i;j<k;j++){
                    sb.append(words[j]);
                    if(j!=k-1) sb.append(" ");
                }
                int remaining=maxWidth-(sb.length());
                while(remaining-- >0) sb.append(" ");
                // sb.append(" ".repeat(remaining));
            }else{
                int totalSpaces =maxWidth-currWidth;
                int spacePerGap =totalSpaces/gaps;
                int extraSpace=totalSpaces % gaps;
                for(int j=i;j<k;j++){
                    sb.append(words[j]);
                    if(j!=k-1){
                        int spacesToApply=spacePerGap+(extraSpace-- >0 ?1:0);
                        while(spacesToApply-- >0) sb.append(" ");
                    }
                }
            }
            list.add(sb.toString());
            i=k;
        }
           return list;
    }
}