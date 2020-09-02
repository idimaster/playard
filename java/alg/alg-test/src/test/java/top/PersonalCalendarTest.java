package top;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 6/17/2015.
 */
public class PersonalCalendarTest {
    @Test
    public void merge() {
        ArrayList<PersonalCalendar.Meeting> l1 = new ArrayList<PersonalCalendar.Meeting>();
        l1.add(new PersonalCalendar.Meeting(new Date(1000), 600));
        l1.add(new PersonalCalendar.Meeting(new Date(2000), 500));
        l1.add(new PersonalCalendar.Meeting(new Date(3000), 400));
        ArrayList<PersonalCalendar.Meeting> l2 = new ArrayList<PersonalCalendar.Meeting>();
        l2.add(new PersonalCalendar.Meeting(new Date(1010), 600));
        l2.add(new PersonalCalendar.Meeting(new Date(2020), 500));
        l2.add(new PersonalCalendar.Meeting(new Date(2990), 400));
        l2.add(new PersonalCalendar.Meeting(new Date(4000), 300));
        PersonalCalendar.ScheduleList sl1 = new PersonalCalendar.ScheduleList(l1);
        PersonalCalendar.ScheduleList sl2 = new PersonalCalendar.ScheduleList(l2);
        List<PersonalCalendar.Schedule> list = new ArrayList<PersonalCalendar.Schedule>();
        list.add(sl1);
        list.add(sl2);
        PersonalCalendar.Schedule s = new PersonalCalendar().merge(list);
        assertTrue(s.hasNext());
        PersonalCalendar.Meeting m = s.next();
        assertNotNull(m);
        assertEquals(1000, m.start.getTime());
        assertEquals(610, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(2000, m.start.getTime());
        assertEquals(520, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(2990, m.start.getTime());
        assertEquals(410, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(4000, m.start.getTime());
        assertEquals(300, m.duration);
        assertFalse(s.hasNext());
        m = s.next();
        assertNull(m);
    }

    @Test
    public void schedule() {
        ArrayList<PersonalCalendar.Meeting> l1 = new ArrayList<PersonalCalendar.Meeting>();
        l1.add(new PersonalCalendar.Meeting(new Date(1000), 600));
        l1.add(new PersonalCalendar.Meeting(new Date(2000), 500));
        l1.add(new PersonalCalendar.Meeting(new Date(3000), 400));
        ArrayList<PersonalCalendar.Meeting> l2 = new ArrayList<PersonalCalendar.Meeting>();
        l2.add(new PersonalCalendar.Meeting(new Date(1010), 600));
        l2.add(new PersonalCalendar.Meeting(new Date(2020), 500));
        l2.add(new PersonalCalendar.Meeting(new Date(2990), 400));
        l2.add(new PersonalCalendar.Meeting(new Date(4000), 300));
        PersonalCalendar.ScheduleList sl1 = new PersonalCalendar.ScheduleList(l1);
        PersonalCalendar.ScheduleList sl2 = new PersonalCalendar.ScheduleList(l2);
        List<PersonalCalendar.Schedule> list = new ArrayList<PersonalCalendar.Schedule>();
        list.add(sl1);
        list.add(sl2);
        PersonalCalendar.Schedule s = new PersonalCalendar().availableMeetings(new Date(500), list);
        assertTrue(s.hasNext());
        PersonalCalendar.Meeting m = s.next();
        assertNotNull(m);
        assertEquals(500, m.start.getTime());
        assertEquals(500, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(1610, m.start.getTime());
        assertEquals(390, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(2520, m.start.getTime());
        assertEquals(470, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(3400, m.start.getTime());
        assertEquals(600, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(4300, m.start.getTime());
        assertEquals(Long.MAX_VALUE, m.duration);
        assertFalse(s.hasNext());
        m = s.next();
        assertNull(m);
    }

    @Test
    public void schedule2() {
        ArrayList<PersonalCalendar.Meeting> l1 = new ArrayList<PersonalCalendar.Meeting>();
        l1.add(new PersonalCalendar.Meeting(new Date(1000), 600));
        l1.add(new PersonalCalendar.Meeting(new Date(2000), 500));
        l1.add(new PersonalCalendar.Meeting(new Date(3000), 400));
        ArrayList<PersonalCalendar.Meeting> l2 = new ArrayList<PersonalCalendar.Meeting>();
        l2.add(new PersonalCalendar.Meeting(new Date(1010), 600));
        l2.add(new PersonalCalendar.Meeting(new Date(2020), 500));
        l2.add(new PersonalCalendar.Meeting(new Date(2990), 400));
        l2.add(new PersonalCalendar.Meeting(new Date(4000), 300));
        PersonalCalendar.ScheduleList sl1 = new PersonalCalendar.ScheduleList(l1);
        PersonalCalendar.ScheduleList sl2 = new PersonalCalendar.ScheduleList(l2);
        List<PersonalCalendar.Schedule> list = new ArrayList<PersonalCalendar.Schedule>();
        list.add(sl1);
        list.add(sl2);
        PersonalCalendar.Schedule s = new PersonalCalendar().availableMeetings(new Date(1200), list);
        assertTrue(s.hasNext());
        PersonalCalendar.Meeting m = s.next();
        assertNotNull(m);
        assertEquals(1610, m.start.getTime());
        assertEquals(390, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(2520, m.start.getTime());
        assertEquals(470, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(3400, m.start.getTime());
        assertEquals(600, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(4300, m.start.getTime());
        assertEquals(Long.MAX_VALUE, m.duration);
        assertFalse(s.hasNext());
        m = s.next();
        assertNull(m);
    }

    @Test
    public void schedule3() {
        ArrayList<PersonalCalendar.Meeting> l1 = new ArrayList<PersonalCalendar.Meeting>();
        l1.add(new PersonalCalendar.Meeting(new Date(1000), 600));
        l1.add(new PersonalCalendar.Meeting(new Date(2000), 500));
        l1.add(new PersonalCalendar.Meeting(new Date(3000), 400));
        ArrayList<PersonalCalendar.Meeting> l2 = new ArrayList<PersonalCalendar.Meeting>();
        l2.add(new PersonalCalendar.Meeting(new Date(1010), 600));
        l2.add(new PersonalCalendar.Meeting(new Date(2020), 500));
        l2.add(new PersonalCalendar.Meeting(new Date(2990), 400));
        l2.add(new PersonalCalendar.Meeting(new Date(4000), 300));
        PersonalCalendar.ScheduleList sl1 = new PersonalCalendar.ScheduleList(l1);
        PersonalCalendar.ScheduleList sl2 = new PersonalCalendar.ScheduleList(l2);
        List<PersonalCalendar.Schedule> list = new ArrayList<PersonalCalendar.Schedule>();
        list.add(sl1);
        list.add(sl2);

        PersonalCalendar.Schedule s = new PersonalCalendar().availableMeetings(new Date(2600), list);
        assertTrue(s.hasNext());
        PersonalCalendar.Meeting m = s.next();
        assertNotNull(m);
        assertEquals(2600, m.start.getTime());
        assertEquals(390, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(3400, m.start.getTime());
        assertEquals(600, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(4300, m.start.getTime());
        assertEquals(Long.MAX_VALUE, m.duration);
        assertFalse(s.hasNext());
        m = s.next();
        assertNull(m);
    }

    @Test
    public void schedule4() {
        ArrayList<PersonalCalendar.Meeting> l1 = new ArrayList<PersonalCalendar.Meeting>();
        l1.add(new PersonalCalendar.Meeting(new Date(1000), 600));
        l1.add(new PersonalCalendar.Meeting(new Date(2000), 500));
        l1.add(new PersonalCalendar.Meeting(new Date(3000), 400));
        ArrayList<PersonalCalendar.Meeting> l2 = new ArrayList<PersonalCalendar.Meeting>();
        l2.add(new PersonalCalendar.Meeting(new Date(1010), 600));
        l2.add(new PersonalCalendar.Meeting(new Date(2020), 500));
        l2.add(new PersonalCalendar.Meeting(new Date(2990), 400));
        l2.add(new PersonalCalendar.Meeting(new Date(4000), 300));
        PersonalCalendar.ScheduleList sl1 = new PersonalCalendar.ScheduleList(l1);
        PersonalCalendar.ScheduleList sl2 = new PersonalCalendar.ScheduleList(l2);
        List<PersonalCalendar.Schedule> list = new ArrayList<PersonalCalendar.Schedule>();
        list.add(sl1);
        list.add(sl2);
        PersonalCalendar.Schedule s = new PersonalCalendar().availableMeetings(new Date(3100), list);
        assertTrue(s.hasNext());
        PersonalCalendar.Meeting m = s.next();
        assertNotNull(m);
        assertEquals(3400, m.start.getTime());
        assertEquals(600, m.duration);
        assertTrue(s.hasNext());
        m = s.next();
        assertNotNull(m);
        assertEquals(4300, m.start.getTime());
        assertEquals(Long.MAX_VALUE, m.duration);
        assertFalse(s.hasNext());
        m = s.next();
        assertNull(m);
    }
}
