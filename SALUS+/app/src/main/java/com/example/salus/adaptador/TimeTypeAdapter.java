package com.example.salus.adaptador;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeTypeAdapter extends TypeAdapter<Time> {
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void write(JsonWriter out, Time value) throws IOException {
        out.value(timeFormat.format(value));
    }

    @Override
    public Time read(JsonReader in) throws IOException {
        try {
            return new Time(timeFormat.parse(in.nextString()).getTime());
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }
}
