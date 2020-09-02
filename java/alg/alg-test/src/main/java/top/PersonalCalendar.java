package top;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dmitry on 6/17/2015.
 */
public class PersonalCalendar {
    static public class Meeting {
        final Date start;
        final long duration;

        public Meeting(Date start, long duration) {
            this.start = start;
            this.duration = duration;
        }
    }

    public interface Schedule extends Iterator<Meeting>{};

    static public class ScheduleList implements Schedule {

        private final List<Meeting> list;
        private int pos = 0;
        private int prev = -1;

        public ScheduleList(List<Meeting> list) {
            if(list == null) throw new IllegalArgumentException("list cannot be null");
            this.list = list;
        }

        public boolean hasNext() {
            return pos < list.size();
        }

        public Meeting next() {
            if(pos < list.size()) {
                prev = pos;
                return list.get(pos++);
            }
            return null;
        }

        public void remove() {
            if(prev != -1) {
                list.remove(prev);
                prev = -1;
            }
        }
    }

    static public class ScheduleMerge implements Schedule {
        final List<Schedule> schedules;
        final Meeting[] meetings;
        int index = -1;

        public ScheduleMerge(List<Schedule> schedules) {
            if(schedules == null) throw new IllegalArgumentException("schedules cannot be null");
            this.schedules = schedules;
            meetings = new Meeting[schedules.size()];
            for(int i = 0; i < meetings.length; i++) {
                if(schedules.get(i).hasNext()) {
                    meetings[i] = schedules.get(i).next();
                    if (index == -1) {
                        index = i;
                    } else {
                        if(meetings[i].start.before(meetings[index].start)) {
                            index = i;
                        }
                    }
                }
            }
        }

        public boolean hasNext() {
            for(int i = 0; i < meetings.length; i++) {
                if(meetings[i] != null) return true;
            }
            return false;
        }

        public Meeting next() {
            if (index != -1) {
                Meeting m = meetings[index];
                long time = m.start.getTime() + m.duration;
                do {
                    meetings[index] = schedules.get(index).next();
                    index = -1;
                    for (int i = 0; i < meetings.length; i++) {
                        if (meetings[i] != null) {
                            if (index == -1) {
                                index = i;
                            } else {
                                if (meetings[i].start.before(meetings[index].start)) {
                                    index = i;
                                }
                            }
                        }
                    }
                    if (index == -1 || time < meetings[index].start.getTime())
                        return m;
                    time = meetings[index].start.getTime() + meetings[index].duration;
                    m = new Meeting(m.start, time - m.start.getTime());
                }while (true);
            }
            return null;
        }

        public void remove() {
            throw new UnsupportedOperationException("ScheduleMerge is readonly iterator");
        }
    }

    static public class ScheduleInverse implements Schedule {
        final private Schedule schedule;
        private Date start;
        private Meeting next = null;
        private boolean isNext = true;

        public ScheduleInverse(Date start, Schedule schedule) {
            if (schedule == null) throw new IllegalArgumentException("schedule cannot be null");
            this.schedule = schedule;
            if (schedule.hasNext()) {
                next = schedule.next();
                while (next != null && next.start.getTime() + next.duration < start.getTime()) {
                        //skip past meetings
                        next = schedule.next();
                }
                if (next != null && next.start.before(start)) {
                    start = new Date(next.start.getTime() + next.duration);
                    next = schedule.next();
                }
            }
            this.start = start;
        }

        public boolean hasNext() {
            return isNext;
        }

        public Meeting next() {
            if (!isNext)
                return null;
            if (next == null) {
                isNext = false;
                return new Meeting(start, Long.MAX_VALUE);
            } else {
                Meeting res = new Meeting(start, next.start.getTime() - start.getTime());
                start = new Date(next.start.getTime() + next.duration);
                next = schedule.next();
                return res;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("ScheduleInverse is readonly iterator");
        }
    }

    public Schedule merge(List<Schedule> schedules) {
        return new ScheduleMerge(schedules);
    }

    public Schedule availableMeetings(Date start, List<Schedule> schedules) {
        Schedule schedule = merge(schedules);
        return new ScheduleInverse(start, schedule);
    }
}
