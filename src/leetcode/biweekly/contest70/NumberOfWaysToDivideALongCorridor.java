package leetcode.biweekly.contest70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumberOfWaysToDivideALongCorridor {
    public static void main(String[] args) {
        NumberOfWaysToDivideALongCorridor obj = new NumberOfWaysToDivideALongCorridor();
        String corridor1 = "PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS";
        System.out.println(obj.numberOfWays(corridor1));

//        String corridor2 = "PPSPSP";
//        System.out.println(obj.numberOfWays(corridor2));
//
//        String corridor3 = "S";
//        System.out.println(obj.numberOfWays(corridor3));
    }

    public int numberOfWays(String corridor) {
        List<int[]> seatPositions = new ArrayList<>();

        int seatCount = 0;
        int previousSeatPosition = 0;
        boolean alreadySeatFound = false;
        for (int i = 0; i < corridor.length(); i++) {
            char ch = corridor.charAt(i);
            if (ch == 'S') {
                seatCount++;
                if (alreadySeatFound) {
                    seatPositions.add(new int[]{previousSeatPosition, i});
                    alreadySeatFound = false;
                } else {
                    previousSeatPosition = i;
                    alreadySeatFound = true;
                }
            }
        }

        //System.out.println("seatCount: " + seatCount);
        //seatPositions.stream().forEach(arr -> System.out.print(Arrays.toString(arr)));

        if (seatCount % 2 != 0) {
            return 0;
        }

        if(seatPositions.size() == 0) {
            return 0;
        }

        int previousPlantPosition = seatPositions.get(0)[1];
        long result = 1;
        for (int i = 1; i < seatPositions.size(); i++) {
            result = result * (seatPositions.get(i)[0] - previousPlantPosition) % 1000000007;
            previousPlantPosition = seatPositions.get(i)[1];
        }
        return (int)result;
    }
}