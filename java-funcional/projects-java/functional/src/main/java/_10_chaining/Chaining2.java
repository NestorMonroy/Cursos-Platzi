package _10_chaining;

public class Chaining2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola").append("Alumno").append("Ejemplo");

        Chainer chainer= new Chainer();
        Chainer chainer2 = chainer.sayHi();

        chainer.sayHi().sayBye();
    }

    static class Chainer {
        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Bye");
            return this;
        }
    }
}
