package com.nlinnik.occ.interview.utils;

import org.apache.commons.io.IOUtils;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class FileIOUtils {

    /**
     * Reads a file for a given path into java.util.stream.Stream
     *
     * @param filepath    full path of the file
     * @param splitRegex  stream split regular expression
     * @param removeValue any file or string padded characters that do need to be in stream
     * @return
     * @throws IOException
     */
    public static Stream<String> getByFilePath(String filepath, String splitRegex, String removeValue) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        String data = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8);

        return  Stream.of(data.replace(removeValue, "").split(splitRegex));
    }

    /**
     * Writes a String into new or existing file for a given full path of a file
     *
     * @param filepath
     * @param string
     * @throws IOException
     */
    public static void write(String filepath, String string)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
        writer.write(string);

        writer.close();
    }

}
