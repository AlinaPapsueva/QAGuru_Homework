package lesson5;

public class Main {
    public static void main(String[] args) {
        byte varByte = 127;
        int varInt = 100;
        short varShort = 32767;
        long varLong = 922337203;
        float varFloat = 1.5F;
        double varDouble = 2.5;
        //математические операторы
        System.out.println(varByte + varInt);
        System.out.println(varShort - varLong);
        System.out.println(varFloat * varDouble);
        System.out.println(varByte / varInt);
        System.out.println(varByte % varInt);
        //логические операторы
        System.out.println(varByte > varInt);
        System.out.println(varByte < varInt);
        System.out.println(varByte >= varInt);
        System.out.println(varByte <= varInt);
        System.out.println(varByte == varInt);
        System.out.println(varByte != varInt);
        //переполнение
        System.out.println((short) (varShort + varLong));
    }
}
