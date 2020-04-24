package sunq;

/**
 * @author nick chen
 */
public class KingArthur extends Thread {

    private Hall hall;

    public KingArthur(Hall hall) {
        this.hall = hall;
    }

    private void away() {
        try {
            sleep(Params.getKingWaitingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mingle() {
        try {
            sleep(Params.getMinglingTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            away();
            System.out.format("King Arthur enters the %s!\n", hall.getName());
            hall.setKingPresent(true);
            hall.startMeeting();

            try {
                mingle();
                hall.endMeeting();
                sleep(Params.MEAN_KING_WAITING_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
