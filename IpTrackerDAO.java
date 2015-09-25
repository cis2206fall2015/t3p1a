package IpTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dylan Lozo and Kyle Zindell
 */
public class IpTrackerDAO {

    private final String fileName;
    protected final List<IpTracker> myList;

    public IpTrackerDAO() {
        this("empdata.txt");
    }

    public IpTrackerDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(IpTracker ipTracker) {
        myList.add(ipTracker);
        writeList();
    }

    public IpTracker retrieveRecord(int id) {
        for (IpTracker ipTracker : myList) {
            if (ipTracker.getUserId() == id) {
                return ipTracker;
            }
        }
        return null;
    }

    public void updateRecord(Employee updatedIpTracker) {
        for (IpTracker ipTracker : myList) {
            if (ipTracker.getUserId() == updatedIpTracker.getUserId()) {
                ipTracker.setIpAddress(updatedEmployee.getIpAddress());
                ipTracker.setDateAdded(updatedEmployee.getDateAdded());
                ipTracker.setNumRequest(updatedEmployee.getNumRequest());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (IpTracker ipTracker : myList) {
            if (ipTracker.getUserId() == id) {
                myList.remove(ipTracker);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(IpTracker ipTracker) {
        myList.remove(ipTracker);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String ipAddress = data[1];
                String dateAdded = data[2];
                int numRequest = Integer.parseInt(data[3]);
                IpTracker ipTracker = new IpTracker(id, ipAddress, dateAdded, numRequest);
                myList.add(ipTracker);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (IpTracker ipTracker : myList) {
                writer.write(String.format("%d,%s,%s,%d\n",
                        ipTracker.getUserId(),
                        ipTracker.getIpAddress(),
                        ipTracker.getDateAdded(),
                        ipTracker.getNumRequest()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((ipTracker) -> {
            sb.append(String.format("%5d : %s, %s, %5d \n", ipTracker.getUserId(),
                    ipTracker.getIpAddress(), 
                    ipTracker.getDateAdded(), ipTracker.getNumRequest()));
        });

        return sb.toString();
    }
}
