package InversionsCount;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InversionsCount {
    private long inversions;
    private List<Integer> numbers;

    public InversionsCount(List<Integer> numbers){
         this.numbers = numbers;
    }

    public long mergeSortInversions(int ini, int high){
        if(high - ini <= 1){
            if(numbers.get(ini) > numbers.get(high)){
                int aux = numbers.get(ini);
                numbers.set(ini, numbers.get(high));
                numbers.set(high, aux);
                inversions++;
            }
            return inversions;
        }

        int mid = (high + ini) / 2;

        mergeSortInversions(ini, mid);
        mergeSortInversions(mid, high);

        mergeList(numbers, ini, mid, high);

        return inversions;
    }

    public void mergeList(List<Integer> numbers, int ini, int mid, int high){
        Queue<Integer> auxList = new LinkedList<>();
        int auxIni = ini;
        int auxMid = mid;

        while(auxIni < mid && auxMid < high){
            if(numbers.get(auxIni) < numbers.get(auxMid)){
                auxList.add(numbers.get(auxIni));
                auxIni++;
            } else {
                auxList.add(numbers.get(auxMid));
                auxMid++;
                inversions = inversions + (mid - auxIni);
            }
        }

        if (auxIni < mid) {
            for (int i = auxIni; i < mid; i++) {
                auxList.add(numbers.get(i));
            }
        } else if (auxMid < high) {
            for (int i = auxMid; i < high; i++) {
                auxList.add(numbers.get(i));
            }
        }

        for (int i = ini; i < high ; i++) {
            numbers.set(i, auxList.poll());
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
