public class TL {
    TrainStation head;

    void addStation(String stationName) {
        TrainStation station = new TrainStation(stationName);
        if(head == null){
            head = station;
        }else{
            // if there is a train station at the head
            TrainStation current = head;
            while (current.hasNext()){
                current = current.getNext();
            }
            // current is last station because it's next is null
            current.setNext(station);
            //current now has a !=null value. It points to new station
            //the new station has a next==null
        }
    }
    public boolean lineHasStation (String name){
        boolean found = false;
        TrainStation current = this.head;
        while(!found && current != null){
            found = current.getName().equals(name);
            current=current.getNext();
        }
        return found;
    }

    /**
     * Assume that taget station is present in the line
     * @param target
     */
    public void insertStationBefore(TrainStation target, String name){
        TrainStation newStation = new TrainStation(name);
        if (target == this.head){
            newStation.setNext(this.head);
            this.head = newStation;
        }else{
            //traverse the line until the station whose next is the target
            TrainStation current = this.head;
            while (current.getNext() != target){
                current = current.getNext();
            }
            TrainStation previous = current ;
            previous.setNext(newStation);
            newStation.setNext(target);
        }
    }



}