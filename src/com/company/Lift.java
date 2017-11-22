package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oksa on 20.11.2017.
 */
public class Lift {
    private int currentPosition;
    private int resultFloor;
    private boolean isMovedUp;
    private boolean isMovedDown;
    private int name;
    private int distance;
    private static final int MAX_COUNT_OF_PASSENGER = 5;
    private int countOfPassenger;

    public Lift(int currentPosition, int resultFloor, int name, int countOfPassenger) {
        this.currentPosition = currentPosition;
        this.resultFloor = resultFloor;
        if (currentPosition == resultFloor) {
            this.isMovedUp = false;
            this.isMovedDown = false;
        } else if (currentPosition > resultFloor) {
            this.isMovedDown = true;
        } else {
            this.isMovedUp = true;
        }
        this.name = name;
        this.countOfPassenger = countOfPassenger;
    }

    public static int searchLift(List<Lift> lifts, int userPosition, String userDirection) {
        boolean userUp = false;
        boolean userDown = false;
        if (userDirection.equals("UP")) userUp = true;
        if (userDirection.equals("DOWN")) userDown = true;

        int result = 555;
        boolean liftFound = false;
        for (int i = 0; i < lifts.size(); i++) {
            if ((userUp && lifts.get(i).isMovedUp()) && (userPosition > lifts.get(i).getCurrentPosition()) && (userPosition <= lifts.get(i).getResultFloor()) && lifts.get(i).getCountOfPassenger() < Lift.getMaxCountOfPassenger()) {
                liftFound = true;
                result = lifts.get(i).getName();
            }
            if ((userDown && lifts.get(i).isMovedDown()) && (userPosition < lifts.get(i).getCurrentPosition()) && userPosition >= lifts.get(i).getResultFloor() && lifts.get(i).getCountOfPassenger() < Lift.getMaxCountOfPassenger()) {
                liftFound = true;
                result = lifts.get(i).getName();
            }
        }

        for (int i = 0; i < lifts.size(); i++) {
            lifts.get(i).setDistance(Math.abs(lifts.get(i).getResultFloor() - userPosition));
        }

        int distance = 1000;
        if (!liftFound) {
            for (int i = 0; i < lifts.size(); i++) {
                if ((lifts.get(i).getDistance() < distance) && (lifts.get(i).getCountOfPassenger() < Lift.getMaxCountOfPassenger())) {
                    distance = lifts.get(i).getDistance();
                    result = lifts.get(i).getName();
                }
            }
        }
        return result;
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

    public boolean isMovedUp() {
        return isMovedUp;
    }

    public void setMovedUp(boolean movedUp) {
        isMovedUp = movedUp;
    }

    public boolean isMovedDown() {
        return isMovedDown;
    }

    public void setMovedDown(boolean movedDown) {
        isMovedDown = movedDown;
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
}