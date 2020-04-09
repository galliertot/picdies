package com.example.rahsa.DAO;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.rahsa.entities.User;
import java.util.List;

@Dao
public interface UserDAO{

    @Insert
    long insertUser(User user);
    @Update
    void updateUser(User user);
    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM User WHERE _id=:id")
    User getUser(int id);

    @Query("SELECT * FROM User")
    List<User> getAllUser();

    @Query("SELECT * FROM User WHERE pseudo=:pseudo")
    User getUserFromPseudo(String pseudo);

    @Query("SELECT * FROM USER WHERE email=:email")
    User getUserFromEmail(String email);

    @Query("SELECT * FROM User WHERE pseudo=:pseudo and password=:password")
    User getConnexion(String pseudo, String password);


}