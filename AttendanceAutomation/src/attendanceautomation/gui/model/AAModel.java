package attendanceautomation.gui.model;

import attendanceautomation.be.Presence;
import attendanceautomation.bll.AAPresenceLogic;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class AAModel{
    private AAPresenceLogic aapl;
    
    public AAModel(){
        aapl = new AAPresenceLogic();
    }
    
    public void addPresence(Presence p){
        try{
            Presence presence = aapl.createPresence(p);
            //presences.getItems().clear();
            //listPresence.addAll(presence);
            //presences.getItems().addAll(listPresence);
        }catch (SQLException ex){
            Logger.getLogger(AAModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}