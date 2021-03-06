package coursera.datastructures.week1;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.IntStream;

public class TreeHeightTest {

    @Test
    public void testComputeHeight() {
        File files = new File(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("test-inputs-treeheight")).getFile());
        File[] in = files.listFiles(pathname -> pathname.isFile() && !pathname.getName().endsWith(".a"));
        IntStream.range(0, Objects.requireNonNull(in).length).forEach(idx -> {
            try {

                System.out.println("Input: " + in[idx].getPath());
                TreeHeight.Report report = new TreeHeight().run(in[idx].getPath());
                Files.lines(Paths.get(in[idx]+".a")).forEach(expected ->
                        Assert.assertEquals(Integer.parseInt(expected), report.getResult()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}