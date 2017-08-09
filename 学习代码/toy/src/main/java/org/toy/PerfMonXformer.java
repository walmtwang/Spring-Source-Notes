package org.toy;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.*;


/**
 * Created by walmt on 2017/8/8.
 */
public class PerfMonXformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        //加载App类才拦截
        if (!"org/toy/App".equals(className)) {
            return null;
        }

        //javassist的包名是用点分割的，要转换下
        className = className.replaceAll("/", ".");

        CtClass cc = null;
        try {
            //通过包名获取类文件
            cc = ClassPool.getDefault().get(className);
            //获取指定方法名的方法
            CtMethod method = cc.getDeclaredMethod("test");
            //在方法执行前插入代码
            doMethod(method);
            return cc.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cc.detach();
        }
        return null;
//        byte[] transformed = null;
//        System.out.println("Transforming " + className);
//        ClassPool pool = ClassPool.getDefault();
//        CtClass cl = null;
//
//        try {
//            cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
//            if (cl.isInterface() == false) {
//                CtBehavior[] methods = cl.getDeclaredBehaviors();
//                for (int i = 0; i < methods.length; i++) {
//                    if (methods[i].isEmpty() == false) {
//                        //修改method字节码
//                        doMethod(methods[i]);
//                    }
//                }
//                transformed = cl.toBytecode();
//            }
//        } catch (Exception e) {
//            System.err.println("Could not istrument " + className + ", exception: " + e.getMessage());
//        } finally {
//            if (cl != null) {
//                cl.detach();
//            }
//        }
//        return transformed;
    }

    private void doMethod(CtBehavior method) throws CannotCompileException {
        method.insertBefore("{System.out.println(System.nanoTime());}");
        method.insertAfter("{System.out.println(System.nanoTime());}");
    }
}
