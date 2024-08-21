package hus.oop.vector;

import java.util.Arrays;

public abstract class AbstractMyVector implements MyVector {

    @Override
    public String toString() {
        double[] coords = this.coordinates();
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < coords.length; i++) {
            sb.append(coords[i]);
            if (i < coords.length - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(MyVector another) {
        if (another == null || this.size() != another.size()) {
            return false;
        }
        double[] coords1 = this.coordinates();
        double[] coords2 = another.coordinates();
        return Arrays.equals(coords1, coords2);
    }
}
