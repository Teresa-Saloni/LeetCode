import java.util.*;

class ExamRoom {
    int n;
    TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        seats = new TreeSet<>();
    }

    public int seat() {
        // Room is empty
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int bestSeat = 0;
        int maxDist = seats.first();  // distance from seat 0

        int prev = -1;

        for (int curr : seats) {
            if (prev != -1) {
                int dist = (curr - prev) / 2;

                if (dist > maxDist) {
                    maxDist = dist;
                    bestSeat = prev + dist;
                }
            }

            prev = curr;
        }

        // Check last seat n - 1
        int lastDist = (n - 1) - seats.last();

        if (lastDist > maxDist) {
            bestSeat = n - 1;
        }

        seats.add(bestSeat);
        return bestSeat;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}