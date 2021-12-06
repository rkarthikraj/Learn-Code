package javaoops.concepts;

import java.io.IOException;

public class Constructor {
    int num;
    String status;

    Constructor() {
        num = 0;
        status = "Fatal";
    }

    public static void main(String args[]) throws IOException {
        Constructor obj = new Constructor();
        try {
            obj.num = 5 / 0;
            obj.status = "Success";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(obj.status + " --> " + obj.num);
    }
}
