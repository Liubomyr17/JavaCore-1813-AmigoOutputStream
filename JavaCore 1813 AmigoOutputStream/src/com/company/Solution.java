package com.company;

/*
1813 AmigoOutputStream

1 Change the AmigoOutputStream class so that it becomes the Wrapper for the FileOutputStream class. Use inheritance.
2 When calling the close () method, the following sequence of actions should be performed:
2.1 Call the flush () method.
2.2 Add the following text "JavaRush © All rights reserved.", Use the getBytes () method.
2.3 Close the stream with the close () method.

Requirements:
1. The main method cannot be changed.
2. The AmigoOutputStream class must inherit from the FileOutputStream class.
3. The AmigoOutputStream class must accept an object of type FileOutputStream in the constructor.
4. All write (), flush (), close () methods in the AmigoOutputStream class must delegate their execution to the FileOutputStream object.
5. The close () method must first call the flush () method, then append the text, then close the stream.

 */

import com.sun.deploy.net.DownloadException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream component;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        component = fos;
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        component.flush();
        String s = "JavaRush @ All rights reserved.";
        write(s.getBytes());
        component.close();
    }

    @Override
    public FileChannel getChannel() {
        return component.getChannel();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}


