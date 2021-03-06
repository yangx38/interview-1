package hatecode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MeetingRooms
 * Creator : duqiang
 * Date : Agu, 2018
 * Description : 252. Meeting Rooms
 */
public class MeetingRooms {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings.

     For example,
     Given [[0, 30],[5, 10],[15, 20]],
     return false.

     time : O(nlogn)
     space : O(1)

     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        //if input is null or only 1 schedule then it is true
        if (intervals == null || intervals.length < 2) return true;
        // this is good, so we can sort by object easily, also PriorityQueue has similiar function
        // so we sort by start first, then if end has overlap then we cannot attend all meetings
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i <intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
