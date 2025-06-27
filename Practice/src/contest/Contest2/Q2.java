package Practice.src.contest.Contest2;

public class Q2 {

    public static void main(String[] args) {

        Q2 q2 = new Q2();
        int[] startTime = new int[]{1,3};
        int[] endTime = new int[]{2,5};
        int ans = q2.maxFreeTime(5, 1, startTime, endTime);
        System.out.println(ans);
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int n = startTime.length;
        int maxDiff = startTime[0];
        int meetingId = 0;
        for (int i = 1; i < n; i++) {
            if (maxDiff < startTime[i] - endTime[i - 1]) {
                maxDiff = startTime[i] - endTime[i - 1];
                meetingId = i;
            }
        }
        if (maxDiff < eventTime - endTime[n - 1]) {
            maxDiff = eventTime - endTime[n - 1];
            meetingId =  n - 1;
        }
        int totalDuration = 0;
        while (k > 0 && meetingId >= 0) {
            totalDuration += endTime[meetingId] - startTime[meetingId];
            meetingId--;
            k--;
        }
        if (meetingId >= 0) {
            totalDuration += endTime[meetingId];
        }
        return eventTime - totalDuration;
    }
}
