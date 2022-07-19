package com.dlxy.entity;


import java.util.Arrays;

public class User {
    public static void main(String[] args) {

        ChickenManager chickenManager = new ChickenManager(2);

        chickenManager.add(new Chicken(1, "chicken1", 1));
        chickenManager.add(new Chicken(2, "chicken2", 2));
        chickenManager.add(new Chicken(3, "chicken3", 3));
        chickenManager.add(new Chicken(4, "chicken4", 4));


        System.out.println(chickenManager.length());

        chickenManager.printAll();
        System.out.println();


        chickenManager.find(3);
        System.out.println();


        chickenManager.delete(3);
        System.out.println(chickenManager.length());
        chickenManager.printAll();
        System.out.println();


        chickenManager.update(1, "chicken egg", 2);
        chickenManager.find(1);
    }
}

class ChickenManager {

    private Chicken[] chicken = null;

    private int chickenCount = 0;


    public ChickenManager(int size) {
        if (size > 0) {
            chicken = new Chicken[size];
        } else {
            chicken = new Chicken[3];
        }
    }


    public int length() {
        return chickenCount;
    }


    public void add(Chicken c) {
        if (chickenCount == chicken.length) {

            int newLen = chicken.length * 2;
            chicken = Arrays.copyOf(chicken, newLen);
        }
        chicken[chickenCount] = c;
        chickenCount++;
    }


    public void delete(int id) {
        Chicken[] c = new Chicken[chickenCount - 1];
        int j = 0;
        for (int i = 0; i < chickenCount; i++) {
            if (chicken[i].getId() != id) {
                c[j] = chicken[i];
                j++;
            }
        }
        chicken = Arrays.copyOf(c, --chickenCount);
    }


    public void update(int id, String name, int age) {
        for (int i = 0; i < chickenCount; i++) {
            if (chicken[i].getId() == id) {
                chicken[i].setName(name);
                chicken[i].setAge(age);
            }
        }
    }


    public void find(int id) {
        for (int i = 0; i < chickenCount; i++) {
            if (chicken[i].getId() == id) {
                System.out.println(chicken[i].getInfo());
            }
        }
    }


    public void printAll() {
        for (int i = 0; i < chickenCount; i++) {
            System.out.println("chicken id：" + chicken[i].getId() + " chicken name：" +
                    chicken[i].getName() + " chicken age：" + chicken[i].getAge());
        }
    }
}

class Chicken {
    private int id;
    private String name;
    private int age;

    public Chicken() {
    }

    public Chicken(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return "chicken id=" + id +
                ", chicken name=" + name +
                ", chicken age=" + age;
    }
}

