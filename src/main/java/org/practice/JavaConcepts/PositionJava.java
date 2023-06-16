package org.practice.JavaConcepts;

import javax.swing.text.Position;

public class PositionJava {
    public static void main(String[] args) {
        Position p= new Position() {
            @Override
            public int getOffset() {
                return 0;
            }
        };
    }
}
