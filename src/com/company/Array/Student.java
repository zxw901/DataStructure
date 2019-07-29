package com.company.Array;

public class Student {
    private String name;
    private int score;

    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return (String.format("name:%s score:%d",name,score));
    }

    public static void main(String[] args) {
        Student Tom =new Student("Tom",55);
        Student Jack = new Student("Jack",66);
        Student Luce = new Student("Luce",99);

        Array<Student> arr=new Array<>();
        arr.addLast(Tom);
        arr.addLast(Jack);
        arr.addLast(Luce);
        System.out.println(arr);

    }
}
