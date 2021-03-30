package come.videoslots.machine.dto;

import java.io.Serializable;

public class Symbol implements Serializable, Comparable<Symbol>, Cloneable {

    private final int id;
    private final int pos;
    private final String name;

    public Symbol(int id, int pos, String name) {
        this.id = id;
        this.name = name;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getPos() {
        return pos;
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(Symbol otherSymbol) {
        return this.name.compareTo(otherSymbol.getName());
    }

}
