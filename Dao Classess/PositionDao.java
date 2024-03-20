package com.EmployeeManagementSystem.Dao;



//import com.EmployeeManagementSystem.entities.Position;
//
//import java.util.List;
//
//public interface PositionDao {
//    List<Position> getAllPositions();
//
//    Position getPositionById(int id);
//
//    void savePosition(Position position);
//
//    void updatePosition(Position position);
//
//    void deletePosition(int id);
//}
//
import java.util.List;
import com.EmployeeManagementSystem.entities.Position;

public interface PositionDao {
    void addPosition(Position position);
    void updatePosition(Position position);
    void deletePosition(int positionID);
    Position getPositionByID(int positionID);
    List<Position> getAllPositions();
}
