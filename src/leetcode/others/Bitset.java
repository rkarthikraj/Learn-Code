package leetcode.others;

import java.util.Arrays;

class Bitset {
    char[] bits;

    public Bitset(int size) {
        bits = new char[size];
        Arrays.fill(bits, '0');

        System.out.println("Bitset: " + String.valueOf(bits));
    }

    public void fix(int idx) {
        bits[idx] = '1';
        System.out.println("Fix: " + String.valueOf(bits));
    }

    public void unfix(int idx) {
        bits[idx] = '0';
        System.out.println("UnFix: " + String.valueOf(bits));
    }

    public void flip() {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                bits[i] = '0';
            } else {
                bits[i] = '1';
            }
        }

        System.out.println("Flip: " + String.valueOf(bits));
    }

    public boolean all() {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '0') {
                return false;
            }
        }

        return true;
    }

    public boolean one() {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                return true;
            }
        }

        return false;
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') {
                count++;
            }
        }

        System.out.println("Count: " + count);
        return count;
    }

    public String toString() {
        return String.valueOf(bits);
    }

    public static void main(String[] args) {
        Bitset obj = null;

        String[] operations = {"Bitset", "fix", "fix", "flip", "all", "unfix", "flip", "one", "unfix", "count", "toString"};
        int[][] values = {{5}, {3}, {1}, {}, {}, {0}, {}, {}, {0}, {}, {}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "Bitset":
                    obj = new Bitset(values[i][0]);
                    break;
                case "fix":
                    obj.fix(values[i][0]);
                    break;
                case "flip":
                    obj.flip();
                    break;
                case "all":
                    obj.all();
                    break;
                case "unfix":
                    obj.unfix(values[i][0]);
                    break;
                case "one":
                    obj.one();
                    break;
                case "count":
                    obj.count();
                    break;
                case "toString":
                    obj.toString();
                    break;
            }
        }
    }
}