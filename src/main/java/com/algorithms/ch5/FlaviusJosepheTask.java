package com.algorithms.ch5;


/**
 * Task 5.5 Задача Иосифа Флавия
 */
public class FlaviusJosepheTask {

    private CycleList<Integer> cycle;

    public static void main(String[] args) {
        FlaviusJosepheTask flaviusJosepheTask = new FlaviusJosepheTask();
        flaviusJosepheTask.initAndFillCycle(Integer.parseInt(args[0]));
        flaviusJosepheTask.run(
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2])-1);

    }

    private void initAndFillCycle(int size) {
        cycle = new CycleList<>(1);
        for (int i = 2; i <= size; i++) {
            cycle.add(i);
        }
    }

    private void run(int first, int each) {
        shift(first);
        while (cycle.size() > 1) {
            shift(each);
            System.out.println(cycle);
            System.out.println("# remove " + cycle.getData());
            cycle.remove();
            System.out.println(cycle);

        }
        System.out.println(cycle);
    }

    private void shift(int each) {
        for (int i = 0; i < each; i++) {
            cycle = cycle.step();
        }
    }
}
