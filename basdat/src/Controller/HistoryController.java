package Controller;
import Entity.*;
import Model.*;
import java.util.ArrayList;


public class HistoryController extends ObjectModelController {
     public HistoryController() {}
     
     public ArrayList <HistoryEntity>showDataHistroy()
    {
        return ObjectModelController.history.showDataHistory();
    }
    
}
