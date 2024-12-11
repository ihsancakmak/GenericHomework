public class MyList<T> {

    Integer capacity = 10;
    int size = 0;
    Object[] list = new Object[capacity];

    MyList(){
        this.capacity = 10;
    }
    MyList(int capacity){
        this.capacity = capacity;
        this.list = new Object[capacity];
    }
    int size(){

        return size;
    }
    void add(T data){
        if(size == capacity){
            capacity *= 2;
            Object[] newArr = new Object[capacity];
            System.arraycopy(list,0, newArr,0, size);
            list = newArr;
        }
        list[size++] = data;
    }
    Object get(int index){
        if(list[index] == null){
            return null;
        }
        else return list[index].toString();
    }
    Object remove(int index){
        if(list[index] == null || index >= size){
            return null;
        }
        Object removedElement = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return removedElement;
    }
    Object set(int index, T data){
        if(list[index] == null || index >= size){
            return null;
        }
        list[index] = data;
        return list[index];
    }
    @Override
    public String toString(){
        String listElements = "";
        for(Object i : list){
            if(i != null){
                listElements += i+" ";
            }
        }
        return listElements;
    }
    int indexOf(T data){
        for(int i=0; i<size; i++){
            if(list[i] == data){
                return i;
            }
        }
        return -1;
    }
    int lastIndexOf(T data){
        for(int i=size-1; i>=0; i--){
            if(list[i] == data){
                return i;
            }
        }
        return -1;
    }
    boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    T[] toArray(){
        Object[] newArray = new Object[size];
        for(int i=0; i<size; i++){
            newArray[i] = list[i];
        }
        return (T[]) newArray;
    }
    void clear(){
        for(int i=0; i<size; i++){
            if(list[i] != null){
                list[i] = null;
            }
        }
    }
    MyList<T> subList(int start, int finish){
        MyList<T> newList = new MyList<>();
        for(int i=start; i<=finish; i++){
            newList.add((T)list[i]);
        }
        return newList;
    }
    boolean contains(T data){
        for(Object i : list){
            if(i == data){
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }
}
