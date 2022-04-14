package lt.vcs.finalproject.repository;

import androidx.room.TypeConverter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converters {
    @TypeConverter
    public String OxidantFromValuesToList(ArrayList<Oxidant> value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Oxidant>>() {}.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public ArrayList<Oxidant> oxidantToOptionValuesList(String value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Oxidant>>() {
        }.getType();
        return gson.fromJson(value, type);
    }

    @TypeConverter
    public String ColorFromValuesToList(ArrayList<Color> value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Color>>() {}.getType();
        return gson.toJson(value, type);
    }

    @TypeConverter
    public ArrayList<Color> ColorToOptionValuesList(String value) {
        if (value== null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Color>>() {
        }.getType();
        return gson.fromJson(value, type);
    }


}
