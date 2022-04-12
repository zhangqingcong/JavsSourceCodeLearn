package JUCLearn.Day01;


//import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class MethodAreaOOM extends ClassLoader {

//    public static void main(String[] args) {
//        int a = 1;
//        int j = 0;
//        try {
//            MethodAreaOOM methodAreaOOM = new MethodAreaOOM();
//            for (int i = 0; i < 10000; i++) {
//                ClassWriter classWriter = new ClassWriter(0);
//                classWriter.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
//                byte[] bytes = classWriter.toByteArray();
//                methodAreaOOM.defineClass("Class" + i, bytes, 0, bytes.length);
//                j++;
//            }
//
//        } finally {
//            System.out.println(j);
//        }
//    }
}

