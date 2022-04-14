package lt.vcs.finalproject.repository;

import android.content.Intent;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.finalproject.Constants;

@Dao
public interface FormulaDao {

    @Query("SELECT * FROM " + Constants.ENTITY_FORMULAS_TABLE)
    List<Formula> getAll();

    @Query("SELECT * FROM " + Constants.ENTITY_FORMULAS_TABLE + " WHERE formulaId =:formulaId")
    Formula getItem(int formulaId);

    @Query("SELECT MAX(formulaId) FROM " + Constants.ENTITY_FORMULAS_TABLE)
    Integer getMaxFormulaId();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFormulas(List<Formula> formulas);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFormula(Formula formula);

    @Delete
    void deleteFormulas(List<Formula> formulas);

    @Delete
    void deleteFormula(Formula formula);

    @Query("DELETE FROM " + Constants.ENTITY_FORMULAS_TABLE+ " WHERE formulaId =:formulaId")
    void deleteItem(int formulaId);

}
