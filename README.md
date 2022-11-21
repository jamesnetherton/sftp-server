### Test SFTP server

A fake SFTP server container for **_test & example purposes. It is not suitable for production usage_**.

### Build & test

```
mvn clean verify
```

### Container image build
```
mvn clean verify
docker build -t jamesnetherton/sftp-server .
```

### Running locally

```
docker run -ti --rm -e FTP_USER=admin -e FTP_PASSWORD=p4ssword -p 2222:2222 jamesnetherton/sftp-server
```
