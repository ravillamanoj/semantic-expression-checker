package com.mr.semantic.expresion.checker;

import java.io.*;

/**
 * Reads expressions from file and evaluates them.
 *
 * @author Manoj
 */
public class FileEvaluator {
    private final String filePath;
    private final String fileName;
    String line;
    ExpressionParser e;

    FileEvaluator(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public String fileEvaluator() {
        int k = fileName.lastIndexOf(".");
        String k1 = fileName.substring(0, k);
        String k2 = k1 + "output.txt";
        int k3 = filePath.lastIndexOf(fileName);
        String k4 = filePath.substring(0, k3);
        String k5 = k4 + k2;
        File file = new File(k5);
        if (file.exists()) {
            file.delete();
        }
        try {
            final BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                if (line.indexOf(',') != -1) {
                    ExpressionSanitizer r = new ExpressionSanitizer(line);
                    line = r.replace();
                }
                e = new ExpressionParser(line);
                try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(k5, true)))) {
                    out.println(line + "\t==>" + e.evaluateExpression());
                } catch (Exception ee2) {
                    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(k5, true)))) {
                        out.println(line + "\t==>Illegal Expression");

                    }

                }
            }
        } catch (Exception ee) {
        }

        final String temp = "Output file  " + k2 + "  has been successfully created";
        return temp;
    }
}


