package main;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class CollectionBenchmarkJMH {

//    private List<Integer> arrayList;
    private List<Integer> linkedList;
//    private List<Integer> vector;
//    private List<Integer> stack;
//    private List<Integer> cowList;

    private int[] sampleData;

    @Setup(Level.Iteration)
    public void setup() {
        int N = 5;
        sampleData = new int[N];
        for (int i = 0; i < N; i++) sampleData[i] = i;

//        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
//        vector = new Vector<>();
//        stack = new Stack<>();
//        cowList = new CopyOnWriteArrayList<>();
    }

//    @Benchmark
//    public void addArrayList() {
//        for (int v : sampleData) arrayList.add(v);
//    }

    @Benchmark
    public void addLinkedList() {
        for (int v : sampleData) linkedList.add(v);
    }
//
//    @Benchmark
//    public void addVector() {
//        for (int v : sampleData) vector.add(v);
//    }
//
//    @Benchmark
//    public void addStack() {
//        for (int v : sampleData) stack.add(v);
//    }
//
//    @Benchmark
//    public void addCopyOnWriteArrayList() {
//        for (int v : sampleData) cowList.add(v);
//    }

//    @Benchmark
//    public void getArrayList() {
//        for (int i = 0; i < sampleData.length; i++) arrayList.get(i);
//    }

    @Benchmark
    public void getLinkedList() {
        for (int i = 0; i < sampleData.length; i++) linkedList.get(i);
    }
//
//    @Benchmark
//    public void getVector() {
//        for (int i = 0; i < sampleData.length; i++) vector.get(i);
//    }
//
//    @Benchmark
//    public void getStack() {
//        for (int i = 0; i < sampleData.length; i++) stack.get(i);
//    }
//
//    @Benchmark
//    public void getCopyOnWriteArrayList() {
//        for (int i = 0; i < sampleData.length; i++) cowList.get(i);
//    }

//    @Benchmark
//    public void removeMiddleArrayList() {
//        int mid = arrayList.size() / 2;
//        if (!arrayList.isEmpty()) arrayList.remove(mid);
//    }

    @Benchmark
    publiccd  void removeMiddleLinkedList() {
        int mid = linkedList.size() / 2;
        if (!linkedList.isEmpty()) linkedList.remove(mid);
    }
//
//    @Benchmark
//    public void removeMiddleVector() {
//        int mid = vector.size() / 2;
//        if (!vector.isEmpty()) vector.remove(mid);
//    }
//
//    @Benchmark
//    public void removeMiddleStack() {
//        int mid = stack.size() / 2;
//        if (!stack.isEmpty()) stack.remove(mid);
//    }
//
//    @Benchmark
//    public void removeMiddleCopyOnWriteArrayList() {
//        int mid = cowList.size() / 2;
//        if (!cowList.isEmpty()) cowList.remove(mid);
//    }
}
