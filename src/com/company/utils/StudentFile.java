package com.company.utils;

import com.company.model.StudentModel;

import javax.tools.JavaFileManager;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentFile {

    private static final String STUDENTS_PATH = "./nstudents/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(STUDENTS_PATH).mkdirs();
        System.out.println("Creating " + STUDENTS_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(STUDENTS_PATH).listFiles();
    }


    /*public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        FileReader fileReader;
        String reader ="";
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()){
                reader += bufferedReader.readLine() + "\n";
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }*/

   /* public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);
        FileWriter fileWriter;
        File file = new File(fileName);
        try {
            fileWriter = new FileWriter(NOTES_PATH + file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    //TODO: Phase1: define method here for reading file with InputStream
    public static String fileReaderInputStream(File file){
        String reader = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() > 0){
                reader += (char) fileInputStream.read();
            }
            fileInputStream.close();
        } catch (FileNotFoundException e){
            //Logger.getLogger(JavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } /*catch (IOException e){
            e.printStackTrace();
        }*/ catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    //TODO: Phase1: define method here for writing file with OutputStream
    public static void fileWriterOutputStream(String content) throws FileNotFoundException {
        String fileName = getProperFileName(content);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            char[] chars = content.toCharArray();
            byte[] bytes = new byte[chars.length];
            for (int i = 0; i < bytes.length; i++){
                bytes[i] = (byte) chars[i];
            }
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException e){
            //Logger.getLogger(JavaFileManager.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } /*catch (IOException e){
            e.printStackTrace();
        }*/ catch (IOException e) {
            e.printStackTrace();
        }
    }
    //TODO: Phase2: proper methods for handling serialization
    public static void objectFileWriter(StudentModel studentModel){
        String fileName = STUDENTS_PATH + studentModel.getUsername() + studentModel.getDate();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentModel);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentModel objectFileReader(File file){
        StudentModel studentModel = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            studentModel = (StudentModel) objectInputStream.readObject();
            objectInputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentModel;
    }

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}


