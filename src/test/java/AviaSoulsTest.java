import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls mng = new AviaSouls();

    Ticket ticket1 = new Ticket("PRM", "MSK", 5_000, 8, 10);
    Ticket ticket2 = new Ticket("MSK", "PRM", 5_500, 16, 18);
    Ticket ticket3 = new Ticket("PRM", "SPB", 4_000, 9, 12);
    Ticket ticket4 = new Ticket("SPB", "PRM", 4_000, 16, 18);
    Ticket ticket5 = new Ticket("PRM", "NVS", 6_000, 8, 12);
    Ticket ticket6 = new Ticket("PRM", "SCH", 8_000, 8, 12);
    Ticket ticket7 = new Ticket("SCH", "MSK", 9_000, 19, 21);
    Ticket ticket8 = new Ticket("PRM", "SCH", 12_000, 18, 21);

    @Test
    public void shouldSearchTickets() {

        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);
        mng.add(ticket6);
        mng.add(ticket7);
        mng.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket6, ticket8}, mng.search("PRM", "SCH"));
    }

    @Test
    public void shouldSearchOneTicket() {

        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);
        mng.add(ticket6);
        mng.add(ticket7);
        mng.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket2}, mng.search("MSK", "PRM"));
    }

    @Test
    public void shouldNotSearchTickets() {

        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);
        mng.add(ticket6);
        mng.add(ticket7);
        mng.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[0], mng.search("PRM", "KZ"));
    }

    @Test
    public void shouldSearchTicketsWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);
        mng.add(ticket6);
        mng.add(ticket7);
        mng.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket8, ticket6}, mng.searchAndSortBy("PRM", "SCH", comparator));
    }

    @Test
    public void shouldSearchOneTicketWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);
        mng.add(ticket6);
        mng.add(ticket7);
        mng.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket4}, mng.searchAndSortBy("SPB", "PRM", comparator));
    }

    @Test
    public void shouldNotSearchTicketsWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        mng.add(ticket1);
        mng.add(ticket2);
        mng.add(ticket3);
        mng.add(ticket4);
        mng.add(ticket5);
        mng.add(ticket6);
        mng.add(ticket7);
        mng.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[0], mng.searchAndSortBy("KZ", "PRM", comparator));
    }
}
