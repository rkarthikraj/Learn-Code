package leetcode.easy;

/*
https://leetcode.com/problems/logger-rate-limiter/
 */

import javafx.util.Pair;

import java.util.*;

/*
359. Logger Rate Limiter
Runtime: 66 ms, faster than 14.63% of Java online submissions for Logger Rate Limiter.
Memory Usage: 71.5 MB, less than 19.40% of Java online submissions for Logger Rate Limiter.
 */
class Logger {
    Map<String, Integer> hm;

    //Optimization
    HashSet<String> messagesHs;
    Queue<Pair<String, Integer>> qp;


    public Logger() {
        hm = new HashMap<>();
        messagesHs = new HashSet<>();
        qp = new LinkedList<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer ts = hm.get(message);
        if (ts == null) {
            hm.put(message, timestamp);
            return true;
        }

        int check = ts + 10;
        if (timestamp < check) {
            return false;
        } else {
            hm.put(message, timestamp);
            return true;
        }
    }

    public boolean shouldPrintMessageOptimise(int timestamp, String message) {
        while (!qp.isEmpty() && qp.peek().getValue() < timestamp - 10) {
            Pair<String, Integer> remove = qp.remove();
            messagesHs.remove(remove.getKey());
        }


        //Check
        // This condition is to check whether we have any recent logs which entered within last 10s.
        if (messagesHs.contains(message)) {
            return false;
        }

        qp.add(new Pair<>(message, timestamp));
        messagesHs.add(message);

        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

public class LoggerRateLimiter {
    public static void main(String[] args) {
        Logger obj = null;
        String[] instructions = {"Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"};
        String[][] logs = {{}, {"1", "foo"}, {"2", "bar"}, {"3", "foo"}, {"8", "bar"}, {"10", "foo"}, {"11", "foo"}};

        for (int i = 0; i < instructions.length; i++) {
            String instruction = instructions[i];

            switch (instruction) {
                case "Logger":
                    obj = new Logger();
                    break;
                case "shouldPrintMessage":
                    System.out.println(obj.shouldPrintMessageOptimise(Integer.parseInt(logs[i][0]), logs[i][1]));
                    break;
            }
        }
    }
}
