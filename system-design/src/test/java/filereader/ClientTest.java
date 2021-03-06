package filereader;

import org.junit.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.Assert.*;

public class ClientTest {

    @Test(expected = IllegalArgumentException.class)
    public void testClient() {
        Client.main(new String[]{});
    }

    @Test
    public void testValidArgumentsExpectReportGenerated()
    {
        Client.main(new String[]{
                Objects.requireNonNull(getClass().getClassLoader().getResource("input.csv")).getPath(),
                "/tmp/output.csv"
        });
        assertTrue(new File("/tmp/output.csv").exists());
    }
}