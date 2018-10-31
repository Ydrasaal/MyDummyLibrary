package lorolla.dummylibrary;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyDummyRepository {

    private int size;

    public MyDummyRepository() {
        this(5);
    }

    public MyDummyRepository(int idSize) {
        setIdSize(idSize);
    }

    /**
     * Set the size of generated MyDmmyObject's id
     *
     * @param idSize id character count (minimum 1)
     */
    public void     setIdSize(int idSize) {
        this.size = idSize < 1 ? 1 : idSize;
    }

    /**
     * @return new MyDummyObject with a random id
     */
    public MyDummyObject        createObject() {
        return new MyDummyObject(generateRandomString());
    }

    /**
     * @param count how many items in the list
     * @return new list of MyDummyObject with random ids
     */
    public List<MyDummyObject>  createObjects(int count) {
        List<MyDummyObject> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(createObject());
        }

        return list;
    }

    private String  generateRandomString() {
        byte[] array = new byte[size];

        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));
    }
}
