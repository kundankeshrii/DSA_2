class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[]months={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[]arr=new int[12];
        int sum=0;
        for(int i=0;i<months.length;i++){
            sum+=months[i];
            arr[i]=sum;
        }
        
        int month1= Integer.parseInt(arriveAlice.substring(0,2));
        int a=Integer.parseInt(arriveAlice.substring(3,5));
        int days1=arr[month1-1]-months[month1-1]+a;


        int month2=Integer.parseInt(arriveBob.substring(0,2));
        int b=Integer.parseInt(arriveBob.substring(3,5));
        int days2=arr[month2-1]-months[month2-1]+b;

        int maxi=Math.max(days1,days2);
 
        int month3= Integer.parseInt(leaveAlice.substring(0,2));

        int c=Integer.parseInt(leaveAlice.substring(3,5));
        int days3=arr[month3-1]-months[month3-1]+c;

        int month4=Integer.parseInt(leaveBob.substring(0,2));

        int d=Integer.parseInt(leaveBob.substring(3,5));
        int days4=arr[month4-1]-months[month4-1]+d;
        
        int mini=Math.min(days3,days4);

        return Math.max(0,mini-maxi+1);  

    }
}