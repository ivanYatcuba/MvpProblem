package ua.edu.iyatsouba.opt;

public interface Algorithm<T extends Solution, E> {

    T resolve(E data);

}
