package com.rvnu.data.firstparty.csv.records.interfaces;

import java.io.InputStream;
import java.util.function.Consumer;

public interface Deserializer<Record> {
    class UnableToDeserializeRecords extends Exception {
    }

    void deserialize(InputStream inputStream, Consumer<Record> recordConsumer) throws UnableToDeserializeRecords;
}
