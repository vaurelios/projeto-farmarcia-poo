import java.util.concurrent.ThreadLocalRandom;

public class AutoRandomID {

    protected int id;

    public AutoRandomID()
    {
        this.id = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
    }

    public int getId()
    {
        return id;
    }
}
