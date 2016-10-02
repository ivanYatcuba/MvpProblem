package ua.edu.iyatsouba.opt;

public interface Solution<T> extends Comparable<Solution> {

    T getSolution();

    @Override
    int compareTo(Solution o);
}
