class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle=minutes*6;
        double hourAngle=(hour%12)*30+minutes*0.5;
        double diff=(hourAngle-minuteAngle);
        if(diff<0){
            diff=diff*(-1);
        }
        return Math.min(diff,360-diff);
    }
}