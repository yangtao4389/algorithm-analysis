package cn.angetech.javademo.io.nio;

import com.sun.istack.internal.Nullable;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.io.File;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class NIOFile {
    public static void main(String[] args) throws Exception{

//        NIOPathExample();
//        fileSystemUse();
        forEachDir(Paths.get("."));



    }

    public static void pathAndFile(){
        File file = new File("d:\\wordcount\\output\\NIOFILE.txt");

        /*
         * nio path  与 io.file  互转
         * */
        Path path = file.toPath();
        System.out.println(path);
        System.out.println(path.getNameCount());
        System.out.println(path.getFileSystem());
        System.out.println(path.getParent());
        System.out.println(path.isAbsolute());// true
        System.out.println(path);
        File toFile = path.toFile();
        System.out.println(toFile);
        URI toURI = file.toURI();
        System.out.println(toURI);
        System.out.println();
        Path path1 = Paths.get("NIOFILE.txt");
        System.out.println(path1.getFileName());
        System.out.println(path1.getParent()); //null
        System.out.println(path1.getName(0));
        System.out.println(path1.getFileSystem());
        System.out.println(path1.getNameCount());
        System.out.println(path1.getRoot());
        System.out.println(path1.isAbsolute());// false
    }

    public static void NIOPathExample(){
        // 获取当前路径
        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());  // D:\AllLearn\javaLearn\algorithm-analysis\.
        System.out.println(currentDir.toAbsolutePath().normalize()); // D:\AllLearn\javaLearn\algorithm-analysis
        System.out.println(currentDir);


    }

    public static void fileSystemUse() throws Exception{
        /*
        * Java NIO中的Files类（java.nio.file.Files）提供了多种操作文件系统中文件的方法
        * */
        Path path = Paths.get("d:\\helloworld.txt");
        boolean exists = Files.exists(path);
        System.out.println(exists);
        Path path2 = null;
        if(!exists){
            path2 = Files.createFile(path);
        }

        // 获取文件属性
        System.out.println(Files.getLastModifiedTime(path2));
        System.out.println(Files.size(path2)); // 0
        System.out.println(Files.isDirectory(path2)); //false
        System.out.println(Files.readAttributes(path2,"*"));//{lastAccessTime=2020-04-06T03:15:42.761676Z, lastModifiedTime=2020-04-06T03:15:42.761676Z, size=0, creationTime=2020-04-06T03:15:42.761676Z, isSymbolicLink=false, isRegularFile=true, fileKey=null, isOther=false, isDirectory=false}

    }

    public static void forEachDir(@Nullable Path path) throws Exception{
        /*
        * 遍历文件夹
        * */
//        Path path = null;
//        if (null == path2){
//            path = Paths.get(".");
//        }else {
//            path = path2;
//        }

        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
        for(Path e:paths){
            System.out.println(e.getFileName());
            if(Files.isDirectory(e)){
                forEachDir(e);
            }
        }



    }

    public static void walkFileTreeTest(){

    }

}
