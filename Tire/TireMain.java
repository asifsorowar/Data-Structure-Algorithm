package com.asifsorowar.Tire;

public class TireMain {
    public static void main(String[] args) {
        var tire = new Tire();
        tire.insert("cat");
        tire.insert("can");
        tire.insert("care");
        tire.insert("car");
//        System.out.println(tire.contains("can"));
//        tire.traversePostOrder();

        var words = tire.findWords("ca");
        System.out.println(words);
    }
}
