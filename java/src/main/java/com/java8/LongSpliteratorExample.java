package com.java8;

import java.util.Spliterator;
import java.util.function.Consumer;

public class LongSpliteratorExample implements  Spliterator {


    Spliterator<Character> characterSpliterator ;
    long l1;
    long l2;

    public LongSpliteratorExample(Spliterator<Character> characterSpliterator) {
        this.characterSpliterator = characterSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer action) {
        if(characterSpliterator.tryAdvance( v -> l1 = (int)v ) &&
        characterSpliterator.tryAdvance(v -> l2 = (int)v )) {
            Long [] l = new Long[2];
            l[0] = l1;
            l[1] = l2;
            action.accept(l);
            return true;
        }
        return false;
    }


    @Override
    public Spliterator trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return this.characterSpliterator.estimateSize()/2;
    }

    @Override
    public int characteristics() {
        return Spliterator.SIZED;
    }
}
