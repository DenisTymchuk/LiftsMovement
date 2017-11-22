package com.company;

import java.util.List;

/**
 * Created by Oksa on 20.11.2017.
 */
public class Lift {
    private static final int MAX_COUNT_OF_PASSENGER = 5;

    private int currentPosition;
    private int resultFloor;
    private String liftState;
    private int name;
    private int distance;
    private int countOfPassenger;

    public Lift(int currentPosition, int resultFloor, int name, int countOfPassenger) {
        this.currentPosition = currentPosition;
        this.resultFloor = resultFloor;
        if (currentPosition == resultFloor) {
            this.liftState = "STAND";
        } else if (currentPosition > resultFloor) {
            this.liftState = "DOWN";
        } else {
            this.liftState = "UP";
        }
        this.name = name;
        if (countOfPassenger <= MAX_COUNT_OF_PASSENGER) {
            this.countOfPassenger = countOfPassenger;
        }
    }

    public static int searchLiftId(List<Lift> lifts, int userPosition, String userDirection) {
        int result = -1;
        boolean liftFound = false;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < lifts.size(); i++) {
            if (lifts.get(i).isRelated(userPosition, userDirection) && lifts.get(i).getCountOfPassenger() < Lift.MAX_COUNT_OF_PASSENGER) {
                lifts.get(i).setDistance(Math.abs(lifts.get(i).getCurrentPosition() - userPosition));
                if (lifts.get(i).getDistance() < distance) {
                    distance = lifts.get(i).getDistance();
                    result = lifts.get(i).getName();
                    liftFound = true;
                }
            }
        }

        if (liftFound) {return result;}

        for (int i = 0; i < lifts.size(); i++) {
            lifts.get(i).setDistance(Math.abs(lifts.get(i).getResultFloor() - userPosition));
        }

        distance = Integer.MAX_VALUE;
        for (int i = 0; i < lifts.size(); i++) {
            if ((lifts.get(i).getDistance() < distance) && (lifts.get(i).getCountOfPassenger() < Lift.getMaxCountOfPassenger())) {
                distance = lifts.get(i).getDistance();
                result = lifts.get(i).getName();
            }
        }
        return result;
    }

    public boolean isRelated(int userPosition, String userDirection) {
        return (userDirection.equals(this.getLiftState()) && ((this.getCurrentPosition() <= userPosition && userPosition < this.getResultFloor())
                || (this.getCurrentPosition() >= userPosition && userPosition > this.getResultFloor())));
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getResultFloor() {
        return resultFloor;
    }

    public void setResultFloor(int resultFloor) {
        this.resultFloor = resultFloor;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCountOfPassenger() {
        return countOfPassenger;
    }

    public void setCountOfPassenger(int countOfPassenger) {
        this.countOfPassenger = countOfPassenger;
    }

    public static int getMaxCountOfPassenger() {
        return MAX_COUNT_OF_PASSENGER;
    }

    public String getLiftState() {
        return liftState;
    }

    public void setLiftState(String liftState) {
        this.liftState = liftState;
    }
}