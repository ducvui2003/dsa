package dataStructure;

class DynamicArray {
    Integer[] arr = null;

    public DynamicArray(int capacity) {
        this.arr = new Integer[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (this.getSize() == this.getCapacity() && arr[arr.length - 1] != null) {
//            Integer[] newArr = new Integer[arr.length + 1];
//            for (int i = 0; i < arr.length; i++)
//                newArr[i] = arr[i];
//
//            newArr[newArr.length - 1] = n;
//            this.arr = newArr;
            this.resize();
        }
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] == null) {
                this.arr[i] = n;
                break;
            }
        }

    }

    public int popback() {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i] != null) {
                int result = arr[i];
                arr[i] = null;
                return result;
            }
        return 0;
    }

    private void resize() {
        Integer[] newArr = new Integer[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[i];
        this.arr = newArr;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != null)
                count += 1;
        return count;
    }

    public int getCapacity() {
        return this.arr.length;
    }

    public static void main(String[] args) {
//        ["Array", 1, "pushback", 1, "getCapacity", "pushback", 2, "getCapacity"]
//        DynamicArray arr = new DynamicArray(1);
//        arr.pushback(1);
//        System.out.println(arr.getCapacity());
//        arr.pushback(2);
//        System.out.println(arr.getCapacity());

//        ["Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize",
//        "getCapacity", "get", 1, "set", 1, 3, "get", 1, "popback", "getSize", "getCapacity"]
//        DynamicArray arr = new DynamicArray(1);
//        System.out.println(arr.getSize());
//        System.out.println(arr.getCapacity());
//        arr.pushback(1);
//        System.out.println(arr.getSize());
//        System.out.println(arr.getCapacity());
//        arr.pushback(2);
//        System.out.println(arr.getSize());
//        System.out.println(arr.getCapacity());
//        System.out.println(arr.get(1));
//        arr.set(1, 3);
//        System.out.println(arr.get(1));
//        arr.popback();
//        System.out.println(arr.getSize());
//        System.out.println(arr.getCapacity());

//        ["Array", 3, "pushback", 1, "pushback", 2, "pushback", 3, "get", 0, "get", 1, "get", 2]
//        DynamicArray arr = new DynamicArray(3);
//        arr.pushback(1);
//        arr.pushback(2);
//        arr.pushback(3);
//        System.out.println(arr.get(0));
//        System.out.println(arr.get(1));
//        System.out.println(arr.get(2));

//        ["Array", 4, "pushback", 1, "set", 0, 0, "pushback", 2, "get", 0, "get", 1, "getCapacity", "popback"]
        DynamicArray arr = new DynamicArray(4);
        arr.pushback(1);
        arr.set(0, 0);
        arr.pushback(2);
        System.out.println(arr.get(0));
        System.out.println(arr.get(1));
        System.out.println(arr.getCapacity());
        arr.popback();
    }
}
