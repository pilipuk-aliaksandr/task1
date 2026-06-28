package by.pilipuk.inno.comparator;

import by.pilipuk.inno.entity.CustomArray;
import java.util.Comparator;

public enum CustomArrayComparator implements Comparator<CustomArray> {
    BY_ID {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    },
    BY_FIRST_ELEMENT_FROM_ARRAY {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            int[] intArrayO1 = o1.getArray();
            int[] intArrayO2 = o2.getArray();
            return Integer.compare(intArrayO1[0], intArrayO2[0]);
        }
    },
    BY_ARRAY_ELEMENTS_AMOUNT {
        @Override
        public int compare(CustomArray o1, CustomArray o2) {
            return Long.compare(o1.length(), o2.length());
        }
    }
}
