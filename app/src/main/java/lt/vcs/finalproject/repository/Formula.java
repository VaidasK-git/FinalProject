package lt.vcs.finalproject.repository;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;

import lt.vcs.finalproject.Constants;

@Entity(tableName = Constants.ENTITY_FORMULAS_TABLE)
public class Formula implements Add {

    @PrimaryKey(autoGenerate = true)
    private int formulaId;

    @ColumnInfo(name = "oxidants")
    private ArrayList<Oxidant> oxidants;

    @ColumnInfo(name = "colors")
    private ArrayList<Color> colors;

    @ColumnInfo(name = "formulaTime")
    private int formulaTime;

    @ColumnInfo(name = "formulaPrice")
    private int formulaPrice;

    public Formula(int formulaTime, int formulaPrice) {
        this.formulaTime = formulaTime;
        this.formulaPrice = formulaPrice;
        this.oxidants = new ArrayList<>();
        this.colors = new ArrayList<>();
    }

    public int getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(int formulaId) {
        this.formulaId = formulaId;
    }

    public ArrayList<Oxidant> getOxidants() {
        return oxidants;
    }

    public void setOxidants(ArrayList<Oxidant> oxidants) {
        this.oxidants = oxidants;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public int getFormulaTime() {
        return formulaTime;
    }

    public void setFormulaTime(int formulaTime) {
        this.formulaTime = formulaTime;
    }

    public int getFormulaPrice() {
        return formulaPrice;
    }

    public void setFormulaPrice(int formulaPrice) {
        this.formulaPrice = formulaPrice;
    }

    public void add(Oxidant oxidant) {
        this.oxidants.add(oxidant);
    }

    public void add(Color color) {
        this.colors.add(color);
    }


}
