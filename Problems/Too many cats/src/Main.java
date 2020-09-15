class Cat {
    String name;
    int age;
    static int counter = 0;

    // write static and instance variables

    public Cat(String name, int age) {
        counter++;
    }

    public static int getNumberOfCats() {
        if (counter > 5) {
            int num = counter - 5;
            for (int i = 0; i < num; i++) {
                System.out.println("You have too many cats");
            }
        }
        return counter;
    }
}