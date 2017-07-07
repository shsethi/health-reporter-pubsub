package com.example.www;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileChannelRead {
    private String filePath = "small-sample.json";

    void readFile()
            throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(this.filePath).getFile());

        printFileContents(this.filePath);
        Path path = Paths.get(file.getPath());

        FileChannel fileChannel = FileChannel.open(path);
        ByteBuffer buffer = ByteBuffer.allocate(6);
        int noOfBytesRead = fileChannel.read(buffer);

        while (noOfBytesRead != -1) {
            System.out.println("Number of bytes read: " + noOfBytesRead);
            buffer.flip();
            System.out.print("Buffer contents: ");

            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            System.out.println(" ");
            buffer.clear();
            noOfBytesRead = fileChannel.read(buffer);
        }
        fileChannel.close();
    }

    private void printFileContents(String path)
            throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String textRead = br.readLine();
        System.out.println("File contents: ");

        while (textRead != null) {
            System.out.println("     " + textRead);
            textRead = br.readLine();
        }
        fr.close();
        br.close();
    }
}