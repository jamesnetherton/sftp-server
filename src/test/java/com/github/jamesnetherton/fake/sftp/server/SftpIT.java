package com.github.jamesnetherton.fake.sftp.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Paths;

public class SftpIT {
    private static final String FTP_USER = "admin";
    private static final String FTP_PASSWORD = "p4ssw0rd";
    private static final int PORT = 2222;


    public GenericContainer<?> server;

    @Before
    public void before() {
        server = new GenericContainer<>(
                new ImageFromDockerfile().withDockerfile(Paths.get("./Dockerfile"))
        );
        server.withExposedPorts(PORT);
        server.withEnv("FTP_USER", FTP_USER);
        server.withEnv("FTP_PASSWORD", FTP_PASSWORD);
        server.start();
    }

    @After
    public void after() {
        if (server != null) {
            server.stop();
        }
    }

    @Test
    public void testSftpServer() throws IOException {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", server.getMappedPort(PORT)), 5000);
        }
    }
}
