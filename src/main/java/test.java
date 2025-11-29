public class test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 4) {
            StackTraceElement caller = stackTrace[3];
            return caller.getClassName() + "#" + caller.getMethodName();
        } else {
            // Точка входа (например, вызов из main или напрямую из JVM)
            return null;
        }
    }
}
