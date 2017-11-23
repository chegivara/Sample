interface Employee {
    default void log(){
        System.out.println("log");
    }
    public void doWork();
    public void tellWithEmployyes();
}
