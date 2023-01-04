public class TrainStation {
    String name;
    TrainStation next;

    public TrainStation(String name)
    {
        this.name = name;
        this.next = null;
    }

    public void setNext() {
        this.next = next;
    }

    public void setNext(TrainStation station) {
        this.next = station;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public TrainStation getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}
