package org.practice.enums;

public class EnumWIthInstanceField {
    enum NameMeaning{
        PANKAJ("Lotus"),
        PAWAN("AIR"),
        PRADEEP("Lighten"),
        PRAVEEN("Intelligent");

        private String meaning;

        NameMeaning(String meaning){
            this.meaning=meaning;
        }
        public String getMeaning(){
            return meaning;
        }
    }

    public static void main(String[] args) {
        System.out.println(NameMeaning.PAWAN.getMeaning());
    }
}
